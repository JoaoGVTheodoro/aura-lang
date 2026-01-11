"""Expression transformers: convert AST expression nodes to Python code."""
from transpiler.ast import *

class ExpressionTransformer:
    def transform(self, node):
        if node is None:
            return "None"
        
        method_name = f"transform_{node.__class__.__name__}"
        method = getattr(self, method_name, None)
        if method:
            return method(node)
        
        raise NotImplementedError(f"No transformer for {node.__class__.__name__}")
    
    # ========== Literals ==========
    def transform_IntLiteral(self, node):
        return str(node.value)
    
    def transform_FloatLiteral(self, node):
        return str(node.value)
    
    def transform_StrLiteral(self, node):
        return repr(node.value)
    
    def transform_BoolLiteral(self, node):
        return "True" if node.value else "False"
    
    def transform_NoneLiteral(self, node):
        return "None"
    
    def transform_ListLiteral(self, node):
        items = [self.transform(e) for e in node.elements]
        return f"[{', '.join(items)}]"
    
    def transform_DictLiteral(self, node):
        pairs = [f"{self.transform(k)}: {self.transform(v)}" for k, v in node.pairs]
        return f"{{{', '.join(pairs)}}}"
    
    def transform_SetLiteral(self, node):
        items = [self.transform(e) for e in node.elements]
        return f"{{{', '.join(items)}}}"
    
    def transform_TupleLiteral(self, node):
        items = [self.transform(e) for e in node.elements]
        if len(items) == 1:
            return f"({items[0]},)"
        return f"({', '.join(items)})"
    
    # ========== Identifiers & Variables ==========
    def transform_Identifier(self, node):
        return node.name
    
    # ========== Binary Operations ==========
    def transform_BinaryOp(self, node):
        left = self.transform(node.left)
        right = self.transform(node.right)
        op_map = {
            '+': '+', '-': '-', '*': '*', '/': '/', '//': '//', '%': '%', '**': '**',
            '&': '&', '|': '|', '^': '^', '<<': '<<', '>>': '>>',
            'and': 'and', 'or': 'or',
            '==': '==', '!=': '!=', '<': '<', '>': '>', '<=': '<=', '>=': '>=',
            'is': 'is', 'in': 'in', 'not in': 'not in',
        }
        py_op = op_map.get(node.op, node.op)
        return f"({left} {py_op} {right})"
    
    # ========== Unary Operations ==========
    def transform_UnaryOp(self, node):
        operand = self.transform(node.operand)
        op_map = {
            '-': '-', '+': '+', 'not': 'not', '~': '~'
        }
        py_op = op_map.get(node.op, node.op)
        return f"({py_op} {operand})"
    
    # ========== Function Calls ==========
    def transform_CallExpr(self, node):
        func = self.transform(node.func)
        args = [self.transform(arg) for arg in node.args]
        kwargs = [f"{k}={self.transform(v)}" for k, v in node.kwargs.items()]
        all_args = args + kwargs
        return f"{func}({', '.join(all_args)})"
    
    # ========== Indexing & Member Access ==========
    def transform_IndexExpr(self, node):
        obj = self.transform(node.obj)
        index = self.transform(node.index)
        return f"{obj}[{index}]"
    
    def transform_MemberExpr(self, node):
        obj = self.transform(node.obj)
        return f"{obj}.{node.member}"
    
    # ========== Null-Safe Operations ==========
    def transform_SafeNavExpr(self, node):
        # For Python, translate to: (obj.member if obj is not None else None)
        obj = self.transform(node.obj)
        if node.is_index:
            index = self.transform(node.member_or_index)
            return f"({obj}[{index}] if {obj} is not None else None)"
        else:
            return f"({obj}.{node.member_or_index} if {obj} is not None else None)"
    
    # ========== Pipe Operator ==========
    def transform_PipeExpr(self, node):
        # left |> right: transpile as right(left)
        left = self.transform(node.left)
        # right might be a function call or identifier
        if isinstance(node.right, CallExpr):
            # Insert left as first arg
            call = node.right
            new_args = [node.left] + call.args
            new_call = CallExpr(call.func, new_args, call.kwargs)
            return self.transform(new_call)
        else:
            # Simple function: apply it
            right = self.transform(node.right)
            return f"{right}({left})"
    
    # ========== Ternary & Coalescing ==========
    def transform_CondExpr(self, node):
        cond = self.transform(node.condition)
        true_expr = self.transform(node.true_expr)
        false_expr = self.transform(node.false_expr)
        return f"({true_expr} if {cond} else {false_expr})"
    
    def transform_ElvisExpr(self, node):
        # value ?: default → value if value else default
        value = self.transform(node.value)
        default = self.transform(node.default)
        return f"({value} if {value} else {default})"
    
    def transform_CoalesceExpr(self, node):
        # value ?? default → value if value is not None else default
        value = self.transform(node.value)
        default = self.transform(node.default)
        return f"({value} if {value} is not None else {default})"
    
    # ========== Range Expressions ==========
    def transform_RangeExpr(self, node):
        start = self.transform(node.start)
        if node.end is None:
            # Infinite range: use a large number or itertools.count
            return f"itertools.count({start})"
        end = self.transform(node.end)
        if node.exclusive:
            end_val = f"{end}"
        else:
            end_val = f"{end} + 1"
        
        if node.step:
            step = self.transform(node.step)
            return f"range({start}, {end_val}, {step})"
        return f"range({start}, {end_val})"
    
    # ========== Lambda ==========
    def transform_LambdaExpr(self, node):
        params = ", ".join(p.name for p in node.params)
        if isinstance(node.body, list):
            # Block body: collect statements
            body_code = "\n".join(self.transform(stmt) for stmt in node.body)
            body_code = "\n    ".join(body_code.split("\n"))
            return f"(lambda {params}: ({body_code}))"
        else:
            body = self.transform(node.body)
            return f"(lambda {params}: {body})"
    
    # ========== Comprehensions ==========
    def transform_ComprehensionExpr(self, node):
        expr_code = self.transform(node.expr)
        
        # Build comprehension clauses
        clauses = []
        for pattern, iterable, filters in node.comprehensions:
            pattern_code = self._transform_pattern(pattern)
            iterable_code = self.transform(iterable)
            clauses.append(f"for {pattern_code} in {iterable_code}")
            
            for f in filters:
                f_code = self.transform(f)
                clauses.append(f"if {f_code}")
        
        clause_str = " ".join(clauses)
        
        if node.expr_type == 'list':
            return f"[{expr_code} {clause_str}]"
        elif node.expr_type == 'set':
            return f"{{{expr_code} {clause_str}}}"
        elif node.expr_type == 'dict':
            return f"{{{expr_code} {clause_str}}}"
        else:
            return f"[{expr_code} {clause_str}]"
    
    # ========== Spread ==========
    def transform_SpreadExpr(self, node):
        expr = self.transform(node.expr)
        if node.is_dict:
            return f"**{expr}"
        else:
            return f"*{expr}"
    
    # ========== Match Expression ==========
    def transform_MatchExpr(self, node):
        # In Python, we can't easily have match as expression in older versions.
        # For now, return a placeholder or raise.
        raise NotImplementedError("MatchExpr as expression not yet implemented")
    
    # ========== Block Expression ==========
    def transform_BlockExpr(self, node):
        # Collect statements and return last
        if not node.statements:
            return "None"
        stmts = [self.transform(stmt) for stmt in node.statements[:-1]]
        last = self.transform(node.statements[-1])
        # For now, return just the last expression
        # A full implementation would need to handle scoping
        return last
    
    # ========== Helper: transform pattern for comprehensions ==========
    def _transform_pattern(self, pattern):
        if isinstance(pattern, IdentifierPattern):
            return pattern.name
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
        else:
            return "_"  # Wildcard/unknown

