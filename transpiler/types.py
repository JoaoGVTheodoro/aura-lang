"""Basic type system foundation for Phase 2."""
class Type:
    def __str__(self):
        return self.__class__.__name__

class AnyType(Type):
    pass

class IntType(Type):
    pass

class StrType(Type):
    pass

# utility
ANY = AnyType()
INT = IntType()
STR = StrType()


def infer_from_literal(node):
    from transpiler.ast import Number, String
    if isinstance(node, Number):
        return INT
    if isinstance(node, String):
        return STR
    return ANY
