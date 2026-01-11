# Aura Type System

## Overview

Aura is a **gradually typed** language with **full type inference**. Types are optional but recommended for function signatures and class definitions. The type system provides:

- **Type inference**: Automatic type detection from literals and operations
- **Union types**: Combine multiple types (`Int | String | None`)
- **Generic types**: Parameterized types (`List[Int]`, `Dict[String, Float]`)
- **Type narrowing**: Automatic type refinement through control flow
- **Type checking**: Compile-time type validation without runtime overhead

## Basic Types

### Primitive Types

```aura
let x: Int = 42
let y: Float = 3.14
let s: String = "hello"
let b: Bool = true
let n: None = null
```

### Collection Types

```aura
let list: [Int] = [1, 2, 3]
let dict: {String: Int} = {"a": 1, "b": 2}
let set: {Int} = {1, 2, 3}
let tuple: (Int, String, Bool) = (1, "a", true)
```

### Function Types

```aura
let f: (Int, Int) -> Int = fn(a, b) { a + b }
let g: (String) -> String = fn(s) { s + "!" }
let async_f: async (Int) -> String = async fn(x) { ... }
```

### Union Types

```aura
let value: Int | String = 42
let option: Int | None = null
let result: {ok: Int, err: String} | None = ...
```

## Type Inference

The transpiler infers types from:

- **Literals**: `42` → `Int`, `3.14` → `Float`, `"str"` → `String`, `true` → `Bool`
- **Operations**: `2 + 3` → `Int`, `"a" + "b"` → `String`, `[1,2,3]` → `[Int]`
- **Function calls**: Based on function signature's return type
- **Control flow**: Narrowing in if/match branches

### Type Inference Examples

```aura
let x = 10              // Inferred: Int
let y = x + 5           // Inferred: Int
let z = "hello"         // Inferred: String
let items = [1, 2, 3]   // Inferred: [Int]
let map = {a: 1}        // Inferred: {String: Int}

fn double(n: Int) {     // Return type inferred: Int
    n * 2
}

fn process(items: [Int]) {  // Return type inferred: [Int]
    items |> map(x => x * 2)
}
```

## Type Annotations

### Variable Annotations

```aura
let name: String = "Alice"
const MAX_SIZE: Int = 100
```

### Function Annotations

```aura
fn add(a: Int, b: Int) -> Int {
    a + b
}

fn greet(name: String, age: Int) -> String {
    "Hello, \(name)! You are \(age) years old."
}

fn process[T](items: [T]) -> [T] {
    items |> filter(x => x != null)
}
```

### Class Annotations

```aura
class User {
    name: String
    age: Int
    email: String | None
    
    fn new(name: String, age: Int) {
        self.name = name
        self.age = age
        self.email = null
    }
    
    fn set_email(email: String) {
        self.email = email
    }
}
```

## Type Narrowing

The type system automatically narrows types in control flow:

```aura
let value: Int | String = ...

if value is Int {
    // value is Int here
    print(value + 10)
}

if value is String {
    // value is String here
    print(value + "!")
}

match value {
    n: Int -> print(n * 2)
    s: String -> print(s.uppercase())
}
```

## Generic Types

### Generic Functions

```aura
fn first[T](items: [T]) -> T | None {
    if items.length > 0 { items[0] } else { null }
}

fn map[T, U](items: [T], fn: (T) -> U) -> [U] {
    items |> map(fn)
}

fn identity[T](x: T) -> T {
    x
}
```

### Generic Classes

```aura
class Box[T] {
    value: T
    
    fn new(value: T) {
        self.value = value
    }
    
    fn get() -> T {
        self.value
    }
}

let int_box: Box[Int] = Box.new(42)
let str_box: Box[String] = Box.new("hello")
```

## Type Compatibility

### Subtyping

A type `A` is a subtype of `B` if:
- They are the same type
- `A` is a subclass of `B`
- `A` is part of a union type that `B` is part of

```aura
class Animal { }
class Dog: Animal { }

fn process_animal(a: Animal) { }

let dog: Dog = Dog.new()
process_animal(dog)  // OK: Dog is subtype of Animal
```

### Implicit Conversions

Implicit conversions are limited to prevent errors:

```aura
let x: Int = 42
let y: Float = x  // ✗ ERROR: Int is not Float
let z: Float = 42.0  // ✓ OK
```

## Null/None Handling

### Nullable Types

Any type can be made nullable with `| None`:

```aura
let required: String = "value"
let optional: String | None = null

// Null-safe navigation
let name: String | None = user?.name

// Elvis operator (coalesce)
let display: String = user?.name ?: "Unknown"
```

### Optional Chaining

```aura
class User {
    name: String
    address: Address | None
}

let city: String | None = user?.address?.city
let zip: String | None = user?.address?.zip ?: "00000"
```

## Advanced Type Features

### Type Aliases

```aura
type UserId = Int
type UserResult = User | None
type Callback = (Int, String) -> Bool
```

### Intersection Types

```aura
// Trait composition
class Reader { fn read() -> String { } }
class Writer { fn write(data: String) { } }

fn process[T: Reader & Writer](obj: T) {
    let data = obj.read()
    obj.write(data)
}
```

### Constrained Types

```aura
fn process[T: Comparable](items: [T]) -> T {
    items |> max()
}
```

## Type System Validation

The type checker validates:

1. **Type correctness**: Operations use compatible types
2. **Function calls**: Arguments match parameter types
3. **Variable assignment**: Assigned values match declared types
4. **Return values**: Function returns match return type
5. **Method calls**: Called methods exist on type
6. **Field access**: Accessed fields exist on type

### Type Checking Example

```aura
fn calculate(x: Int, y: Int) -> Int {
    x + y  // ✓ Returns Int
}

fn badCalculate(x: Int, y: Int) -> Int {
    x + "hello"  // ✗ ERROR: Cannot add Int + String
    "result"     // ✗ ERROR: String is not Int
}
```

## Error Messages

Type errors include helpful messages:

```
error[E101]: Type mismatch: expected Int, got String
  at line 42: let x: Int = "hello"
  hint: Remove type annotation or provide an Int value
```

## Best Practices

1. **Type annotations on public APIs**: Always annotate function parameters and return types
2. **Use type narrowing**: Check types in conditionals to avoid errors
3. **Prefer immutable types**: Use `const` for non-changing values
4. **Leverage inference**: Don't over-annotate local variables
5. **Use union types sparingly**: Keep union types simple and well-documented
6. **Pattern match**: Use match expressions for type-safe branching

## Integration with Python

Aura types map to Python types:

| Aura Type | Python Type |
|-----------|-------------|
| Int | int |
| Float | float |
| String | str |
| Bool | bool |
| None | NoneType |
| [T] | list |
| {K: V} | dict |
| {T} | set |
| (A, B, C) | tuple |
| (A) -> B | Callable |

Aura's type system is a **compile-time feature** - types are erased before Python generation, but type information is used for:
- Error detection
- IDE support and completions
- Documentation
- Optimization opportunities
