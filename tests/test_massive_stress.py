import pytest
import os
import sys
import textwrap
from pathlib import Path

# Add project root to path
sys.path.insert(0, str(Path(__file__).parent.parent))

from parser.to_ast import Tokenizer, Parser
from transpiler.transformer import Transformer

SPEED_DIR = Path("tests/speed_aura_tests")
SECURE_DIR = Path("tests/secure_aura_tests")

def get_stress_files(directory):
    files = list(directory.glob("*.aura"))
    return [str(f) for f in files]

@pytest.mark.parametrize("file_path", get_stress_files(SPEED_DIR))
@pytest.mark.parametrize("level", range(1, 51))
def test_speed_aura(file_path, level):
    # This creates 1000 * 50 = 50,000 tests
    with open(file_path, "r") as f:
        source = f.read()
    
    # Scale variables in the source based on level
    source = source.replace("1000", str(1000 * level))
    
    tokens = Tokenizer(source).tokenize()
    ast = Parser(tokens).parse()
    py_code = Transformer().transform(ast)
    
    # Execution validation
    wrapped_code = f"def wrapper():\n{textwrap.indent(py_code, '    ')}\nwrapper()"
    exec(wrapped_code, {"print": lambda *args: None})

@pytest.mark.parametrize("file_path", get_stress_files(SECURE_DIR))
@pytest.mark.parametrize("level", range(1, 51))
def test_secure_aura(file_path, level):
    # This creates 1000 * 50 = 50,000 tests
    with open(file_path, "r") as f:
        source = f.read()
    
    # Scale variables in the source based on level
    source = source.replace("100", str(100 * level))
    
    tokens = Tokenizer(source).tokenize()
    ast = Parser(tokens).parse()
    py_code = Transformer().transform(ast)
    
    # Execution validation (Security focus)
    wrapped_code = f"def wrapper():\n{textwrap.indent(py_code, '    ')}\nwrapper()"
    
    try:
        # We increase recursion limit for deep recursion tests to avoid Python-specific crashes
        # which aren't representative of the transpiler's logic quality
        import sys
        old_limit = sys.getrecursionlimit()
        sys.setrecursionlimit(max(old_limit, 100 * level + 1000))
        
        exec(wrapped_code, {"print": lambda *args: None})
    finally:
        sys.setrecursionlimit(old_limit)
