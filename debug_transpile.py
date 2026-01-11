from parser.to_ast import Tokenizer, Parser
from transpiler.transformer import Transformer

source = """// Syntax & Scope 0
let mut x = 0;
unless x > 10 {
    guard x >= 0 else { return; }
    until x == 5 {
        x = x + 1;
        {
            let y = x * 2;
            print(y);
        }
    }
}
match x {
    case 5 { print("done"); }
    case _ { print("error"); }
}
"""
tokens = Tokenizer(source).tokenize()
ast = Parser(tokens).parse()
py_code = Transformer().transform(ast)
print(py_code)
