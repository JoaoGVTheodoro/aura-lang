# Aura Programming Language

Aura is a modern, expressive programming language that bridges the gap between elegant syntax and Python's vast ecosystem. It offers powerful abstractions, functional programming features, and safety guarantees while maintaining 100% compatibility with CPython.

---

## ✨ Key Features

- **Brace-Based Syntax**: Explicit block scoping with `{}` - no mandatory indentation
- **Python Ecosystem**: Full compatibility with PyPI packages and Python libraries
- **Advanced Pattern Matching**: Destructuring, guards, type patterns, and OR patterns
- **Functional Programming**: Pipe operators, composition, partial application, and immutability
- **Modern Safety**: Null-safe navigation, result types, optional chaining, and error boundaries
- **Macro System**: Compile-time metaprogramming with custom transformations
- **Rich Type System**: Gradual typing, union types, generics, and structural typing
- **Integrated Toolchain**: Formatter, linter, LSP, REPL, package manager, and test runner

---

## 🛠️ Installation & Setup

### Requirements
- Python 3.10+
- ANTLR4 Python3 Runtime

### Quick Start
```bash
# Install Aura
pip install aura-lang

# Or install from source
git clone https://github.com/aura-lang/aura
cd aura
pip install -e .

# Create a new project
aura new my_app --template=web
cd my_app

# Run your application
aura run src/main.aura

# Watch mode for development
aura dev
```

---

## 📖 Language Reference

### 1. Variables & Bindings

```aura
// Mutable bindings
let x = 10
let mut counter = 0

// Immutable by default
const PI = 3.14159
const MAX_USERS = 1000

// Type annotations
let name: str = "Aura"
let age: int = 1
let scores: list[float] = [9.5, 8.7, 9.2]

// Type aliases
type UserId = int
type Point = {x: float, y: float}
type Result<T, E> = Ok(T) | Err(E)

// Structural types
type User = {
    id: UserId,
    name: str,
    email: str,
    metadata?: dict  // Optional field
}

// Destructuring
let {x, y} = point
let [first, *rest] = numbers
let {name, age: userAge} = user
```

### 2. Control Flow

```aura
// If expressions (return values)
let status = if score >= 90 {
    "Excellent"
} else if score >= 70 {
    "Good"
} else {
    "Needs Improvement"
}

// Unless (inverted if)
unless authenticated {
    redirect("/login")
}

// Guard clauses
def process(data) {
    guard data != null else {
        return Err("No data provided")
    }
    
    guard data.length > 0 else {
        return Err("Empty data")
    }
    
    return Ok(transform(data))
}

// While loops
while x < 100 {
    x *= 2
}

// Until loops (inverted while)
until ready {
    wait(100)
}

// For loops with range
for i in 0..10 {
    print(i)
}

// For with step
for i in 0..100 step 5 {
    print(i)
}

// Loop with index
for (index, item) in enumerate(items) {
    print(f"{index}: {item}")
}

// Infinite loop
loop {
    let input = read_input()
    if input == "quit" { break }
}
```

### 3. Functions & Lambdas

