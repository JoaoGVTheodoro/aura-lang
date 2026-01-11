# Aura Language Syntax Specification

This document provides the complete formal syntax rules for the Aura programming language.

---

## 📋 Table of Contents

1. [Lexical Structure](#lexical-structure)
2. [Type System](#type-system)
3. [Expressions](#expressions)
4. [Statements](#statements)
5. [Declarations](#declarations)
6. [Pattern Matching](#pattern-matching)
7. [Operators](#operators)
8. [Literals](#literals)

---

## 1. Lexical Structure

### 1.1 Keywords

**Reserved Keywords:**
```
async      await      break      case       catch      class
const      continue   def        else       enum       export
extends    false      finally    for        from       guard
if         implements import     in         is         let
loop       match      module     mut        none       null
return     self       static     super      trait      true
try        type       unless     until      while      with
yield
```

**Contextual Keywords:**
```
abstract   as         dataclass  derive     inline
memoize    property   readonly   step       where
```

### 1.2 Identifiers

```ebnf
identifier ::= (letter | '_') (letter | digit | '_')*
letter     ::= 'a'..'z' | 'A'..'Z'
digit      ::= '0'..'9'
```

**Rules:**
- Must start with a letter or underscore
- Cannot be a reserved keyword
- Case-sensitive
- Convention: `snake_case` for variables/functions, `PascalCase` for classes/types

**Examples:**
```aura
valid_name
_private_var
userName2
MyClass
MAX_SIZE
```

### 1.3 Comments

```aura
// Single-line comment

/* 
   Multi-line comment
   spans multiple lines
*/

/**
 * Documentation comment
 * Used for generating docs
 * @param x The input value
 * @returns Processed result
 */
```

### 1.4 Whitespace

- Spaces, tabs, newlines, and carriage returns
- Generally ignored except for line continuation
- No significant indentation (unlike Python)

---

## 2. Type System

### 2.1 Type Syntax

```ebnf
type_expr ::= primitive_type
            | compound_type
            | function_type
            | union_type
            | generic_type
            | literal_type
            | structural_type

primitive_type ::= 'int' | 'float' | 'str' | 'bool' | 'bytes' | 'none' | 'any'
```

### 2.2 Primitive Types

```aura
int        // Integer numbers
float      // Floating-point numbers
str        // Unicode strings
bool       // true or false
bytes      // Byte sequences
none       // None/null value
any        // Any type (opt-out of type checking)
```

### 2.3 Compound Types

```ebnf
compound_type ::= list_type
                | dict_type
                | set_type
                | tuple_type
                | optional_type

list_type     ::= 'list' '[' type_expr ']'
dict_type     ::= 'dict' '[' type_expr ',' type_expr ']'
set_type      ::= 'set' '[' type_expr ']'
tuple_type    ::= 'tuple' '[' type_expr (',' type_expr)* ']'
optional_type ::= type_expr '?'
```

**Examples:**
```aura
list[int]                    // List of integers
dict[str, int]              // Dictionary with string keys, int values
set[str]                    // Set of strings
tuple[int, str, bool]       // Tuple with specific types
User?                       // Optional User (can be null)
list[list[int]]            // Nested list
dict[str, list[User]]      // Complex nested type
```

### 2.4 Union Types

```ebnf
union_type ::= type_expr ('|' type_expr)+
```

**Examples:**
```aura
str | int                   // String or integer
int | float | none         // Numeric or null
Result[T] | Error          // Result or error type
```

### 2.5 Generic Types

```ebnf
generic_type ::= identifier '<' type_param_list '>'
type_param_list ::= type_expr (',' type_expr)*

type_constraint ::= identifier ':' type_expr
```

**Examples:**
```aura
Box[int]                   // Generic box containing int
Pair[str, int]            // Pair with string and int
Result[User, Error]       // Result type with two parameters
dict[K, V]                // Generic dictionary

// With constraints
def sort<T: Comparable>(items: list[T]) -> list[T]
def process<T: Serializable & Hashable>(data: T) -> bytes
```

### 2.6 Function Types

```ebnf
function_type ::= '(' param_type_list? ')' '->' type_expr
param_type_list ::= type_expr (',' type_expr)*
```

**Examples:**
```aura
(int, int) -> int          // Function taking two ints, returning int
(str) -> bool              // Predicate function
() -> none                 // Function with no params, no return
(int, str, *args) -> list  // Variadic function
```

### 2.7 Literal Types

```ebnf
literal_type ::= string_literal
               | number_literal
               | bool_literal
               | literal_union
               
literal_union ::= literal_type ('|' literal_type)+
```

**Examples:**
```aura
"GET" | "POST" | "PUT" | "DELETE"    // HTTP methods
1 | 2 | 3 | 4 | 5 | 6                // Dice roll
true | false                          // Boolean literal
0 | 1                                 // Binary
```

### 2.8 Structural Types

```ebnf
structural_type ::= '{' field_list? '}'
field_list      ::= field (',' field)* ','?
field           ::= identifier '?'? ':' type_expr
```

**Examples:**
```aura
{x: int, y: int}                     // Point type

{
    name: str,
    age: int,
    email?: str                       // Optional field
}

{
    id: int,
    data: {
        value: str,
        metadata: dict[str, any]
    }
}
```

### 2.9 Type Aliases

```ebnf
type_alias ::= 'type' identifier type_params? '=' type_expr
type_params ::= '<' identifier (',' identifier)* '>'
```

**Examples:**
```aura
type UserId = int
type Point = {x: float, y: float}
type Result<T, E> = Ok(T) | Err(E)
type StringMap = dict[str, str]
type Handler = (Request) -> Response
type Json = dict[str, any]

// Generic aliases
type Box<T> = {value: T, metadata: dict}
type Pair<A, B> = tuple[A, B]
type Option<T> = Some(T) | None
```

### 2.10 Type Annotations

```ebnf
type_annotation ::= ':' type_expr
variable_decl   ::= 'let' 'mut'? identifier type_annotation? '=' expr
```

**Examples:**
```aura
let name: str = "Alice"
let age: int = 25
let scores: list[float] = [9.5, 8.7]
let user: User? = null
let handler: (int) -> str = process

// Type inference
let count = 10                        // Inferred as int
let items = [1, 2, 3]                // Inferred as list[int]
let point = {x: 10, y: 20}           // Inferred structural type
```

---

## 3. Expressions

### 3.1 Expression Grammar

```ebnf
expression ::= assignment_expr
             | pipe_expr
             | conditional_expr
             | binary_expr
             | unary_expr
             | postfix_expr
             | primary_expr

primary_expr ::= literal
               | identifier
               | lambda_expr
               | '(' expression ')'
               | list_expr
               | dict_expr
               | set_expr
```

### 3.2 Literals

```ebnf
literal ::= integer_literal
          | float_literal
          | string_literal
          | bool_literal
          | none_literal

integer_literal ::= decimal_literal
                  | hex_literal
                  | octal_literal
                  | binary_literal
                  
decimal_literal ::= digit+ ('_' digit+)*
hex_literal     ::= '0x' hex_digit+ ('_' hex_digit+)*
octal_literal   ::= '0o' octal_digit+ ('_' octal_digit+)*
binary_literal  ::= '0b' binary_digit+ ('_' binary_digit+)*

float_literal   ::= digit+ '.' digit+ exponent?
                  | digit+ exponent

string_literal  ::= '"' string_char* '"'
                  | "'" string_char* "'"
                  | 'f"' fstring_content* '"'
                  | '"""' multiline_string '"""'

bool_literal    ::= 'true' | 'false'
none_literal    ::= 'none' | 'null'
```

**Examples:**
```aura
// Integers
42
1_000_000
0xFF
0o755
0b1010

// Floats
3.14
2.5e10
1.5e-5

// Strings
"hello"
'world'
f"Value: {x}"
"""
Multi-line
string
"""

// Others
true
false
null
```

### 3.3 Collection Literals

```ebnf
list_expr ::= '[' (expression (',' expression)* ','?)? ']'
            | '[' expression 'for' comprehension ']'

dict_expr ::= '{' (key_value (',' key_value)* ','?)? '}'
            | '{' key_value 'for' comprehension '}'
            
set_expr  ::= '{' expression (',' expression)+ ','? '}'
            | '{' expression 'for' comprehension '}'

key_value ::= expression ':' expression

comprehension ::= identifier 'in' expression filter*
filter        ::= 'if' expression
```

**Examples:**
```aura
// Lists
[]
[1, 2, 3]
[x * 2 for x in range(10)]
[x for x in items if x > 0]

// Dictionaries
{}
{name: "Alice", age: 25}
{k: v for k, v in pairs}
{x: x**2 for x in range(5) if x % 2 == 0}

// Sets
{1, 2, 3}
{x for x in data if valid(x)}

// Tuples
(1, 2)
(name, age, email)
()  // Empty tuple
```

### 3.4 Lambda Expressions

```ebnf
lambda_expr ::= '(' param_list? ')' '=>' (expression | block)
param_list  ::= param (',' param)*
param       ::= identifier type_annotation?
```

**Examples:**
```aura
(x) => x * 2
(a, b) => a + b
() => 42
(x: int) => x > 0

// Multi-line lambda
(data) => {
    validate(data)
    transform(data)
    return save(data)
}
```

### 3.5 Binary Expressions

```ebnf
binary_expr ::= expression binary_op expression

binary_op ::= arithmetic_op
            | comparison_op
            | logical_op
            | bitwise_op

arithmetic_op ::= '+' | '-' | '*' | '/' | '//' | '%' | '**'
comparison_op ::= '==' | '!=' | '<' | '>' | '<=' | '>=' | 'is' | 'in'
logical_op    ::= 'and' | 'or'
bitwise_op    ::= '&' | '|' | '^' | '<<' | '>>'
```

**Precedence (highest to lowest):**
1. `**` (exponentiation)
2. `*`, `/`, `//`, `%` (multiplication, division, modulo)
3. `+`, `-` (addition, subtraction)
4. `<<`, `>>` (bitwise shifts)
5. `&` (bitwise AND)
6. `^` (bitwise XOR)
7. `|` (bitwise OR)
8. `<`, `>`, `<=`, `>=`, `==`, `!=`, `is`, `in` (comparisons)
9. `and` (logical AND)
10. `or` (logical OR)

### 3.6 Unary Expressions

```ebnf
unary_expr ::= unary_op expression

unary_op ::= '+' | '-' | 'not' | '~'
```

**Examples:**
```aura
-x
+y
not condition
~bitmask
```

### 3.7 Postfix Expressions

```ebnf
postfix_expr ::= primary_expr postfix_op*

postfix_op ::= call_suffix
             | index_suffix
             | member_suffix
             | safe_nav_suffix

call_suffix     ::= '(' argument_list? ')'
index_suffix    ::= '[' expression ']'
member_suffix   ::= '.' identifier
safe_nav_suffix ::= '?.' identifier
                  | '?[' expression ']'
```

**Examples:**
```aura
func(arg1, arg2)
array[0]
obj.property
user?.name
list?[index]
obj.method(args)
```

### 3.8 Pipe Expressions

```ebnf
pipe_expr ::= expression '|>' expression
```

**Examples:**
```aura
data |> filter |> map |> reduce
value |> transform |> validate |> save
users |> filter(is_active) |> map(get_name)
```

### 3.9 Conditional Expressions

```ebnf
conditional_expr ::= expression '?' expression ':' expression
elvis_expr       ::= expression '?:' expression
coalesce_expr    ::= expression '??' expression
```

**Examples:**
```aura
age >= 18 ? "Adult" : "Minor"
value ?: default
name ?? "Anonymous"
```

### 3.10 Range Expressions

```ebnf
range_expr ::= expression '..' expression?          // Inclusive
             | expression '..<' expression          // Exclusive
             | expression '..' 'step' expression    // With step
```

**Examples:**
```aura
1..10          // 1 to 10 inclusive
0..<100        // 0 to 99
0..100 step 5  // 0, 5, 10, ..., 100
1..            // Infinite range from 1
```

---

## 4. Statements

### 4.1 Statement Grammar

```ebnf
statement ::= simple_stmt
            | compound_stmt

simple_stmt ::= expr_stmt
              | assignment_stmt
              | return_stmt
              | break_stmt
              | continue_stmt
              | import_stmt

compound_stmt ::= if_stmt
                | while_stmt
                | for_stmt
                | try_stmt
                | with_stmt
                | match_stmt
                | block_stmt

block_stmt ::= '{' statement* '}'
```

### 4.2 Assignment Statements

```ebnf
assignment_stmt ::= target assignment_op expression

target ::= identifier
         | index_expr
         | member_expr
         | destructure_pattern

assignment_op ::= '='
                | '+=' | '-=' | '*=' | '/=' | '//=' | '%=' | '**='
                | '&=' | '|=' | '^=' | '<<=' | '>>='
                | '??='

destructure_pattern ::= '[' identifier_list ']'
                      | '{' field_pattern_list '}'
                      
identifier_list ::= identifier (',' identifier)* (',' '*' identifier)?
field_pattern_list ::= field_pattern (',' field_pattern)*
field_pattern ::= identifier (':' identifier)?
```

**Examples:**
```aura
x = 10
counter += 1
name ??= "Default"

// Destructuring
let [a, b, c] = list
let {x, y} = point
let [first, *rest] = items
let {name, age: userAge} = user
```

### 4.3 Control Flow Statements

#### If Statement

```ebnf
if_stmt ::= 'if' expression block_stmt
           ('else' 'if' expression block_stmt)*
           ('else' block_stmt)?
```

**Examples:**
```aura
if x > 0 {
    print("Positive")
}

if score >= 90 {
    grade = "A"
} else if score >= 80 {
    grade = "B"
} else {
    grade = "C"
}
```

#### Unless Statement

```ebnf
unless_stmt ::= 'unless' expression block_stmt
              ('else' block_stmt)?
```

**Examples:**
```aura
unless authenticated {
    redirect("/login")
}
```

#### Guard Statement

```ebnf
guard_stmt ::= 'guard' expression 'else' block_stmt
```

**Examples:**
```aura
guard user != null else {
    return Err("User not found")
}

guard data.length > 0 else {
    return
}
```

#### While Statement

```ebnf
while_stmt ::= 'while' expression block_stmt
```

**Examples:**
```aura
while x < 100 {
    x *= 2
}
```

#### Until Statement

```ebnf
until_stmt ::= 'until' expression block_stmt
```

**Examples:**
```aura
until ready {
    wait(100)
}
```

#### For Statement

```ebnf
for_stmt ::= 'for' pattern 'in' expression block_stmt

pattern ::= identifier
          | '(' identifier (',' identifier)* ')'
```

**Examples:**
```aura
for i in 0..10 {
    print(i)
}

for (index, item) in enumerate(list) {
    print(f"{index}: {item}")
}

for item in items {
    process(item)
}
```

#### Loop Statement

```ebnf
loop_stmt ::= 'loop' block_stmt
```

**Examples:**
```aura
loop {
    let input = read()
    if input == "quit" { break }
}
```

### 4.4 Exception Handling

```ebnf
try_stmt ::= 'try' block_stmt
            ('catch' exception_pattern block_stmt)*
            ('finally' block_stmt)?

exception_pattern ::= type_expr ('as' identifier)?
                    | ε  // Catch all
```

**Examples:**
```aura
try {
    risky_operation()
} catch FileNotFoundError as e {
    log(e)
} catch PermissionError {
    handle_permission()
} catch {
    handle_unknown()
} finally {
    cleanup()
}
```

### 4.5 Context Managers

```ebnf
with_stmt ::= 'with' with_item (',' with_item)* block_stmt
with_item ::= expression ('as' identifier)?
```

**Examples:**
```aura
with open("file.txt") as f {
    content = f.read()
}

with lock, timer as t {
    perform_operation()
}
```

### 4.6 Return Statement

```ebnf
return_stmt ::= 'return' expression?
```

**Examples:**
```aura
return
return 42
return Ok(result)
return x * 2 + 1
```

---

## 5. Declarations

### 5.1 Variable Declarations

```ebnf
var_decl ::= 'let' 'mut'? identifier type_annotation? '=' expression
const_decl ::= 'const' identifier type_annotation? '=' expression
```

**Examples:**
```aura
let x = 10
let mut counter = 0
let name: str = "Alice"
const PI: float = 3.14159
const MAX_SIZE = 1000
```

### 5.2 Function Declarations

```ebnf
func_decl ::= decorator* 'async'? 'def' identifier
              type_params?
              '(' parameter_list? ')'
              return_type?
              (block_stmt | '=' expression)

parameter_list ::= parameter (',' parameter)*
parameter      ::= identifier type_annotation? default_value?
                 | '*' identifier
                 | '**' identifier
                 | '*'  // Keyword-only marker

default_value  ::= '=' expression
return_type    ::= '->' type_expr
type_params    ::= '<' type_param (',' type_param)* '>'
type_param     ::= identifier (':' type_expr)?

decorator      ::= '@' identifier ('(' argument_list? ')')?
```

**Examples:**
```aura
def add(a: int, b: int) -> int {
    return a + b
}

// Expression body
def multiply(a: int, b: int) -> int = a * b

// Default parameters
def greet(name: str, greeting: str = "Hello") {
    print(f"{greeting}, {name}")
}

// Keyword-only parameters
def create(name: str, *, email: str, age: int = 18) {
    return User(name, email, age)
}

// Variadic
def sum_all(*numbers: int) -> int {
    return sum(numbers)
}

def log(level: str, **context) {
    print(f"[{level}] {context}")
}

// Generic function
def map<T, R>(fn: (T) -> R, items: list[T]) -> list[R] {
    return [fn(item) for item in items]
}

// With constraints
def sort<T: Comparable>(items: list[T]) -> list[T] {
    return sorted(items)
}

// Async
async def fetch_data() -> Data {
    return await api.get()
}

// Decorators
@memoize
@debug
def fibonacci(n: int) -> int {
    if n <= 1 { return n }
    return fibonacci(n-1) + fibonacci(n-2)
}
```

### 5.3 Class Declarations

```ebnf
class_decl ::= decorator* 'class' identifier type_params?
               inheritance?
               class_body

inheritance ::= 'extends' type_expr
              | 'implements' type_expr (',' type_expr)*

class_body ::= '{' class_member* '}'

class_member ::= method_decl
               | property_decl
               | field_decl

field_decl ::= identifier type_annotation? ('=' expression)?
```

**Examples:**
```aura
class User {
    name: str
    email: str
    
    def __init__(self, name: str, email: str) {
        self.name = name
        self.email = email
    }
    
    def greet(self) {
        print(f"Hello, {self.name}")
    }
    
    @property
    def display_name(self) -> str {
        return self.name.upper()
    }
    
    @staticmethod
    def validate_email(email: str) -> bool {
        return "@" in email
    }
}

// Inheritance
class Admin extends User {
    permissions: set[str]
    
    def __init__(self, name: str, email: str, permissions: set[str]) {
        super().__init__(name, email)
        self.permissions = permissions
    }
}

// Generic class
class Box<T> {
    value: T
    
    def __init__(self, value: T) {
        self.value = value
    }
    
    def get(self) -> T {
        return self.value
    }
}

// Dataclass
@dataclass
class Point {
    x: float
    y: float
    
    def distance_to(self, other: Point) -> float {
        return sqrt((self.x - other.x)**2 + (self.y - other.y)**2)
    }
}
```

### 5.4 Trait Declarations

```ebnf
trait_decl ::= 'trait' identifier type_params? trait_body
trait_body ::= '{' trait_member* '}'
trait_member ::= method_signature | property_signature

method_signature ::= 'def' identifier '(' parameter_list? ')' return_type?
```

**Examples:**
```aura
trait Drawable {
    def draw(self) -> none
    def get_bounds(self) -> Rectangle
}

trait Comparable<T> {
    def compare(self, other: T) -> int
}

class Circle implements Drawable {
    radius: float
    
    def draw(self) {
        // Implementation
    }
    
    def get_bounds(self) -> Rectangle {
        // Implementation
    }
}
```

### 5.5 Type Declarations

```ebnf
type_decl ::= 'type' identifier type_params? '=' type_expr
```

**Examples:**
```aura
type UserId = int
type Point = {x: float, y: float}
type Result<T, E> = Ok(T) | Err(E)
type Handler = (Request) -> Response
type Json = dict[str, any]
```

### 5.6 Module Declarations

```ebnf
module_decl ::= 'module' identifier module_body
module_body ::= '{' module_member* '}'
module_member ::= 'export'? declaration
```

**Examples:**
```aura
module Math {
    export const PI = 3.14159
    
    export def sin(x: float) -> float {
        // Implementation
    }
    
    def internal_helper() {
        // Not exported
    }
}
```

---

## 6. Pattern Matching

### 6.1 Match Statement

```ebnf
match_stmt ::= 'match' expression '{' case_clause+ '}'
case_clause ::= 'case' pattern guard? block_stmt

pattern ::= literal_pattern
          | identifier_pattern
          | wildcard_pattern
          | constructor_pattern
          | list_pattern
          | dict_pattern
          | or_pattern
          | as_pattern

guard ::= 'if' expression
```

### 6.2 Pattern Types

```ebnf
literal_pattern     ::= literal
identifier_pattern  ::= identifier
wildcard_pattern    ::= '_'
constructor_pattern ::= identifier '(' pattern_list? ')'
list_pattern       ::= '[' pattern_list? ']'
dict_pattern       ::= '{' field_pattern_list? '}'
or_pattern         ::= pattern ('|' pattern)+
as_pattern         ::= pattern 'as' identifier

pattern_list       ::= pattern (',' pattern)* (',' '*' identifier)?
```

**Examples:**
```aura
match value {
    case 0 { print("Zero") }
    case 1 | 2 | 3 { print("Small") }
    case x if x > 100 { print("Large") }
    case _ { print("Other") }
}

match point {
    case Point(0, 0) { print("Origin") }
    case Point(x, 0) { print(f"On X-axis: {x}") }
    case Point(0, y) { print(f"On Y-axis: {y}") }
    case Point(x, y) { print(f"At ({x}, {y})") }
}

match list {
    case [] { print("Empty") }
    case [x] { print(f"Single: {x}") }
    case [first, *rest] { print(f"First: {first}") }
    case [1, 2, *rest as remaining] { print(remaining) }
}

match result {
    case Ok(value) { process(value) }
    case Err(error) { handle_error(error) }
}
```

---

## 7. Operators

### 7.1 Operator Precedence Table

| Precedence | Operator | Description | Associativity |
|------------|----------|-------------|---------------|
| 1 (highest) | `**` | Exponentiation | Right |
| 2 | `+x`, `-x`, `~x` | Unary plus, minus, bitwise NOT | Right |
| 3 | `*`, `/`, `//`, `%` | Multiplication, division, floor div, modulo | Left |
| 4 | `+`, `-` | Addition, subtraction | Left |
| 5 | `<<`, `>>` | Bitwise shifts | Left |
| 6 | `&` | Bitwise AND | Left |
| 7 | `^` | Bitwise XOR | Left |
| 8 | `\|` | Bitwise OR | Left |
| 9 | `<`, `<=`, `>`, `>=` | Comparisons | Left |
| 10 | `==`, `!=`, `is`, `in` | Equality, identity, membership | Left |
| 11 | `not` | Logical NOT | Right |
| 12 | `and` | Logical AND | Left |
| 13 | `or` | Logical OR | Left |
| 14 | `?:` | Elvis operator | Right |
| 15 | `??` | Null coalescing | Right |
| 16 | `? :` | Ternary conditional | Right |
| 17 | `\|>` | Pipe | Left |
| 18 (lowest) | `=`, `+=`, etc. | Assignment | Right |

### 7.2 Special Operators

#### Null-Safe Navigation
```aura
user?.profile?.name
object?.method()
list?[index]
```

#### Null Coalescing
```aura
value ?? default
name ?? "Anonymous"
config.port ?? 8080
```

#### Elvis Operator
```aura
value ?: default  // Returns value if truthy, else default
```

#### Pipe Operator
```aura
data |> filter |> map |> reduce
value |> transform |> validate
```

#### Range Operators
```aura
1..10        // Inclusive range
0..<100      // Exclusive range
1..          // Infinite range
0..100 step 5  // Range with step
```

#### Spread Operator
```aura
[*list1, *list2]
{**dict1, **dict2}
func(*args, **kwargs)
```

---

## 8. Grammar Summary

### 8.1 Complete EBNF Grammar

```ebnf
(* Program Structure *)
program ::= (import_stmt | declaration | statement)*

(* Declarations *)
declaration ::= var_decl | const_decl | func_decl | class_decl 
              | trait_decl | type_decl | module_decl

(* Statements *)
statement ::= simple_stmt | compound_stmt
simple_stmt ::= expr_stmt | assignment_stmt | return_stmt 
              | break_stmt | continue_stmt
compound_stmt ::= if_stmt | unless_stmt | guard_stmt | while_stmt 
                | until_stmt | for_stmt | loop_stmt | try_stmt 
                | with_stmt | match_stmt | block_stmt

(* Expressions *)
expression ::= assignment_expr | pipe_expr | conditional_expr 
             | binary_expr | unary_expr | postfix_expr | primary_expr

(* Types *)
type_expr ::= primitive_type | compound_type | function_type 
            | union_type | generic_type | literal_type | structural_type

(* Patterns *)
pattern ::= literal_pattern | identifier_pattern | wildcard_pattern 
          | constructor_pattern | list_pattern | dict_pattern
          | or_pattern | as_pattern
```

---

## 9. Semantic Rules

### 9.1 Scoping Rules

**Block Scope:**
- Variables declared with `let` are block-scoped
- Each `{}` creates a new scope
- Inner scopes can access outer scope variables
- Shadowing is allowed

```aura
let x = 10

if true {
    let x = 20  // Shadows outer x
    print(x)    // Prints 20
}

print(x)  // Prints 10
```

**Function Scope:**
- Function parameters are scoped to the function body
- Nested functions can access outer function variables (closures)

```aura
def outer() {
    let x = 10
    
    def inner() {
        print(x)  // Accesses outer x
    }
    
    inner()
}
```

**Module Scope:**
- Top-level declarations are module-scoped
- Can be exported with `export` keyword

```aura
module MyModule {
    const PRIVATE = 10
    export const PUBLIC = 20
    
    export def public_func() { }
    def private_func() { }
}
```

### 9.2 Mutability Rules

**Immutable by Default:**
```aura
let x = 10
x = 20  // ERROR: Cannot reassign immutable variable
```

**Explicit Mutability:**
```aura
let mut counter = 0
counter += 1  // OK: Variable is mutable

const PI = 3.14159
PI = 3.14  // ERROR: Constants cannot be reassigned
```

**Reference Mutability:**
```aura
let list = [1, 2, 3]
list.append(4)  // OK: Mutating the object, not the reference

let mut mutable_list = [1, 2, 3]
mutable_list = [4, 5, 6]  // OK: Can reassign mutable variable
```

### 9.3 Type Checking Rules

**Type Inference:**
```aura
let x = 10           // Inferred as int
let y = 3.14         // Inferred as float
let name = "Alice"   // Inferred as str
let items = [1, 2]   // Inferred as list[int]
```

**Explicit Type Annotations:**
```aura
let x: int = 10
let name: str = "Alice"
let scores: list[float] = [9.5, 8.7]

def add(a: int, b: int) -> int {
    return a + b
}
```

**Type Compatibility:**
```aura
// Subtype relationships
let x: int | str = 10      // OK: int is compatible with int|str
let y: int = x             // ERROR: int|str not compatible with int

// Structural typing
type Point = {x: int, y: int}
let p = {x: 10, y: 20, z: 30}  // OK: Has all required fields
let point: Point = p            // OK: Structural match
```

**Generic Type Constraints:**
```aura
def process<T: Serializable>(data: T) -> bytes {
    return data.serialize()
}

// T must implement Serializable trait
process(user)  // OK if User implements Serializable
process(123)   // ERROR if int doesn't implement Serializable
```

### 9.4 Null Safety Rules

**Optional Types:**
```aura
let name: str? = get_name()  // Can be str or null

// Safe access
let upper = name?.upper()    // Returns str? (null if name is null)

// Null coalescing
let display = name ?? "Anonymous"  // Returns str (never null)
```

**Null Checks:**
```aura
if name != null {
    // Type narrowing: name is str here, not str?
    print(name.upper())
}

guard user != null else {
    return
}
// user is non-null here
```

**Safe Unwrapping:**
```aura
match value {
    case Some(x) { process(x) }  // x is unwrapped
    case None { handle_none() }
}
```

### 9.5 Error Handling Rules

**Result Type Pattern:**
```aura
def divide(a: float, b: float) -> Result<float, str> {
    if b == 0 {
        return Err("Division by zero")
    }
    return Ok(a / b)
}

// Must handle both cases
match divide(10, 2) {
    case Ok(result) { print(result) }
    case Err(msg) { print(msg) }
}
```

**Error Propagation:**
```aura
def process() -> Result<Data, Error> {
    let content = read_file(path)?  // Propagates error if Err
    let parsed = parse(content)?
    return Ok(transform(parsed))
}
```

**Exception Safety:**
```aura
try {
    risky_operation()
} catch SpecificError as e {
    // Must handle or re-raise
    log(e)
    raise
} finally {
    // Always executed
    cleanup()
}
```

---

## 10. Standard Library Types

### 10.1 Built-in Types

```aura
// Primitives
int        // Arbitrary precision integer
float      // 64-bit floating point
str        // Unicode string
bool       // true or false
bytes      // Byte sequence
none       // Null/None value

// Collections
list[T]           // Dynamic array
dict[K, V]        // Hash map
set[T]            // Hash set
tuple[T1, T2, ...]  // Fixed-size tuple

// Special Types
any        // Any type (opt-out of type checking)
never      // Type that never occurs (for functions that never return)
unknown    // Type-safe 'any' (requires type checking before use)
```

### 10.2 Option Type

```aura
// Option type definition
type Option<T> = Some(T) | None

// Usage
def find(list: list[T], predicate: (T) -> bool) -> Option<T> {
    for item in list {
        if predicate(item) {
            return Some(item)
        }
    }
    return None
}

// Pattern matching
match find(users, (u) => u.id == 5) {
    case Some(user) { display(user) }
    case None { print("Not found") }
}

// Chaining
let result = find(users, predicate)
    .map((u) => u.name)
    .unwrap_or("Unknown")
```

### 10.3 Result Type

```aura
// Result type definition
type Result<T, E> = Ok(T) | Err(E)

// Usage
def safe_divide(a: float, b: float) -> Result<float, str> {
    if b == 0 {
        return Err("Division by zero")
    }
    return Ok(a / b)
}

// Pattern matching
match safe_divide(10, 0) {
    case Ok(value) { print(value) }
    case Err(msg) { print(f"Error: {msg}") }
}

// Combinators
result
    .map((x) => x * 2)
    .and_then(validate)
    .unwrap_or(default_value)
```

---

## 11. Macro System

### 11.1 Macro Syntax

```ebnf
macro_decl ::= 'macro' identifier '(' param_list? ')' macro_body
macro_body ::= '{' macro_stmt* '}'
macro_stmt ::= 'quote' block_stmt
             | 'unquote' expression
             | statement

macro_invocation ::= '@' identifier ('(' argument_list? ')')?
```

### 11.2 Built-in Macros

**Debug Macro:**
```aura
@debug
def calculate(x: int, y: int) -> int {
    return x * y
}

// Expands to:
def calculate(x: int, y: int) -> int {
    print(f"calculate called with x={x}, y={y}")
    let __result = x * y
    print(f"calculate returned {__result}")
    return __result
}
```

**Inline Macro:**
```aura
@inline
def add(a: int, b: int) -> int = a + b

// Call site: result = add(5, 3)
// Expands to: result = 5 + 3
```

**Memoize Macro:**
```aura
@memoize
def fibonacci(n: int) -> int {
    if n <= 1 { return n }
    return fibonacci(n-1) + fibonacci(n-2)
}

// Adds caching logic automatically
```

**Derive Macro:**
```aura
@derive(Eq, Hash, Debug, Clone)
class Point {
    x: int
    y: int
}

// Automatically implements:
// - __eq__ and __hash__ for Eq and Hash
// - __repr__ for Debug
// - clone() method for Clone
```

**Time Macro:**
```aura
@time
def expensive_operation() {
    // Implementation
}

// Expands to add timing logic:
def expensive_operation() {
    let __start = time.time()
    try {
        // Original implementation
    } finally {
        let __duration = time.time() - __start
        print(f"expensive_operation took {__duration}s")
    }
}
```

### 11.3 Custom Macros

```aura
// Define custom macro
macro assert_positive(expr) {
    quote {
        if not (${expr} > 0) {
            raise ValueError(f"${expr} must be positive")
        }
    }
}

// Usage
def set_age(age: int) {
    assert_positive!(age)
    self.age = age
}

// Expands to:
def set_age(age: int) {
    if not (age > 0) {
        raise ValueError(f"age must be positive")
    }
    self.age = age
}
```

**Macro with Multiple Arguments:**
```aura
macro log_call(level, func_name, args) {
    quote {
        print(f"[${level}] Calling ${func_name} with ${args}")
    }
}

// Usage
log_call!("INFO", "process_data", [x, y, z])
```

---

## 12. Advanced Type Features

### 12.1 Type Guards

```aura
def is_string(value: any) -> value is str {
    return isinstance(value, str)
}

def is_user(obj: any) -> obj is User {
    return hasattr(obj, 'name') and hasattr(obj, 'email')
}

// Usage with type narrowing
if is_string(data) {
    // Type checker knows data is str here
    print(data.upper())
}
```

### 12.2 Mapped Types

```aura
// Readonly - makes all fields readonly
type Readonly<T> = {
    [K in keyof T]: readonly T[K]
}

// Partial - makes all fields optional
type Partial<T> = {
    [K in keyof T]?: T[K]
}

// Pick - select specific fields
type Pick<T, K> = {
    [P in K]: T[P]
}

// Omit - exclude specific fields
type Omit<T, K> = {
    [P in Exclude<keyof T, K>]: T[P]
}

// Usage
type User = {
    id: int,
    name: str,
    email: str,
    age: int
}

type ReadonlyUser = Readonly<User>
type PartialUser = Partial<User>
type UserPreview = Pick<User, "id" | "name">
type UserWithoutAge = Omit<User, "age">
```

### 12.3 Conditional Types

```abnf
conditional_type ::= type_expr 'extends' type_expr '?' type_expr ':' type_expr
```

```aura
// Check if type is array
type IsArray<T> = T extends list ? true : false

// Extract element type from array
type ElementType<T> = T extends list[infer U] ? U : never

// Return type extraction
type ReturnType<T> = T extends (...args: any) -> infer R ? R : never

// Usage
type Numbers = list[int]
type IsNumbersArray = IsArray<Numbers>  // true
type NumberType = ElementType<Numbers>   // int

type AddFunc = (int, int) -> int
type AddReturn = ReturnType<AddFunc>     // int
```

### 12.4 Template Literal Types

```aura
// String literal types
type HttpMethod = "GET" | "POST" | "PUT" | "DELETE"

// Template literal types
type ApiRoute = `/api/${string}`
type IdRoute = `/users/${int}`
type VersionedRoute = `/v${1 | 2 | 3}/${string}`

// Usage
def fetch(route: ApiRoute) {
    // route must start with /api/
}

fetch("/api/users")      // OK
fetch("/api/posts/123")  // OK
fetch("/users")          // ERROR: doesn't match ApiRoute
```

### 12.5 Variance Annotations

```aura
// Covariant type parameter
type Producer<out T> = {
    produce: () -> T
}

// Contravariant type parameter
type Consumer<in T> = {
    consume: (T) -> none
}

// Invariant (default)
type Box<T> = {
    get: () -> T,
    set: (T) -> none
}

// Covariance allows:
let producer: Producer[Animal] = Producer[Dog]()  // OK

// Contravariance allows:
let consumer: Consumer[Dog] = Consumer[Animal]()  // OK
```

---

## 13. Import and Export System

### 13.1 Import Syntax

```ebnf
import_stmt ::= 'import' module_path ('as' identifier)?
              | 'from' module_path 'import' import_items

module_path ::= identifier ('.' identifier)*
import_items ::= import_item (',' import_item)*
               | '*'
               
import_item ::= identifier ('as' identifier)?
```

**Examples:**
```aura
// Import module
import math
import json
import http.client

// Import with alias
import numpy as np
import pandas as pd

// Import specific items
from collections import Counter, defaultdict
from typing import Optional, List

// Import with renaming
from utils import long_function_name as short

// Relative imports
from .utils import helper
from ..models import User
from ...core import Config

// Import all (discouraged)
from math import *
```

### 13.2 Export Syntax

```aura
// Export individual items
export const VERSION = "1.0.0"
export type UserId = int

export def public_function() {
    // Implementation
}

export class PublicClass {
    // Implementation
}

// Module with exports
module MyLib {
    const PRIVATE = 10
    export const PUBLIC = 20
    
    def private_func() { }
    
    export def public_func() {
        return private_func() + PUBLIC
    }
}
```

### 13.3 Re-exports

```aura
// Re-export from other modules
export { User, Post } from "./models"
export { default as Config } from "./config"
export * from "./utils"

// Re-export with renaming
export { OldName as NewName } from "./legacy"
```

---

## 14. Attributes and Decorators

### 14.1 Function Decorators

```aura
// Single decorator
@staticmethod
def helper() { }

// Multiple decorators (applied bottom-up)
@log
@validate
@cache
def process(data) { }

// Decorator with arguments
@retry(max_attempts=3, delay=1.0)
def fetch_data() { }

// Custom decorator
def timer(func) {
    def wrapper(*args, **kwargs) {
        let start = time.time()
        let result = func(*args, **kwargs)
        print(f"Took {time.time() - start}s")
        return result
    }
    return wrapper
}

@timer
def slow_function() {
    // Implementation
}
```

### 14.2 Class Decorators

```aura
@dataclass
class Point {
    x: float
    y: float
}

@abstract
class Shape {
    @abstract
    def area(self) -> float
}

@singleton
class Database {
    // Only one instance can exist
}

@derive(Eq, Hash, Clone, Debug)
class User {
    name: str
    email: str
}
```

### 14.3 Property Decorators

```aura
class Rectangle {
    width: float
    height: float
    
    @property
    def area(self) -> float {
        return self.width * self.height
    }
    
    @property
    def perimeter(self) -> float {
        return 2 * (self.width + self.height)
    }
    
    @area.setter
    def area(self, value: float) {
        // Maintain aspect ratio
        let ratio = self.width / self.height
        self.height = sqrt(value / ratio)
        self.width = value / self.height
    }
}
```

---

## 15. Compilation and Execution Model

### 15.1 Compilation Phases

1. **Lexical Analysis**: Source code → Tokens
2. **Parsing**: Tokens → AST (Abstract Syntax Tree)
3. **Semantic Analysis**: AST → Annotated AST
   - Type checking
   - Name resolution
   - Macro expansion
4. **Transformation**: Annotated AST → Python AST
   - Desugar syntax (pipe, null-safe, etc.)
   - Apply macros
   - Transform patterns
5. **Code Generation**: Python AST → Python bytecode
6. **Execution**: Run bytecode in CPython VM

### 15.2 Type Checking

```aura
// Type checking happens at compile-time
let x: int = "hello"  // ERROR at compile-time

// Generic type checking
def identity<T>(x: T) -> T {
    return x
}

let result = identity(42)        // T inferred as int
let name = identity("Alice")     // T inferred as str

// Type narrowing
def process(value: int | str) {
    if isinstance(value, int) {
        // value is int here
        return value * 2
    } else {
        // value is str here
        return value.upper()
    }
}
```

### 15.3 Macro Expansion

```aura
// Before expansion
@debug
def add(a: int, b: int) -> int {
    return a + b
}

// After macro expansion
def add(a: int, b: int) -> int {
    print(f"add called with a={a}, b={b}")
    let __result = a + b
    print(f"add returned {__result}")
    return __result
}

// Then transpiles to Python AST
```

---

## 16. Memory and Performance

### 16.1 Memory Model

- **Value Types**: Copied on assignment (int, float, bool, tuple)
- **Reference Types**: Shared references (list, dict, class instances)
- **Immutable Types**: Can be safely shared (str, tuple, frozen sets)

```aura
// Value semantics
let a = 10
let b = a  // Copy of value
b = 20     // Doesn't affect a

// Reference semantics
let list1 = [1, 2, 3]
let list2 = list1  // Both reference same list
list2.append(4)    // Affects list1 too

// Explicit copy
let list3 = list1.copy()  // Independent copy
```

### 16.2 Performance Considerations

**Inline Functions:**
```aura
@inline
def fast_add(a: int, b: int) -> int = a + b

// Inlined at call site for performance
```

**Memoization:**
```aura
@memoize
def fibonacci(n: int) -> int {
    // Cached for repeated calls
    if n <= 1 { return n }
    return fibonacci(n-1) + fibonacci(n-2)
}
```

**Lazy Evaluation:**
```aura
// Generator expressions for memory efficiency
let large_numbers = (x**2 for x in range(1_000_000))

// Only computed when needed
for num in large_numbers {
    if num > 100 { break }
}
```

---

## 17. Best Practices

### 17.1 Naming Conventions

```aura
// Variables and functions: snake_case
let user_count = 10
def calculate_total() { }

// Classes and types: PascalCase
class UserAccount { }
type UserId = int

// Constants: SCREAMING_SNAKE_CASE
const MAX_RETRIES = 3
const API_ENDPOINT = "https://api.example.com"

// Private members: _prefix
def _internal_helper() { }
let _private_var = 10

// Type parameters: Single uppercase letter or PascalCase
def map<T, R>(fn: (T) -> R, items: list[T]) -> list[R]
def process<TInput, TOutput>(data: TInput) -> TOutput
```

### 17.2 Type Annotation Guidelines

```aura
// Always annotate public APIs
export def public_function(param: str) -> int {
    return process(param)
}

// Optional for private/local code
def _helper(x) {
    return x * 2
}

// Always annotate complex types
let users: list[{name: str, age: int}] = load_users()

// Use type aliases for clarity
type Callback = (Event) -> none
let handler: Callback = on_click
```

### 17.3 Error Handling Patterns

```aura
// Prefer Result types for expected errors
def divide(a: float, b: float) -> Result<float, str> {
    if b == 0 {
        return Err("Division by zero")
    }
    return Ok(a / b)
}

// Use exceptions for unexpected errors
def load_config(path: str) -> Config {
    if not file_exists(path) {
        raise FileNotFoundError(f"Config not found: {path}")
    }
    return parse_config(read_file(path))
}

// Guard clauses for early returns
def process_user(user: User?) {
    guard user != null else {
        return
    }
    
    guard user.is_active else {
        log("Inactive user")
        return
    }
    
    // Main logic here
    perform_action(user)
}
```

---

This completes the comprehensive Aura Language Syntax Specification. For more details, see the main documentation and examples in the official repository.