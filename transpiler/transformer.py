"""Main transpiler that orchestrates AST → Python code transformation."""
from transpiler.ast import *
from transpiler.transformers.expressions import ExpressionTransformer
from transpiler.transformers.statements import StatementTransformer

class Transformer:
    def __init__(self):
        self.expr_transformer = ExpressionTransformer()
        self.stmt_transformer = StatementTransformer()
    
    def transform(self, node):
        # print(f"DEBUG: Transform {type(node)}")
        if isinstance(node, Program):
            return self._transform_program(node)
        elif isinstance(node, Import):
            return self._transform_import(node)
        elif isinstance(node, FromImport):
            return self._transform_from_import(node)
        elif isinstance(node, Module):
            return self._transform_module(node)
        elif isinstance(node, Stmt):
            return self.stmt_transformer.transform(node)
        elif isinstance(node, Expr):
            # Support old Expr node wrapper
            return self.expr_transformer.transform(node)
        else:
            print(f"DEBUG: Fallback for {type(node)}. Is Stmt? {isinstance(node, Stmt)}. Stmt class: {Stmt}", flush=True)
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
    
    def _transform_import(self, node):
        """Transform import statement."""
        if node.alias:
            return f"import {node.module} as {node.alias}"
        else:
            return f"import {node.module}"
    
    def _transform_from_import(self, node):
        """Transform from-import statement."""
        items = []
        for name, alias in node.items:
            if alias:
                items.append(f"{name} as {alias}")
            else:
                items.append(name)
        items_str = ", ".join(items)
        return f"from {node.module} import {items_str}"
    
    def _transform_module(self, node):
        """Transform module declaration."""
        lines = [f"# Module: {node.name}"]
        for member in node.members:
            code = self.transform(member)
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

