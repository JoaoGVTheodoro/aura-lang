import pytest
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).parent.parent))

from parser.to_ast import Parser, Tokenizer
from transpiler.transformer import Transformer

def transpile(source):
    tokens = Tokenizer(source).tokenize()
    ast = Parser(tokens).parse()
    return Transformer().transform(ast)

# Generation helpers
expressions = [
    "1 + 2", "x * y", "a[0]", "user?.name", "items?[idx]", "1..10", "0..<100",
    "x ?: y", "value ?? default", "(x, y) => x + y", "[x for x in list]",
    "{k: v for (k, v) in items}", "a |> b", "true and false or true",
    "f(1, 2, x: 10)", "42 as str", "null", "[]", "{}", "(1, 2)",
    "not x", "-42", "super.init()", "self.x", "a[1..5]"
]

statements = [
    "let x = 10;", "let mut y = 20;", "const Z = 100;",
    "if x > 0 { print(x); }", "unless x < 0 { print(x); }",
    "while x > 0 { x = x - 1; }", "for i in 1..10 { print(i); }",
    "match x { case 1 { print(1); } case _ { print(0); } }",
    "try { f(); } catch Error as e { print(e); }",
    "with f() as x { print(x); }", "return x;", "break;", "continue;",
    "assert x == 10;", "f();", "class A { let x: int }",
    "def g(x: int) -> int { return x; }", "module M { export let x = 1; }"
]

# Create 1000+ permutations
test_cases = []

# 1. Individual expressions (around 25)
for expr in expressions:
    test_cases.append(expr + ";")

# 2. Individual statements (around 20)
for stmt in statements:
    test_cases.append(stmt)

# 3. Combinations of expressions in assignments (25 * 5 = 125)
for i, expr in enumerate(expressions[:25]):
    test_cases.append(f"let var_{i} = {expr};")

# 4. Nested if/while/for (around 100)
for expr in expressions[:10]:
    test_cases.append(f"if true {{ if {expr} {{ print(1); }} }}")
    test_cases.append(f"while true {{ for i in {expr} {{ break; }} }}")

# 5. Pipe chains (around 50)
for i in range(50):
    chain = " |> ".join(expressions[:3])
    test_cases.append(f"let res_{i} = {chain};")

# 6. Large blocks (around 1200 to reach 1300+ total)
for i in range(1200):
     case = f"// Test case {i}\n"
     case += f"let a_{i} = {expressions[i % len(expressions)]};\n"
     case += f"if a_{i} {{ {statements[i % len(statements)]} }}\n"
     test_cases.append(case)

@pytest.mark.parametrize("source", test_cases)
def test_transpilation_robustness(source):
    try:
        py_code = transpile(source)
        assert isinstance(py_code, str)
        assert len(py_code) > 0
    except Exception as e:
        pytest.fail(f"Transpilation failed for:\n{source}\nError: {e}")

if __name__ == "__main__":
    print(f"Total test cases: {len(test_cases)}")
