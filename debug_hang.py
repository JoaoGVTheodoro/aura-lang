from parser.to_ast import Parser, Tokenizer
import sys

# Read comprehensive.aura
with open('examples/comprehensive.aura', 'r') as f:
    code = f.read()

print("Tokenizing...")
tokenizer = Tokenizer(code)
tokens = tokenizer.tokenize()
print(f"Tokens: {len(tokens)}")

print("Parsing...")
parser = Parser(tokens)

# Monkey patch parse loop to trace
original_parse = parser.parse

def traced_parse():
    print("Start Loop")
    count = 0
    while not parser.check('EOF'):
        count += 1
        pos = parser.pos
        tok = parser.peek()
        # print(f"Stmt {count} at pos {pos} token={tok}")
        if count % 100 == 0:
             print(f"Stmt {count} at pos {pos}")
        
        stmt = parser.parse_statement()
        
        if parser.pos == pos:
             print(f"INFINITE LOOP DETECTED at pos {pos} token={tok}")
             break
    print("End Loop")
    return None # parser.program

# parser.parse = traced_parse # Can't replace bound method easily on instance
# Run loop manually
traced_parse()
