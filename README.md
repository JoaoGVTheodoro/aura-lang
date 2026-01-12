# 🎆 Aura Programming Language

> A production-grade transpiler for the Aura programming language. Write clean, expressive code and compile directly to Python.

[![GitHub](https://img.shields.io/badge/GitHub-JoaoGVTheodoro%2Faura--lang-blue?logo=github)](https://github.com/JoaoGVTheodoro/aura-lang)
![Status](https://img.shields.io/badge/Status-Phase%204%20Complete-success)
![Python](https://img.shields.io/badge/Python-3.10%2B-blue)
![Tests](https://img.shields.io/badge/Tests-100%25%20Pass-success)

---

## 🚀 Features

### ✨ Production-Ready
- **Complete Standard Library**: 128+ built-in functions across 4 core modules
- **8 Built-in Macros**: Decorators for common patterns (@debug, @timeit, @memoize, @property, etc.)
- **Type Inference**: 13 type classes with full type checking and narrowing
- **72 AST Node Types**: Comprehensive language feature support
- **5 CLI Commands**: transpile, check, format, lint, repl

### 🎯 Language Features
```aura
# Functions with type inference
def fibonacci(n) -> int {
  let mut a, b = 0, 1
  for i in range(n) {
    a, b = b, a + b
  }
  ret a
}

# Classes with methods
class Counter {
  let count = 0
  
  def increment() {
    self.count += 1
  }
  
  def get_count() -> int {
    ret self.count
  }
}

# Pattern matching
match value {
  case 0 => print("zero")
  case 1 => print("one")
  case n if n > 1 => print("big")
  case _ => print("other")
}

# List comprehensions
let squares = [x * x for x in range(10) if x % 2 == 0]

# Guard statements
if let x = opt_value {
  print(x)
}

# Piping operations
let result = values
  |> filter(def(x) { x > 5 })
  |> map(def(x) { x * 2 })
```

---

## ⚡ Quick Start

### Installation
```bash
git clone https://github.com/JoaoGVTheodoro/aura-lang.git
cd aura-lang
```

### Run an Example
```bash
python3 main.py run examples/hello.aura
```

### Transpile to Python
```bash
python3 main.py transpile examples/fibonacci.aura
```

### Interactive REPL
```bash
python3 main.py repl
```

---

## 📚 Examples

### Hello World
```aura
# hello.aura
print("Hello, Aura!")
```

### Fibonacci
```aura
def fibonacci(n) -> int {
  let mut a, b = 0, 1
  for i in range(n) {
    a, b = b, a + b
  }
  ret a
}

print(fibonacci(10))
```

### Prime Checker
```aura
def is_prime(n) -> bool {
  if n < 2 ret false
  if n == 2 ret true
  if n % 2 == 0 ret false
  
  for i in range(3, int(n**0.5) + 1, 2) {
    if n % i == 0 ret false
  }
  
  ret true
}

for n in [2, 3, 5, 7, 11, 13, 17, 19, 23, 29] {
  print(f"{n} is prime: {is_prime(n)}")
}
```

### Class with Methods
```aura
class BankAccount {
  let account_number = ""
  let balance = 0.0
  
  def deposit(amount) {
    if amount > 0 {
      self.balance += amount
      print(f"Deposited {amount}, new balance: {self.balance}")
    }
  }
  
  def withdraw(amount) -> bool {
    if amount <= self.balance {
      self.balance -= amount
      print(f"Withdrew {amount}, new balance: {self.balance}")
      ret true
    }
    print("Insufficient funds")
    ret false
  }
}

let account = BankAccount {account_number: "12345", balance: 1000.0}
account.deposit(500.0)
account.withdraw(200.0)
```

### Pattern Matching
```aura
match user_input {
  case "quit" => {
    print("Goodbye!")
    exit()
  }
  case "help" => {
    print("Available commands: quit, help, status")
  }
  case cmd if str.starts_with(cmd, "run ") => {
    let script = str.slice(cmd, 4)
    print(f"Running: {script}")
  }
  case _ => {
    print("Unknown command")
  }
}
```

### Using Decorators
```aura
@timeit
def slow_calculation() {
  let mut sum = 0
  for i in range(1000000) {
    sum += i
  }
  ret sum
}

@memoize
def factorial(n) -> int {
  if n <= 1 ret 1
  ret n * factorial(n - 1)
}

result = slow_calculation()
print(factorial(5))
```

---

## 📖 Documentation

All documentation is in the [`docs/`](docs/) folder.

*   **Standards**:
    *   [AEP-001: The Zen of Aura](docs/AEP-001_Zen_of_Aura.md) (Strict Syntax Rules)

*   **Guides**:
    *   [Language Guide](docs/LANGUAGE_GUIDE.md) (Full Reference)
    *   [Standard Library](docs/STDLIB.md) (Coming Soon)

*   **Internals**:
    *   [Design Architecture](docs/DESIGN.md)
    *   [Type System](docs/TYPES.md)

---

## 🏗️ Project Structure

```
aura-lang/
├── parser/              # ANTLR4 grammar & AST generation
│   ├── aura.g4         # ANTLR4 grammar (400+ rules)
│   ├── to_ast.py       # Grammar to AST converter
│   └── generated/      # Generated parser code
├── transpiler/         # Core transpilation logic
│   ├── ast.py          # 60+ AST node types
│   ├── transformer.py  # AST to Python converter
│   ├── types.py        # Type system (13 type classes)
│   └── transformers/   # Modular transformers
├── stdlib/             # Standard library (128+ functions)
│   ├── collections.py  # List, dict, set utilities
│   ├── itertools.py    # Iterator utilities
│   ├── math.py         # Math functions
│   └── string.py       # String utilities
├── examples/           # 10+ working examples
│   ├── hello.aura
│   ├── fibonacci.aura
│   ├── prime_checker.aura
│   └── ... (7 more)
├── tests/              # Test suite (100% pass rate)
│   ├── test_parser_*.py
│   ├── test_transpiler.py
│   └── ... (comprehensive coverage)
├── docs/               # Complete documentation
├── main.py             # CLI (transpile, check, format, lint, repl)
└── pyproject.toml      # Project metadata
```

---

## 🎯 CLI Commands

### Transpile
Convert Aura to Python:
```bash
python3 main.py transpile file.aura          # Print to stdout
python3 main.py transpile file.aura -o out   # Save to file
```

### Check
Type check your code:
```bash
python3 main.py check file.aura
```

### Format
Format code style:
```bash
python3 main.py format file.aura -o out.aura
```

### Lint
Check code style:
```bash
python3 main.py lint file.aura
```

### Run
Transpile and execute:
```bash
python3 main.py run file.aura        # Run with output
python3 main.py run file.aura -v     # Show generated Python
```

### REPL
Interactive session:
```bash
python3 main.py repl
```

---

## 📊 Statistics

| Component                  | Count |
| -------------------------- | ----- |
| AST Node Types             | 60+   |
| Grammar Rules              | 400+  |
| Standard Library Functions | 128+  |
| Built-in Macros            | 8     |
| Type Classes               | 13    |
| Test Files                 | 100+  |
| Example Programs           | 10    |
| Documentation Lines        | 1000+ |
| Total Lines of Code        | 5000+ |

---

## 🧪 Testing

Run all tests:
```bash
python3 -m pytest tests/ -v
```

Run specific test:
```bash
python3 -m pytest tests/test_transpiler.py -v
```

**Current Status**: ✅ 100% tests passing

---

## 🛣️ Roadmap (Phase 5)

See [NEXT_STEPS.md](docs/NEXT_STEPS.md) for detailed roadmap.

---

## 🤝 Contributing

Contributions are welcome! Please read [CONTRIBUTING.md](docs/CONTRIBUTING.md) first.

---

## 📝 License

MIT License - see LICENSE file for details

---

## 👤 Author

**João G.V. Theodoro**
- GitHub: [@JoaoGVTheodoro](https://github.com/JoaoGVTheodoro)
- Project: [aura-lang](https://github.com/JoaoGVTheodoro/aura-lang)

---

## ⭐ Show Your Support

If you like this project, please give it a star! ⭐

---

## 📞 Support

- 📖 [Documentation](docs/)
- 🐛 [Report Issues](https://github.com/JoaoGVTheodoro/aura-lang/issues)
- 💬 [Discussions](https://github.com/JoaoGVTheodoro/aura-lang/discussions)

---

<div align="center">

**Made with ❤️ by João G.V. Theodoro**

[GitHub](https://github.com/JoaoGVTheodoro/aura-lang) • [Examples](examples/) • [Docs](docs/)

</div>
