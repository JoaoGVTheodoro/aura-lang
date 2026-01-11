import unittest
from transpiler.transformers.statements import StatementTransformer
from transpiler.transformers.expressions import ExpressionTransformer
from transpiler.ast import *

class TestTranspilerTransformers(unittest.TestCase):
    def setUp(self):
        self.stmt_transformer = StatementTransformer()
        self.expr_transformer = ExpressionTransformer()

    def test_transform_assignment(self):
        # x = 1 (top-level statement)
        node = ExprStmt(BinaryOp(Identifier('x'), '=', IntLiteral(1)))
        result = self.stmt_transformer.transform(node)
        self.assertEqual(result, "x = 1")
    
    def test_transform_assignment_parens(self):
        # (x) = 1 (should strip parens)
        # Note: Identifier usually doesn't have parens in AST, but valid logic check
        # Let's test computed assignment
        node = ExprStmt(BinaryOp(Identifier('x'), '+=', IntLiteral(1)))
        result = self.stmt_transformer.transform(node)
        self.assertEqual(result, "x += 1")

    def test_if_expression_ternary(self):
        # if x { 1 } else { 0 }
        node = IfStmt(
            Identifier('x'), 
            [ExprStmt(IntLiteral(1))], 
            [ExprStmt(IntLiteral(0))]
        )
        result = self.expr_transformer.transform(node)
        self.assertEqual(result, "(1 if x else 0)")
        
    def test_if_expression_return(self):
        # if x { return 1 } else { return 0 }
        node = IfStmt(
            Identifier('x'), 
            [ReturnStmt(IntLiteral(1))], 
            [ReturnStmt(IntLiteral(0))]
        )
        result = self.expr_transformer.transform(node)
        self.assertEqual(result, "(1 if x else 0)")
        
    def test_range_expr(self):
        # 0..10
        node = RangeExpr(IntLiteral(0), IntLiteral(10), exclusive=False)
        result = self.expr_transformer.transform(node)
        self.assertEqual(result, "range(0, 10 + 1)")
        
    def test_range_expr_exclusive(self):
        # 0..<10
        node = RangeExpr(IntLiteral(0), IntLiteral(10), exclusive=True)
        result = self.expr_transformer.transform(node)
        self.assertEqual(result, "range(0, 10)")

    def test_list_comprehension(self):
        # [x for x in list]
        node = ComprehensionExpr(
            Identifier('x'), 
            [(IdentifierPattern('x'), Identifier('list'), [])], 
            'list'
        )
        result = self.expr_transformer.transform(node)
        self.assertEqual(result, "[x for x in list]")

    def test_function_decl(self):
        # fn add(a, b) { return a + b }
        node = FunctionDecl(
            'add', 
            [Parameter('a'), Parameter('b')], 
            None, 
            [ReturnStmt(BinaryOp(Identifier('a'), '+', Identifier('b')))]
        )
        result = self.stmt_transformer.transform(node)
        expected = "def add(a, b):\n    return (a + b)"
        self.assertEqual(result, expected)

if __name__ == '__main__':
    unittest.main()
