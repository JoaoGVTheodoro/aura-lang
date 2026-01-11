"""Test suite for Aura transpiler."""
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).parent.parent))

from parser.to_ast import parse_file
from transpiler.transformer import Transformer
from transpiler.ast import *


def test_simple_variables():
    """Test simple variable declarations."""
    ast = Program([
        VarDecl("x", False, None, IntLiteral(10)),
        VarDecl("y", True, None, StrLiteral("hello")),
    ])
    
    t = Transformer()
    output = t.transform(ast)
    assert "x = 10" in output
    assert "y = 'hello'" in output
    print("✓ test_simple_variables")


def test_function_decl():
    """Test function declarations."""
    params = [Parameter("a"), Parameter("b")]
    body = [
        ExprStmt(BinaryOp(Identifier("a"), "+", Identifier("b")))
    ]
    
    ast = Program([
        FunctionDecl("add", params, "int", body)
    ])
    
    t = Transformer()
    output = t.transform(ast)
    assert "def add(" in output
    assert "a" in output and "b" in output
    print("✓ test_function_decl")


def test_if_statement():
    """Test if statements."""
    ast = Program([
        IfStmt(
            BinaryOp(Identifier("x"), ">", IntLiteral(5)),
            [ExprStmt(StrLiteral("big"))],
            [ExprStmt(StrLiteral("small"))]
        )
    ])
    
    t = Transformer()
    output = t.transform(ast)
    assert "if" in output
    assert "else" in output
    print("✓ test_if_statement")


def test_for_loop():
    """Test for loops."""
    ast = Program([
        ForStmt(
            IdentifierPattern("i"),
            RangeExpr(IntLiteral(0), IntLiteral(10)),
            [ExprStmt(Identifier("i"))]
        )
    ])
    
    t = Transformer()
    output = t.transform(ast)
    assert "for" in output
    assert "range" in output
    print("✓ test_for_loop")


def test_binary_ops():
    """Test binary operations."""
    ast = Program([
        ExprStmt(BinaryOp(IntLiteral(10), "+", IntLiteral(5))),
        ExprStmt(BinaryOp(IntLiteral(20), "*", IntLiteral(3))),
        ExprStmt(BinaryOp(Identifier("a"), "and", Identifier("b"))),
    ])
    
    t = Transformer()
    output = t.transform(ast)
    assert "+" in output
    assert "*" in output
    assert "and" in output
    print("✓ test_binary_ops")


def test_list_literal():
    """Test list literals."""
    ast = Program([
        ExprStmt(ListLiteral([
            IntLiteral(1),
            IntLiteral(2),
            IntLiteral(3),
        ]))
    ])
    
    t = Transformer()
    output = t.transform(ast)
    assert "[" in output and "]" in output
    assert "1" in output and "2" in output and "3" in output
    print("✓ test_list_literal")


def test_class_decl():
    """Test class declarations."""
    members = [
        VarDecl("name", False, None, None),
        Method("greet", [Parameter("self")], None, [
            ReturnStmt(StrLiteral("Hello"))
        ])
    ]
    
    ast = Program([
        ClassDecl("Person", members)
    ])
    
    t = Transformer()
    output = t.transform(ast)
    assert "class Person" in output
    assert "def greet" in output
    print("✓ test_class_decl")


def test_pipe_operator():
    """Test pipe operator transformation."""
    # x |> func becomes func(x)
    left = Identifier("x")
    right = CallExpr(Identifier("transform"), [])
    
    ast = Program([
        ExprStmt(PipeExpr(left, right))
    ])
    
    t = Transformer()
    output = t.transform(ast)
    assert "transform" in output
    print("✓ test_pipe_operator")


def test_null_safe_nav():
    """Test null-safe navigation."""
    ast = Program([
        ExprStmt(SafeNavExpr(Identifier("user"), "name", False))
    ])
    
    t = Transformer()
    output = t.transform(ast)
    assert "is not None" in output
    print("✓ test_null_safe_nav")


def test_coalesce():
    """Test null coalescing operator."""
    ast = Program([
        ExprStmt(CoalesceExpr(Identifier("value"), StrLiteral("default")))
    ])
    
    t = Transformer()
    output = t.transform(ast)
    assert "is not None" in output
    assert "default" in output
    print("✓ test_coalesce")


def test_try_catch():
    """Test try-catch statements."""
    ast = Program([
        TryStmt(
            [ExprStmt(CallExpr(Identifier("risky"), []))],
            [CatchClause("Exception", "e", [
                ExprStmt(StrLiteral("error"))
            ])],
            None
        )
    ])
    
    t = Transformer()
    output = t.transform(ast)
    assert "try" in output
    assert "except" in output
    print("✓ test_try_catch")


def test_comprehension():
    """Test list comprehensions."""
    # [x * 2 for x in items if x > 0]
    ast = Program([
        ExprStmt(ComprehensionExpr(
            BinaryOp(Identifier("x"), "*", IntLiteral(2)),
            [(IdentifierPattern("x"), Identifier("items"), [
                BinaryOp(Identifier("x"), ">", IntLiteral(0))
            ])],
            'list'
        ))
    ])
    
    t = Transformer()
    output = t.transform(ast)
    assert "for" in output
    assert "if" in output
    print("✓ test_comprehension")


def run_all():
    """Run all tests."""
    tests = [
        test_simple_variables,
        test_function_decl,
        test_if_statement,
        test_for_loop,
        test_binary_ops,
        test_list_literal,
        test_class_decl,
        test_pipe_operator,
        test_null_safe_nav,
        test_coalesce,
        test_try_catch,
        test_comprehension,
    ]
    
    print("Running Aura transpiler tests...\n")
    failed = 0
    for test in tests:
        try:
            test()
        except Exception as e:
            print(f"✗ {test.__name__}: {e}")
            failed += 1
    
    print(f"\n{len(tests) - failed}/{len(tests)} tests passed")
    return 0 if failed == 0 else 1


if __name__ == "__main__":
    sys.exit(run_all())