```aura
// Standard function
def add(a: int, b: int) -> int {
    return a + b
}

// Expression body
def multiply(a: int, b: int) -> int = a * b

// Default parameters
def greet(name: str, greeting: str = "Hello") {
    print(f"{greeting}, {name}!")
}

// Named parameters
def create_user(name: str, *, email: str, age: int = 18) {
    return User(name, email, age)
}

create_user("Alice", email="alice@example.com")

// Variadic parameters
def sum_all(*numbers: int) -> int {
    return sum(numbers)
}

def log(level: str, **context) {
    print(f"[{level}] {context}")
}

// Arrow functions
let square = (x) => x * x
let add = (a, b) => a + b
let process = (data) => {
    validate(data)
    transform(data)
    save(data)
}

// Higher-order functions
def map_with<T, R>(fn: (T) -> R, items: list[T]) -> list[R] {
    return [fn(item) for item in items]
}

// Partial application
let add_five = add(5, _)  // Creates a function waiting for second arg
let greet_hello = greet(_, "Hello")

// Function composition
let pipeline = compose(
    strip,
    lowercase,
    remove_punctuation
)

// Async functions
async def fetch_user(id: UserId) -> User {
    let response = await api.get(f"/users/{id}")
    return await response.json()
}

// Async with error handling
async def safe_fetch(id: UserId) -> Result<User, Error> {
    try {
        let user = await fetch_user(id)
        return Ok(user)
    } catch e {
        return Err(e)
    }
}

// Generator functions
def fibonacci() {
    let a, b = 0, 1
    loop {
        yield a
        a, b = b, a + b
    }
}

// Decorator functions
@memoize
@validate_inputs
def expensive_calculation(n: int) -> int {
    return fib(n) * factorial(n)
}
```

### 4. Pattern Matching

```aura
// Basic matching
match status {
    case "success" { handle_success() }
    case "error" { handle_error() }
    case _ { handle_unknown() }
}

// Type patterns
match value {
    case int(x) if x > 0 { print("Positive int") }
    case str(s) { print(f"String: {s}") }
    case list(items) { print(f"{len(items)} items") }
    case _ { print("Other type") }
}

// Destructuring patterns
match point {
    case Point(0, 0) { print("Origin") }
    case Point(x, 0) { print(f"On X-axis at {x}") }
    case Point(0, y) { print(f"On Y-axis at {y}") }
    case Point(x, y) { print(f"At ({x}, {y})") }
}

// List patterns
match numbers {
    case [] { print("Empty") }
    case [x] { print(f"Single: {x}") }
    case [first, *middle, last] { 
        print(f"First: {first}, Last: {last}") 
    }
    case [1, 2, *rest] { print(f"Starts with 1,2") }
}

// Dictionary patterns
match config {
    case {type: "prod", **settings} {
        setup_production(settings)
    }
    case {type: "dev", debug: true} {
        setup_debug_mode()
    }
    case _ { setup_default() }
}

// Guards
match age {
    case x if x < 0 { Err("Invalid age") }
    case x if x < 18 { "Minor" }
    case x if x < 65 { "Adult" }
    case _ { "Senior" }
}

// OR patterns
match command {
    case "quit" | "exit" | "q" { exit_program() }
    case "help" | "h" | "?" { show_help() }
    case _ { process_command(command) }
}

// As patterns (binding)
match data {
    case [first, *rest as remaining] {
        print(f"First: {first}")
        print(f"Remaining: {remaining}")
    }
}

// Result type matching
match fetch_user(id) {
    case Ok(user) { display(user) }
    case Err(error) { log_error(error) }
}
```

### 5. Operators & Expressions

#### Pipe Operator
```aura
// Sequential transformation
let result = data
    |> filter(is_valid)
    |> map(transform)
    |> reduce(combine)
    |> format

// With lambdas
users
    |> filter((u) => u.age >= 18)
    |> map((u) => u.name)
    |> sort()
    |> take(10)
```

#### Null-Safe Operators
```aura
// Safe navigation
let city = user?.address?.city

// With function calls
let name = get_user()?.get_profile()?.name

// Null coalescing
let display_name = user?.name ?? "Anonymous"
let port = config?.port ?? 8080

// Null coalescing assignment
name ??= "Default Name"
```

#### Spread & Rest
```aura
// Spread in lists
let combined = [*list1, *list2, extra]
let extended = [first, *middle, last]

// Spread in dicts
let merged = {**defaults, **overrides}
let user = {name: "Alice", **metadata}

// Rest in destructuring
let [head, *tail] = numbers
let {x, y, **rest} = point3d
```

#### Range Operators
```aura
// Inclusive range
for i in 1..10 { }       // 1 to 10

// Exclusive range
for i in 1..<10 { }      // 1 to 9

// Infinite range
for i in 1.. { }         // 1, 2, 3, ...

// Range with step
for i in 0..100 step 5 { }
```

