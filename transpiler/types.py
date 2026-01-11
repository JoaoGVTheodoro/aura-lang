"""Complete type system with inference, checking, and narrowing for Aura."""
from typing import Dict, List, Optional, Set, Tuple, Any
from dataclasses import dataclass, field

# ============================================================================
# Type Classes
# ============================================================================

@dataclass
class Type:
    """Base type class."""
    def __str__(self):
        return self.__class__.__name__
    
    def __eq__(self, other):
        return isinstance(other, self.__class__)
    
    def __hash__(self):
        return hash(self.__class__.__name__)
    
    def is_compatible(self, other: 'Type') -> bool:
        """Check if this type is compatible with another type."""
        return self == other or isinstance(other, AnyType) or isinstance(self, AnyType)

@dataclass
class AnyType(Type):
    """Unknown/dynamic type."""
    pass

@dataclass
class NeverType(Type):
    """Bottom type (unreachable code)."""
    pass

@dataclass
class NoneType(Type):
    """Null/None type."""
    def __str__(self):
        return "None"

@dataclass
class IntType(Type):
    """Integer type."""
    def __str__(self):
        return "Int"

@dataclass
class FloatType(Type):
    """Float type."""
    def __str__(self):
        return "Float"

@dataclass
class StrType(Type):
    """String type."""
    def __str__(self):
        return "String"

@dataclass
class BoolType(Type):
    """Boolean type."""
    def __str__(self):
        return "Bool"

@dataclass
class ListType(Type):
    """List type with element type."""
    element_type: Type = field(default_factory=lambda: AnyType())
    
    def __str__(self):
        return f"[{self.element_type}]"
    
    def is_compatible(self, other: Type) -> bool:
        if isinstance(other, ListType):
            return self.element_type.is_compatible(other.element_type)
        return super().is_compatible(other)

@dataclass
class DictType(Type):
    """Dict type with key and value types."""
    key_type: Type = field(default_factory=lambda: AnyType())
    value_type: Type = field(default_factory=lambda: AnyType())
    
    def __str__(self):
        return f"{{{self.key_type}: {self.value_type}}}"
    
    def is_compatible(self, other: Type) -> bool:
        if isinstance(other, DictType):
            return (self.key_type.is_compatible(other.key_type) and 
                    self.value_type.is_compatible(other.value_type))
        return super().is_compatible(other)

@dataclass
class SetType(Type):
    """Set type with element type."""
    element_type: Type = field(default_factory=lambda: AnyType())
    
    def __str__(self):
        return f"{{{self.element_type}}}"
    
    def is_compatible(self, other: Type) -> bool:
        if isinstance(other, SetType):
            return self.element_type.is_compatible(other.element_type)
        return super().is_compatible(other)

@dataclass
class TupleType(Type):
    """Tuple type with element types."""
    element_types: List[Type] = field(default_factory=list)
    
    def __str__(self):
        types_str = ", ".join(str(t) for t in self.element_types)
        return f"({types_str})"

@dataclass
class FunctionType(Type):
    """Function type with parameter and return types."""
    param_types: List[Type] = field(default_factory=list)
    return_type: Type = field(default_factory=lambda: AnyType())
    is_async: bool = False
    
    def __str__(self):
        params = ", ".join(str(t) for t in self.param_types)
        prefix = "async " if self.is_async else ""
        return f"{prefix}({params}) -> {self.return_type}"

@dataclass
class ClassType(Type):
    """Class type with fields and methods."""
    name: str
    fields: Dict[str, Type] = field(default_factory=dict)
    methods: Dict[str, FunctionType] = field(default_factory=dict)
    parent: Optional['ClassType'] = None
    
    def __str__(self):
        return self.name
    
    def get_field_type(self, field_name: str) -> Type:
        """Get field type with inheritance."""
        if field_name in self.fields:
            return self.fields[field_name]
        if self.parent:
            return self.parent.get_field_type(field_name)
        return AnyType()
    
    def get_method_type(self, method_name: str) -> Optional[FunctionType]:
        """Get method type with inheritance."""
        if method_name in self.methods:
            return self.methods[method_name]
        if self.parent:
            return self.parent.get_method_type(method_name)
        return None

