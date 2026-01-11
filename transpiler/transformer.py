from .ast import *

class Transformer:
    def transform(self, node):
        if isinstance(node, Program):
            return "\n".join(self.transform(s) for s in node.statements)
        if isinstance(node, Let):
            val = self.transform(node.value) if node.value else 'None'
            return f"{node.name} = {val}"
        if isinstance(node, Expr):
            return self.transform(node.value)
        if isinstance(node, Identifier):
            return node.name
        if isinstance(node, Number):
            return repr(node.value)
        if isinstance(node, String):
            return repr(node.value)
        raise NotImplementedError(type(node))
