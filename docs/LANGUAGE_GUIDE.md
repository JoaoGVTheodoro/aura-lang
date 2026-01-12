# Aura Language Guide

A comprehensive guide to writing Aura code with best practices and examples.

## Table of Contents

1. [Getting Started](#getting-started)
2. [Variables & Constants](#variables--constants)
3. [Functions](#functions)
4. [Classes & Objects](#classes--objects)
5. [Control Flow](#control-flow)
6. [Collections](#collections)
7. [Functional Programming](#functional-programming)
8. [Error Handling](#error-handling)
9. [Patterns & Idioms](#patterns--idioms)
10. [Performance Tips](#performance-tips)

## Getting Started

### Installation

```bash
cd /Volumes/SSD_240G/blueprints/aura
python3 main.py transpile examples/test.aura
```

### Your First Aura Program

```aura
// hello.aura
def main() {
    print("Hello, Aura!")
}

main()
```

Transpile and run:
```bash
python3 main.py transpile hello.aura > hello.py
python3 hello.py
# Output: Hello, Aura!
```

## Variables & Constants

### Declaring Variables

```aura
// Mutable variable with type inference
let name = "Alice"
let age = 30
let scores = [85, 90, 92]

// Explicit type annotation
let count: Int = 0
let message: String = "Hello"
let items: [String] = []

// Constants (immutable)
const PI = 3.14159
const MAX_SIZE: Int = 100
const GREETING = "Welcome to Aura!"
```

### Shadowing

```aura
let x = 5          // Int
let x = "hello"    // OK: String shadows Int
// x is now "hello"
```

### Destructuring

```aura
// List destructuring
let [first, second, ...rest] = [1, 2, 3, 4, 5]
// first = 1, second = 2, rest = [3, 4, 5]

// Dictionary destructuring
let {name, age} = {name: "Bob", age: 25}
// name = "Bob", age = 25

// Tuple destructuring
let (x, y) = (10, 20)
```

## Functions

### Basic Functions

```aura
def greet(name) {
    "Hello, " + name
}

def add(a: Int, b: Int) -> Int {
    a + b
}

// Implicit return (last expression)
def square(x: Int) -> Int {
    x * x
}

// Multiple statements
def process(n: Int) -> Int {
    let doubled = n * 2
    doubled + 1
}
```

### Default Parameters

```aura
def greet(name, greeting = "Hello") -> String {
    greeting + ", " + name
}

greet("Alice")           // "Hello, Alice"
greet("Bob", "Hi")       // "Hi, Bob"
```

### Variadic Functions

```aura
def sum(...numbers: [Int]) -> Int {
    numbers |> reduce(0, (a, b) => a + b)
}

sum()           // 0
sum(1)          // 1
sum(1, 2, 3)    // 6
```

### Named Parameters

```aura
def make_request(url: String, method: String = "GET", timeout: Int = 30) {
    // ...
}

make_request("https://api.example.com")
make_request("https://api.example.com", method="POST")
make_request(url="https://api.example.com", timeout=60)
```

### Async Functions

```aura
async def fetch_user(id: Int) -> User {
    let response = @http.get("https://api.example.com/users/" + id)
    response.json()
}

// Usage
let user = await fetch_user(42)
```

### Lambda Expressions

```aura
// Single parameter
let double = def(x) { x * 2 }
double(5)  // 10

// Multiple parameters
let add = def(a, b) { a + b }
add(3, 4)  // 7

// Shorthand (for simple expressions)
let is_positive = def(x) { x > 0 }
```

### Function Composition

```aura
def compose[A, B, C](f: (A) -> B, g: (B) -> C) -> (A) -> C {
    def(x) { g(f(x)) }
}

let add_one = def(x) { x + 1 }
let double = def(x) { x * 2 }

let add_then_double = compose(add_one, double)
add_then_double(5)  // (5 + 1) * 2 = 12
```

## Classes & Objects

### Basic Classes

```aura
class Point {
    x: Int
    y: Int

    def new(x: Int, y: Int) {
        self.x = x
        self.y = y
    }

    def distance() -> Float {
        let dx = self.x
        let dy = self.y
        sqrt(dx * dx + dy * dy)
    }
}

let p = Point.new(3, 4)
print(p.distance())  // 5.0
```

### Inheritance

```aura
class Shape {
    def area() -> Float { 0.0 }
}

class Circle(Shape) {
    radius: Float

    def new(radius: Float) {
        self.radius = radius
    }

    def area() -> Float {
        3.14159 * self.radius * self.radius
    }
}

let circle = Circle.new(5.0)
print(circle.area())  // 78.54
```

### Properties

```aura
class Rectangle {
    width: Float
    height: Float

    def new(w: Float, h: Float) {
        self.width = w
        self.height = h
    }

    @property
    def area() -> Float {
        self.width * self.height
    }

    @property
    def perimeter() -> Float {
        2 * (self.width + self.height)
    }
}

let rect = Rectangle.new(10.0, 5.0)
print(rect.area)        // 50.0
print(rect.perimeter)   // 30.0
```

### Static Methods

```aura
class Math {
    @staticmethod
    def pi() -> Float {
        3.14159
    }

    @staticmethod
    def max(a: Int, b: Int) -> Int {
        if a > b { a } else { b }
    }
}

print(Math.pi())       // 3.14159
print(Math.max(5, 10)) // 10
```

## Control Flow

### If/Else

```aura
let age = 25

if age >= 18 {
    print("Adult")
} else if age >= 13 {
    print("Teenager")
} else {
    print("Child")
}
```

### Unless

```aura
unless x > 0 {
    print("Not positive")
}
// Equivalent to: if !(x > 0) { ... }
```

### Guard

```aura
def process(value: Int) {
    guard value > 0 else {
        print("Invalid: must be positive")
        return
    }

    print("Processing: " + value)
}
```

### For Loops

```aura
// Iterate over list
for item in [1, 2, 3] {
    print(item)
}

// Iterate over range
for i in 0..10 {
    print(i * i)
}

// With index
for (i, item) in [10, 20, 30] {
    print(i + ": " + item)
}
```

### While/Until Loops

```aura
let x = 0

while x < 10 {
    print(x)
    x = x + 1
}

let y = 10

until y == 0 {
    print(y)
    y = y - 1
}
```

### Match Expressions

```aura
let value = 42

match value {
    0 -> print("zero")
    1 -> print("one")
    n if n > 0 -> print("positive")
    n -> print("other: " + n)
}

// Pattern matching with types
match user {
    {name, age} if age >= 18 -> process_adult(name)
    {name} -> process_minor(name)
}
```

### Break & Continue

```aura
for i in 0..100 {
    if i == 50 {
        break  // Exit loop
    }
    if i % 2 == 0 {
        continue  // Skip to next iteration
    }
    print(i)
}
```

## Collections

### Lists

```aura
// Create list
let numbers = [1, 2, 3, 4, 5]
let mixed = [1, "two", 3.0]  // Inferred as [Any]

// Access elements
print(numbers[0])      // 1
print(numbers[-1])     // 5 (last element)
print(numbers[1..3])   // [2, 3]

// Modify list
numbers.push(6)
numbers.pop()
numbers.insert(0, 0)
numbers.remove(0)
```

### Dictionaries

```aura
// Create dict
let user = {
    name: "Alice",
    age: 30,
    email: "alice@example.com"
}

// Access values
print(user["name"])    // "Alice"
print(user.age)        // 30

// Modify dict
user["city"] = "NYC"
user.phone = "555-1234"

// Check keys
if "email" in user {
    print(user["email"])
}
```

### Sets

```aura
let unique = {1, 2, 3, 2, 1}  // {1, 2, 3}

// Operations
unique.add(4)
unique.remove(1)
1 in unique  // false

// Set algebra
let a = {1, 2, 3}
let b = {2, 3, 4}

a | b       // Union: {1, 2, 3, 4}
a & b       // Intersection: {2, 3}
a - b       // Difference: {1}
```

## Functional Programming

### Map, Filter, Reduce

```aura
let numbers = [1, 2, 3, 4, 5]

// Map: transform each element
let doubled = numbers |> map(x => x * 2)
// [2, 4, 6, 8, 10]

// Filter: keep elements matching predicate
let even = numbers |> filter(x => x % 2 == 0)
// [2, 4]

// Reduce: combine into single value
let sum = numbers |> reduce(0, (acc, x) => acc + x)
// 15
```

### Pipe Operator

```aura
let result = [1, 2, 3, 4, 5]
    |> map(x => x * 2)
    |> filter(x => x > 4)
    |> reduce(0, (a, b) => a + b)
// = 6 + 8 + 10 = 24

// Without pipe (less readable)
let x = [1, 2, 3]
let y = map(x, n => n * 2)
let z = filter(y, n => n > 2)
```

### Comprehensions

```aura
// List comprehension
let squares = [x * x for x in [1, 2, 3, 4, 5]]
// [1, 4, 9, 16, 25]

// With condition
let even_squares = [x * x for x in [1, 2, 3, 4, 5] if x % 2 == 0]
// [4, 16]

// Dict comprehension
let powers = {x: x * x for x in [1, 2, 3, 4, 5]}
// {1: 1, 2: 4, 3: 9, 4: 16, 5: 25}

// Nested comprehension
let pairs = [(x, y) for x in [1, 2] for y in ["a", "b"]]
// [(1, "a"), (1, "b"), (2, "a"), (2, "b")]
```

### Higher-Order Functions

```aura
def apply_twice[T](f: (T) -> T, value: T) -> T {
    f(f(value))
}

let add_one = def(x) { x + 1 }
apply_twice(add_one, 5)  // 7

def repeat[T](f: (T) -> T, n: Int, value: T) -> T {
    let result = value
    for _ in 0..n {
        result = f(result)
    }
    result
}

repeat(add_one, 3, 0)  // 3
```

## Error Handling

### Try/Catch

```aura
try {
    let data = @http.get("https://api.example.com/data")
    process(data)
} catch error {
    print("Error: " + error)
}
```

### Custom Errors

```aura
class ValidationError {
    message: String
    field: String

    def new(message: String, field: String) {
        self.message = message
        self.field = field
    }
}

def validate_email(email: String) {
    if email.contains("@") {
        return email
    } else {
        throw ValidationError.new("Invalid format", "email")
    }
}
```

### Finally

```aura
try {
    let file = @file.open("data.txt")
    process(file)
} catch error {
    print("Error: " + error)
} finally {
    file.close()
}
```

## Patterns & Idioms

### Null-Safe Navigation

```aura
let user = fetch_user(id)
let city = user?.address?.city ?: "Unknown"
let zip = user?.address?.zip ?: "00000"
```

### Option Pattern

```aura
// Simulating Option/Maybe type
def safe_divide(a: Int, b: Int) -> Int | None {
    if b == 0 {
        null
    } else {
        a / b
    }
}

let result = safe_divide(10, 2)

match result {
    value: Int -> print("Result: " + value)
    null -> print("Division by zero")
}
```

### Early Return

```aura
def process_user(user) {
    if !user {
        return
    }

    if !user.is_active {
        return
    }

    // Process user...
}
```

### Lazy Evaluation

```aura
def log_expensive[T](level: String, fn: () -> T) {
    if should_log(level) {
        print(level + ": " + fn())  // fn() called only if needed
    }
}

log_expensive("debug", def() { expensive_computation() })
```

## Performance Tips

### Use Const for Immutable Values

```aura
// Good
const MAX_SIZE = 100

// Less ideal
let MAX_SIZE = 100
```

### Prefer Immutable Data

```aura
// Good
let updated = original |> map(x => x + 1)

// Avoid when possible
let copy = original
copy[0] = copy[0] + 1
```

### Use Comprehensions Over Loops

```aura
// Better
let squares = [x * x for x in numbers]

// Less efficient
let squares = []
for x in numbers {
    squares.push(x * x)
}
```

### Lazy Chains

```aura
// Transpiles to efficient Python iterators
[1, 2, 3, 4, 5]
    |> filter(x => x > 2)
    |> map(x => x * 2)
    |> take(2)
```

## Next Steps

- Read [Type System Guide](TYPES.md)
- Explore [Functional Programming Features](functional.md)
- Check [Example Files](examples/)
- Review [Semantic Rules](rules.md)
- Study [Error Handling](errors.md)

Happy coding with Aura! 🚀
