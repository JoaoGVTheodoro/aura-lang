from parser.to_ast import Tokenizer, Parser
from transpiler.transformer import Transformer

source = """// Collections 0
let base = [1, 2, 3];
let extended = [*base, 4, 5];
let filtered = extended |> filter((v) => v % 2 == 0);
let mapped = filtered |> map((v) => v * 2);
let d = { "a": 1, "b": 2 };
let d2 = { **d, "c": 3 };
print(mapped);
print(d2);
"""
try:
    tokens = Tokenizer(source).tokenize()
    ast = Parser(tokens).parse()
    py_code = Transformer().transform(ast)
    print(py_code)
except Exception as e:
    import traceback
    traceback.print_exc()
