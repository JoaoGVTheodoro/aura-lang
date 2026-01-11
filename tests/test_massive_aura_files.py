import pytest
import os
import sys
from pathlib import Path

# Add project root to path
sys.path.insert(0, str(Path(__file__).parent.parent))

from parser.to_ast import Tokenizer, Parser
from transpiler.transformer import Transformer

SUCCESS_DIR = Path("tests/success_tests_aura")
SYNTAX_DIR = Path("tests/syntax_checker_aura")

def get_aura_files():
    files = list(SUCCESS_DIR.glob("*.aura")) + list(SYNTAX_DIR.glob("*.aura"))
    return [str(f) for f in files]

@pytest.mark.parametrize("file_path", get_aura_files())
class TestAuraMassive:
    
    def test_stage_1_tokenization(self, file_path):
        with open(file_path, "r") as f:
            source = f.read()
        tokens = Tokenizer(source).tokenize()
        assert len(tokens) > 0
        assert tokens[-1].type == "EOF"

    def test_stage_2_parsing(self, file_path):
        with open(file_path, "r") as f:
            source = f.read()
        tokens = Tokenizer(source).tokenize()
        ast = Parser(tokens).parse()
        assert ast is not None

    def test_stage_3_transpilation(self, file_path):
        with open(file_path, "r") as f:
            source = f.read()
        tokens = Tokenizer(source).tokenize()
        ast = Parser(tokens).parse()
        py_code = Transformer().transform(ast)
        assert isinstance(py_code, str)
        assert len(py_code) > 0

    def test_stage_4_python_syntax(self, file_path):
        with open(file_path, "r") as f:
            source = f.read()
        tokens = Tokenizer(source).tokenize()
        ast = Parser(tokens).parse()
        py_code = Transformer().transform(ast)
        # Check if it's valid Python syntax
        import textwrap
        wrapped_code = f"def wrapper():\n{textwrap.indent(py_code, '    ')}"
        compile(wrapped_code, "<string>", "exec")

    def test_stage_5_execution_or_semantic(self, file_path):
        # For success_tests_aura, we try to execute
        if "success_tests_aura" in file_path:
            with open(file_path, "r") as f:
                source = f.read()
            tokens = Tokenizer(source).tokenize()
            ast = Parser(tokens).parse()
            py_code = Transformer().transform(ast)
            
            import textwrap
            try:
                wrapped_code = f"def wrapper():\n{textwrap.indent(py_code, '    ')}\nwrapper()"
                exec(wrapped_code, {"print": lambda *args: None})
            except Exception as e:
                # Some might fail if they need specific dummies not in gen, 
                # but gen_aura_scenarios was designed to be self-contained.
                pytest.fail(f"Execution failed for {file_path}: {e}")
        else:
            # For syntax_checker_aura, we just verify it reached this stage successfully
            assert True
