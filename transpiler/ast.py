class Node:
    pass

class Program(Node):
    def __init__(self, statements):
        self.statements = statements

class Let(Node):
    def __init__(self, name, mutable, value):
        self.name = name
        self.mutable = mutable
        self.value = value

class Expr(Node):
    def __init__(self, value):
        self.value = value

class Identifier(Node):
    def __init__(self, name):
        self.name = name

class Number(Node):
    def __init__(self, value):
        self.value = float(value) if '.' in value else int(value)

class String(Node):
    def __init__(self, value):
        self.value = value
