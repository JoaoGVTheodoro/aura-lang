"""Main transpiler that orchestrates AST → Python code transformation."""
from transpiler.ast import *
from transpiler.transformers.expressions import ExpressionTransformer
from transpiler.transformers.statements import StatementTransformer

class Transformer:
    def __init__(self):
        self.expr_transformer = ExpressionTransformer()
        self.stmt_transformer = StatementTransformer()
    
    def transform(self, node):
        if isinstance(node, Program):
            return self._transform_program(node)
        elif isinstance(node, (VarDecl, ConstDecl, FunctionDecl, ClassDecl,
                              IfStmt, UnlessStmt, GuardStmt,
                              WhileStmt, UntilStmt, ForStmt, LoopStmt,
                              BreakStmt, ContinueStmt, ReturnStmt,
                              TryStmt, WithStmt, MatchStmt,
                              ExprStmt, Method, TypeDecl, TraitDecl)):
            return self.stmt_transformer.transform(node)
        elif isinstance(node, Expr):
            # Support old Expr node wrapper
            return self.expr_transformer.transform(node)
        else:
            # Fallback for other expression types
            try:
                return self.expr_transformer.transform(node)
            except NotImplementedError:
                return self._transform_legacy(node)
    
    def _transform_program(self, program):
        lines = []
        for stmt in program.statements:
            code = self.transform(stmt)
            if code and code.strip():
                lines.append(code)
        return "\n".join(lines)
    
    def _transform_legacy(self, node):
        """Support for legacy AST node names (Phase 1 compatibility)."""
        if hasattr(node, 'value') and isinstance(node.value, (Identifier, IntLiteral, FloatLiteral, StrLiteral)):
            return self.expr_transformer.transform(node.value)
        
        if isinstance(node, Identifier):
            return self.expr_transformer.transform(node)
        
        if isinstance(node, (IntLiteral, FloatLiteral, StrLiteral)):
            return self.expr_transformer.transform(node)
        
        raise NotImplementedError(f"Transformer for {node.__class__.__name__} not implemented")
