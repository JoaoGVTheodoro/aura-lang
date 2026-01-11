"""Statement and declaration transformers."""
from transpiler.ast import *
from transpiler.transformers.expressions import ExpressionTransformer

class StatementTransformer:
    def __init__(self):
        self.expr_transformer = ExpressionTransformer()
        self.indent_level = 0
    
    def transform(self, node):
        if node is None:
            return ""
        
        method_name = f"transform_{node.__class__.__name__}"
        method = getattr(self, method_name, None)
        if method:
            return method(node)
        
        raise NotImplementedError(f"No transformer for {node.__class__.__name__}")
    
    def _indent(self):
        return "    " * self.indent_level
    
    def _block(self, statements):
        """Transform a list of statements into indented block."""
        self.indent_level += 1
        lines = []
        for stmt in statements:
            code = self.transform(stmt)
            if code:
                for line in code.split('\n'):
                    if line.strip():
                        lines.append(self._indent() + line)
        self.indent_level -= 1
        return '\n'.join(lines)
    
    # ========== Declarations ==========
    def transform_VarDecl(self, node):
        if node.value:
            value = self.expr_transformer.transform(node.value)
            return f"{node.name} = {value}"
        else:
            return f"{node.name} = None"
    
    def transform_ConstDecl(self, node):
        value = self.expr_transformer.transform(node.value)
        return f"{node.name} = {value}  # const"
    
    def transform_FunctionDecl(self, node):
        decorators_code = ""
        for dec in node.decorators:
            decorators_code += f"@{dec.name}\n"
        
        params = []
        for param in node.params:
            if param.is_variadic:
                params.append(f"*{param.name}")
            elif param.is_kwonly:
                params.append(f"**{param.name}")
            elif param.default:
                default = self.expr_transformer.transform(param.default)
                params.append(f"{param.name}={default}")
            else:
                params.append(param.name)
        
        params_str = ", ".join(params)
        
        async_kw = "async " if node.is_async else ""
        
        if node.body is None:
            return f"{decorators_code}{async_kw}def {node.name}({params_str}): pass"
        elif isinstance(node.body, list):
            body_code = self._block(node.body)
            if not body_code.strip():
                body_code = self._indent() + "pass"
            return f"{decorators_code}{async_kw}def {node.name}({params_str}):\n{body_code}"
        else:
            # Expression body
            expr_code = self.expr_transformer.transform(node.body)
            return f"{decorators_code}{async_kw}def {node.name}({params_str}): return {expr_code}"
    
    def transform_ClassDecl(self, node):
        decorators_code = ""
        for dec in node.decorators:
            decorators_code += f"@{dec.name}\n"
        
        base = ""
        if node.base_class:
            base = f"({node.base_class})"
        
        body_code = ""
        for member in node.body:
            if isinstance(member, VarDecl):
                body_code += self._indent() + self.transform(member) + "\n"
            elif isinstance(member, Method):
                body_code += self.transform(member) + "\n"
            else:
                body_code += self.transform(member) + "\n"
        
        if not body_code.strip():
            body_code = self._indent() + "pass"
        
        return f"{decorators_code}class {node.name}{base}:\n{body_code}"
    
    def transform_Method(self, node):
        decorators_code = ""
        if node.is_static:
            decorators_code += "@staticmethod\n"
        if node.is_classmethod:
            decorators_code += "@classmethod\n"
        if node.is_property:
            decorators_code += "@property\n"
        
        params = ["self"] if not node.is_static and not node.is_classmethod else []
        for param in node.params:
            if param.name != "self":
                if param.default:
                    default = self.expr_transformer.transform(param.default)
                    params.append(f"{param.name}={default}")
                else:
                    params.append(param.name)
        
        params_str = ", ".join(params)
        
        if node.body is None:
            return f"{decorators_code}def {node.name}({params_str}): pass"
        elif isinstance(node.body, list):
            self.indent_level += 1
            body_code = self._block(node.body)
            self.indent_level -= 1
            if not body_code.strip():
                body_code = self._indent() + "pass"
            return f"{decorators_code}def {node.name}({params_str}):\n{body_code}"
        else:
            expr_code = self.expr_transformer.transform(node.body)
            return f"{decorators_code}def {node.name}({params_str}): return {expr_code}"
    
    def transform_TypeDecl(self, node):
        # In Python, we can represent as a comment or via typing module
        return f"# Type alias: {node.name}"
    
    def transform_TraitDecl(self, node):
        # Traits → ABC in Python
        return f"# Trait: {node.name} (use ABC)"
    
    # ========== Statements ==========
    def transform_ExprStmt(self, node):
        return self.expr_transformer.transform(node.expr)
    
    def transform_IfStmt(self, node):
        cond = self.expr_transformer.transform(node.condition)
        then_body = self._block(node.then_body)
        
        result = f"if {cond}:\n{then_body}"
        
        if node.else_body:
            else_body = self._block(node.else_body)
            result += f"\nelse:\n{else_body}"
        
        return result
    
    def transform_UnlessStmt(self, node):
        # unless → if not
        cond = self.expr_transformer.transform(node.condition)
        body = self._block(node.body)
        
        result = f"if not ({cond}):\n{body}"
        
        if node.else_body:
            else_body = self._block(node.else_body)
            result += f"\nelse:\n{else_body}"
        
        return result
    
    def transform_GuardStmt(self, node):
        # guard condition else { ... } → if not condition: ...
        cond = self.expr_transformer.transform(node.condition)
        else_body = self._block(node.else_body)
        return f"if not ({cond}):\n{else_body}"
    
    def transform_WhileStmt(self, node):
        cond = self.expr_transformer.transform(node.condition)
        body = self._block(node.body)
        return f"while {cond}:\n{body}"
    
    def transform_UntilStmt(self, node):
        # until condition → while not condition
        cond = self.expr_transformer.transform(node.condition)
        body = self._block(node.body)
        return f"while not ({cond}):\n{body}"
    
    def transform_ForStmt(self, node):
        pattern = self._transform_pattern(node.pattern)
        iterable = self.expr_transformer.transform(node.iterable)
        body = self._block(node.body)
        
        if node.step:
            step = self.expr_transformer.transform(node.step)
            iterable = f"range({iterable.split('range(')[1] if 'range(' in iterable else iterable}, step={step})"
        
        return f"for {pattern} in {iterable}:\n{body}"
    
    def transform_LoopStmt(self, node):
        body = self._block(node.body)
        return f"while True:\n{body}"
    
    def transform_BreakStmt(self, node):
        return "break"
    
    def transform_ContinueStmt(self, node):
        return "continue"
    
    def transform_ReturnStmt(self, node):
        if node.value:
            value = self.expr_transformer.transform(node.value)
            return f"return {value}"
        return "return"
    
    def transform_TryStmt(self, node):
        try_body = self._block(node.try_body)
        result = f"try:\n{try_body}"
        
        for catch in node.catch_clauses:
            exc_type = catch.exception_type or "Exception"
            var_name = f" as {catch.var_name}" if catch.var_name else ""
            catch_body = self._block(catch.body)
            result += f"\nexcept {exc_type}{var_name}:\n{catch_body}"
        
        if node.finally_body:
            finally_body = self._block(node.finally_body)
            result += f"\nfinally:\n{finally_body}"
        
        return result
    
    def transform_WithStmt(self, node):
        items = []
        for expr, var_name in node.items:
            expr_code = self.expr_transformer.transform(expr)
            if var_name:
                items.append(f"{expr_code} as {var_name}")
            else:
                items.append(expr_code)
        
        items_str = ", ".join(items)
        body = self._block(node.body)
        return f"with {items_str}:\n{body}"
    
    def transform_MatchStmt(self, node):
        expr = self.expr_transformer.transform(node.expr)
        
        # Python 3.10+ match statement
        result = f"match {expr}:\n"
        for case in node.cases:
            pattern = self._transform_pattern(case.pattern)
            if case.guard:
                guard = self.expr_transformer.transform(case.guard)
                result += f"{self._indent()}case {pattern} if {guard}:\n"
            else:
                result += f"{self._indent()}case {pattern}:\n"
            
            body = self._block(case.body)
            result += body + "\n"
        
        return result
    
    # ========== Helper: Transform patterns ==========
    def _transform_pattern(self, pattern):
        if isinstance(pattern, IdentifierPattern):
            return pattern.name
        elif isinstance(pattern, LiteralPattern):
            return self.expr_transformer.transform(pattern.value)
        elif isinstance(pattern, WildcardPattern):
            return "_"
        elif isinstance(pattern, ListPattern):
            pats = [self._transform_pattern(p) for p in pattern.patterns]
            if pattern.rest_pattern:
                pats.append(f"*{pattern.rest_pattern.name}")
            return f"[{', '.join(pats)}]"
        elif isinstance(pattern, DictPattern):
            fields = []
            for name, pat in pattern.field_patterns.items():
                fields.append(f"{name}={self._transform_pattern(pat)}")
            if pattern.rest_pattern:
                fields.append(f"**{pattern.rest_pattern.name}")
            return f"{{{', '.join(fields)}}}"
        elif isinstance(pattern, OrPattern):
            pats = [self._transform_pattern(p) for p in pattern.patterns]
            return f"({' | '.join(pats)})"
        else:
            return "_"

