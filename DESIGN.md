# Aura Transpiler Design Document

## Overview

Aura is a **gradually-typed**, **functional-first** programming language that transpiles to Python 3. The transpiler converts Aura source code (.aura) to executable Python code while maintaining type safety, performance, and expressiveness.

## Design Principles

1. **Simplicity**: Straightforward syntax, minimal boilerplate
2. **Type Safety**: Optional but comprehensive type system without runtime overhead
3. **Functional First**: Pure functions, immutable data, higher-order functions
4. **Python Integration**: Seamless interoperability with Python ecosystem
5. **Clarity**: Generated code should be readable and debuggable
6. **Performance**: No unnecessary abstractions or overhead

## Architecture

### Phase Model

Aura development follows a phased approach:

```
Phase 1: Foundation (COMPLETE)
  - Basic AST nodes
  - Simple parser scaffold
  - Basic transformer
  - Project structure

Phase 2: Core Features (COMPLETE)
  - 60+ AST node types
  - ANTLR4 grammar
  - Complete expression/statement transformers
  - Type system foundation
  - 12-test suite (100% passing)
  - CLI with transpile command

Phase 3: Advanced Features (IN PROGRESS)
  - Complete type checking system
  - Error handling with source locations
  - CLI: check, format, lint, repl commands
  - Comprehensive documentation
  - ANTLR4 code generation

Phase 4: Production Ready
  - Macro system with decorators
  - Standard library
  - Package management
  - Optimization passes

Phase 5: Ecosystem
  - IDE integration (LSP, VS Code)
  - Package registry
  - REPL with debugging
  - Performance profiling
```

### Component Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                        CLI (main.py)                        │
│  transpile | check | format | lint | repl                 │
└────────────────────────┬────────────────────────────────────┘
                         │
        ┌────────────────┼────────────────┐
        │                │                │
┌───────▼────┐  ┌────────▼────────┐  ┌──▼──────────┐
│  Parser    │  │  Type System    │  │ Error       │
│            │  │                 │  │ Handling    │
│ aura.g4    │  │ types.py        │  │ errors.py   │
│ to_ast.py  │  │ - TypeChecker   │  │ - ErrorCode │
└───────┬────┘  │ - TypeInference │  │ - Collector │
        │       └────────┬────────┘  └──┬──────────┘
        │                │              │
        │                │              │
        └────────────────┼──────────────┘
                         │
                ┌────────▼────────┐
                │   AST Nodes     │
                │   (ast.py)      │
                │                 │
                │ 60+ node types  │
                └────────┬────────┘
                         │
        ┌────────────────┼────────────────┐
        │                │                │
┌───────▼──────────┐  ┌──▼──────────┐  ┌─▼────────────┐
│  ExprTransformer │  │  StmtTrans- │  │ Main         │
│                  │  │  former     │  │ Transformer  │
│ expressions.py   │  │ statements  │  │ transformer  │
│ - 50+ methods    │  │ .py         │  │ .py          │
│ - Operators      │  │ - 30+ methods   │ - Orchestrator
│ - Functions      │  │ - Control flow  │
│ - Lambdas        │  │ - Declarations  │
└────────┬─────────┘  └──┬──────────┘  └─┬────────────┘
         │               │              │
         └───────────────┼──────────────┘
                         │
                ┌────────▼─────────┐
                │  Python Code     │
                │  (generated)     │
                └──────────────────┘
```

### Data Flow

```
Aura Source (.aura)
       │
       ▼
   Parser (to_ast.py)
       │
       ▼
   AST (60+ node types)
       │
       ├──────────────────┐
       │                  │
       ▼                  ▼
   Type Checker     Transformer
   (types.py)      (transformer.py)
       │                  │
       │                  │
       └──────────┬───────┘
                  │
                  ▼
          Python Code (.py)
                  │
                  ▼
          Python Interpreter
```

## Type System Design

### Type Hierarchy

```
Type
├── AnyType
├── NeverType
├── NoneType
├── IntType
├── FloatType
├── StrType
├── BoolType
├── ListType[T]
├── DictType[K, V]
├── SetType[T]
├── TupleType[T...]
├── FunctionType[Params... → Return]
├── UnionType[T1 | T2 | ...]
├── ClassType[T]
└── TypeVariable[T]
```

### Type Inference

The type inference system:

1. **Literal Inference**: Infer types from literal values
   - `42` → `Int`
   - `3.14` → `Float`
   - `"hello"` → `String`

2. **Operation Inference**: Infer from operations
   - `2 + 3` → `Int`
   - `[1, 2, 3]` → `[Int]`
   - `{a: 1, b: 2}` → `{String: Int}`

3. **Function Inference**: From parameter/return types
   - `fn(x: Int) -> Int { x * 2 }` → `(Int) -> Int`

4. **Control Flow Narrowing**: Type refinement
   - In `if x is Int { ... }`, `x` is narrowed to `Int`

### Type Checking

The TypeChecker validates:

- **Assignments**: Value type matches variable type
- **Function calls**: Arguments match parameter types
- **Operations**: Operands are compatible
- **Return values**: Match function's return type
- **Method calls**: Method exists on object's type
- **Field access**: Field exists on object's type

## Transformer Design

### Expression Transformation

Expression transformers convert Aura expressions to Python:

```
Aura: 2 + 3
→ Python: (2 + 3)

Aura: [1, 2, 3] |> map(x => x * 2)
→ Python: list(map(lambda x: x * 2, [1, 2, 3]))

