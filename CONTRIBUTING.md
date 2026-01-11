# Contributing to Aura

Thank you for your interest in contributing to the Aura transpiler! This guide will help you get started.

## Getting Started

### Prerequisites
- Python 3.10+
- Git
- ANTLR 4 (for grammar development - optional)

### Setup Development Environment

```bash
# Clone repository
git clone https://github.com/yourusername/aura.git
cd aura

# Create virtual environment
python3 -m venv venv
source venv/bin/activate

# Install dependencies
pip install -e .

# Install development dependencies
pip install pytest pylint mypy
```

### Run Tests

```bash
# Run all tests
python3 tests/test_transpiler.py

# Run with verbose output
python3 tests/test_transpiler.py -v

# Test individual component
python3 -m pytest tests/test_transpiler.py::test_pipe_operator
```

## Development Workflow

### 1. Understanding the Architecture

The transpiler has these main components:

- **Parser** (`parser/`): Converts Aura source to AST
  - `aura.g4`: ANTLR grammar definition
  - `to_ast.py`: Regex-based parser (Phase 2, will be replaced by ANTLR)
  
- **AST** (`transpiler/ast.py`): 60+ node types representing language constructs

- **Transformers** (`transpiler/transformers/`):
  - `expressions.py`: Transform expression AST nodes to Python
  - `statements.py`: Transform statement AST nodes to Python
  
- **Type System** (`transpiler/types.py`): Type inference and checking
  - `Type` classes: Int, Float, String, List, Dict, etc.
  - `TypeInference`: Infer types from AST nodes
  - `TypeChecker`: Validate type compatibility
  
- **Error Handling** (`transpiler/errors.py`): Structured error reporting
  - `ErrorCode`: Enumerated error types
  - `ErrorCollector`: Accumulate errors during compilation
  
- **CLI** (`main.py`): Command-line interface with transpile/check/format/lint/repl

### 2. Adding a Language Feature

Follow these steps to add a new language feature:

#### Step 1: Define AST Node

Add to `transpiler/ast.py`:

```python
@dataclass
class NewFeatureNode(Node):
    """New language feature node."""
    name: str
    value: Expr
    attributes: List[str] = field(default_factory=list)
```

#### Step 2: Update Grammar

Add to `parser/aura.g4`:

```antlr
newFeatureDecl: 'feature' IDENT '{' (attribute IDENT)* '}';
attribute: '@' IDENT;
```

#### Step 3: Update Parser

Add to `parser/to_ast.py`:

```python
def parse_feature(self, line: str) -> NewFeatureNode:
    """Parse feature declaration."""
    # Regex-based parsing logic
    return NewFeatureNode(name="...", value=...)
```

#### Step 4: Add Transformer

Add to appropriate transformer class:

```python
def transform_NewFeatureNode(self, node: NewFeatureNode) -> str:
    """Transform feature to Python."""
    name = node.name
    value = self.transform(node.value)
    return f"# Feature: {name}\n{value}"
```

#### Step 5: Add Tests

Add to `tests/test_transpiler.py`:

```python
def test_new_feature():
    source = """
    feature MyFeature {
        @attr value
    }
    """
    ast = parse_aura(source)
    result = Transformer().transform(ast)
    assert "MyFeature" in result
```

#### Step 6: Update Documentation

- Add examples to `LANGUAGE_GUIDE.md`
- Update relevant `.md` file (aura.md, rules.md, etc.)
- Add type system docs if applicable

### 3. Code Style

- **Python**: Follow PEP 8
  - Use type hints where possible
  - Maximum line length: 100 characters
  - Use f-strings for formatting

- **Aura**: Follow conventions in `LANGUAGE_GUIDE.md`
  - Use snake_case for variables/functions
  - Use PascalCase for classes/types
  - Comment complex logic

### 4. Commit Messages

Use meaningful commit messages:

```
feat: Add new language feature
fix: Resolve type checking bug
docs: Update language guide
refactor: Simplify transformer logic
test: Add tests for pipe operator
chore: Update dependencies
```

### 5. Creating a Pull Request

1. Create a feature branch: `git checkout -b feature/my-feature`
2. Make changes and commit
3. Push branch: `git push origin feature/my-feature`
4. Create PR with description of changes
5. Ensure CI passes (tests, linting)
6. Request review from maintainers
7. Address feedback and squash commits if needed
8. Merge when approved

## Areas Needing Work

### High Priority

1. **ANTLR4 Integration**
   - Generate Python lexer/parser from `aura.g4`
   - Replace regex-based `to_ast.py` with generated parser
   - Add tests for ANTLR-generated code

2. **Type System Enhancement**
   - Complete type inference for all node types
   - Add type narrowing in control flow
   - Implement union types and generics
   - Add runtime type annotations to generated Python

3. **Error Messages**
   - Add source location to all AST nodes
   - Implement source location tracking in parser
   - Create helpful error messages with hints
   - Add error recovery for better diagnostics

### Medium Priority

4. **Macro System**
   - Parse decorator syntax
   - Implement macro expansion pipeline
   - Create standard library of macros

5. **Standard Library**
   - Create `stdlib/` with core modules
   - Implement collections, itertools wrappers
   - Add file I/O, networking, JSON support

6. **Optimization**
   - Add optimization passes
   - Implement constant folding
   - Add dead code elimination
   - Optimize comprehensions to generators

### Lower Priority

7. **Package Management**
   - Create package manager (apm)
   - Setup package registry
   - Implement dependency resolution

8. **IDE Integration**
   - Create LSP server
   - Build VS Code extension
   - Add IDE language support

## Code Review Checklist

When reviewing PRs, ensure:

- [ ] Code follows style guidelines
- [ ] New features have tests
- [ ] All tests pass
- [ ] Documentation is updated
- [ ] No unnecessary dependencies added
- [ ] Error handling is appropriate
- [ ] Performance is considered

## Testing Guidelines

### Writing Tests

```python
def test_feature_name():
    """Test description."""
    # Arrange
    source = "feature code here"
    expected = "expected output"
    
    # Act
    result = transpile(source)
    
    # Assert
    assert result == expected
```

### Test Coverage

- Aim for >80% code coverage
- Test happy path
- Test error cases
- Test edge cases
- Test integration with other features

## Performance Considerations

- Minimize AST traversals
- Cache type information
- Use generators for large collections
- Profile before optimizing

## Documentation Style

- Use clear, concise language
- Include code examples
- Show input and output
- Explain rationale for design decisions
- Link to related documentation

## Getting Help

- Check existing [issues](https://github.com/yourusername/aura/issues)
- Read [discussion threads](https://github.com/yourusername/aura/discussions)
- Ask questions in PRs
- Contact maintainers on Discord/Slack

## License

By contributing, you agree that your contributions will be licensed under the same license as Aura.

---

Thank you for contributing to Aura! 🚀
