"""Simple parse-to-AST converter for Aura.
This implementation handles a basic subset for Phase 2+ testing.
For production, replace with ANTLR-generated parser.

Supported forms:
- let [mut] name [: type] [= value];
- const name [: type] = value;
- expression statements
- Basic control flow (if/else, for, while)
- Function declarations
- Class declarations (basic)
"""
import re
from transpiler.ast import *

# Regex patterns
LET_RE = re.compile(r"^let\s+(mut\s+)?([a-zA-Z_][a-zA-Z0-9_]*)\s*(:\s*\w+)?\s*(=\s*(.+))?;$")
CONST_RE = re.compile(r"^const\s+([a-zA-Z_][a-zA-Z0-9_]*)\s*(:\s*\w+)?\s*=\s*(.+);$")
STRING_RE = re.compile(r"^(['\"])(.*)\1$")
NUMBER_RE = re.compile(r"^[0-9]+(\.[0-9]+)?$")
IDENT_RE = re.compile(r"^[a-zA-Z_][a-zA-Z0-9_]*$")
FUNC_DEF_RE = re.compile(r"^def\s+([a-zA-Z_][a-zA-Z0-9_]*)\s*\((.*?)\)\s*(?:->\s*(\w+))?\s*\{")
CLASS_DEF_RE = re.compile(r"^class\s+([a-zA-Z_][a-zA-Z0-9_]*)\s*\{")


def parse_value(token: str):
    """Parse a simple literal value."""
    token = token.strip()
    
    # string
    m = STRING_RE.match(token)
    if m:
        return StrLiteral(m.group(2))
    
    # number
    if NUMBER_RE.match(token):
        try:
            if '.' in token:
                return FloatLiteral(float(token))
            else:
                return IntLiteral(int(token))
        except ValueError:
            pass
    
    # boolean
    if token == 'true':
        return BoolLiteral(True)
    if token == 'false':
        return BoolLiteral(False)
    
    # null/none
    if token in ('null', 'none'):
        return NoneLiteral()
    
    # identifier/variable
    if IDENT_RE.match(token):
        return Identifier(token)
    
    # list literal
    if token.startswith('[') and token.endswith(']'):
        inner = token[1:-1].strip()
        if not inner:
            return ListLiteral([])
        elements = [parse_value(e.strip()) for e in inner.split(',')]
        return ListLiteral(elements)
    
    # dict literal
    if token.startswith('{') and token.endswith('}'):
        inner = token[1:-1].strip()
        if not inner:
            return DictLiteral([])
        pairs = []
        for pair_str in inner.split(','):
            if ':' in pair_str:
                k, v = pair_str.split(':', 1)
                pairs.append((parse_value(k.strip()), parse_value(v.strip())))
        return DictLiteral(pairs)
    
    # fallback: treat as string
    return StrLiteral(token)


def extract_block(text: str, start_pos: int) -> tuple:
    """Extract a block {...} from text starting at position.
    Returns (block_content, end_position).
    """
    depth = 0
    i = start_pos
    block_start = start_pos + 1
    
    while i < len(text):
        if text[i] == '{':
            depth += 1
        elif text[i] == '}':
            depth -= 1
            if depth == 0:
                return text[block_start:i].strip(), i + 1
        i += 1
    
    raise ValueError("Unmatched braces")


def parse_function(text: str, start_pos: int) -> tuple:
    """Parse a function definition. Returns (FunctionDecl node, end_pos)."""
    m = FUNC_DEF_RE.match(text[start_pos:])
    if not m:
        return None, start_pos
    
    func_name = m.group(1)
    params_str = m.group(2)
    return_type = m.group(3)
    
    block_start = start_pos + m.end()
    block_content, block_end = extract_block(text, block_start - 1)
    
    # Parse parameters (simplified)
    params = []
    if params_str.strip():
        for param_str in params_str.split(','):
            p = param_str.strip()
            if ':' in p:
                name, type_str = p.split(':', 1)
                params.append(Parameter(name.strip(), type_str.strip()))
            else:
                params.append(Parameter(p))
    
    # Parse body (simplified: collect statements)
    body_stmts = []
    for line in block_content.split('\n'):
        line = line.strip()
        if line and not line.startswith('//'):
            stmt = parse_statement(line)
            if stmt:
                body_stmts.append(stmt)
    
    func_decl = FunctionDecl(
        func_name,
        params,
        return_type,
        body_stmts
    )
    
    return func_decl, block_end


def parse_class(text: str, start_pos: int) -> tuple:
    """Parse a class definition. Returns (ClassDecl node, end_pos)."""
    m = CLASS_DEF_RE.match(text[start_pos:])
    if not m:
        return None, start_pos
    
    class_name = m.group(1)
    
    block_start = start_pos + m.end()
    block_content, block_end = extract_block(text, block_start - 1)
    
    # Parse class members (simplified)
    members = []
    for line in block_content.split('\n'):
        line = line.strip()
        if not line or line.startswith('//'):
            continue
        
        if line.startswith('def '):
            # Method
            method_m = re.match(r'def\s+(\w+)\s*\((.*?)\)(?:\s*->\s*(\w+))?\s*\{', line)
            if method_m:
                method_name = method_m.group(1)
                params_str = method_m.group(2)
                return_type = method_m.group(3)
                
                params = []
                if params_str.strip():
                    for p in params_str.split(','):
                        params.append(Parameter(p.strip()))
                
                method = Method(method_name, params, return_type, [])
                members.append(method)
        else:
            # Field
            if ':' in line:
                name, type_str = line.split(':', 1)
                name = name.strip()
                type_str = type_str.strip().rstrip(';')
                members.append(VarDecl(name, False, type_str, None))
    
    class_decl = ClassDecl(class_name, members)
    
    return class_decl, block_end


def parse_statement(line: str) -> Node:
    """Parse a single statement line."""
    line = line.strip()
    
    if not line or line.startswith('//'):
        return None
    
    # Remove trailing semicolon
    if line.endswith(';'):
        line = line[:-1]
    
    # let declaration
    m = LET_RE.match(line + ';')
    if m:
        mutable = bool(m.group(1))
        name = m.group(2)
        value = None
        if m.group(5):
            value = parse_value(m.group(5))
        return VarDecl(name, mutable, None, value)
    
    # const declaration
    m = CONST_RE.match(line + ';')
    if m:
        name = m.group(1)
        value = parse_value(m.group(3))
        return ConstDecl(name, None, value)
    
    # Expression statement
    value = parse_value(line)
    return ExprStmt(value)


def parse_file(path: str) -> Program:
    """Parse an Aura file and return AST."""
    with open(path, 'r', encoding='utf-8') as f:
        text = f.read()
    
    statements = []
    i = 0
    
    while i < len(text):
        # Skip whitespace
        while i < len(text) and text[i].isspace():
            i += 1
        
        if i >= len(text):
            break
        
        # Skip comments
        if text[i:i+2] == '//':
            while i < len(text) and text[i] != '\n':
                i += 1
            continue
        
        # Try function
        func, next_i = parse_function(text, i)
        if func:
            statements.append(func)
            i = next_i
            continue
        
        # Try class
        cls, next_i = parse_class(text, i)
        if cls:
            statements.append(cls)
            i = next_i
            continue
        
        # Find end of statement (;)
        stmt_end = text.find(';', i)
        if stmt_end == -1:
            break
        
        stmt_text = text[i:stmt_end + 1].strip()
        if stmt_text:
            stmt = parse_statement(stmt_text)
            if stmt:
                statements.append(stmt)
        
        i = stmt_end + 1
    
    return Program(statements)

