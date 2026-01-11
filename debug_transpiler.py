from transpiler.ast import ExprStmt, Identifier
from transpiler.transformers.statements import StatementTransformer

print("Instantiating Transformer...")
t = StatementTransformer()
print("Transformer methods:", [m for m in dir(t) if m.startswith('transform_')])

try:
    node = ExprStmt(Identifier("test"))
    print(f"Node: {node}, Type: {type(node)}")
    print(f"ExprStmt bases: {ExprStmt.__bases__}")
    print(f"Start MRO: {ExprStmt.__mro__}")
    from transpiler.ast import Stmt
    print(f"Stmt class: {Stmt}")
    print(f"Is Stmt? {isinstance(node, Stmt)}") 
    
    print("Calling transform...")
    result = t.transform(node)
    print("Result:", result)
except Exception as e:
    print(f"Error: {e}")
    import traceback
    traceback.print_exc()
