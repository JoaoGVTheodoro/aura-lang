
from parser.to_ast import Tokenizer

source = 'let nullable: str? = "hello"'
print(f"Tokenizing: {source}")
tokenizer = Tokenizer(source)
tokens = tokenizer.tokenize()
for t in tokens:
    print(t)
