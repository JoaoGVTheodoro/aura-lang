from parser.to_ast import Parser, Tokenizer

code = """
    // Generic function for filtering
    def filter<T>(predicate: (T) -> bool, items: list[T]) -> list[T] {
        return [x for x in items if predicate(x)]
    }
"""

print("Tokenizing...")
tokenizer = Tokenizer(code)
tokens = tokenizer.tokenize()
print("Tokens:", tokens)

print("Parsing...")
parser = Parser(tokens)
ast = parser.parse()
print("Parsed!", ast)