#### Conditional Expressions
```aura
// Ternary
let result = condition ? "yes" : "no"

// Elvis operator
let value = potential_null ?: default_value

// Safe index
let item = list?[index]  // Returns null if out of bounds
```

### 6. Classes & Objects

```aura
// Class definition
class User {
    // Constructor
    def __init__(self, name: str, email: str) {
        self.name = name
        self.email = email
        self._created_at = now()
    }
    
    // Properties
    @property
    def age(self) -> int {
        return calculate_age(self.birth_date)
    }
    
    // Methods
    def update_email(self, new_email: str) {
        self.email = new_email
        self.notify_change()
    }
    
    // Static method
    @staticmethod
    def validate_email(email: str) -> bool {
        return "@" in email
    }
    
    // Class method
    @classmethod
    def from_dict(cls, data: dict) -> User {
        return cls(data["name"], data["email"])
    }
}

// Dataclass (immutable by default)
@dataclass
class Point {
    x: float
    y: float
    
    def distance_to(self, other: Point) -> float {
        return sqrt((self.x - other.x)**2 + (self.y - other.y)**2)
    }
}

// Inheritance
class Admin extends User {
    def __init__(self, name: str, email: str, permissions: set[str]) {
        super().__init__(name, email)
        self.permissions = permissions
    }
    
    def has_permission(self, perm: str) -> bool {
        return perm in self.permissions
    }
}

// Traits (Protocols)
trait Drawable {
    def draw(self) -> None
    def get_bounds(self) -> Rectangle
}

class Circle implements Drawable {
    def draw(self) { /* ... */ }
    def get_bounds(self) -> Rectangle { /* ... */ }
}

// Abstract classes
@abstract
class Shape {
    @abstract
    def area(self) -> float
    
    @abstract
    def perimeter(self) -> float
    
    def describe(self) {
        print(f"Area: {self.area()}, Perimeter: {self.perimeter()}")
    }
}
```

### 7. Error Handling

```aura
// Traditional try-catch
try {
    let file = open("data.txt")
    let content = file.read()
} catch FileNotFoundError as e {
    print(f"File not found: {e}")
} catch PermissionError {
    print("Permission denied")
} catch {
    print("Unknown error")
} finally {
    file?.close()
}

// Result type (functional approach)
def divide(a: float, b: float) -> Result<float, str> {
    if b == 0 {
        return Err("Division by zero")
    }
    return Ok(a / b)
}

// Result handling with match
match divide(10, 2) {
    case Ok(result) { print(result) }
    case Err(msg) { print(f"Error: {msg}") }
}

// Option type
def find_user(id: int) -> Option<User> {
    let user = db.query(id)
    return Some(user) if user else None
}

// Unwrapping with default
let user = find_user(123).unwrap_or(default_user)

// Error propagation with ?
def process_file(path: str) -> Result<Data, Error> {
    let content = read_file(path)?  // Returns early if Err
    let parsed = parse(content)?
    return Ok(transform(parsed))
}

// Multiple error handling
def fetch_and_process() -> Result<Output, Error> {
    let data = fetch_data()
        .and_then(validate)
        .and_then(transform)
        .map(format)?
    
    return Ok(data)
}
```

### 8. Macro System

```aura
// Debug macro - logs function calls
@debug
def calculate(x: int, y: int) -> int {
    return x * y + x
}
// Generates logging for arguments and return value

// Inline macro - inlines function at call site
@inline
def fast_add(a: int, b: int) -> int = a + b

// Memoization macro
@memoize
def fibonacci(n: int) -> int {
    if n <= 1 { return n }
    return fibonacci(n-1) + fibonacci(n-2)
}

// Timing macro
@time
def expensive_operation() {
    // Automatically logs execution time
}

// Validation macro
@validate(age > 0, age < 150)
def set_age(age: int) {
    self.age = age
}

// Custom macro definition
macro assert_positive(expr) {
    quote {
        if not (${expr} > 0) {
            raise ValueError(f"${expr} must be positive")
        }
    }
}

// Compile-time constants
@const_eval
def MAX_SIZE() = 1024 * 1024

// Auto-implement trait
@derive(Eq, Hash, Debug)
class Person {
    name: str
    age: int
}
```