@dataclass
class UnionType(Type):
    """Union of multiple types."""
    types: Set[Type] = field(default_factory=set)
    
    def __str__(self):
        types_str = " | ".join(sorted(str(t) for t in self.types))
        return types_str
    
    def is_compatible(self, other: Type) -> bool:
        return any(t.is_compatible(other) for t in self.types)

@dataclass
class TypeVariable(Type):
    """Generic type variable (T, U, etc.)."""
    name: str
    constraints: List[Type] = field(default_factory=list)
    
    def __str__(self):
        return self.name

# ============================================================================
# Type Inference
# ============================================================================

class TypeInference:
    """Infer types from AST nodes."""
    
    def __init__(self):
        self.builtin_types = {
            'Int': IntType(),
            'Float': FloatType(),
            'String': StrType(),
            'Bool': BoolType(),
            'None': NoneType(),
            'Any': AnyType(),
        }
    
    def infer(self, node) -> Type:
        """Infer type of an AST node."""
        from transpiler.ast import (
            IntLiteral, FloatLiteral, StrLiteral, BoolLiteral,
            ListLiteral, DictLiteral, SetLiteral,
            Identifier, BinaryOp, UnaryOp, CallExpr,
            LambdaExpr, FunctionDecl, ClassDecl,
            VarDecl, ConstDecl, IfStmt, PipeExpr,
            SafeNavExpr, CoalesceExpr, ComprehensionExpr,
            RangeExpr
        )
        
        if isinstance(node, IntLiteral):
            return IntType()
        elif isinstance(node, FloatLiteral):
            return FloatType()
        elif isinstance(node, StrLiteral):
            return StrType()
        elif isinstance(node, BoolLiteral):
            return BoolType()
        elif isinstance(node, ListLiteral):
            if node.elements:
                elem_type = self.infer(node.elements[0])
                return ListType(elem_type)
            return ListType(AnyType())
        elif isinstance(node, DictLiteral):
            if node.pairs:
                key_type = self.infer(node.pairs[0][0])
                val_type = self.infer(node.pairs[0][1])
                return DictType(key_type, val_type)
            return DictType(AnyType(), AnyType())
        elif isinstance(node, SetLiteral):
            if node.elements:
                elem_type = self.infer(node.elements[0])
                return SetType(elem_type)
            return SetType(AnyType())
        elif isinstance(node, Identifier):
            # Should be looked up in context
            return AnyType()
        elif isinstance(node, BinaryOp):
            return self._infer_binary_op(node)
        elif isinstance(node, UnaryOp):
            return self._infer_unary_op(node)
        elif isinstance(node, LambdaExpr):
            return FunctionType()
        elif isinstance(node, RangeExpr):
            return ListType(IntType())
        elif isinstance(node, ComprehensionExpr):
            if node.expression:
                return ListType(self.infer(node.expression))
            return ListType(AnyType())
        elif isinstance(node, SafeNavExpr):
            # Null-safe navigation always returns optional
            inner_type = self.infer(node.object)
            return UnionType({inner_type, NoneType()})
        elif isinstance(node, CoalesceExpr):
            # Coalesce with elvis removes None from union
            left_type = self.infer(node.left)
            if isinstance(left_type, UnionType):
                return UnionType(left_type.types - {NoneType()})
            return left_type
        else:
            return AnyType()
    
    def _infer_binary_op(self, node) -> Type:
        """Infer type of binary operation."""
        from transpiler.ast import BinaryOp
        
        left_type = self.infer(node.left)
        right_type = self.infer(node.right)
        
        if node.operator in ['+', '-', '*', '/', '%']:
            if isinstance(left_type, (IntType, FloatType)) and isinstance(right_type, (IntType, FloatType)):
                if isinstance(left_type, FloatType) or isinstance(right_type, FloatType):
                    return FloatType()
                return IntType()
            if isinstance(left_type, StrType) and node.operator == '+':
                return StrType()
            return AnyType()
        elif node.operator in ['<', '>', '<=', '>=', '==', '!=']:
            return BoolType()
        elif node.operator in ['&&', '||']:
            return BoolType()
        else:
            return AnyType()
    
    def _infer_unary_op(self, node) -> Type:
        """Infer type of unary operation."""
        operand_type = self.infer(node.operand)
        
        if node.operator == '!':
            return BoolType()
        elif node.operator == '-':
            return operand_type if isinstance(operand_type, (IntType, FloatType)) else AnyType()
        else:
            return operand_type

