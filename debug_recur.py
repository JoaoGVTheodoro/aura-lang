from parser.to_ast import Parser, Tokenizer

code = """
def bug() {
    return () => {
        count += 1
        return count
    }
}
"""

try:
    tokenizer = Tokenizer(code)
    tokens = tokenizer.tokenize()
    print("Tokens:", tokens)
    parser = Parser(tokens)
    ast = parser.parse()
    print("Parsed successfully")
except RecursionError:
    print("RecursionError detected!")
except Exception as e:
    print(f"Error: {e}")
