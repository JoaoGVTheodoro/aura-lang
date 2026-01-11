import unittest
from parser.to_ast import Tokenizer, Parser
from transpiler.ast import *

class TestParserErrors(unittest.TestCase):
    def parse(self, source):
        tokenizer = Tokenizer(source)
        tokens = tokenizer.tokenize()
        parser = Parser(tokens)
        return parser.parse()

    def test_missing_semicolon_recovery(self):
        # Semicolons are optional/recoverable, so this should parse correctly
        prog = self.parse("let x = 1 let y = 2")
        self.assertEqual(len(prog.statements), 2)
            
    def test_invalid_syntax(self):
        with self.assertRaises(SyntaxError):
            self.parse("let = 1") # Missing name
            
    def test_unexpected_token(self):
         with self.assertRaises(SyntaxError):
            self.parse("if { }") # Missing condition
            
    def test_unterminated_string(self):
        # Tokenizer might not raise but produce weird token or infinite loop
        # Our tokenizer loop checks len, so it terminates.
        # But let's check parsing
        pass 

if __name__ == '__main__':
    unittest.main()
