# Aura Language - Functions and Functional Programming Guide

A comprehensive guide to functions, functional programming paradigms, and advanced function techniques in Aura.

---

## 📋 Table of Contents

1. [Function Fundamentals](#1-function-fundamentals)
2. [Function Types and Signatures](#2-function-types-and-signatures)
3. [Arrow Functions and Lambdas](#3-arrow-functions-and-lambdas)
4. [Higher-Order Functions](#4-higher-order-functions)
5. [Closures and Scope](#5-closures-and-scope)
6. [Function Composition](#6-function-composition)
7. [Partial Application and Currying](#7-partial-application-and-currying)
8. [The Pipe Operator](#8-the-pipe-operator)
9. [Recursion](#9-recursion)
10. [Pure Functions and Side Effects](#10-pure-functions-and-side-effects)
11. [Async Functions](#11-async-functions)
12. [Generators and Iterators](#12-generators-and-iterators)
13. [Decorators and Function Modification](#13-decorators-and-function-modification)
14. [Advanced Patterns](#14-advanced-patterns)
15. [Best Practices](#15-best-practices)

---

## 1. Function Fundamentals

### 1.1 Basic Function Declaration

```aura
// Standard function with explicit return
def greet(name: str) -> str {
    return f"Hello, {name}!"
}

// Function with multiple parameters
def add(a: int, b: int) -> int {
    return a + b
}

// Function with no return value
def print_message(message: str) -> none {
    print(message)
}

// Shorter: omit return type for void functions
def log(message: str) {
    print(f"[LOG] {message}")
}
```

### 1.2 Expression-Body Functions

```aura
// Single expression functions use = instead of block
def square(x: int) -> int = x * x

def multiply(a: int, b: int) -> int = a * b

def is_even(n: int) -> bool = n % 2 == 0

def get_full_name(first: str, last: str) -> str = f"{first} {last}"

// Can include type inference
def double(x) = x * 2  // Type inferred from usage
```

### 1.3 Default Parameters

```aura
// Parameters with default values
def greet(name: str, greeting: str = "Hello") -> str {
    return f"{greeting}, {name}!"
}

greet("Alice")              // "Hello, Alice!"
greet("Bob", "Hi")          // "Hi, Bob!"

// Multiple defaults
def create_user(
    name: str,
    age: int = 18,
    country: str = "USA",
    active: bool = true
) -> User {
    return User(name, age, country, active)
}

create_user("Alice")                           // Uses all defaults
create_user("Bob", age=25)                    // Override age
create_user("Charlie", country="UK", age=30)  // Override multiple
```

### 1.4 Keyword-Only Parameters

```aura
// Force callers to use keyword arguments
def create_account(
    username: str,
    *,  // Everything after * must be passed by keyword
    email: str,
    password: str,
    admin: bool = false
) -> Account {
    return Account(username, email, password, admin)
}

// Must use keywords
create_account(
    "alice",
    email="alice@example.com",
    password="secret123"
)

// Error: positional arguments not allowed
// create_account("alice", "alice@example.com", "secret123")
```

### 1.5 Variadic Parameters

```aura
// Variable number of positional arguments
def sum_all(*numbers: int) -> int {
    return sum(numbers)
}

sum_all(1, 2, 3)           // 6
sum_all(1, 2, 3, 4, 5)     // 15

// Variable number of keyword arguments
def create_config(**options) -> Config {
    let config = Config()
    for key, value in options.items() {
        config.set(key, value)
    }
    return config
}

create_config(
    host="localhost",
    port=8080,
    debug=true
)

// Combining all parameter types
def complex_function(
    required: str,              // Required positional
    optional: int = 10,         // Optional positional
    *args: str,                 // Variable positional
    keyword_only: bool,         // Keyword-only
    **kwargs                    // Variable keyword
) {
    print(f"Required: {required}")
    print(f"Optional: {optional}")
    print(f"Args: {args}")
    print(f"Keyword: {keyword_only}")
    print(f"Kwargs: {kwargs}")
}
```

### 1.6 Function Overloading (via Type Dispatch)

```aura
// Multiple implementations based on types
def process(value: int) -> str {
    return f"Processing integer: {value}"
}

def process(value: str) -> str {
    return f"Processing string: {value}"
}

def process(value: list) -> str {
    return f"Processing list of {len(value)} items"
}

// Called based on argument type
process(42)         // "Processing integer: 42"
process("hello")    // "Processing string: hello"
process([1, 2, 3])  // "Processing list of 3 items"
```

---

## 2. Function Types and Signatures

### 2.1 Function Type Annotations

```aura
// Simple function type
type IntFunction = (int) -> int
type Predicate = (str) -> bool
type Callback = () -> none

// Using function types
let square_func: IntFunction = (x) => x * x
let is_valid: Predicate = (s) => s.length() > 0
let on_complete: Callback = () => print("Done!")

// Function types with multiple parameters
type BinaryOp = (int, int) -> int
type Comparator<T> = (T, T) -> int

let add: BinaryOp = (a, b) => a + b
let compare_strings: Comparator<str> = (a, b) => {
    if a < b { return -1 }
    if a > b { return 1 }
    return 0
}
```

### 2.2 Generic Function Signatures

```aura
// Generic function
def identity<T>(value: T) -> T {
    return value
}

identity(42)        // T = int
identity("hello")   // T = str
identity([1, 2])    // T = list[int]

// Multiple type parameters
def pair<A, B>(first: A, second: B) -> tuple[A, B] {
    return (first, second)
}

pair(1, "hello")    // tuple[int, str]
pair(true, 3.14)    // tuple[bool, float]

// Generic with constraints
def sort_items<T: Comparable>(items: list[T]) -> list[T] {
    return sorted(items)
}

// Generic function type
type Mapper<T, R> = (T) -> R
type Reducer<T, R> = (R, T) -> R

def map_list<T, R>(fn: Mapper<T, R>, items: list[T]) -> list[R] {
    return [fn(item) for item in items]
}
```

### 2.3 Type Inference in Functions

```aura
// Full type annotations
def explicit_add(a: int, b: int) -> int {
    return a + b
}

// Type inference for locals
def inferred_function(x: int, y: int) {
    let sum = x + y        // Inferred as int
    let doubled = sum * 2  // Inferred as int
    let message = f"Result: {doubled}"  // Inferred as str
    return message         // Return type inferred as str
}

// Partial inference
def hybrid(x: int) {
    return x * 2  // Return type inferred as int
}
```

---

## 3. Arrow Functions and Lambdas

### 3.1 Arrow Function Syntax

```aura
// Single parameter, expression body
let square = (x) => x * x

// Multiple parameters
let add = (a, b) => a + b

// No parameters
let get_random = () => random.random()

// With type annotations
let typed_add: (int, int) -> int = (a, b) => a + b

// Block body for complex logic
let process = (data) => {
    let validated = validate(data)
    let transformed = transform(validated)
    return save(transformed)
}
```

### 3.2 Lambda Expressions

```aura
// Inline lambdas
let numbers = [1, 2, 3, 4, 5]

// Filter with lambda
let evens = numbers.filter((x) => x % 2 == 0)

// Map with lambda
let squares = numbers.map((x) => x * x)

// Sort with lambda
let sorted_desc = numbers.sort((a, b) => b - a)

// Multiple statement lambda
let process_and_log = numbers.map((x) => {
    print(f"Processing {x}")
    return x * 2
})
```

### 3.3 Capturing Variables (Closures Preview)

```aura
// Arrow functions capture outer scope
def make_adder(x: int) -> (int) -> int {
    return (y) => x + y  // Captures x
}

let add_five = make_adder(5)
print(add_five(3))  // 8
print(add_five(10)) // 15

// Capturing in loops
let multipliers = []
for i in range(1, 4) {
    multipliers.append((x) => x * i)
}

// Each lambda captures different value of i
print(multipliers[0](10))  // 10 (1 * 10)
print(multipliers[1](10))  // 20 (2 * 10)
print(multipliers[2](10))  // 30 (3 * 10)
```

---

## 4. Higher-Order Functions

### 4.1 Functions as Arguments

```aura
// Function that takes function as parameter
def apply_twice(fn: (int) -> int, value: int) -> int {
    return fn(fn(value))
}

let double = (x) => x * 2
print(apply_twice(double, 5))  // 20

// Generic higher-order function
def apply<T>(fn: (T) -> T, value: T) -> T {
    return fn(value)
}

print(apply((x) => x * 2, 10))      // 20
print(apply((s) => s.upper(), "hi")) // "HI"
```

### 4.2 Functions as Return Values

```aura
// Function that returns function
def make_multiplier(factor: int) -> (int) -> int {
    return (x) => x * factor
}

let double = make_multiplier(2)
let triple = make_multiplier(3)

print(double(10))  // 20
print(triple(10))  // 30

// Returning different functions based on condition
def get_operation(op: str) -> (int, int) -> int {
    match op {
        case "add" { return (a, b) => a + b }
        case "subtract" { return (a, b) => a - b }
        case "multiply" { return (a, b) => a * b }
        case "divide" { return (a, b) => a / b }
        case _ { return (a, b) => 0 }
    }
}

let operation = get_operation("add")
print(operation(10, 5))  // 15
```

### 4.3 Built-in Higher-Order Functions

```aura
let numbers = [1, 2, 3, 4, 5]

// map - transform each element
let doubled = numbers.map((x) => x * 2)
// [2, 4, 6, 8, 10]

// filter - keep elements matching predicate
let evens = numbers.filter((x) => x % 2 == 0)
// [2, 4]

// reduce - accumulate to single value
let sum = numbers.reduce((acc, x) => acc + x, 0)
// 15

// forEach - side effects for each element
numbers.forEach((x) => print(x))

// any - check if any element matches
let has_even = numbers.any((x) => x % 2 == 0)  // true

// all - check if all elements match
let all_positive = numbers.all((x) => x > 0)   // true

// find - get first matching element
let first_even = numbers.find((x) => x % 2 == 0)  // Some(2)

// partition - split by predicate
let (evens, odds) = numbers.partition((x) => x % 2 == 0)
// evens = [2, 4], odds = [1, 3, 5]
```

### 4.4 Custom Higher-Order Functions

```aura
// Retry function
def retry<T>(
    fn: () -> T,
    max_attempts: int = 3,
    delay: float = 1.0
) -> T {
    let mut attempts = 0
    
    loop {
        attempts += 1
        try {
            return fn()
        } catch Exception as e {
            if attempts >= max_attempts {
                raise e
            }
            sleep(delay)
        }
    }
}

// Usage
let data = retry(
    () => fetch_from_api(),
    max_attempts=5,
    delay=2.0
)

// Memoization wrapper
def memoize<T, R>(fn: (T) -> R) -> (T) -> R {
    let cache: dict[T, R] = {}
    
    return (arg) => {
        if arg in cache {
            return cache[arg]
        }
        let result = fn(arg)
        cache[arg] = result
        return result
    }
}

// Usage
let expensive_calc = (n) => {
    sleep(1)  // Simulate expensive operation
    return n * n
}

let memoized_calc = memoize(expensive_calc)
print(memoized_calc(10))  // Takes 1 second
print(memoized_calc(10))  // Instant (cached)

// Timing wrapper
def time_it<T>(fn: () -> T) -> T {
    let start = time.time()
    let result = fn()
    let duration = time.time() - start
    print(f"Execution time: {duration:.3f}s")
    return result
}

// Usage
let result = time_it(() => {
    // Some expensive operation
    return sum(range(1_000_000))
})
```

---

## 5. Closures and Scope

### 5.1 Closure Basics

```aura
// Closure captures outer scope
def make_counter() -> () -> int {
    let mut count = 0
    
    return () => {
        count += 1
        return count
    }
}

let counter1 = make_counter()
print(counter1())  // 1
print(counter1())  // 2
print(counter1())  // 3

let counter2 = make_counter()
print(counter2())  // 1 (independent counter)
```

### 5.2 Lexical Scoping

```aura
let x = 10

def outer() {
    let y = 20
    
    def inner() {
        let z = 30
        print(x)  // Accesses global x
        print(y)  // Accesses outer's y
        print(z)  // Accesses local z
    }
    
    inner()
}

outer()

// Scope chain: inner -> outer -> global
```

### 5.3 Closure with Multiple Variables

```aura
def make_account(initial_balance: float) {
    let mut balance = initial_balance
    
    return {
        deposit: (amount) => {
            balance += amount
            return balance
        },
        withdraw: (amount) => {
            if amount > balance {
                raise ValueError("Insufficient funds")
            }
            balance -= amount
            return balance
        },
        get_balance: () => balance
    }
}

let account = make_account(100.0)
print(account.get_balance())     // 100.0
print(account.deposit(50.0))     // 150.0
print(account.withdraw(30.0))    // 120.0
```

### 5.4 Closure Gotchas

```aura
// ❌ Common mistake: capturing loop variable
let functions = []
for i in range(3) {
    functions.append(() => print(i))
}

// All print 2 (last value of i)
functions[0]()  // 2
functions[1]()  // 2
functions[2]()  // 2

// ✅ Solution: use closure parameter
let functions = []
for i in range(3) {
    let capture = i  // Create local copy
    functions.append(() => print(capture))
}

functions[0]()  // 0
functions[1]()  // 1
functions[2]()  // 2

// ✅ Better: use map
let functions = range(3).map((i) => () => print(i))
```

---

## 6. Function Composition

### 6.1 Manual Composition

```aura
// Composing functions manually
let add_one = (x) => x + 1
let double = (x) => x * 2
let square = (x) => x * x

// Nested calls
let result = square(double(add_one(5)))
// 5 -> 6 -> 12 -> 144

// Step by step
let step1 = add_one(5)    // 6
let step2 = double(step1)  // 12
let step3 = square(step2)  // 144
```

### 6.2 Compose Function

```aura
// Generic compose function (right to left)
def compose<A, B, C>(
    f: (B) -> C,
    g: (A) -> B
) -> (A) -> C {
    return (x) => f(g(x))
}

let add_one = (x) => x + 1
let double = (x) => x * 2

let add_then_double = compose(double, add_one)
print(add_then_double(5))  // 12 (5 + 1 = 6, 6 * 2 = 12)

// Compose multiple functions
def compose_all<T>(*functions: (T) -> T) -> (T) -> T {
    return (x) => {
        let mut result = x
        for fn in reversed(functions) {
            result = fn(result)
        }
        return result
    }
}

let pipeline = compose_all(square, double, add_one)
print(pipeline(5))  // 144
```

### 6.3 Pipe Function (Left to Right)

```aura
// Pipe function - more natural left-to-right
def pipe<A, B, C>(
    g: (A) -> B,
    f: (B) -> C
) -> (A) -> C {
    return (x) => f(g(x))
}

let add_then_double = pipe(add_one, double)
print(add_then_double(5))  // 12

// Pipe multiple functions
def pipe_all<T>(*functions: (T) -> T) -> (T) -> T {
    return (x) => {
        let mut result = x
        for fn in functions {
            result = fn(result)
        }
        return result
    }
}

let transform = pipe_all(
    add_one,
    double,
    square
)

print(transform(5))  // 144 (5 -> 6 -> 12 -> 144)
```

### 6.4 Practical Composition Examples

```aura
// String processing pipeline
let trim = (s: str) => s.strip()
let lowercase = (s: str) => s.lower()
let remove_spaces = (s: str) => s.replace(" ", "")

let normalize = pipe_all(trim, lowercase, remove_spaces)

print(normalize("  Hello World  "))  // "helloworld"

// Data transformation pipeline
let parse_json = (s: str) => json.loads(s)
let extract_names = (data: dict) => data["users"].map((u) => u["name"])
let sort_names = (names: list) => sorted(names)

let process_users = pipe_all(
    parse_json,
    extract_names,
    sort_names
)

let json_data = '{"users": [{"name": "Bob"}, {"name": "Alice"}]}'
print(process_users(json_data))  // ["Alice", "Bob"]
```

---

## 7. Partial Application and Currying

### 7.1 Partial Application

```aura
// Manual partial application
def greet(greeting: str, name: str) -> str {
    return f"{greeting}, {name}!"
}

def make_greeter(greeting: str) -> (str) -> str {
    return (name) => greet(greeting, name)
}

let say_hello = make_greeter("Hello")
let say_hi = make_greeter("Hi")

print(say_hello("Alice"))  // "Hello, Alice!"
print(say_hi("Bob"))       // "Hi, Bob!"

// Using placeholder _
let add = (a: int, b: int) => a + b
let add_five = add(5, _)  // Placeholder for second argument

print(add_five(10))  // 15
print(add_five(20))  // 25

// Multiple placeholders
let subtract = (a: int, b: int) => a - b
let subtract_from_100 = subtract(100, _)
let subtract_5_from = subtract(_, 5)

print(subtract_from_100(30))  // 70 (100 - 30)
print(subtract_5_from(20))    // 15 (20 - 5)
```

### 7.2 Currying

```aura
// Curried function - one parameter at a time
def curry_add(a: int) -> (int) -> int {
    return (b) => a + b
}

let add_5 = curry_add(5)
print(add_5(3))  // 8

// Generic curry function
def curry<A, B, C>(fn: (A, B) -> C) -> (A) -> (B) -> C {
    return (a) => (b) => fn(a, b)
}

let add = (a: int, b: int) => a + b
let curried_add = curry(add)

print(curried_add(5)(3))  // 8

// Currying three parameters
def curry3<A, B, C, D>(
    fn: (A, B, C) -> D
) -> (A) -> (B) -> (C) -> D {
    return (a) => (b) => (c) => fn(a, b, c)
}

let add_three = (a: int, b: int, c: int) => a + b + c
let curried = curry3(add_three)

print(curried(1)(2)(3))  // 6

// Partial application from curried
let add_1 = curried(1)
let add_1_2 = add_1(2)
print(add_1_2(3))  // 6
```

### 7.3 Practical Applications

```aura
// Configurable functions
def make_validator(min_length: int, max_length: int) {
    return (s: str) => {
        return min_length <= s.length() <= max_length
    }
}

let validate_username = make_validator(3, 20)
let validate_password = make_validator(8, 100)

print(validate_username("ab"))      // false
print(validate_username("alice"))   // true
print(validate_password("short"))   // false

// Event handlers with context
def make_click_handler(element_id: str) {
    return (event) => {
        print(f"Element {element_id} clicked!")
        process_event(event)
    }
}

let button1_handler = make_click_handler("submit-btn")
let button2_handler = make_click_handler("cancel-btn")

// Database queries with partial application
def query_users(status: str, role: str) -> list[User] {
    return db.query(
        "SELECT * FROM users WHERE status = ? AND role = ?",
        status, role
    )
}

let get_active_users = curry(query_users)("active")
let get_active_admins = get_active_users("admin")
let get_active_users_regular = get_active_users("user")

print(get_active_admins())  // Active admin users
print(get_active_users_regular())  // Active regular users
```

---

## 8. The Pipe Operator

### 8.1 Basic Pipe Usage

```aura
// Without pipe - nested calls
let result = save(transform(validate(parse(data))))

// With pipe - left-to-right flow
let result = data
    |> parse
    |> validate
    |> transform
    |> save

// With arguments
let numbers = [1, 2, 3, 4, 5]
let result = numbers
    |> filter((x) => x % 2 == 0)
    |> map((x) => x * 2)
    |> reduce((acc, x) => acc + x, 0)

// Result: 12 ([2, 4] -> [4, 8] -> 12)
```

### 8.2 Pipe with Method Calls

```aura
// String processing
let text = "  Hello World  "
let processed = text
    |> strip
    |> lower
    |> replace(" ", "-")

print(processed)  // "hello-world"

// List processing
let data = [1, -2, 3, -4, 5]
let result = data
    |> filter((x) => x > 0)
    |> map((x) => x ** 2)
    |> sorted
    |> reversed

print(result)  // [25, 9, 1]
```

### 8.3 Complex Pipe Chains

```aura
// Data processing pipeline
let users = load_users()
    |> filter((u) => u.is_active)
    |> map((u) => {
        name: u.name,
        email: u.email,
        score: calculate_score(u)
    })
    |> sort_by((u) => u.score, reverse=true)
    |> take(10)
    |> to_json

// API response pipeline
let response = request
    |> validate_request
    |> authenticate
    |> authorize
    |> process_request
    |> format_response
    |> add_headers

// File processing
let content = open("data.csv")
    |> read
    |> parse_csv
    |> filter_rows((row) => row["status"] == "active")
    |> transform_rows((row) => enhance(row))
    |> aggregate_by("category")
    |> to_dataframe
```

### 8.4 Pipe with Custom Functions

```aura
// Define pipeline stages
def parse_input(text: str) -> dict {
    return json.loads(text)
}

def validate_data(data: dict) -> dict {
    if "name" not in data {
        raise ValidationError("Name required")
    }
    return data
}

def enrich_data(data: dict) -> dict {
    data["timestamp"] = time.time()
    data["processed"] = true
    return data
}

def save_to_db(data: dict) -> int {
    return database.insert("records", data)
}

// Use in pipeline
let record_id = raw_input
    |> parse_input
    |> validate_data
    |> enrich_data
    |> save_to_db

print(f"Saved with ID: {record_id}")
```

### 8.5 Pipe vs Composition

```aura
// Composition (right-to-left)
let process = compose(save, transform, validate, parse)
let result = process(data)

// Pipe operator (left-to-right, more readable)
let result = data
    |> parse
    |> validate
    |> transform
    |> save

// Pipe is syntax sugar for nested calls
// These are equivalent:
let r1 = data |> f |> g |> h
let r2 = h(g(f(data)))

// But pipe is more readable for complex chains
let users = load_data()
    |> filter_active
    |> sort_by_name
    |> map_to_dto
    |> paginate(page=1, size=20)
    |> to_json

// vs.
let users = to_json(
    paginate(
        map_to_dto(
            sort_by_name(
                filter_active(
                    load_data()
                )
            )
        ),
        page=1,
        size=20
    )
)
```

---

## 9. Recursion

### 9.1 Basic Recursion

```aura
// Factorial
def factorial(n: int) -> int {
    if n <= 1 {
        return 1
    }
    return n * factorial(n - 1)
}

print(factorial(5))  // 120

// Fibonacci
def fibonacci(n: int) -> int {
    if n <= 1 {
        return n
    }
    return fibonacci(n - 1) + fibonacci(n - 2)
}

print(fibonacci(10))  // 55

// Sum of list
def sum_list(numbers: list[int]) -> int {
    if not numbers {
        return 0
    }
    let [head, *tail] = numbers
    return head + sum_list(tail)
}

print(sum_list([1, 2, 3, 4, 5]))  // 15
```

### 9.2 Tail Recursion

```aura
// Non-tail recursive (builds up stack)
def factorial_normal(n: int) -> int {
    if n <= 1 {
        return 1
    }
    return n * factorial_normal(n - 1)  // Operation after recursive call
}

// Tail recursive (can be optimized)
def factorial_tail(n: int, acc: int = 1) -> int {
    if n <= 1 {
        return acc
    }
    return factorial_tail(n - 1, n * acc)  // Recursive call is last operation
}

print(factorial_tail(5))  // 120

// Tail recursive sum
def sum_tail(numbers: list[int], acc: int = 0) -> int {
    if not numbers {
        return acc
    }
    let [head, *tail] = numbers
    return sum_tail(tail, acc + head)
}

// Tail recursive reverse
def reverse_tail(items: list, acc: list = []) -> list {
    if not items {
        return acc
    }
    let [head, *tail] = items
    return reverse_tail(tail, [head, *acc])
}

print(reverse_tail([1, 2, 3, 4, 5]))  // [5, 4, 3, 2, 1]
```

### 9.3 Mutual Recursion

```aura
// Two functions calling each other
def is_even(n: int) -> bool {
    if n == 0 {
        return true
    }
    return is_odd(n - 1)
}

def is_odd(n: int) -> bool {
    if n == 0 {
        return false
    }
    return is_even(n - 1)
}

print(is_even(4))  // true
print(is_odd(4))   // false
print(is_even(7))  // false
print(is_odd(7))   // true

// Tree traversal with mutual recursion
def process_node(node: Node) {
    print(f"Processing {node.value}")
    process_children(node.children)
}

def process_children(children: list[Node]) {
    for child in children {
        process_node(child)
    }
}
```

### 9.4 Memoized Recursion

```aura
// Without memoization - slow for large n
def fib_slow(n: int) -> int {
    if n <= 1 {
        return n
    }
    return fib_slow(n - 1) + fib_slow(n - 2)
}

// With memoization - much faster
@memoize
def fib_fast(n: int) -> int {
    if n <= 1 {
        return n
    }
    return fib_fast(n - 1) + fib_fast(n - 2)
}

// Manual memoization
def fib_memo(n: int, cache: dict[int, int] = {}) -> int {
    if n in cache {
        return cache[n]
    }
    
    if n <= 1 {
        return n
    }
    
    cache[n] = fib_memo(n - 1, cache) + fib_memo(n - 2, cache)
    return cache[n]
}

print(fib_fast(100))  // Fast!
print(fib_slow(100))  // Very slow!
```

### 9.5 Recursive Data Structures

```aura
// Binary tree operations
type Tree<T> = 
    | Leaf
    | Node(value: T, left: Tree<T>, right: Tree<T>)

def tree_sum(tree: Tree[int]) -> int {
    match tree {
        case Leaf { return 0 }
        case Node(value, left, right) {
            return value + tree_sum(left) + tree_sum(right)
        }
    }
}

def tree_map<T, R>(tree: Tree[T], fn: (T) -> R) -> Tree[R] {
    match tree {
        case Leaf { return Leaf }
        case Node(value, left, right) {
            return Node(
                fn(value),
                tree_map(left, fn),
                tree_map(right, fn)
            )
        }
    }
}

def tree_height<T>(tree: Tree[T]) -> int {
    match tree {
        case Leaf { return 0 }
        case Node(_, left, right) {
            return 1 + max(tree_height(left), tree_height(right))
        }
    }
}

// Linked list operations
type List<T> = 
    | Empty
    | Cons(head: T, tail: List<T>)

def list_length<T>(list: List[T]) -> int {
    match list {
        case Empty { return 0 }
        case Cons(_, tail) { return 1 + list_length(tail) }
    }
}

def list_reverse<T>(list: List[T>, acc: List[T] = Empty) -> List[T] {
    match list {
        case Empty { return acc }
        case Cons(head, tail) {
            return list_reverse(tail, Cons(head, acc))
        }
    }
}
```

---

## 10. Pure Functions and Side Effects

### 10.1 Pure Functions

```aura
// ✅ Pure function - same input always produces same output
def add(a: int, b: int) -> int {
    return a + b
}

def square(x: int) -> int {
    return x * x
}

def get_full_name(first: str, last: str) -> str {
    return f"{first} {last}"
}

// Pure functions are:
// - Deterministic (same input -> same output)
// - No side effects
// - No external state dependence
// - Easier to test
// - Can be memoized
// - Thread-safe

// ✅ Pure with immutable data
def add_item(items: list[int], item: int) -> list[int] {
    return [*items, item]  // Returns new list
}

let list1 = [1, 2, 3]
let list2 = add_item(list1, 4)  // list1 unchanged
print(list1)  // [1, 2, 3]
print(list2)  // [1, 2, 3, 4]
```

### 10.2 Impure Functions (Side Effects)

```aura
// ❌ Impure - modifies external state
let mut global_counter = 0

def increment_counter() -> int {
    global_counter += 1  // Side effect!
    return global_counter
}

// ❌ Impure - depends on external state
def get_next_id() -> int {
    return global_counter  // Depends on mutable global
}

// ❌ Impure - I/O operations
def read_config() -> dict {
    return json.loads(open("config.json").read())  // File I/O
}

// ❌ Impure - network calls
def fetch_data() -> dict {
    return http.get("https://api.example.com/data").json()
}

// ❌ Impure - random values
def get_random_number() -> int {
    return random.randint(1, 100)  // Non-deterministic
}

// ❌ Impure - current time
def get_timestamp() -> int {
    return int(time.time())  // Changes every call
}

// ❌ Impure - mutates argument
def append_item(items: list, item: any) {
    items.append(item)  // Mutates input!
}
```

### 10.3 Managing Side Effects

```aura
// ✅ Isolate side effects
// Pure core logic
def calculate_discount(price: float, percent: float) -> float {
    return price * (1 - percent / 100)
}

// Impure I/O wrapper
def apply_discount_and_save(product_id: int, discount_percent: float) {
    let product = load_product(product_id)  // Side effect
    let new_price = calculate_discount(product.price, discount_percent)  // Pure
    product.price = new_price
    save_product(product)  // Side effect
}

// ✅ Make dependencies explicit
def process_order(
    order: Order,
    load_user: (int) -> User,      // Injected dependencies
    send_email: (str, str) -> none
) {
    let user = load_user(order.user_id)
    // ... processing ...
    send_email(user.email, "Order confirmed")
}

// ✅ Return values instead of mutating
def update_user(user: User, new_email: str) -> User {
    return User(
        id=user.id,
        name=user.name,
        email=new_email  // New user object
    )
}
```

### 10.4 Functional Core, Imperative Shell

```aura
// Pure core - all business logic
def calculate_total(items: list[CartItem]) -> float {
    return sum(item.price * item.quantity for item in items)
}

def apply_tax(total: float, tax_rate: float) -> float {
    return total * (1 + tax_rate)
}

def create_invoice(order: Order, total: float) -> Invoice {
    return Invoice(
        order_id=order.id,
        total=total,
        created_at=order.created_at
    )
}

// Impure shell - handles I/O
def process_checkout(order_id: int) {
    // Load data (impure)
    let order = database.load_order(order_id)
    
    // Pure calculations
    let subtotal = calculate_total(order.items)
    let total = apply_tax(subtotal, 0.1)
    let invoice = create_invoice(order, total)
    
    // Save results (impure)
    database.save_invoice(invoice)
    email.send_confirmation(order.customer_email, invoice)
}
```

---

## 11. Async Functions

### 11.1 Basic Async Functions

```aura
// Async function declaration
async def fetch_user(user_id: int) -> User {
    let response = await http.get(f"/api/users/{user_id}")
    return await response.json()
}

// Calling async functions
async def main() {
    let user = await fetch_user(123)
    print(f"User: {user.name}")
}

// Multiple awaits
async def fetch_user_data(user_id: int) -> UserData {
    let user = await fetch_user(user_id)
    let posts = await fetch_posts(user_id)
    let comments = await fetch_comments(user_id)
    
    return UserData(user, posts, comments)
}
```

### 11.2 Parallel Async Operations

```aura
// Sequential (slow)
async def fetch_all_sequential(ids: list[int]) -> list[User] {
    let users = []
    for id in ids {
        let user = await fetch_user(id)  // Waits for each
        users.append(user)
    }
    return users
}

// Parallel (fast)
async def fetch_all_parallel(ids: list[int]) -> list[User] {
    let tasks = [fetch_user(id) for id in ids]
    return await Promise.all(tasks)  // All at once
}

// Mixed parallel and sequential
async def fetch_user_with_details(user_id: int) -> UserProfile {
    // Fetch user first (required)
    let user = await fetch_user(user_id)
    
    // Then fetch details in parallel
    let [posts, comments, followers] = await Promise.all([
        fetch_posts(user_id),
        fetch_comments(user_id),
        fetch_followers(user_id)
    ])
    
    return UserProfile(user, posts, comments, followers)
}
```

### 11.3 Error Handling in Async

```aura
// Try-catch in async
async def safe_fetch(user_id: int) -> Option[User] {
    try {
        let user = await fetch_user(user_id)
        return Some(user)
    } catch NetworkError as e {
        logging.error(f"Network error: {e}")
        return None
    } catch TimeoutError {
        logging.error("Request timed out")
        return None
    }
}

// Result type with async
async def fetch_with_result(user_id: int) -> Result<User, str> {
    try {
        let user = await fetch_user(user_id)
        return Ok(user)
    } catch Exception as e {
        return Err(f"Failed to fetch user: {e}")
    }
}

// Promise.all with error handling
async def fetch_all_with_errors(ids: list[int]) -> list[Result<User, str>> {
    let tasks = [fetch_with_result(id) for id in ids]
    return await Promise.all_settled(tasks)
}
```

### 11.4 Async Higher-Order Functions

```aura
// Async map
async def async_map<T, R>(
    fn: async (T) -> R,
    items: list[T]
) -> list[R] {
    let tasks = [fn(item) for item in items]
    return await Promise.all(tasks)
}

// Usage
async def process_users(user_ids: list[int]) {
    let users = await async_map(
        async (id) => await fetch_user(id),
        user_ids
    )
    return users
}

// Async filter
async def async_filter<T>(
    predicate: async (T) -> bool,
    items: list[T]
) -> list[T> {
    let results = await async_map(
        async (item) => (item, await predicate(item)),
        items
    )
    return [item for (item, keep) in results if keep]
}

// Async reduce
async def async_reduce<T, R>(
    fn: async (R, T) -> R,
    items: list[T],
    initial: R
) -> R {
    let mut acc = initial
    for item in items {
        acc = await fn(acc, item)
    }
    return acc
}
```

### 11.5 Async Pipe

```aura
// Async pipeline
async def process_data(input: str) {
    return await input
        |> parse_async
        |> validate_async
        |> enrich_async
        |> save_async
}

// Define async stages
async def parse_async(data: str) -> dict {
    await sleep(0.1)  // Simulate async work
    return json.loads(data)
}

async def validate_async(data: dict) -> dict {
    let is_valid = await check_validation_service(data)
    if not is_valid {
        raise ValidationError("Invalid data")
    }
    return data
}

async def enrich_async(data: dict) -> dict {
    let extra = await fetch_additional_data(data["id"])
    return {**data, **extra}
}

async def save_async(data: dict) -> int {
    return await database.insert_async(data)
}
```

---

## 12. Generators and Iterators

### 12.1 Generator Functions

```aura
// Generator with yield
def count_up(start: int, end: int) {
    let mut current = start
    while current <= end {
        yield current
        current += 1
    }
}

// Using generator
for num in count_up(1, 5) {
    print(num)  // 1, 2, 3, 4, 5
}

// Infinite generators
def fibonacci_gen() {
    let mut a, b = 0, 1
    loop {
        yield a
        a, b = b, a + b
    }
}

// Take first 10 fibonacci numbers
let fib = fibonacci_gen()
for i in range(10) {
    print(next(fib))
}

// Generator expressions
let squares = (x**2 for x in range(10))
let evens = (x for x in range(100) if x % 2 == 0)
```

### 12.2 Custom Iterators

```aura
// Iterator protocol
class RangeIterator {
    current: int
    end: int
    step: int
    
    def __init__(self, start: int, end: int, step: int = 1) {
        self.current = start
        self.end = end
        self.step = step
    }
    
    def __iter__(self) {
        return self
    }
    
    def __next__(self) -> int {
        if self.current >= self.end {
            raise StopIteration
        }
        let value = self.current
        self.current += self.step
        return value
    }
}

// Usage
for i in RangeIterator(0, 10, 2) {
    print(i)  // 0, 2, 4, 6, 8
}

// Tree iterator
class TreeIterator {
    stack: list[Node]
    
    def __init__(self, root: Node) {
        self.stack = [root]
    }
    
    def __iter__(self) {
        return self
    }
    
    def __next__(self) -> Node {
        if not self.stack {
            raise StopIteration
        }
        
        let node = self.stack.pop()
        
        // Add children to stack (right to left for left-to-right traversal)
        for child in reversed(node.children) {
            self.stack.append(child)
        }
        
        return node
    }
}
```

### 12.3 Generator Pipelines

```aura
// Chain generators for memory efficiency
def read_lines(filename: str) {
    with open(filename) as f {
        for line in f {
            yield line.strip()
        }
    }
}

def filter_comments(lines) {
    for line in lines {
        if not line.starts_with("#") {
            yield line
        }
    }
}

def parse_lines(lines) {
    for line in lines {
        let parts = line.split(",")
        yield {
            "name": parts[0],
            "value": int(parts[1])
        }
    }
}

// Process large file without loading it all into memory
let data = read_lines("large_file.csv")
    |> filter_comments
    |> parse_lines

for record in data {
    process(record)
}
```

### 12.4 Async Generators

```aura
// Async generator
async def fetch_pages(url: str, max_pages: int) {
    for page in range(1, max_pages + 1) {
        let data = await http.get(f"{url}?page={page}")
        yield await data.json()
    }
}

// Consume async generator
async def process_all_pages() {
    async for page_data in fetch_pages("https://api.example.com/items", 10) {
        process_page(page_data)
    }
}

// Async generator pipeline
async def stream_process(url: str) {
    async for batch in fetch_pages(url, 100) {
        let processed = await process_batch(batch)
        yield processed
    }
}
```

---

## 13. Decorators and Function Modification

### 13.1 Basic Decorators

```aura
// Simple decorator
def log_calls(fn) {
    def wrapper(*args, **kwargs) {
        print(f"Calling {fn.__name__} with {args}, {kwargs}")
        let result = fn(*args, **kwargs)
        print(f"{fn.__name__} returned {result}")
        return result
    }
    return wrapper
}

@log_calls
def add(a: int, b: int) -> int {
    return a + b
}

add(5, 3)
// Output:
// Calling add with (5, 3), {}
// add returned 8

// Equivalent to:
// add = log_calls(add)
```

### 13.2 Decorators with Arguments

```aura
// Decorator factory
def repeat(times: int) {
    def decorator(fn) {
        def wrapper(*args, **kwargs) {
            for _ in range(times) {
                fn(*args, **kwargs)
            }
        }
        return wrapper
    }
    return decorator
}

@repeat(3)
def greet(name: str) {
    print(f"Hello, {name}!")
}

greet("Alice")
// Output:
// Hello, Alice!
// Hello, Alice!
// Hello, Alice!

// Retry decorator
def retry(max_attempts: int = 3, delay: float = 1.0) {
    def decorator(fn) {
        def wrapper(*args, **kwargs) {
            let mut attempts = 0
            while attempts < max_attempts {
                try {
                    return fn(*args, **kwargs)
                } catch Exception as e {
                    attempts += 1
                    if attempts >= max_attempts {
                        raise e
                    }
                    sleep(delay)
                }
            }
        }
        return wrapper
    }
    return decorator
}

@retry(max_attempts=5, delay=2.0)
def fetch_data() {
    return http.get("https://api.example.com/data")
}
```

### 13.3 Class Decorators

```aura
// Class method decorators
class Counter {
    def __init__(self) {
        self.count = 0
    }
    
    @log_calls
    def increment(self) {
        self.count += 1
    }
    
    @property
    def value(self) -> int {
        return self.count
    }
    
    @staticmethod
    def create_from_value(value: int) -> Counter {
        let c = Counter()
        c.count = value
        return c
    }
    
    @classmethod
    def zero(cls) -> Counter {
        return cls()
    }
}

// Dataclass decorator
@dataclass
class Point {
    x: float
    y: float
}

// Singleton decorator
def singleton(cls) {
    let mut instance = null
    
    def get_instance(*args, **kwargs) {
        if instance == null {
            instance = cls(*args, **kwargs)
        }
        return instance
    }
    
    return get_instance
}

@singleton
class Database {
    def __init__(self) {
        print("Connecting to database...")
    }
}

let db1 = Database()  // Connects
let db2 = Database()  // Returns same instance
```

### 13.4 Built-in Decorators

```aura
// @memoize - cache function results
@memoize
def expensive_calculation(n: int) -> int {
    print(f"Computing for {n}")
    sleep(1)
    return n ** 2
}

print(expensive_calculation(5))  // Takes 1 second
print(expensive_calculation(5))  // Instant (cached)

// @debug - log function calls
@debug
def process(x: int, y: int) -> int {
    return x + y * 2
}

// @inline - inline function at call site
@inline
def add(a: int, b: int) -> int = a + b

// @time - measure execution time
@time
def slow_function() {
    sleep(2)
    return "done"
}

// @deprecated - mark as deprecated
@deprecated("Use new_function instead")
def old_function() {
    pass
}

// @async - make function async
@async
def fetch_data() {
    return http.get("https://api.example.com")
}
```

### 13.5 Chaining Decorators

```aura
// Multiple decorators applied bottom-up
@log_calls
@retry(max_attempts=3)
@time
def fetch_and_process(url: str) -> dict {
    let data = http.get(url).json()
    return process(data)
}

// Equivalent to:
// fetch_and_process = log_calls(retry(time(fetch_and_process)))

// Order matters!
@time      # Applied last (outermost)
@memoize   # Applied second
@debug     # Applied first (innermost)
def calculate(n: int) -> int {
    return fibonacci(n)
}
```

---

## 14. Advanced Patterns

### 14.1 Function Factories

```aura
// Create specialized functions
def make_multiplier(factor: int) -> (int) -> int {
    return (x) => x * factor
}

let double = make_multiplier(2)
let triple = make_multiplier(3)
let quadruple = make_multiplier(4)

print(double(10))     // 20
print(triple(10))     // 30
print(quadruple(10))  // 40

// Validator factory
def make_range_validator(min: int, max: int) -> (int) -> bool {
    return (value) => min <= value <= max
}

let validate_age = make_range_validator(0, 150)
let validate_percentage = make_range_validator(0, 100)

print(validate_age(25))      // true
print(validate_age(200))     // false
print(validate_percentage(50))  // true

// Parser factory
def make_parser(separator: str, converter: (str) -> any) {
    return (text: str) => {
        let parts = text.split(separator)
        return [converter(part) for part in parts]
    }
}

let parse_ints = make_parser(",", int)
let parse_floats = make_parser(";", float)

print(parse_ints("1,2,3"))      // [1, 2, 3]
print(parse_floats("1.5;2.7"))  // [1.5, 2.7]
```

### 14.2 Strategy Pattern

```aura
// Define strategies as functions
type SortStrategy<T> = (list[T]) -> list[T]

def bubble_sort<T: Comparable>(items: list[T]) -> list[T] {
    // Implementation
}

def quick_sort<T: Comparable>(items: list[T]) -> list[T] {
    // Implementation
}

def merge_sort<T: Comparable>(items: list[T>) -> list[T] {
    // Implementation
}

// Context that uses strategy
class Sorter<T: Comparable> {
    strategy: SortStrategy<T>
    
    def __init__(self, strategy: SortStrategy<T>) {
        self.strategy = strategy
    }
    
    def sort(self, items: list[T]) -> list[T] {
        return self.strategy(items)
    }
    
    def set_strategy(self, strategy: SortStrategy<T>) {
        self.strategy = strategy
    }
}

// Usage
let sorter = Sorter(quick_sort)
let sorted_data = sorter.sort([3, 1, 4, 1, 5])

// Change strategy at runtime
sorter.set_strategy(merge_sort)
let sorted_again = sorter.sort([9, 2, 6, 5])
```

### 14.3 Command Pattern

```aura
// Commands as functions
type Command = () -> none

class CommandManager {
    history: list[Command] = []
    
    def execute(self, command: Command) {
        command()
        self.history.append(command)
    }
    
    def undo_last(self) {
        if self.history {
            self.history.pop()
        }
    }
}

// Define commands
def save_command() {
    print("Saving document...")
    // Save logic
}

def print_command() {
    print("Printing document...")
    // Print logic
}

def email_command() {
    print("Emailing document...")
    // Email logic
}

// Usage
let manager = CommandManager()
manager.execute(save_command)
manager.execute(print_command)
manager.execute(email_command)
```

### 14.4 Observer Pattern with Callbacks

```aura
class Observable {
    observers: list[(any) -> none] = []
    
    def subscribe(self, observer: (any) -> none) {
        self.observers.append(observer)
    }
    
    def unsubscribe(self, observer: (any) -> none) {
        self.observers.remove(observer)
    }
    
    def notify(self, data: any) {
        for observer in self.observers {
            observer(data)
        }
    }
}

// Create observable
let button_clicks = Observable()

// Subscribe with functions
def log_click(data) {
    print(f"Button clicked: {data}")
}

def track_click(data) {
    analytics.track("button_click", data)
}

def update_counter(data) {
    counter.increment()
}

button_clicks.subscribe(log_click)
button_clicks.subscribe(track_click)
button_clicks.subscribe(update_counter)

// Trigger event
button_clicks.notify({"button_id": "submit"})
```

### 14.5 Middleware Pattern

```aura
type Middleware = (Request) -> Response

def create_middleware_chain(middlewares: list[Middleware]) -> Middleware {
    def chain(request: Request) -> Response {
        let mut current_request = request
        
        for middleware in middlewares {
            let response = middleware(current_request)
            if response.should_stop {
                return response
            }
            current_request = response.request
        }
        
        return Response(current_request)
    }
    
    return chain
}

// Define middleware
def logging_middleware(request: Request) -> Response {
    print(f"[LOG] {request.method} {request.path}")
    return Response(request, should_stop=false)
}

def auth_middleware(request: Request) -> Response {
    if not request.headers.get("Authorization") {
        return Response(
            request,
            status=401,
            should_stop=true
        )
    }
    return Response(request, should_stop=false)
}

def rate_limit_middleware(request: Request) -> Response {
    if is_rate_limited(request.ip) {
        return Response(
            request,
            status=429,
            should_stop=true
        )
    }
    return Response(request, should_stop=false)
}

// Create chain
let middleware = create_middleware_chain([
    logging_middleware,
    auth_middleware,
    rate_limit_middleware
])

// Process request through chain
let response = middleware(incoming_request)
```

---

## 15. Best Practices

### 15.1 Function Design Principles

```aura
// ✅ Single Responsibility
def calculate_total(items: list[CartItem]) -> float {
    return sum(item.price * item.quantity for item in items)
}

def apply_discount(total: float, discount: float) -> float {
    return total * (1 - discount)
}

// ❌ Multiple responsibilities
def process_order_bad(items, discount, user) {
    let total = sum(item.price * item.quantity for item in items)
    let discounted = total * (1 - discount)
    save_to_database(user, discounted)
    send_email(user.email, discounted)
    update_inventory(items)
}

// ✅ Small and Focused
def is_valid_email(email: str) -> bool {
    return "@" in email and "." in email.split("@")[1]
}

def is_valid_age(age: int) -> bool {
    return 0 <= age <= 150
}

// ❌ Too large and complex
def validate_everything(data) {
    // 200 lines of validation logic...
}

// ✅ Descriptive Names
def calculate_monthly_payment(principal: float, rate: float, months: int) -> float

// ❌ Unclear names
def calc(p, r, m)

// ✅ Consistent Abstraction Level
def process_user_registration(user_data: dict) {
    let user = create_user(user_data)
    send_welcome_email(user)
    log_registration(user)
}

// ❌ Mixed abstraction levels
def process_bad(data) {
    let user = User(data["name"], data["email"])  // Low level
    send_welcome_email(user)  // High level
    print(f"User {user.id} registered")  // Low level
}
```

### 15.2 Parameter Guidelines

```aura
// ✅ Limit number of parameters (max 3-4)
def create_user(name: str, email: str, age: int) -> User

// ❌ Too many parameters
def create_user_bad(name, email, age, address, phone, city, country, zip)

// ✅ Use objects for many parameters
type UserData = {
    name: str,
    email: str,
    age: int,
    address: str,
    phone: str
}

def create_user_better(data: UserData) -> User {
    return User(data)
}

// ✅ Default parameters at the end
def greet(name: str, greeting: str = "Hello", punctuation: str = "!") -> str {
    return f"{greeting}, {name}{punctuation}"
}

// ❌ Default parameters in the middle
// def bad(a, b = 10, c)  // Error!

// ✅ Use keyword-only for optional config
def fetch_data(
    url: str,
    *,
    timeout: int = 30,
    retries: int = 3,
    verify_ssl: bool = true
) -> Response

// ✅ Boolean parameters should be clear
def send_email(to: str, *, html: bool = false, urgent: bool = false)

// ❌ Unclear boolean flags
// def send(to, flag1, flag2)
```

### 15.3 Return Value Best Practices

```aura
// ✅ Consistent return types
def find_user(id: int) -> Option<User> {
    let user = database.query(id)
    return Some(user) if user else None
}

// ❌ Inconsistent returns
def find_user_bad(id: int) {
    let user = database.query(id)
    if user {
        return user
    }
    return null  // Sometimes None, sometimes User
}

// ✅ Return early for error cases
def process_order(order: Order) -> Result<Receipt, str> {
    if not order.items {
        return Err("Order has no items")
    }
    
    if order.total < 0 {
        return Err("Invalid total")
    }
    
    let receipt = create_receipt(order)
    return Ok(receipt)
}

// ❌ Deep nesting
def process_order_bad(order) {
    if order.items {
        if order.total >= 0 {
            let receipt = create_receipt(order)
            return Ok(receipt)
        } else {
            return Err("Invalid total")
        }
    } else {
        return Err("No items")
    }
}

// ✅ Use Result for operations that can fail
def divide(a: float, b: float) -> Result<float, str> {
    if b == 0 {
        return Err("Division by zero")
    }
    return Ok(a / b)
}

// ✅ Use Option for values that may not exist
def get_config(key: str) -> Option<str> {
    return config.get(key)
}
```

### 15.4 Error Handling in Functions

```aura
// ✅ Handle errors explicitly
def read_config(path: str) -> Result<Config, str> {
    try {
        let content = read_file(path)
        let config = parse_config(content)
        return Ok(config)
    } catch FileNotFoundError {
        return Err(f"Config file not found: {path}")
    } catch ParseError as e {
        return Err(f"Invalid config format: {e}")
    }
}

// ✅ Propagate errors with ?
def load_user_settings(user_id: int) -> Result<Settings, str> {
    let user = find_user(user_id)?
    let config = read_config(user.config_path)?
    return Ok(Settings(user, config))
}

// ✅ Validate inputs early
def calculate_discount(price: float, percent: float) -> Result<float, str> {
    if price < 0 {
        return Err("Price cannot be negative")
    }
    
    if percent < 0 or percent > 100 {
        return Err("Discount must be between 0 and 100")
    }
    
    return Ok(price * (1 - percent / 100))
}

// ❌ Silent failures
def bad_function(x) {
    try {
        return process(x)
    } catch {
        return null  // Lost error information!
    }
}
```

### 15.5 Performance Considerations

```aura
// ✅ Use generators for large sequences
def process_large_file(filename: str) {
    for line in read_lines(filename) {  // Generator
        yield process_line(line)
    }
}

// ❌ Loading everything into memory
def process_large_file_bad(filename: str) {
    let lines = read_all_lines(filename)  // Loads entire file
    return [process_line(line) for line in lines]
}

// ✅ Memoize expensive pure functions
@memoize
def fibonacci(n: int) -> int {
    if n <= 1 {
        return n
    }
    return fibonacci(n - 1) + fibonacci(n - 2)
}

// ✅ Use lazy evaluation
def get_user_or_default(id: int) -> User {
    return find_user(id).unwrap_or_else(() => {
        // Only called if user not found
        create_default_user()
    })
}

// ❌ Eager evaluation
def get_user_or_default_bad(id: int) -> User {
    let default = create_default_user()  // Always created!
    return find_user(id).unwrap_or(default)
}

// ✅ Avoid unnecessary allocations
def sum_range(start: int, end: int) -> int {
    return sum(range(start, end + 1))  // Generator, no list
}

// ❌ Unnecessary allocations
def sum_range_bad(start: int, end: int) -> int {
    let numbers = [x for x in range(start, end + 1)]  // Creates list
    return sum(numbers)
}
```

### 15.6 Testing Functions

```aura
// ✅ Pure functions are easy to test
def calculate_total(items: list[CartItem]) -> float {
    return sum(item.price * item.quantity for item in items)
}

// Test
def test_calculate_total() {
    let items = [
        CartItem(price=10.0, quantity=2),
        CartItem(price=5.0, quantity=3)
    ]
    assert calculate_total(items) == 35.0
}

// ✅ Inject dependencies for testability
def send_notification(
    user: User,
    message: str,
    sender: (str, str) -> none = send_email
) {
    sender(user.email, message)
}

// Test with mock
def test_send_notification() {
    let mut sent_to = null
    let mut sent_message = null
    
    def mock_send(email: str, msg: str) {
        sent_to = email
        sent_message = msg
    }
    
    send_notification(test_user, "Hello", sender=mock_send)
    assert sent_to == test_user.email
    assert sent_message == "Hello"
}

// ✅ Test edge cases
def test_divide_by_zero() {
    match divide(10, 0) {
        case Err(msg) {
            assert "zero" in msg.lower()
        }
        case _ {
            fail("Expected error for division by zero")
        }
    }
}

def test_empty_list() {
    assert calculate_total([]) == 0.0
}
```

### 15.7 Documentation

```aura
/**
 * Calculates the monthly payment for a loan.
 * 
 * @param principal The loan amount in dollars
 * @param annual_rate Annual interest rate as a percentage (e.g., 5.5 for 5.5%)
 * @param months The loan term in months
 * @return The monthly payment amount
 * 
 * @example
 * let payment = calculate_monthly_payment(100000, 5.5, 360)
 * print(payment)  // 567.79
 */
def calculate_monthly_payment(
    principal: float,
    annual_rate: float,
    months: int
) -> float {
    let monthly_rate = annual_rate / 100 / 12
    let numerator = monthly_rate * (1 + monthly_rate) ** months
    let denominator = (1 + monthly_rate) ** months - 1
    return principal * numerator / denominator
}

/**
 * Filters a list based on a predicate function.
 * 
 * @param predicate Function that returns true for items to keep
 * @param items List to filter
 * @return New list containing only items that match predicate
 * 
 * @example
 * let evens = filter((x) => x % 2 == 0, [1, 2, 3, 4, 5])
 * print(evens)  // [2, 4]
 */
def filter<T>(predicate: (T) -> bool, items: list[T]) -> list[T] {
    return [item for item in items if predicate(item)]
}
```

---

## 16. Common Patterns and Idioms

### 16.1 Pipeline Pattern

```aura
// Transform data through multiple stages
let result = load_data("users.csv")
    |> parse_csv
    |> filter((row) => row.age >= 18)
    |> map((row) => User.from_row(row))
    |> sort_by((user) => user.name)
    |> take(100)
    |> to_json

// API request pipeline
let response = request
    |> validate_request
    |> authenticate
    |> authorize
    |> rate_limit
    |> process
    |> format_response
```

### 16.2 Builder Pattern with Functions

```aura
// Functional builder
def build_query(table: str) {
    let mut query = f"SELECT * FROM {table}"
    
    return {
        where: (condition: str) => {
            query += f" WHERE {condition}"
            return this
        },
        order_by: (column: str) => {
            query += f" ORDER BY {column}"
            return this
        },
        limit: (n: int) => {
            query += f" LIMIT {n}"
            return this
        },
        build: () => query
    }
}

// Usage
let sql = build_query("users")
    .where("age >= 18")
    .order_by("name")
    .limit(10)
    .build()
```

### 16.3 Lens Pattern for Immutable Updates

```aura
// Lens for accessing nested data
def lens<S, A>(
    get: (S) -> A,
    set: (A, S) -> S
) {
    return {
        get: get,
        set: set,
        modify: (fn: (A) -> A, obj: S) -> S {
            return set(fn(get(obj)), obj)
        }
    }
}

// Example: User address lens
let address_lens = lens(
    (user) => user.address,
    (address, user) => {**user, address: address}
)

let city_lens = lens(
    (address) => address.city,
    (city, address) => {**address, city: city}
)

// Compose lenses
def compose_lens<A, B, C>(outer, inner) {
    return lens(
        (a) => inner.get(outer.get(a)),
        (c, a) => outer.set(inner.set(c, outer.get(a)), a)
    )
}

let user_city_lens = compose_lens(address_lens, city_lens)

// Update nested data immutably
let updated_user = user_city_lens.set("New York", user)
```

### 16.4 Railway Oriented Programming

```aura
// Chain operations that can fail
def process_order(order_data: dict) -> Result<Receipt, str> {
    return parse_order(order_data)
        .and_then(validate_order)
        .and_then(check_inventory)
        .and_then(calculate_total)
        .and_then(process_payment)
        .and_then(create_receipt)
}

// Each function returns Result
def parse_order(data: dict) -> Result<Order, str> {
    // ...
}

def validate_order(order: Order) -> Result<Order, str> {
    // ...
}

// Error handling at the end
match process_order(data) {
    case Ok(receipt) {
        send_confirmation(receipt)
    }
    case Err(error) {
        log_error(error)
        show_error_to_user(error)
    }
}
```

### 16.5 Continuation-Passing Style

```aura
// CPS for async-like control flow
def read_file_cps(
    path: str,
    on_success: (str) -> none,
    on_error: (str) -> none
) {
    try {
        let content = read_file(path)
        on_success(content)
    } catch Exception as e {
        on_error(str(e))
    }
}

// Usage
read_file_cps(
    "data.txt",
    (content) => process(content),
    (error) => log_error(error)
)

// Chain multiple CPS operations
def process_pipeline(
    input: str,
    on_complete: (any) -> none,
    on_error: (str) -> none
) {
    read_file_cps(
        input,
        (content) => {
            parse_cps(
                content,
                (data) => {
                    validate_cps(
                        data,
                        on_complete,
                        on_error
                    )
                },
                on_error
            )
        },
        on_error
    )
}
```

---

## 17. Performance Optimization

### 17.1 Memoization Strategies

```aura
// Simple memoization
@memoize
def fibonacci(n: int) -> int {
    if n <= 1 { return n }
    return fibonacci(n - 1) + fibonacci(n - 2)
}

// Custom memoization with size limit
def memoize_lru<K, V>(max_size: int = 128) {
    def decorator(fn: (K) -> V) {
        let cache: dict[K, V] = {}
        let access_order: list[K] = []
        
        return (key: K) -> V {
            if key in cache {
                // Move to end (most recently used)
                access_order.remove(key)
                access_order.append(key)
                return cache[key]
            }
            
            let result = fn(key)
            cache[key] = result
            access_order.append(key)
            
            // Evict oldest if over limit
            if len(cache) > max_size {
                let oldest = access_order.pop(0)
                del cache[oldest]
            }
            
            return result
        }
    }
    return decorator
}

@memoize_lru(max_size=100)
def expensive_calc(n: int) -> int {
    // Expensive operation
}
```

### 17.2 Lazy Evaluation

```aura
// Lazy computation wrapper
class Lazy<T> {
    computation: () -> T
    cached_value: T?
    is_computed: bool = false
    
    def __init__(self, computation: () -> T) {
        self.computation = computation
    }
    
    def get(self) -> T {
        if not self.is_computed {
            self.cached_value = self.computation()
            self.is_computed = true
        }
        return self.cached_value
    }
}

// Usage
let lazy_data = Lazy(() => {
    print("Computing...")
    return expensive_operation()
})

// Not computed yet
print("Before get")

// Computed on first access
let value1 = lazy_data.get()  // Prints "Computing..."

// Cached on subsequent access
let value2 = lazy_data.get()  // No print
```

### 17.3 Tail Call Optimization

```aura
// Tail-recursive functions can be optimized
@tail_recursive
def factorial_tail(n: int, acc: int = 1) -> int {
    if n <= 1 {
        return acc
    }
    return factorial_tail(n - 1, n * acc)
}

@tail_recursive
def sum_list_tail(items: list[int], acc: int = 0) -> int {
    if not items {
        return acc
    }
    let [head, *tail] = items
    return sum_list_tail(tail, acc + head)
}

// Compiler can convert to loop, preventing stack overflow
```

### 17.4 Function Inlining

```aura
// Small functions can be inlined for performance
@inline
def square(x: int) -> int = x * x

@inline
def is_even(n: int) -> bool = n % 2 == 0

// At call site:
let result = square(5)  // Becomes: let result = 5 * 5

// Use sparingly - only for very small, frequently called functions
```

---

## 18. Conclusion

### 18.1 Key Takeaways

**Function Fundamentals:**
- Functions are first-class values in Aura
- Support multiple parameter styles (positional, keyword, variadic)
- Type annotations improve clarity and safety
- Expression-body syntax for simple functions

**Functional Programming:**
- Higher-order functions enable powerful abstractions
- Pure functions are easier to test and reason about
- Closures capture outer scope elegantly
- Composition builds complex logic from simple pieces

**Advanced Features:**
- Pipe operator makes data transformations readable
- Partial application and currying enable function specialization
- Generators provide memory-efficient iteration
- Decorators modify function behavior cleanly

**Best Practices:**
- Keep functions small and focused (single responsibility)
- Prefer pure functions when possible
- Use descriptive names and clear signatures
- Handle errors explicitly with Result or Option
- Document complex functions
- Test thoroughly, especially edge cases

### 18.2 Function Design Checklist

✅ **Does it do one thing well?** (Single Responsibility)
✅ **Is the name descriptive?** (Clear intent)
✅ **Are parameters well-ordered?** (Required first, optional last)
✅ **Does it return consistent types?** (No mixed returns)
✅ **Are side effects minimized?** (Pure when possible)
✅ **Is it testable?** (Dependencies injectable)
✅ **Is error handling explicit?** (Result/Option/Exceptions)
✅ **Is it documented?** (Complex logic explained)
✅ **Is performance considered?** (Memoization, lazy eval)
✅ **Can it be composed?** (Works in pipelines)

### 18.3 Common Patterns Summary

| Pattern | Use Case | Example |
|---------|----------|---------|
| **Pipeline** | Sequential transformations | `data \|> parse \|> validate \|> save` |
| **Higher-Order** | Function composition | `map`, `filter`, `reduce` |
| **Closure** | State encapsulation | `make_counter()` |
| **Partial Application** | Function specialization | `add(5, _)` |
| **Currying** | One parameter at a time | `curry(add)(5)(3)` |
| **Memoization** | Cache expensive results | `@memoize` |
| **Generator** | Lazy sequences | `yield` for large data |
| **Decorator** | Function modification | `@log_calls` |

### 18.4 Further Learning

**Topics to Explore:**
- Advanced type theory (dependent types, effect systems)
- Category theory concepts (functors, monads)
- Reactive programming with functions
- Concurrent functional programming
- Property-based testing
- Function optimization techniques

**Resources:**
- [Aura Documentation](https://aura-lang.org/docs)
- [Functional Programming Guide](https://aura-lang.org/docs/fp)
- [Standard Library Reference](https://aura-lang.org/api)
- [Community Examples](https://github.com/aura-lang/examples)

---

**End of Functions and Functional Programming Guide**

This guide covered the complete spectrum of functions in Aura, from basics to advanced functional programming techniques. Master these concepts to write elegant, composable, and maintainable code.

Happy coding! 🚀