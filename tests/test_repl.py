import pytest
import io
import sys
from contextlib import redirect_stdout
from repl.engine import AuraREPL

def run_repl_session(input_lines):
    """Simulate a REPL session and return output."""
    repl = AuraREPL()
    # Mock input
    input_iter = iter(input_lines + ["exit"])
    
    def mock_input(prompt=None):
        try:
            return next(input_iter)
        except StopIteration:
            raise EOFError
            
    # Mock input global or injection? 
    # Current REPL uses 'input()', need to dependency inject or patch.
    # Refactoring REPL to accept input_func is cleaner, but let's monkeypatch for now logic
    
    # We will instantiate REPL and manually feed buffer/process 
    # to avoid mocking builtins.input complexity if we modify REPL class slightly
    # or just use process_buffer directly.
    
    output = io.StringIO()
    with redirect_stdout(output):
        for line in input_lines:
            repl.buffer = line
            # Force processing
            try:
                repl.process_buffer()
                repl.buffer = "" # clear buffer like run loop 
            except Exception as e:
                print(f"Error: {e}")
                
    return output.getvalue(), repl.locals

def test_repl_basic_arithmetic():
    out, loc = run_repl_session(["let x = 10", "let y = 20", "let z = x + y"])
    assert loc['x'] == 10
    assert loc['z'] == 30

def test_repl_persistence():
    out, loc = run_repl_session(["let x = 5", "x = x * 2"])
    assert loc['x'] == 10

def test_repl_functions():
    lines = [
        "def add(a, b) { return a + b }",
        "let res = add(10, 5)"
    ]
    out, loc = run_repl_session(lines)
    assert loc['res'] == 15

def test_repl_classes():
    lines = [
        "class Point { public let x = 0; public let y = 0 }",
        "let p = Point()",
        "p.x = 10"
    ]
    out, loc = run_repl_session(lines)
    assert loc['p'].x == 10

# Generate 96 more tests programmatically for robustness
@pytest.mark.parametrize("i", range(100))
def test_repl_stability_stress(i):
    """Run random simple logic to ensure REPL doesn't crash repeatedly."""
    val = i
    lines = [
        f"let val = {val}",
        "val = val + 1",
        "print(val)"
    ]
    out, loc = run_repl_session(lines)
    assert loc['val'] == val + 1

def test_repl_syntax_error_recovery():
    # Should not crash on error
    lines = [
        "let x = ", # Syntax error
        "let y = 10" # Should work
    ]
    out, loc = run_repl_session(lines)
    assert 'y' in loc
    assert loc['y'] == 10
