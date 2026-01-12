import pytest
import sys
import io
import textwrap
from pathlib import Path

# Add project root to path
sys.path.insert(0, str(Path(__file__).parent.parent))

from parser.to_ast import Tokenizer, Parser
from transpiler.transformer import Transformer

def transpile_and_run(code):
    """Helper to transpile and run Aura code, returning local variables."""
    tokenizer = Tokenizer(code)
    tokens = tokenizer.tokenize()
    parser = Parser(tokens)
    ast = parser.parse()
    transformer = Transformer()
    py_code = transformer.transform(ast)
    
    # Execute
    loc = {}
    exec(py_code, {}, loc)
    return loc

def test_private_visibility_enforcement():
    """Test that private members are not accessible from outside."""
    # 1. Test Valid Access
    valid_code = """
    class Secret {
        private let x = 10
        public def get_x() { return self.x }
    }
    let s = Secret()
    let val = s.get_x()
    """
    loc = transpile_and_run(valid_code)
    assert loc['val'] == 10
    
    # 2. Test Invalid Access (Runtime Error)
    invalid_code = """
    class Secret {
        private let x = 10
    }
    let s = Secret()
    let val = s.x  // Should fail
    """
    
    with pytest.raises(AttributeError):
        transpile_and_run(invalid_code)

def test_private_method_enforcement():
    """Test that private methods are not accessible."""
    invalid_code = """
    class Bank {
        private def transfer() { return "money" }
    }
    let b = Bank()
    b.transfer()
    """
    with pytest.raises(AttributeError):
        transpile_and_run(invalid_code)

def test_static_method_semantics():
    """Test static method decoration."""
    code = """
    class MathUtil {
        static def add(a, b) { return a + b }
    }
    let res = MathUtil.add(10, 5)
    """
    loc = transpile_and_run(code)
    assert loc['res'] == 15

def test_global_modifiers_parsing():
    """Test that parser accepts global modifiers (even if Python ignores them for now)."""
    code = """
    public let x = 1
    private let y = 2
    static def foo() { return 3 }
    """
    # This should verify transpilation passes
    loc = transpile_and_run(code)
    assert loc['x'] == 1
    # Global 'private' y maps to __y
    assert loc['__y'] == 2 