### 9. Advanced Types

```aura
// Union types
type StringOrInt = str | int
type Result<T> = Ok(T) | Err(str)

// Generic types
type Box<T> = {
    value: T,
    metadata: dict
}

type Pair<A, B> = {
    first: A,
    second: B
}

// Constrained generics
def sort<T: Comparable>(items: list[T]) -> list[T] {
    return sorted(items)
}

// Type guards
def is_string(value: any) -> value is str {
    return isinstance(value, str)
}

if is_string(data) {
    // TypeScript-style type narrowing
    print(data.upper())  // Safe - TypeChecker knows it's str
}

// Literal types
type HttpMethod = "GET" | "POST" | "PUT" | "DELETE"
type DiceRoll = 1 | 2 | 3 | 4 | 5 | 6

// Mapped types
type Readonly<T> = {
    [K in keyof T]: readonly T[K]
}

type Partial<T> = {
    [K in keyof T]?: T[K]
}

// Conditional types
type IsArray<T> = T extends list ? true : false
```

### 10. Modules & Imports

```aura
// Import module
import math
import json

// Import specific items
from collections import Counter, defaultdict
from typing import Optional, List

// Import with alias
import numpy as np
import pandas as pd

// Relative imports
from .utils import helpers
from ..models import User

// Import all (discouraged)
from math import *

// Module definition
module MyLib {
    export def public_function() { }
    
    def private_function() { }  // Not exported
    
    export class PublicClass { }
    
    export const VERSION = "1.0.0"
}

// Using modules
import MyLib

MyLib.public_function()
```

---

## 🎯 Advanced Features

### Async/Await & Concurrency

```aura
// Async execution
async def main() {
    let users = await fetch_users()
    let posts = await fetch_posts()
    
    return combine(users, posts)
}

// Parallel execution
async def fetch_all() {
    let results = await Promise.all([
        fetch_users(),
        fetch_posts(),
        fetch_comments()
    ])
    
    return results
}

// Async comprehension
let results = [await fetch(url) for url in urls]

// Async context manager
async with DatabaseConnection() as db {
    await db.execute(query)
}
```

### Comprehensions

```aura
// List comprehension
let squares = [x**2 for x in range(10)]
let evens = [x for x in numbers if x % 2 == 0]

// Dict comprehension
let word_lengths = {word: len(word) for word in words}

// Set comprehension
let unique_lengths = {len(word) for word in words}

// Nested comprehension
let matrix = [[i*j for j in range(5)] for i in range(5)]

// With multiple conditions
let filtered = [x for x in data if x > 0 if x < 100]
```

### Context Managers

```aura
// Using context managers
with open("file.txt") as f {
    let content = f.read()
}

// Multiple contexts
with open("input.txt") as input, open("output.txt", "w") as output {
    for line in input {
        output.write(process(line))
    }
}

// Custom context manager
class Timer {
    def __enter__(self) {
        self.start = time.time()
        return self
    }
    
    def __exit__(self, *args) {
        self.duration = time.time() - self.start
        print(f"Elapsed: {self.duration}s")
    }
}
```

---

## 📦 Tooling Reference