# ============================================================================
# Type Checker
# ============================================================================

class TypeError(Exception):
    """Type checking error."""
    pass

class TypeChecker:
    """Check type compatibility and constraints."""
    
    def __init__(self):
        self.inference = TypeInference()
        self.context: Dict[str, Type] = {}
        self.classes: Dict[str, ClassType] = {}
        self.functions: Dict[str, FunctionType] = {}
        self.errors: List[str] = []
    
    def check(self, node) -> bool:
        """Check types in AST node. Returns True if all checks pass."""
        from transpiler.ast import (
            Program, VarDecl, ConstDecl, FunctionDecl, ClassDecl,
            IfStmt, ForStmt, WhileStmt, TryStmt, ReturnStmt,
            ExprStmt, Identifier, CallExpr, BinaryOp, Assignment
        )
        
        try:
            if isinstance(node, Program):
                for stmt in node.statements:
                    self.check(stmt)
            elif isinstance(node, VarDecl):
                self._check_var_decl(node)
            elif isinstance(node, ConstDecl):
                self._check_const_decl(node)
            elif isinstance(node, FunctionDecl):
                self._check_function_decl(node)
            elif isinstance(node, ClassDecl):
                self._check_class_decl(node)
            elif isinstance(node, IfStmt):
                self._check_if_stmt(node)
            elif isinstance(node, ForStmt):
                self._check_for_stmt(node)
            elif isinstance(node, ReturnStmt):
                self._check_return_stmt(node)
            elif isinstance(node, ExprStmt):
                self._check_expr_stmt(node)
            elif isinstance(node, CallExpr):
                self._check_call_expr(node)
            elif isinstance(node, BinaryOp):
                self._check_binary_op(node)
        except TypeError as e:
            self.errors.append(str(e))
            return False
        
        return len(self.errors) == 0
    
    def _check_var_decl(self, node):
        """Check variable declaration."""
        expr_type = self.inference.infer(node.value)
        
        if node.type_annotation:
            declared_type = self._parse_type_annotation(node.type_annotation)
            if not expr_type.is_compatible(declared_type):
                raise TypeError(f"Variable '{node.name}': expected {declared_type}, got {expr_type}")
        
        self.context[node.name] = expr_type
    
    def _check_const_decl(self, node):
        """Check constant declaration."""
        self._check_var_decl(node)
    
    def _check_function_decl(self, node):
        """Check function declaration."""
        param_types = []
        if node.parameters:
            for param in node.parameters:
                if hasattr(param, 'type_annotation') and param.type_annotation:
                    param_types.append(self._parse_type_annotation(param.type_annotation))
                else:
                    param_types.append(AnyType())
        
        return_type = AnyType()
        if node.return_type:
            return_type = self._parse_type_annotation(node.return_type)
        
        func_type = FunctionType(param_types, return_type, getattr(node, 'is_async', False))
        self.functions[node.name] = func_type
        
        # Check function body
        old_context = self.context.copy()
        if node.parameters:
            for i, param in enumerate(node.parameters):
                param_name = param.name if hasattr(param, 'name') else str(param)
                self.context[param_name] = param_types[i] if i < len(param_types) else AnyType()
        
        for stmt in node.body:
            self.check(stmt)
        
        self.context = old_context
    
    def _check_class_decl(self, node):
        """Check class declaration."""
        class_type = ClassType(node.name)
        
        if node.body:
            for item in node.body:
                from transpiler.ast import VarDecl, Method
                
                if isinstance(item, VarDecl):
                    field_type = self.inference.infer(item.value) if item.value else AnyType()
                    if item.type_annotation:
                        field_type = self._parse_type_annotation(item.type_annotation)
                    class_type.fields[item.name] = field_type
                elif isinstance(item, Method):
                    method_type = self._method_to_function_type(item)
                    class_type.methods[item.name] = method_type
        
        self.classes[node.name] = class_type
    
    def _check_if_stmt(self, node):
        """Check if statement."""
        condition_type = self.inference.infer(node.condition)
        if not isinstance(condition_type, BoolType):
            self.errors.append(f"If condition must be Bool, got {condition_type}")
        
        for stmt in node.then_branch:
            self.check(stmt)
        
        if node.else_branch:
            for stmt in node.else_branch:
                self.check(stmt)
    
    def _check_for_stmt(self, node):
        """Check for statement."""
        if node.iterable:
            iter_type = self.inference.infer(node.iterable)
            if isinstance(iter_type, ListType):
                self.context[node.variable] = iter_type.element_type
            elif isinstance(iter_type, SetType):
                self.context[node.variable] = iter_type.element_type
            elif isinstance(iter_type, DictType):
                self.context[node.variable] = iter_type.key_type
            else:
                self.context[node.variable] = AnyType()
        
        for stmt in node.body:
            self.check(stmt)
    
    def _check_return_stmt(self, node):
        """Check return statement."""
        if node.value:
            return_type = self.inference.infer(node.value)
            # Can be checked against function return type in larger context
    
    def _check_expr_stmt(self, node):
        """Check expression statement."""
        self.inference.infer(node.expression)
    
    def _check_call_expr(self, node):
        """Check function call."""
        if hasattr(node, 'function') and isinstance(node.function, Identifier):
            func_name = node.function.name
            if func_name in self.functions:
                func_type = self.functions[func_name]
                if len(node.arguments) != len(func_type.param_types):
                    self.errors.append(
                        f"Function '{func_name}' expects {len(func_type.param_types)} "
                        f"arguments, got {len(node.arguments)}"
                    )
    
    def _check_binary_op(self, node):
        """Check binary operation."""
        left_type = self.inference.infer(node.left)
        right_type = self.inference.infer(node.right)
        
        if node.operator in ['+', '-', '*', '/'] and isinstance(left_type, StrType) and isinstance(right_type, StrType):
            if node.operator != '+':
                self.errors.append(f"Cannot use {node.operator} on strings")
    
    def _parse_type_annotation(self, annotation) -> Type:
        """Parse type annotation string/object to Type."""
        if isinstance(annotation, str):
            if annotation in self.inference.builtin_types:
                return self.inference.builtin_types[annotation]
            if annotation in self.classes:
                return self.classes[annotation]
            return AnyType()
        return AnyType()
    
    def _method_to_function_type(self, method) -> FunctionType:
        """Convert method to function type."""
        param_types = []
        if method.parameters:
            for param in method.parameters[1:]:  # Skip 'self'
                if hasattr(param, 'type_annotation') and param.type_annotation:
                    param_types.append(self._parse_type_annotation(param.type_annotation))
                else:
                    param_types.append(AnyType())
        
        return_type = AnyType()
        if method.return_type:
            return_type = self._parse_type_annotation(method.return_type)
        
        return FunctionType(param_types, return_type)

# ============================================================================
# Convenience Exports
# ============================================================================

ANY = AnyType()
NONE = NoneType()
INT = IntType()
FLOAT = FloatType()
STR = StrType()
BOOL = BoolType()
NEVER = NeverType()