Aura: user?.address?.city
→ Python: (user.address.city if user is not None and user.address is not None else None)
```

### Statement Transformation

Statement transformers convert Aura statements to Python:

```
Aura: if x > 0 { print(x) }
→ Python: if x > 0:
          print(x)

Aura: for item in [1, 2, 3] { print(item) }
→ Python: for item in [1, 2, 3]:
          print(item)
```

## Error Handling Design

### Error Categories

1. **Syntax Errors** (E00x): Invalid grammar
2. **Type Errors** (E10x): Type mismatches
3. **Runtime Errors** (E20x): Division by zero, etc.
4. **Semantic Errors** (E30x): Duplicate definitions
5. **I/O Errors** (E40x): File not found, etc.

### Error Recovery

Errors are collected during compilation:

```python
collector = ErrorCollector()
collector.add(ErrorCode.TYPE_MISMATCH, "Expected Int, got String")
collector.add_warning(ErrorCode.UNUSED_VARIABLE, "Variable 'x' is unused")

if collector.has_errors():
    raise CompilationException(collector)
```

### Error Messages

Error messages include:
- **Location**: File, line, column
- **Message**: Clear description
- **Hint**: Suggested fix
- **Related**: Related source locations

Example:
```
error[E101]: Type mismatch: expected Int, got String
  at hello.aura:5:10
  let x: Int = "hello"
           ^ Type annotation says Int
  hint: Remove type annotation or provide an Int value
```

## Performance Considerations

### Code Generation Quality

- **Minimal wrapping**: Direct Python idioms
- **No intermediate objects**: Avoid unnecessary conversions
- **Generator-based**: Comprehensions compile to generators
- **Inlining**: Small functions are inlined

### Optimization Passes

Phase 4+ will include:

1. **Constant Folding**: Compute constant expressions at compile time
2. **Dead Code Elimination**: Remove unreachable code
3. **Function Inlining**: Replace function calls with body
4. **Loop Optimization**: Simplify comprehensions
5. **Type Specialization**: Optimize based on types

## Python Integration

### Direct Python Interop

```aura
// Use Python modules
import sys
import json

// Call Python functions
let data = json.loads(json_str)

// Create Python objects
let now = @datetime.datetime.now()
```

### Generated Code Quality

Generated Python code should be:

- **Readable**: Proper indentation and formatting
- **Debuggable**: Line numbers match source
- **Efficient**: No unnecessary operations
- **Compatible**: Works with Python 3.8+

Example:

```python
# Generated from: let x = 10
x = 10

# Generated from: fn add(a, b) { a + b }
def add(a, b):
    return a + b
```

## Extension Points

### Macros

Future macro system will support:

```aura
@macro
fn my_macro(code: String) -> String {
    // Transform code at compile time
}

@my_macro
let result = expensive_computation()
```

### Custom Transformers

Custom transformers for new syntax:

```python
class CustomTransformer(Transformer):
    def transform_MyNode(self, node):
        # Custom transformation logic
        return "..."
```

### Plugin System

Phase 4+ will support plugins:

```python
class MyPlugin(AuraPlugin):
    def register_types(self, registry):
        registry.add('MyType', MyTypeClass)
    
    def register_transformers(self, registry):
        registry.add('MyNode', MyTransformer)
```

## Testing Strategy

### Test Levels

1. **Unit Tests** (tests/): Individual components
2. **Integration Tests**: Multiple components together
3. **End-to-End Tests**: Full transpilation pipeline
4. **Performance Tests**: Benchmark generated code

### Test Coverage

- Target >80% code coverage
- Test happy paths
- Test error cases
- Test edge cases

### Example Test

```python
def test_pipe_operator():
    """Pipe operator chains functions correctly."""
    source = "[1, 2, 3] |> map(x => x * 2)"
    expected = "list(map(lambda x: x * 2, [1, 2, 3]))"
    
    ast = parse_aura(source)
    result = Transformer().transform(ast)
    
    assert result.strip() == expected
```

## Future Directions

### Phase 4+

1. **Standard Library**: Core modules (collections, math, etc.)
2. **Package Management**: Package manager and registry
3. **REPL**: Interactive shell with debugging
4. **IDE Support**: LSP server, VS Code extension
5. **Performance**: Optimization passes, benchmarking
6. **Compiler**: Ahead-of-time compilation to machine code

### Long-term Vision

Aura could evolve into:
- Standalone language with own VM
- WebAssembly compilation target
- Distributed computing support
- Advanced type system features
- Metaprogramming capabilities

## Design Decisions

### Why Gradual Typing?

- **Developer productivity**: Write code without types first
- **Flexible migration**: Gradually add types as needed
- **Python compatibility**: Python is dynamically typed
- **Type safety option**: Types available when wanted

### Why Functional-First?

- **Correctness**: Pure functions are easier to reason about
- **Concurrency**: No mutable state issues
- **Testing**: Easier to test pure functions
- **Composition**: Function composition enables reusability

### Why Transpile to Python?

- **Proven ecosystem**: Leverage Python libraries
- **Easy debugging**: Generated Python is readable
- **Rapid prototyping**: No compiler infrastructure needed
- **Compatibility**: Works anywhere Python runs

## References

- [Language Specification](aura.md)
- [Type System Guide](TYPES.md)
- [Language Guide](LANGUAGE_GUIDE.md)
- [Contributing Guide](CONTRIBUTING.md)
- [Semantic Rules](rules.md)
- [Error Handling](errors.md)
- [Functional Features](functional.md)