| Command | Description |
|---------|-------------|
| `aura new <name>` | Create a new project with scaffolding |
| `aura run <file>` | Transpile and execute Aura code |
| `aura build` | Build project for distribution |
| `aura dev` | Run development server with hot reload |
| `aura test` | Run test suite |
| `aura format <file>` | Format code to Aura style guide |
| `aura check <file>` | Type checking with mypy |
| `aura lint <file>` | Lint transpiled code |
| `aura transpile <file>` | Convert Aura to Python source |
| `aura convert <file.py>` | Convert Python to Aura |
| `aura install <package>` | Install dependency |
| `aura add <package>` | Add package to aura.toml |
| `aura remove <package>` | Remove dependency |
| `aura publish` | Publish package to registry |
| `aura doc` | Generate documentation |
| `aura repl` | Start interactive REPL |
| `aura lsp` | Start Language Server Protocol |

---

## 📁 Project Structure

```
my-aura-project/
├── src/
│   ├── main.aura           # Entry point
│   ├── models/
│   │   ├── user.aura
│   │   └── post.aura
│   ├── utils/
│   │   └── helpers.aura
│   └── stdlib/
│       └── core.aura       # Built-in utilities
├── tests/
│   ├── test_models.aura
│   └── test_utils.aura
├── docs/
│   └── README.md
├── aura.toml               # Project config & dependencies
├── .aura-version           # Aura version lock
└── README.md
```

### aura.toml Example

```toml
[project]
name = "my-app"
version = "0.1.0"
authors = ["Your Name <you@example.com>"]
description = "A sample Aura project"
license = "MIT"

[dependencies]
requests = "^2.31.0"
numpy = "^1.24.0"

[dev-dependencies]
pytest = "^7.4.0"

[build]
target = "python3.11"
optimize = true

[scripts]
start = "aura run src/main.aura"
test = "aura test"
```

---

## 🚀 Roadmap

### ✅ Phase 1: Foundation (Completed)
- [x] ANTLR4 Grammar
- [x] Custom AST Design
- [x] Core Transpiler

### ✅ Phase 2: Transformations (Completed)
- [x] Expression Transformers
- [x] Statement Transformers
- [x] Macro System
- [x] Type System Foundation

### 🔄 Phase 3: Tooling (In Progress)
- [x] CLI Tool
- [x] REPL
- [ ] LSP Server (70% complete)
- [ ] Package Manager
- [ ] Test Runner
- [ ] Debugger Integration

### 📋 Phase 4: Advanced Features (Planned)
- [ ] Compile to WASM
- [ ] JIT Compilation
- [ ] Advanced Type Inference
- [ ] IDE Plugins (VSCode, IntelliJ)
- [ ] Standard Library Expansion

---

## 💡 Examples

### Web Server
```aura
import flask

let app = Flask(__name__)

@app.route("/")
def index() {
    return "Hello from Aura!"
}

@app.route("/users/<int:user_id>")
async def get_user(user_id: int) {
    let user = await db.fetch_user(user_id)
    return user?.to_json() ?? {"error": "Not found"}
}

if __name__ == "__main__" {
    app.run(debug=true)
}
```

### Data Processing Pipeline
```aura
let results = load_csv("data.csv")
    |> filter((row) => row.age >= 18)
    |> map((row) => {name: row.name, score: row.score * 1.1})
    |> sort_by((row) => row.score, reverse=true)
    |> take(10)
    |> to_json()
```

### Pattern Matching Example
```aura
def handle_event(event: Event) {
    match event {
        case Click(x, y) if x > 100 {
            handle_right_click(x, y)
        }
        case KeyPress("Escape") {
            close_window()
        }
        case Resize(width, height) {
            update_layout(width, height)
        }
        case _ {
            log_unknown(event)
        }
    }
}
```

---

## 🤝 Contributing

We welcome contributions! Check out our [Contributing Guide](CONTRIBUTING.md) for details.

---

## 📄 License

Aura is released under the MIT License. See [LICENSE](LICENSE) for details.

---

## 🔗 Links

- **Documentation**: https://aura-lang.org/docs
- **GitHub**: https://github.com/aura-lang/aura
- **Discord**: https://discord.gg/aura-lang
- **Twitter**: https://twitter.com/aura_lang