"""Statement and declaration transformers."""
from transpiler.ast import *
from transpiler.transformers.expressions import ExpressionTransformer

class StatementTransformer:
    def __init__(self):
        self.expr_transformer = ExpressionTransformer()
        self.indent_level = 0
        self.class_members = {} # class_name -> {member_name: visibility}
    
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
        name = node.name
        if node.visibility == 'private': name = f"__{name}"
        elif node.visibility == 'protected': name = f"_{name}"
        
        if node.value:
            value = self.expr_transformer.transform(node.value)
            return f"{name} = {value}"
        else:
            return f"{name} = None"
    
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
        
        self.indent_level += 1
        
        # Populate visibility map for expressions
        current_vis = {}
        # Inherit from base
        if node.base_class in self.class_members:
            current_vis.update(self.class_members[node.base_class])
        
        # Add current members
        for member in node.body:
            if hasattr(member, 'name') and hasattr(member, 'visibility'):
                current_vis[member.name] = member.visibility
        
        # Save to global map
        self.class_members[node.name] = current_vis
        
        old_vis = self.expr_transformer.member_visibilities
        self.expr_transformer.member_visibilities = current_vis

        # Automatic __init__ and __match_args__ for instance fields
        # Note: static fields go directly into class body, not __init__
        instance_fields = [m for m in node.body if isinstance(m, VarDecl) and not m.is_static]
        init_code = ""
        if instance_fields:
            if any(f.name == '__init__' for f in node.body if isinstance(f, Method)):
                # If manual __init__ exists, we might still want to add auto-assignments?
                pass
            else:
                params = ", ".join([f"{f.name}=None" for f in instance_fields])
                if params: params += ", "
                params += "**kwargs"
                
                assign_lines = []
                for f in instance_fields:
                    name = f.name
                    if f.visibility == 'private': name = f"__{name}"
                    elif f.visibility == 'protected': name = f"_{name}"
                    
                    if f.value:
                        default_py = self.expr_transformer.transform(f.value)
                        assign_lines.append(f"{self._indent()}    self.{name} = {f.name} if {f.name} is not None else {default_py}")
                    else:
                        assign_lines.append(f"{self._indent()}    self.{name} = {f.name}")
                assigns = "\n".join(assign_lines)
                
                match_args = ", ".join([f"'{f.name}'" for f in instance_fields])
                if len(instance_fields) == 1: match_args += ","
                init_code = f"{self._indent()}__match_args__ = ({match_args})\n{self._indent()}def __init__(self, {params}):\n{self._indent()}    super().__init__(**kwargs)\n{assigns}\n"

        body_code = ""
        for member in node.body:
            if isinstance(member, VarDecl):
                body_code += self._indent() + self.transform(member) + "\n"
            elif isinstance(member, Method):
                body_code += self._indent() + self.transform(member).replace('\n', '\n' + self._indent()) + "\n"
            else:
                body_code += self._indent() + self.transform(member) + "\n"
        
        # Reset and finish
        final_body = init_code + body_code
        self.indent_level -= 1
        self.expr_transformer.member_visibilities = old_vis
        
        if not final_body.strip():
            final_body = self._indent() + "pass"
        
        return f"{decorators_code}class {node.name}{base}:\n{final_body}"
    
    def transform_Method(self, node):
        decorators_code = ""
        if node.is_static:
            decorators_code += "@staticmethod\n"
        if node.is_classmethod:
            decorators_code += "@classmethod\n"
        if node.is_property:
            decorators_code += "@property\n"
        
        name = node.name
        if node.visibility == 'private': name = f"__{name}"
        elif node.visibility == 'protected': name = f"_{name}"
        
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
            return f"{decorators_code}def {name}({params_str}): pass"
        elif isinstance(node.body, list):
            self.indent_level += 1
            body_code = self._block(node.body)
            self.indent_level -= 1
            if not body_code.strip():
                body_code = self._indent() + "pass"
            return f"{decorators_code}def {name}({params_str}):\n{body_code}"
        else:
            expr_code = self.expr_transformer.transform(node.body)
            return f"{decorators_code}def {name}({params_str}): return {expr_code}"
    
    def transform_TypeDecl(self, node):
        # In Python, we can represent as a comment or via typing module
        return f"# Type alias: {node.name}"
    
    def transform_TraitDecl(self, node):
        # Traits → ABC in Python
        return f"# Trait: {node.name} (use ABC)"
    
    # ========== Statements ==========
    def transform_AssertStmt(self, node):
        cond = self.expr_transformer.transform(node.condition)
        if node.message:
            msg = self.expr_transformer.transform(node.message)
            return f"assert {cond}, {msg}"
        return f"assert {cond}"

    def transform_ExprStmt(self, node):
        if isinstance(node.expr, BlockExpr):
            return "\n".join([self.transform(s) for s in node.expr.statements])
            
        # Check if it's an assignment (BinaryOp with '=')
        # Aura parsers assignments as BinaryOp expressions. 
        # In Python, assignment is a statement.
        if isinstance(node.expr, BinaryOp) and node.expr.op == '=':
            left = self.expr_transformer.transform(node.expr.left)
            # Remove outer parens from left if present (though usually identifier)
            if left.startswith('(') and left.endswith(')'):
                left = left[1:-1]
                
            right = self.expr_transformer.transform(node.expr.right)
            return f"{left} = {right}"
        elif isinstance(node.expr, BinaryOp) and node.expr.op in ('+=', '-=', '*=', '/=', '//=', '%=', '**=', '&=', '|=', '^=', '<<=', '>>='):
            # Computed assignments are also statements in Python
            left = self.expr_transformer.transform(node.expr.left)
            if left.startswith('(') and left.endswith(')'):
                left = left[1:-1]
            right = self.expr_transformer.transform(node.expr.right)
            op = node.expr.op
            return f"{left} {op} {right}"
            
        expr = node.expr
        
        # Safety: unwrap nested ExprStmt if parser wrapped redundantly
        # Use Duck Typing / Name check to avoid class identity issues
        attempts = 0
        while expr.__class__.__name__ == 'ExprStmt':
            expr = expr.expr
            attempts += 1
            if attempts > 100:
                raise Exception("Infinite recursion unwrapping ExprStmt")
            
        return self.expr_transformer.transform(expr)
    
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
        pattern = self.expr_transformer.transform(node.pattern)
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
    
    def transform_ImportStmt(self, node):
        # import a.b {x, y} -> from a.b import x, y
        # import a.b -> import a.b
        if node.items:
            items = ", ".join(node.items)
            return f"from {node.module} import {items}"
        return f"import {node.module}"

    def transform_MatchStmt(self, node):
        expr = self.expr_transformer.transform(node.expr)
        
        # Python 3.10+ match statement
        result = f"match {expr}:\n"
        
        # Increase indent for cases
        self.indent_level += 1
        
        for case in node.cases:
            pattern = self.expr_transformer.transform(case.pattern)
            if case.guard:
                guard = self.expr_transformer.transform(case.guard)
                result += f"{self._indent()}case {pattern} if {guard}:\n"
            else:
                result += f"{self._indent()}case {pattern}:\n"
            
            # Block handles its own indent increment usually? 
            # If _block adds ANOTHER indent... check _block logic.
            # Assuming _block increments, renders, decrements.
            # So calling _block here works for case body relative to case.
            body = self._block(case.body)
            result += body + "\n"
            
        self.indent_level -= 1
        return result
    
    # ========== Helper: Transform patterns ==========
    def _transform_pattern(self, pattern):
        if isinstance(pattern, IdentifierPattern):
            return pattern.name
        elif isinstance(pattern, LiteralPattern):
            # Primitive values cannot be passed to transformer directly
            val = pattern.value
            if isinstance(val, str): return repr(val)
            if isinstance(val, bool): return str(val)
            if val is None: return "None"
            return str(val)
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
                 # Match Python dict pattern: {key: value} 
                 # Python match dict syntax: {"key": value} or {k: v} if k is literal?
                 # Actually Python 3.10 match items are keys? 
                 # case {"a": 1}:
                 fields.append(f'"{name}": {self._transform_pattern(pat)}')
            if pattern.rest_pattern:
                 fields.append(f"**{pattern.rest_pattern.name}")
            return f"{{{', '.join(fields)}}}"
        elif isinstance(pattern, ConstructorPattern):
            name = pattern.name
            args = [self._transform_pattern(p) for p in pattern.subpatterns]
            return f"{name}({', '.join(args)})"

        elif isinstance(pattern, OrPattern):
            pats = [self._transform_pattern(p) for p in pattern.patterns]
            return f"({' | '.join(pats)})"
        
        return "_"

