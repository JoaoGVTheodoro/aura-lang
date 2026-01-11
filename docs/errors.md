# Aura Language - Error Handling and Diagnostics Guide

A comprehensive guide to error handling, warnings, and diagnostic systems in Aura.

---

## 📋 Table of Contents

1. [Error Handling Philosophy](#1-error-handling-philosophy)
2. [Exception-Based Error Handling](#2-exception-based-error-handling)
3. [Result-Based Error Handling](#3-result-based-error-handling)
4. [Option-Based Error Handling](#4-option-based-error-handling)
5. [Compile-Time Errors](#5-compile-time-errors)
6. [Runtime Errors](#6-runtime-errors)
7. [Warnings and Lints](#7-warnings-and-lints)
8. [Error Recovery Patterns](#8-error-recovery-patterns)
9. [Debugging and Diagnostics](#9-debugging-and-diagnostics)
10. [Best Practices](#10-best-practices)

---

## 1. Error Handling Philosophy

Aura provides **three complementary error handling approaches**, each suited for different scenarios:

### 1.1 Error Handling Approaches

```aura
// 1. Exceptions - For unexpected, exceptional errors
def load_config(path: str) -> Config {
    if not file_exists(path) {
        raise FileNotFoundError(f"Config file not found: {path}")
    }
    return parse(read_file(path))
}

// 2. Result Type - For expected, recoverable errors
def divide(a: float, b: float) -> Result<float, str> {
    if b == 0 {
        return Err("Division by zero")
    }
    return Ok(a / b)
}

// 3. Option Type - For values that may not exist
def find_user(id: int) -> Option<User> {
    let user = database.query(id)
    return Some(user) if user else None
}
```

### 1.2 When to Use Each Approach

| Approach | Use When | Example |
|----------|----------|---------|
| **Exceptions** | Truly exceptional, unrecoverable errors | File not found, out of memory, network timeout |
| **Result** | Expected failures in business logic | Validation errors, parsing failures, authentication errors |
| **Option** | Value may or may not exist | Dictionary lookup, search operation, optional configuration |

**Decision Tree:**
```
Is the absence of a value normal?
├─ Yes → Use Option<T>
└─ No → Is this error expected in normal operation?
    ├─ Yes → Use Result<T, E>
    └─ No → Use Exceptions
```

---

## 2. Exception-Based Error Handling

### 2.1 Try-Catch-Finally

```aura
try {
    let file = open("data.txt")
    let content = file.read()
    process(content)
} catch FileNotFoundError as e {
    print(f"File not found: {e}")
} catch PermissionError as e {
    print(f"Permission denied: {e}")
} catch IOError as e {
    print(f"I/O error occurred: {e}")
} catch {
    print("An unknown error occurred")
} finally {
    // Always executed, even if exception occurs
    cleanup()
}
```

### 2.2 Built-in Exception Types

```aura
// Standard exceptions
ValueError          // Invalid value
TypeError           // Wrong type
KeyError            // Dictionary key not found
IndexError          // List index out of range
AttributeError      // Attribute doesn't exist
ZeroDivisionError   // Division by zero
FileNotFoundError   // File doesn't exist
PermissionError     // Insufficient permissions
RuntimeError        // Generic runtime error
AssertionError      // Assertion failed
NotImplementedError // Method not implemented

// Usage examples
try {
    let num = int("not a number")
} catch ValueError as e {
    print(f"Cannot convert to int: {e}")
}

try {
    let value = my_dict["missing_key"]
} catch KeyError as e {
    print(f"Key not found: {e}")
}

try {
    let item = my_list[999]
} catch IndexError as e {
    print(f"Index out of range: {e}")
}
```

### 2.3 Custom Exceptions

```aura
// Define custom exception
class ValidationError extends Exception {
    field: str
    message: str
    
    def __init__(self, field: str, message: str) {
        self.field = field
        self.message = message
        super().__init__(f"{field}: {message}")
    }
}

class AuthenticationError extends Exception {
    def __init__(self, message: str = "Authentication failed") {
        super().__init__(message)
    }
}

class DatabaseError extends Exception {
    query: str
    original_error: Exception
    
    def __init__(self, query: str, original_error: Exception) {
        self.query = query
        self.original_error = original_error
        super().__init__(f"Database error in query: {query}")
    }
}

// Using custom exceptions
def validate_user(user: dict) {
    if "email" not in user {
        raise ValidationError("email", "Email is required")
    }
    
    if not "@" in user["email"] {
        raise ValidationError("email", "Invalid email format")
    }
    
    if "age" in user and user["age"] < 0 {
        raise ValidationError("age", "Age cannot be negative")
    }
}

// Catching custom exceptions
try {
    validate_user(user_data)
} catch ValidationError as e {
    print(f"Validation failed for {e.field}: {e.message}")
} catch AuthenticationError as e {
    print(f"Auth error: {e}")
}
```

### 2.4 Exception Chaining

```aura
// Re-raising exceptions with context
try {
    process_data(raw_data)
} catch ValueError as e {
    raise ProcessingError("Failed to process data") from e
}

// Accessing the original exception
try {
    complex_operation()
} catch ProcessingError as e {
    print(f"Error: {e}")
    print(f"Caused by: {e.__cause__}")
}
```

### 2.5 Context Managers for Resource Management

```aura
// Automatic resource cleanup
with open("file.txt") as f {
    content = f.read()
    process(content)
}
// File is automatically closed, even if exception occurs

// Multiple resources
with open("input.txt") as input, 
     open("output.txt", "w") as output {
    for line in input {
        output.write(transform(line))
    }
}

// Custom context manager
class DatabaseConnection {
    def __enter__(self) {
        self.conn = connect_to_db()
        return self.conn
    }
    
    def __exit__(self, exc_type, exc_value, traceback) {
        self.conn.close()
        // Return true to suppress exception, false to propagate
        return false
    }
}

with DatabaseConnection() as db {
    db.execute("SELECT * FROM users")
}
// Connection automatically closed
```

### 2.6 Assert Statements

```aura
// Assert for debugging and preconditions
def calculate_discount(price: float, discount_percent: float) -> float {
    assert price >= 0, "Price cannot be negative"
    assert 0 <= discount_percent <= 100, "Discount must be between 0 and 100"
    
    return price * (1 - discount_percent / 100)
}

// Assertions can be disabled in production with --no-assert flag
// aura run --no-assert main.aura

// Use for development/debugging, not for validation
def process_data(data: list) {
    assert len(data) > 0, "Data should not be empty"
    assert all(x > 0 for x in data), "All values should be positive"
    
    return sum(data) / len(data)
}
```

---

## 3. Result-Based Error Handling

### 3.1 Result Type Definition

```aura
// Built-in Result type
type Result<T, E> = Ok(T) | Err(E)

// Creating Results
def safe_divide(a: float, b: float) -> Result<float, str> {
    if b == 0 {
        return Err("Division by zero")
    }
    return Ok(a / b)
}

// More specific error types
type MathError = 
    | DivisionByZero
    | InvalidInput(str)
    | Overflow

def advanced_divide(a: float, b: float) -> Result<float, MathError> {
    if b == 0 {
        return Err(MathError.DivisionByZero)
    }
    
    if a.is_infinite() or b.is_infinite() {
        return Err(MathError.InvalidInput("Infinite values not allowed"))
    }
    
    let result = a / b
    if result.is_infinite() {
        return Err(MathError.Overflow)
    }
    
    return Ok(result)
}
```

### 3.2 Pattern Matching on Results

```aura
// Basic pattern match result {
    case Ok(data) { process(data) }
    case Err(msg) { log_error(msg) }
}
```

### 8.5 Error Aggregation Pattern

```aura
// Collect multiple errors instead of failing fast
def validate_user(user: dict) -> Result<User, list[str]> {
    let mut errors = []
    
    if "name" not in user or not user["name"] {
        errors.append("Name is required")
    }
    
    if "email" not in user {
        errors.append("Email is required")
    } else if not "@" in user["email"] {
        errors.append("Email format is invalid")
    }
    
    if "age" in user and user["age"] < 0 {
        errors.append("Age cannot be negative")
    }
    
    if len(errors) > 0 {
        return Err(errors)
    }
    
    return Ok(User(
        name=user["name"],
        email=user["email"],
        age=user.get("age", 0)
    ))
}

// Usage
match validate_user(user_data) {
    case Ok(user) {
        save_user(user)
    }
    case Err(errors) {
        for error in errors {
            print(f"- {error}")
        }
    }
}
```

### 8.6 Graceful Degradation

```aura
def get_user_profile(user_id: int) -> UserProfile {
    // Try to get complete profile
    match fetch_full_profile(user_id) {
        case Ok(profile) { return profile }
        case Err(_) {
            // Fallback to basic profile
            print("Warning: Using basic profile")
        }
    }
    
    // Try basic profile
    match fetch_basic_profile(user_id) {
        case Ok(profile) { return profile }
        case Err(_) {
            // Last resort: minimal profile
            print("Warning: Using minimal profile")
        }
    }
    
    // Return minimal valid profile
    return UserProfile(
        id=user_id,
        name="Unknown User",
        status="offline"
    )
}
```

---

## 9. Debugging and Diagnostics

### 9.1 Debug Macro

```aura
@debug
def calculate(x: int, y: int) -> int {
    let intermediate = x * 2
    let result = intermediate + y
    return result
}

calculate(5, 3)

// Output:
// [DEBUG] calculate called with x=5, y=3
// [DEBUG] intermediate = 10
// [DEBUG] result = 13
// [DEBUG] calculate returned 13
```

### 9.2 Trace Decorator

```aura
@trace
def process_data(data: list[int]) -> int {
    let filtered = [x for x in data if x > 0]
    let sum = sum(filtered)
    return sum
}

// Output:
// [TRACE] Entering process_data
// [TRACE]   Arguments: data=[1, -2, 3, -4, 5]
// [TRACE]   filtered = [1, 3, 5]
// [TRACE]   sum = 9
// [TRACE] Exiting process_data
// [TRACE]   Return value: 9
```

### 9.3 Logging

```aura
import logging

// Configure logging
logging.configure(
    level="DEBUG",
    format="[{level}] {time} - {message}",
    output="app.log"
)

// Use logging
def fetch_user(id: int) -> Result<User, str> {
    logging.debug(f"Fetching user with id={id}")
    
    match database.query(id) {
        case Ok(user) {
            logging.info(f"Successfully fetched user {user.name}")
            return Ok(user)
        }
        case Err(error) {
            logging.error(f"Failed to fetch user: {error}")
            return Err(error)
        }
    }
}

// Different log levels
logging.debug("Detailed debug information")
logging.info("General information")
logging.warning("Warning message")
logging.error("Error occurred")
logging.critical("Critical error!")
```

### 9.4 Stack Traces

```aura
// Print stack trace
import traceback

try {
    risky_operation()
} catch Exception as e {
    traceback.print_exc()
    // Prints:
    // Traceback (most recent call last):
    //   File "main.aura", line 45, in <module>
    //     risky_operation()
    //   File "main.aura", line 12, in risky_operation
    //     helper_function()
    //   File "main.aura", line 8, in helper_function
    //     raise ValueError("Something went wrong")
    // ValueError: Something went wrong
}

// Get stack trace as string
try {
    risky_operation()
} catch Exception as e {
    let trace = traceback.format_exc()
    log_to_file(trace)
}
```

### 9.5 Performance Profiling

```aura
@profile
def expensive_function() {
    let mut result = 0
    for i in range(1_000_000) {
        result += i * i
    }
    return result
}

// Output:
// [PROFILE] expensive_function
//   Execution time: 0.245s
//   Memory usage: 12.5 MB
//   Calls: 1
```

### 9.6 Interactive Debugging

```aura
import debugger

def complex_algorithm(data: list) {
    let processed = transform(data)
    
    // Set breakpoint
    debugger.breakpoint()
    
    let filtered = filter(processed)
    return filtered
}

// When breakpoint is hit:
// > Breakpoint at main.aura:15
// > (aura-debug) print(processed)
// > [1, 2, 3, 4, 5]
// > (aura-debug) step
// > (aura-debug) continue
```

### 9.7 Error Context

```aura
class ErrorContext {
    message: str
    file: str
    line: int
    function: str
    locals: dict
    
    @staticmethod
    def capture(message: str) -> ErrorContext {
        import inspect
        
        frame = inspect.currentframe().f_back
        return ErrorContext(
            message=message,
            file=frame.f_code.co_filename,
            line=frame.f_lineno,
            function=frame.f_code.co_name,
            locals=dict(frame.f_locals)
        )
    }
    
    def format(self) -> str {
        return f"""
Error: {self.message}
  File: {self.file}
  Line: {self.line}
  Function: {self.function}
  Locals: {self.locals}
        """
    }
}

// Usage
def process(data: any) {
    if not validate(data) {
        let ctx = ErrorContext.capture("Invalid data")
        raise ValueError(ctx.format())
    }
}
```

---

## 10. Best Practices

### 10.1 When to Use Each Error Handling Approach

```aura
// ✅ Use Result for business logic errors
def transfer_money(from: Account, to: Account, amount: float) -> Result<Transaction, str> {
    if from.balance < amount {
        return Err("Insufficient funds")
    }
    
    if amount <= 0 {
        return Err("Amount must be positive")
    }
    
    let transaction = execute_transfer(from, to, amount)
    return Ok(transaction)
}

// ✅ Use Option for values that may not exist
def find_user_by_email(email: str) -> Option<User> {
    return database.query("SELECT * FROM users WHERE email = ?", email)
}

// ✅ Use exceptions for truly exceptional cases
def load_config(path: str) -> Config {
    if not file_exists(path) {
        raise FileNotFoundError(f"Critical: Config file missing: {path}")
    }
    
    try {
        return parse_config(read_file(path))
    } catch ParseError as e {
        raise RuntimeError(f"Fatal: Cannot parse config: {e}")
    }
}

// ❌ Don't use exceptions for control flow
def find_user_bad(id: int) -> User {
    try {
        return database.get(id)
    } catch NotFoundError {
        return default_user()
    }
}

// ✅ Better: use Option or Result
def find_user_good(id: int) -> Option<User> {
    return database.query(id)
}
```

### 10.2 Error Message Guidelines

```aura
// ✅ Descriptive, actionable error messages
if password.length() < 8 {
    return Err("Password must be at least 8 characters long")
}

if not email.contains("@") {
    return Err("Email must contain an '@' symbol. Example: user@example.com")
}

// ❌ Vague error messages
if not valid {
    return Err("Invalid")  // What's invalid? Why?
}

// ✅ Include context
def process_file(path: str) -> Result<Data, str> {
    match read_file(path) {
        case Ok(content) { /* ... */ }
        case Err(e) {
            return Err(f"Failed to read file '{path}': {e}")
        }
    }
}

// ✅ Suggest solutions
if not has_permission(user, resource) {
    return Err(
        "You don't have permission to access this resource. " +
        "Please contact an administrator to request access."
    )
}
```

### 10.3 Error Handling Patterns

```aura
// ✅ Fail fast for invalid preconditions
def calculate_discount(price: float, discount_percent: float) -> float {
    guard price >= 0 else {
        raise ValueError("Price cannot be negative")
    }
    
    guard 0 <= discount_percent <= 100 else {
        raise ValueError("Discount must be between 0 and 100")
    }
    
    return price * (1 - discount_percent / 100)
}

// ✅ Use guard clauses for early returns
def process_request(request: Request?) -> Response {
    guard request != null else {
        return error_response("Request is null")
    }
    
    guard request.is_valid() else {
        return error_response("Request validation failed")
    }
    
    guard authenticate(request) else {
        return error_response("Authentication failed")
    }
    
    // Main logic here
    return handle_request(request)
}

// ✅ Chain operations with ?
def get_user_city(user_id: int) -> Result<str, str> {
    let user = find_user(user_id)?
    let address = get_address(user)?
    let city = parse_city(address)?
    return Ok(city)
}

// ✅ Provide meaningful defaults
def get_config(key: str) -> str {
    return config.get(key)
        .unwrap_or(default_config[key])
        .unwrap_or("default_value")
}
```

### 10.4 Resource Management

```aura
// ✅ Always use context managers for resources
with open("data.txt") as file {
    content = file.read()
}  // File automatically closed

// ✅ Handle cleanup in finally
let mut connection = null
try {
    connection = connect_to_database()
    execute_query(connection)
} catch DatabaseError as e {
    log_error(e)
} finally {
    connection?.close()
}

// ✅ Create custom context managers
class Transaction {
    def __enter__(self) {
        self.begin()
        return self
    }
    
    def __exit__(self, exc_type, exc_value, traceback) {
        if exc_type == null {
            self.commit()
        } else {
            self.rollback()
        }
        return false  // Don't suppress exceptions
    }
}

with Transaction() as tx {
    tx.execute("INSERT INTO users ...")
    tx.execute("UPDATE accounts ...")
}  // Auto-commit or rollback
```

### 10.5 Testing Error Conditions

```aura
// Test that errors are raised
def test_division_by_zero() {
    assert_raises(ZeroDivisionError, () => 10 / 0)
}

// Test Result values
def test_safe_divide() {
    match safe_divide(10, 2) {
        case Ok(5.0) { pass }
        case _ { fail("Expected Ok(5.0)") }
    }
    
    match safe_divide(10, 0) {
        case Err(_) { pass }
        case _ { fail("Expected Err") }
    }
}

// Test Option values
def test_find_user() {
    match find_user(999) {
        case None { pass }
        case _ { fail("Expected None for non-existent user") }
    }
}

// Test error messages
def test_validation_error() {
    match validate_email("invalid") {
        case Err(msg) if "must contain" in msg { pass }
        case _ { fail("Expected specific error message") }
    }
}
```

### 10.6 Logging vs Error Handling

```aura
// ✅ Log and handle errors appropriately
def fetch_data(url: str) -> Result<Data, str> {
    logging.info(f"Fetching data from {url}")
    
    match http.get(url) {
        case Ok(response) {
            logging.info("Data fetched successfully")
            return Ok(parse_response(response))
        }
        case Err(error) {
            logging.error(f"Failed to fetch data: {error}")
            return Err(error)
        }
    }
}

// ❌ Don't swallow errors silently
try {
    risky_operation()
} catch {
    pass  // BAD: Error is lost!
}

// ✅ At minimum, log the error
try {
    risky_operation()
} catch Exception as e {
    logging.error(f"Operation failed: {e}")
    // Then decide: propagate, retry, or use fallback
}

// ✅ Different log levels for different errors
def process(data: any) -> Result<Output, str> {
    match validate(data) {
        case Err(e) {
            logging.warning(f"Validation warning: {e}")  // Not critical
            return Err(e)
        }
        case Ok(_) { }
    }
    
    match transform(data) {
        case Err(e) {
            logging.error(f"Transform error: {e}")  // More serious
            return Err(e)
        }
        case Ok(result) { return Ok(result) }
    }
}
```

### 10.7 Error Recovery Strategy

```aura
// ✅ Define clear recovery strategies
def fetch_with_recovery(url: str) -> Data {
    // Try primary source
    match fetch_from_api(url) {
        case Ok(data) { return data }
        case Err(e) {
            logging.warning(f"API failed: {e}, trying cache")
        }
    }
    
    // Try cache
    match fetch_from_cache(url) {
        case Ok(data) { return data }
        case Err(e) {
            logging.warning(f"Cache failed: {e}, using default")
        }
    }
    
    // Last resort
    return default_data()
}

// ✅ Circuit breaker for repeated failures
let api_breaker = CircuitBreaker(
    failure_threshold=5,
    reset_timeout=60.0
)

def resilient_fetch(url: str) -> Result<Data, str> {
    return api_breaker.call(() => fetch_from_api(url))
}

// ✅ Exponential backoff for retries
def fetch_with_backoff(url: str) -> Result<Data, str> {
    let mut delay = 1.0
    
    for attempt in range(5) {
        match fetch_from_api(url) {
            case Ok(data) { return Ok(data) }
            case Err(e) {
                if attempt < 4 {
                    logging.info(f"Retry {attempt + 1} after {delay}s")
                    sleep(delay)
                    delay *= 2  // Exponential backoff
                } else {
                    return Err(e)
                }
            }
        }
    }
}
```

---

## 11. Summary

### 11.1 Error Handling Decision Matrix

| Scenario | Recommended Approach | Example |
|----------|---------------------|---------|
| Value may not exist | `Option<T>` | Database lookup, dictionary access |
| Operation can fail expectedly | `Result<T, E>` | Validation, parsing, API calls |
| Critical system failure | Exception | Out of memory, file not found |
| Assertion during development | `assert` | Precondition checks |
| Optional configuration | `Option<T>` with `??` | Config values with defaults |
| Multiple possible errors | `Result<T, list[E>>` | Form validation |
| Resource management | Context managers (`with`) | Files, connections, transactions |

### 11.2 Quick Reference

```aura
// Exceptions
try {
    risky()
} catch SpecificError as e {
    handle(e)
} finally {
    cleanup()
}

// Result
match operation() {
    case Ok(value) { use(value) }
    case Err(error) { handle(error) }
}

let value = operation()?  // Early return on error

// Option
match find(key) {
    case Some(value) { use(value) }
    case None { handle_missing() }
}

let value = optional?.field ?? default

// Guards
guard condition else {
    return error
}

// Context managers
with resource() as r {
    use(r)
}
```

### 11.3 Key Principles

1. **Be Explicit**: Make errors visible and handleable
2. **Fail Fast**: Catch errors early, validate preconditions
3. **Provide Context**: Include helpful error messages
4. **Recover Gracefully**: Have fallback strategies
5. **Log Appropriately**: Record errors for debugging
6. **Test Error Paths**: Ensure error handling works
7. **Clean Up Resources**: Use context managers
8. **Choose the Right Tool**: Exception, Result, or Option

### 11.4 Common Pitfalls to Avoid

```aura
// ❌ Swallowing errors
try { risky() } catch { pass }

// ❌ Catching too broadly
try { operation() } catch { handle() }

// ❌ Using exceptions for control flow
try { 
    user = db.get(id) 
} catch NotFound { 
    user = default 
}

// ❌ Not cleaning up resources
let file = open("data.txt")
process(file)
// File never closed if process() fails!

// ❌ Vague error messages
return Err("Error")

// ❌ Ignoring null safety
let value = nullable.field  // Might crash!
```

---

## 12. Additional Resources

### 12.1 Compiler Flags

```bash
# Enable all warnings
aura run --warn-all main.aura

# Treat warnings as errors
aura run --warn-error main.aura

# Disable specific warnings
aura run --no-warn-unused main.aura

# Enable debug mode
aura run --debug main.aura

# Show detailed error traces
aura run --verbose main.aura
```

### 12.2 Configuration File

```toml
# aura.toml
[errors]
stack_trace = true
colorize = true
verbose = false

[warnings]
unused_variables = "error"
unreachable_code = "warn"
deprecated = "warn"

[debugging]
enable_assertions = true
log_level = "INFO"
profile_performance = false
```

### 12.3 Further Reading

- [Aura Language Documentation](https://aura-lang.org/docs)
- [Error Handling Best Practices](https://aura-lang.org/docs/error-handling)
- [Result and Option API Reference](https://aura-lang.org/docs/stdlib/result)
- [Exception Hierarchy](https://aura-lang.org/docs/exceptions)
- [Debugging Guide](https://aura-lang.org/docs/debugging)

---

**Remember**: Good error handling is not just about catching errors—it's about making your code resilient, maintainable, and helpful to both developers and users. Choose the right tool for each situation, provide clear error messages, and always clean up resources properly.

---

## 13. Advanced Error Handling Techniques

### 13.1 Error Type Hierarchies

Create structured error types for better error handling:

```aura
// Base error type
class AppError extends Exception {
    code: str
    context: dict
    
    def __init__(self, message: str, code: str, **context) {
        super().__init__(message)
        self.code = code
        self.context = context
    }
}

// Domain-specific errors
class ValidationError extends AppError {
    field: str
    
    def __init__(self, field: str, message: str, **context) {
        super().__init__(message, "VALIDATION_ERROR", **context)
        self.field = field
    }
}

class DatabaseError extends AppError {
    query: str
    
    def __init__(self, message: str, query: str, **context) {
        super().__init__(message, "DATABASE_ERROR", query=query, **context)
        self.query = query
    }
}

class ApiError extends AppError {
    status_code: int
    endpoint: str
    
    def __init__(self, message: str, status_code: int, endpoint: str) {
        super().__init__(
            message, 
            "API_ERROR", 
            status_code=status_code,
            endpoint=endpoint
        )
        self.status_code = status_code
        self.endpoint = endpoint
    }
}

// Usage with pattern matching
try {
    perform_operation()
} catch ValidationError as e {
    return {
        "error": e.code,
        "field": e.field,
        "message": str(e)
    }
} catch DatabaseError as e {
    log_database_error(e.query, str(e))
    return {"error": e.code, "message": "Database operation failed"}
} catch ApiError as e {
    if e.status_code >= 500 {
        retry_operation()
    }
    return {"error": e.code, "status": e.status_code}
}
```

### 13.2 Error Middleware Pattern

```aura
type ErrorHandler = (Exception) -> Response

class ErrorMiddleware {
    handlers: dict[type, ErrorHandler]
    
    def __init__(self) {
        self.handlers = {}
    }
    
    def register(self, error_type: type, handler: ErrorHandler) {
        self.handlers[error_type] = handler
    }
    
    def handle(self, error: Exception) -> Response {
        for error_type, handler in self.handlers.items() {
            if isinstance(error, error_type) {
                return handler(error)
            }
        }
        
        // Default handler
        return Response(
            status=500,
            body={"error": "Internal Server Error"}
        )
    }
}

// Setup middleware
let error_middleware = ErrorMiddleware()

error_middleware.register(ValidationError, (e) => {
    return Response(
        status=400,
        body={
            "error": "Validation Failed",
            "field": e.field,
            "message": str(e)
        }
    )
})

error_middleware.register(AuthenticationError, (e) => {
    return Response(
        status=401,
        body={"error": "Unauthorized", "message": str(e)}
    )
})

error_middleware.register(DatabaseError, (e) => {
    logging.error(f"Database error: {e.query}")
    return Response(
        status=503,
        body={"error": "Service Unavailable"}
    )
})

// Usage in request handler
def handle_request(request: Request) -> Response {
    try {
        return process_request(request)
    } catch Exception as e {
        return error_middleware.handle(e)
    }
}
```

### 13.3 Async Error Handling

```aura
// Async exception handling
async def fetch_user_data(user_id: int) -> Result<UserData, str> {
    try {
        let user = await fetch_user(user_id)
        let posts = await fetch_posts(user_id)
        let comments = await fetch_comments(user_id)
        
        return Ok(UserData(user, posts, comments))
    } catch TimeoutError as e {
        return Err(f"Request timed out: {e}")
    } catch NetworkError as e {
        return Err(f"Network error: {e}")
    } catch {
        return Err("Unknown error occurred")
    }
}

// Parallel async operations with error handling
async def fetch_all_users(ids: list[int]) -> list[Result<User, str>> {
    let tasks = [fetch_user(id) for id in ids]
    let results = await Promise.all_settled(tasks)
    
    return results.map((result) => {
        match result {
            case Fulfilled(user) { Ok(user) }
            case Rejected(error) { Err(str(error)) }
        }
    })
}

// Error boundary for async operations
async def with_error_boundary<T>(
    operation: async () -> T,
    on_error: (Exception) -> T
) -> T {
    try {
        return await operation()
    } catch Exception as e {
        logging.error(f"Error in async operation: {e}")
        return on_error(e)
    }
}

// Usage
let user = await with_error_boundary(
    async () => fetch_user(123),
    (error) => default_user()
)
```

### 13.4 Composable Error Handling

```aura
// Error handling combinators
class ResultExt {
    @staticmethod
    def all<T, E>(results: list[Result<T, E>]) -> Result<list[T], E> {
        let mut values = []
        
        for result in results {
            match result {
                case Ok(value) { values.append(value) }
                case Err(error) { return Err(error) }
            }
        }
        
        return Ok(values)
    }
    
    @staticmethod
    def any<T, E>(results: list[Result<T, E>]) -> Result<T, list[E>> {
        let mut errors = []
        
        for result in results {
            match result {
                case Ok(value) { return Ok(value) }
                case Err(error) { errors.append(error) }
            }
        }
        
        return Err(errors)
    }
    
    @staticmethod
    def partition<T, E>(
        results: list[Result<T, E>>
    ) -> tuple[list[T], list[E]] {
        let mut successes = []
        let mut errors = []
        
        for result in results {
            match result {
                case Ok(value) { successes.append(value) }
                case Err(error) { errors.append(error) }
            }
        }
        
        return (successes, errors)
    }
}

// Usage
let results = [
    parse_int("42"),
    parse_int("abc"),
    parse_int("123")
]

// All must succeed
match ResultExt.all(results) {
    case Ok(numbers) { print(f"All succeeded: {numbers}") }
    case Err(error) { print(f"First error: {error}") }
}

// At least one must succeed
match ResultExt.any(results) {
    case Ok(number) { print(f"Found valid number: {number}") }
    case Err(errors) { print(f"All failed: {errors}") }
}

// Partition successes and failures
let (successes, errors) = ResultExt.partition(results)
print(f"Successes: {successes}, Errors: {errors}")
```

### 13.5 Custom Error Reporters

```aura
class ErrorReporter {
    def report_error(self, error: Exception, context: dict = {}) {
        let report = {
            "error_type": type(error).__name__,
            "message": str(error),
            "timestamp": datetime.now().isoformat(),
            "context": context,
            "stack_trace": traceback.format_exc()
        }
        
        // Send to logging service
        self.log_locally(report)
        
        // Send to error tracking service (e.g., Sentry)
        if self.should_report_remotely(error) {
            self.send_to_service(report)
        }
        
        // Notify on critical errors
        if self.is_critical(error) {
            self.send_alert(report)
        }
    }
    
    def log_locally(self, report: dict) {
        logging.error(json.dumps(report, indent=2))
    }
    
    def should_report_remotely(self, error: Exception) -> bool {
        // Don't report validation errors remotely
        return not isinstance(error, ValidationError)
    }
    
    def is_critical(self, error: Exception) -> bool {
        return isinstance(error, (DatabaseError, SecurityError))
    }
    
    def send_to_service(self, report: dict) {
        // Integration with error tracking service
        try {
            sentry.capture_exception(report)
        } catch {
            logging.warning("Failed to send error to tracking service")
        }
    }
    
    def send_alert(self, report: dict) {
        // Send alerts for critical errors
        send_email(admin_email, "Critical Error", json.dumps(report))
        send_slack_notification(report)
    }
}

// Global error reporter
let error_reporter = ErrorReporter()

// Usage
try {
    critical_operation()
} catch Exception as e {
    error_reporter.report_error(e, {
        "user_id": current_user.id,
        "operation": "critical_operation",
        "environment": "production"
    })
    raise
}
```

---

## 14. Testing Error Handling

### 14.1 Unit Testing Errors

```aura
import unittest

class TestErrorHandling extends unittest.TestCase {
    def test_division_by_zero_returns_error(self) {
        match safe_divide(10, 0) {
            case Err(msg) {
                self.assert_true("zero" in msg.lower())
            }
            case _ {
                self.fail("Expected Err result")
            }
        }
    }
    
    def test_validation_error_raised(self) {
        self.assert_raises(ValidationError, () => {
            validate_user({"name": ""})
        })
    }
    
    def test_validation_error_message(self) {
        try {
            validate_user({"age": -5})
            self.fail("Expected ValidationError")
        } catch ValidationError as e {
            self.assert_equal(e.field, "age")
            self.assert_in("negative", str(e).lower())
        }
    }
    
    def test_error_recovery(self) {
        // Test that fallback works
        let result = fetch_with_fallback("http://invalid")
        self.assert_is_not_null(result)
        self.assert_equal(result, default_data())
    }
    
    def test_retry_mechanism(self) {
        let mut attempts = 0
        
        def failing_operation() -> Result<int, str> {
            attempts += 1
            if attempts < 3 {
                return Err("Temporary failure")
            }
            return Ok(42)
        }
        
        let result = retry(failing_operation, max_attempts=5)
        
        self.assert_equal(attempts, 3)
        match result {
            case Ok(42) { pass }
            case _ { self.fail("Expected Ok(42)") }
        }
    }
}
```

### 14.2 Integration Testing

```aura
class TestErrorIntegration extends unittest.TestCase {
    def test_end_to_end_error_flow(self) {
        // Test complete error flow from API to database
        let request = create_invalid_request()
        let response = handle_request(request)
        
        self.assert_equal(response.status, 400)
        self.assert_in("error", response.body)
    }
    
    async def test_async_error_handling(self) {
        // Test async error handling
        let result = await fetch_user_data(99999)
        
        match result {
            case Err(msg) {
                self.assert_in("not found", msg.lower())
            }
            case _ {
                self.fail("Expected error for non-existent user")
            }
        }
    }
    
    def test_error_middleware(self) {
        let middleware = ErrorMiddleware()
        
        // Test different error types
        let validation_response = middleware.handle(
            ValidationError("email", "Invalid email")
        )
        self.assert_equal(validation_response.status, 400)
        
        let auth_response = middleware.handle(
            AuthenticationError("Invalid token")
        )
        self.assert_equal(auth_response.status, 401)
    }
}
```

### 14.3 Property-Based Testing

```aura
import hypothesis

class TestErrorProperties {
    @hypothesis.given(
        a=hypothesis.floats(),
        b=hypothesis.floats()
    )
    def test_divide_never_panics(self, a: float, b: float) {
        // safe_divide should never panic, always return Result
        let result = safe_divide(a, b)
        
        match result {
            case Ok(value) {
                // If Ok, value should be finite
                self.assert_true(value.is_finite())
            }
            case Err(_) {
                // If Err, b should be zero
                self.assert_equal(b, 0.0)
            }
        }
    }
    
    @hypothesis.given(data=hypothesis.dictionaries(
        keys=hypothesis.text(),
        values=hypothesis.integers()
    ))
    def test_validation_is_deterministic(self, data: dict) {
        // Validation should always return same result for same input
        let result1 = validate_data(data)
        let result2 = validate_data(data)
        
        self.assert_equal(result1.is_ok(), result2.is_ok())
    }
}
```

---

## 15. Performance Considerations

### 15.1 Error Handling Performance

```aura
// ✅ Result is more performant than exceptions for expected errors
def fast_parse(s: str) -> Result<int, str> {
    // No exception overhead
    if not s.is_numeric() {
        return Err("Not a number")
    }
    return Ok(int(s))
}

// ❌ Exceptions have overhead
def slow_parse(s: str) -> int {
    try {
        return int(s)
    } catch ValueError {
        return 0
    }
}

// Benchmark: Result vs Exception
@benchmark
def benchmark_result() {
    for _ in range(10000) {
        fast_parse("not a number")
    }
}

@benchmark
def benchmark_exception() {
    for _ in range(10000) {
        slow_parse("not a number")
    }
}

// Result is ~10-100x faster for expected errors
```

### 15.2 Lazy Error Construction

```aura
// ❌ Eager error construction (wasteful if not used)
def expensive_validation(data: any) -> Result<Data, str> {
    let detailed_error = generate_detailed_report(data)  // Expensive!
    
    if not valid(data) {
        return Err(detailed_error)
    }
    return Ok(data)
}

// ✅ Lazy error construction
def efficient_validation(data: any) -> Result<Data, () -> str> {
    if not valid(data) {
        return Err(() => generate_detailed_report(data))
    }
    return Ok(data)
}

// Only generate error message when needed
match efficient_validation(data) {
    case Ok(d) { process(d) }
    case Err(error_fn) {
        let message = error_fn()  // Called only on error path
        log_error(message)
    }
}
```

### 15.3 Error Pooling

```aura
// Reuse error objects to reduce allocations
class ErrorPool {
    pool: dict[str, Exception] = {}
    
    def get(self, error_type: str, message: str) -> Exception {
        let key = f"{error_type}:{message}"
        
        if key not in self.pool {
            self.pool[key] = Exception(message)
        }
        
        return self.pool[key]
    }
}

let error_pool = ErrorPool()

// Reuse common errors
def validate(value: int) -> Result<int, Exception> {
    if value < 0 {
        return Err(error_pool.get("ValueError", "Negative value"))
    }
    return Ok(value)
}
```

---

## 16. Real-World Examples

### 16.1 Web API Error Handling

```aura
class ApiController {
    def handle_request(self, request: Request) -> Response {
        try {
            // Validate request
            let validated = self.validate_request(request)?
            
            // Authenticate
            let user = self.authenticate(validated)?
            
            // Authorize
            self.check_permissions(user, validated)?
            
            // Process
            let result = self.process(validated, user)?
            
            return Response(
                status=200,
                body=result.to_json()
            )
        } catch ValidationError as e {
            return Response(
                status=400,
                body={
                    "error": "Validation Failed",
                    "details": e.errors
                }
            )
        } catch AuthenticationError {
            return Response(
                status=401,
                body={"error": "Unauthorized"}
            )
        } catch PermissionError {
            return Response(
                status=403,
                body={"error": "Forbidden"}
            )
        } catch DatabaseError as e {
            logging.error(f"Database error: {e}")
            return Response(
                status=503,
                body={"error": "Service Unavailable"}
            )
        } catch {
            logging.error("Unexpected error", exc_info=true)
            return Response(
                status=500,
                body={"error": "Internal Server Error"}
            )
        }
    }
}
```

### 16.2 Database Transaction Error Handling

```aura
async def transfer_funds(
    from_account: int,
    to_account: int,
    amount: float
) -> Result<Transaction, str> {
    let mut transaction = null
    
    try {
        // Begin transaction
        transaction = await db.begin_transaction()
        
        // Check balance
        let balance = await transaction.get_balance(from_account)
        if balance < amount {
            await transaction.rollback()
            return Err("Insufficient funds")
        }
        
        // Debit
        await transaction.update_balance(from_account, -amount)
        
        // Credit
        await transaction.update_balance(to_account, amount)
        
        // Create record
        let record = await transaction.create_transaction_record(
            from_account, to_account, amount
        )
        
        // Commit
        await transaction.commit()
        
        return Ok(record)
        
    } catch DatabaseError as e {
        if transaction != null {
            await transaction.rollback()
        }
        logging.error(f"Transaction failed: {e}")
        return Err("Transaction failed, please try again")
    } catch {
        if transaction != null {
            await transaction.rollback()
        }
        return Err("Unexpected error occurred")
    }
}
```

### 16.3 File Processing with Error Recovery

```aura
def process_files(directory: str) -> ProcessingReport {
    let report = ProcessingReport()
    
    for filename in list_files(directory) {
        match process_single_file(filename) {
            case Ok(result) {
                report.add_success(filename, result)
            }
            case Err(error) {
                report.add_failure(filename, error)
                
                // Try to recover
                match attempt_recovery(filename, error) {
                    case Ok(recovered) {
                        report.add_recovered(filename, recovered)
                    }
                    case Err(_) {
                        // Move to failed directory
                        move_to_failed(filename)
                    }
                }
            }
        }
    }
    
    return report
}

def process_single_file(filename: str) -> Result<Data, str> {
    return read_file(filename)
        .and_then(validate_format)
        .and_then(parse_content)
        .and_then(transform_data)
        .and_then(save_to_database)
}
```

---

## 17. Conclusion

Error handling in Aura is designed to be:

- **Explicit**: Errors are visible in type signatures
- **Flexible**: Multiple approaches for different scenarios
- **Safe**: Compile-time checks prevent common mistakes
- **Ergonomic**: Convenient operators and combinators
- **Performant**: Efficient for both expected and unexpected errors

### Key Takeaways

1. **Choose the right tool**: Exception, Result, or Option based on the scenario
2. **Make errors visible**: Use type signatures to document possible errors
3. **Provide context**: Include helpful error messages and context
4. **Handle errors close to source**: Deal with errors where you have the most information
5. **Fail fast**: Validate early, propagate errors clearly
6. **Test error paths**: Ensure error handling works correctly
7. **Monitor and log**: Track errors in production
8. **Recover gracefully**: Have fallback strategies

By following these principles and using Aura's error handling features effectively, you can build robust, maintainable applications that handle errors elegantly and provide great user experiences even when things go wrong.

---

**End of Error Handling and Diagnostics Guide**

For more information:
- [Aura Documentation](https://aura-lang.org/docs)
- [API Reference](https://aura-lang.org/api)
- [Community Forums](https://community.aura-lang.org)
- [GitHub Issues](https://github.com/aura-lang/aura/issues)ing
match safe_divide(10, 2) {
    case Ok(value) {
        print(f"Result: {value}")
    }
    case Err(error) {
        print(f"Error: {error}")
    }
}

// With destructuring
match advanced_divide(10, 0) {
    case Ok(value) {
        print(f"Success: {value}")
    }
    case Err(MathError.DivisionByZero) {
        print("Cannot divide by zero")
    }
    case Err(MathError.InvalidInput(msg)) {
        print(f"Invalid input: {msg}")
    }
    case Err(MathError.Overflow) {
        print("Result would overflow")
    }
}

// Nested Results
match fetch_and_parse() {
    case Ok(Ok(data)) {
        process(data)
    }
    case Ok(Err(parse_error)) {
        print(f"Parse error: {parse_error}")
    }
    case Err(fetch_error) {
        print(f"Fetch error: {fetch_error}")
    }
}
```

### 3.3 Result Combinators

```aura
let result: Result<int, str> = Ok(42)

// map - Transform success value
let doubled = result.map((x) => x * 2)  // Ok(84)

// map_err - Transform error value
let formatted_error = result.map_err((e) => f"ERROR: {e}")

// and_then (flatMap) - Chain operations
def parse_int(s: str) -> Result<int, str>
def validate_positive(n: int) -> Result<int, str>

let result = parse_int("42")
    .and_then(validate_positive)
    .and_then((n) => Ok(n * 2))

// or - Provide alternative Result
let result = fetch_from_cache()
    .or(fetch_from_database())
    .or(fetch_from_api())

// unwrap_or - Extract value with default
let value = result.unwrap_or(0)

// unwrap_or_else - Extract value with computed default
let value = result.unwrap_or_else(() => compute_default())

// Checking state
if result.is_ok() {
    print("Operation succeeded")
}

if result.is_err() {
    print("Operation failed")
}

// expect - Unwrap with custom panic message
let value = result.expect("Failed to parse value")
```

### 3.4 Error Propagation with ?

```aura
// The ? operator propagates errors automatically
def read_and_process(path: str) -> Result<Data, Error> {
    // If read_file returns Err, function returns early with that error
    let content = read_file(path)?
    
    // If parse returns Err, function returns early
    let parsed = parse(content)?
    
    // If validate returns Err, function returns early
    let validated = validate(parsed)?
    
    // All succeeded, return transformed data
    return Ok(transform(validated))
}

// Equivalent to:
def read_and_process_verbose(path: str) -> Result<Data, Error> {
    match read_file(path) {
        case Ok(content) {
            match parse(content) {
                case Ok(parsed) {
                    match validate(parsed) {
                        case Ok(validated) {
                            return Ok(transform(validated))
                        }
                        case Err(e) { return Err(e) }
                    }
                }
                case Err(e) { return Err(e) }
            }
        }
        case Err(e) { return Err(e) }
    }
}

// Works in any context that returns Result
async def fetch_user_data(id: int) -> Result<UserData, ApiError> {
    let user = await fetch_user(id)?
    let posts = await fetch_posts(user.id)?
    let comments = await fetch_comments(user.id)?
    
    return Ok(UserData(user, posts, comments))
}
```

### 3.5 Converting Between Result and Exception

```aura
// Convert Result to Exception
def divide_or_throw(a: float, b: float) -> float {
    match safe_divide(a, b) {
        case Ok(value) { return value }
        case Err(msg) { raise ValueError(msg) }
    }
}

// Convert Exception to Result
def safe_operation() -> Result<Data, str> {
    try {
        let data = risky_operation()
        return Ok(data)
    } catch ValueError as e {
        return Err(f"Value error: {e}")
    } catch IOError as e {
        return Err(f"I/O error: {e}")
    } catch {
        return Err("Unknown error occurred")
    }
}

// Helper function for conversion
def to_result<T>(fn: () -> T) -> Result<T, str> {
    try {
        return Ok(fn())
    } catch Exception as e {
        return Err(str(e))
    }
}

// Usage
let result = to_result(() => int("42"))
```

---

## 4. Option-Based Error Handling

### 4.1 Option Type Definition

```aura
// Built-in Option type
type Option<T> = Some(T) | None

// Creating Options
def find_user(id: int) -> Option<User> {
    let user = database.query("SELECT * FROM users WHERE id = ?", id)
    return Some(user) if user else None
}

def get_config_value(key: str) -> Option<str> {
    if key in config {
        return Some(config[key])
    }
    return None
}
```

### 4.2 Pattern Matching on Options

```aura
// Basic matching
match find_user(123) {
    case Some(user) {
        print(f"Found user: {user.name}")
    }
    case None {
        print("User not found")
    }
}

// Guard clauses with Option
def process_user(user_id: int) {
    guard let Some(user) = find_user(user_id) else {
        print("User not found")
        return
    }
    
    // user is available and unwrapped here
    print(f"Processing {user.name}")
}

// If-let syntax
if let Some(user) = find_user(123) {
    print(f"Found: {user.name}")
} else {
    print("Not found")
}
```

### 4.3 Option Combinators

```aura
let option: Option<int> = Some(42)

// map - Transform the value inside Some
let doubled = option.map((x) => x * 2)  // Some(84)

// and_then (flatMap) - Chain optional operations
let result = get_user_id()
    .and_then(find_user)
    .and_then((user) => get_email(user))

// filter - Keep Some only if predicate is true
let even = Some(42).filter((x) => x % 2 == 0)  // Some(42)
let odd = Some(43).filter((x) => x % 2 == 0)   // None

// or - Provide alternative Option
let result = find_in_cache(key)
    .or(find_in_database(key))
    .or(Some(default_value))

// unwrap_or - Extract value with default
let value = option.unwrap_or(0)

// unwrap_or_else - Extract value with computed default
let value = option.unwrap_or_else(() => expensive_default())

// Checking state
if option.is_some() {
    print("Has value")
}

if option.is_none() {
    print("No value")
}

// expect - Unwrap with custom panic message
let value = option.expect("Expected value to be present")
```

### 4.4 Null-Safe Operators

```aura
// Null-safe navigation operator ?.
let user: User? = get_user()
let name = user?.name  // Returns Option<str>
let email = user?.profile?.email  // Chains safely

// Null coalescing operator ??
let display_name = user?.name ?? "Anonymous"
let port = config?.port ?? 8080

// Safe indexing
let value = list?[index]  // Returns None if index out of bounds
let item = dict?["key"]   // Returns None if key doesn't exist

// Null coalescing assignment
let mut name: str? = null
name ??= "Default"  // Assigns only if name is null

// Combining operators
let city = user?.address?.city?.name ?? "Unknown"
let count = cache?["count"] ?? 0
```

### 4.5 Converting Between Option and Result

```aura
// Option to Result
let option: Option<int> = Some(42)
let result: Result<int, str> = option.ok_or("Value not found")

match result {
    case Ok(value) { print(value) }
    case Err(msg) { print(msg) }
}

// Result to Option
let result: Result<int, str> = Ok(42)
let option: Option<int> = result.ok()  // Discards error

match option {
    case Some(value) { print(value) }
    case None { print("No value") }
}

// Practical example
def get_user_email(id: int) -> Result<str, str> {
    find_user(id)
        .and_then((user) => user.email)
        .ok_or("User or email not found")
}
```

---

## 5. Compile-Time Errors

### 5.1 Syntax Errors

```aura
// Missing closing brace
def example() {
    print("Hello"
}  // ERROR: Expected '}' to close function body

// Invalid syntax
let x = 10 +  // ERROR: Unexpected end of expression

// Incorrect operator
let result = 10 ** "2"  // ERROR: Cannot use ** with string

// Missing colons in dict
let data = {
    "name" "Alice"  // ERROR: Expected ':' in dictionary literal
}
```

**Error Message Example:**
```
Error: Syntax error at line 3, column 5
  |
3 | }  
  |    ^ Expected '}' to close function body
  |
Note: Function started at line 1
```

### 5.2 Type Errors

```aura
// Type mismatch
let x: int = "hello"  
// ERROR: Cannot assign str to int

// Invalid operation
let result = 10 + "20"
// ERROR: Cannot add int and str

// Incorrect function argument
def greet(name: str) {
    print(f"Hello, {name}")
}

greet(42)
// ERROR: Expected str, got int

// Return type mismatch
def get_number() -> int {
    return "42"
}
// ERROR: Cannot return str from function with return type int
```

**Error Message Example:**
```
Error: Type mismatch at line 5, column 7
  |
5 | greet(42)
  |       ^^ Expected type 'str', but found 'int'
  |
Note: Function 'greet' is defined at line 1
  Parameter 'name' expects type 'str'
```

### 5.3 Name Resolution Errors

```aura
// Undefined variable
print(undefined_var)
// ERROR: Name 'undefined_var' is not defined

// Out of scope
if true {
    let x = 10
}
print(x)  
// ERROR: Name 'x' is not in scope

// Shadowing in same scope (warning or error depending on settings)
let x = 10
let x = 20  
// WARNING: Variable 'x' shadows previous declaration

// Import errors
import non_existent_module
// ERROR: Module 'non_existent_module' not found

from math import non_existent_function
// ERROR: Cannot import 'non_existent_function' from module 'math'
```

### 5.4 Mutability Errors

```aura
// Attempting to modify immutable variable
let x = 10
x = 20
// ERROR: Cannot assign to immutable variable 'x'

// Modifying const
const PI = 3.14159
PI = 3.14
// ERROR: Cannot assign to constant 'PI'

// Solution: use mut
let mut y = 10
y = 20  // OK

// Immutable dataclass
@dataclass(frozen=true)
class Point {
    x: float
    y: float
}

let p = Point(10.0, 20.0)
p.x = 15.0
// ERROR: Cannot assign to field of frozen dataclass
```

### 5.5 Null Safety Errors

```aura
// Using nullable value without checking
let user: User? = get_user()
print(user.name)
// ERROR: Cannot access field 'name' on nullable type 'User?'

// Solution: use null-safe operator
print(user?.name)  // OK: Returns str?

// Or check for null
if user != null {
    print(user.name)  // OK: Type narrowed to User
}

// Guard clause
guard user != null else {
    return
}
print(user.name)  // OK: user is known to be non-null
```

### 5.6 Pattern Matching Errors

```aura
// Non-exhaustive match
match value {
    case 1 { print("One") }
    case 2 { print("Two") }
}
// ERROR: Non-exhaustive pattern match
// Missing cases for other int values

// Solution: add wildcard
match value {
    case 1 { print("One") }
    case 2 { print("Two") }
    case _ { print("Other") }
}  // OK

// Unreachable pattern
match value {
    case _ { print("Anything") }
    case 1 { print("One") }
}
// WARNING: Unreachable pattern - wildcard matches everything
```

---

## 6. Runtime Errors

### 6.1 Common Runtime Errors

```aura
// Division by zero
let result = 10 / 0
// RuntimeError: Division by zero

// Index out of bounds
let list = [1, 2, 3]
let item = list[10]
// IndexError: List index out of range

// Key not found
let dict = {"a": 1}
let value = dict["b"]
// KeyError: Key 'b' not found

// Attribute error
let obj = SomeObject()
obj.non_existent_method()
// AttributeError: 'SomeObject' has no attribute 'non_existent_method'

// Type error at runtime (when using 'any')
let value: any = "hello"
value + 10
// TypeError: Cannot add str and int
```

### 6.2 Assertion Failures

```aura
def calculate_average(numbers: list[float]) -> float {
    assert len(numbers) > 0, "Cannot calculate average of empty list"
    return sum(numbers) / len(numbers)
}

calculate_average([])
// AssertionError: Cannot calculate average of empty list
```

### 6.3 Stack Overflow

```aura
// Infinite recursion
def infinite_loop(n: int) -> int {
    return infinite_loop(n + 1)
}

infinite_loop(0)
// RuntimeError: Maximum recursion depth exceeded

// Solution: add base case
def safe_recursion(n: int) -> int {
    if n <= 0 {
        return 0
    }
    return n + safe_recursion(n - 1)
}
```

### 6.4 Memory Errors

```aura
// Out of memory (creating huge data structure)
let huge_list = [0] * 10**10
// MemoryError: Cannot allocate memory

// Use generators for large sequences
let huge_gen = (i for i in range(10**10))
// OK: Generator doesn't allocate all at once
```

---

## 7. Warnings and Lints

### 7.1 Compiler Warnings

```aura
// Unused variable
let unused = 10
// WARNING: Variable 'unused' is declared but never used

// Unreachable code
def example() {
    return 42
    print("This will never execute")
}
// WARNING: Unreachable code detected

// Unused import
import math
// WARNING: Imported module 'math' is never used

// Dead code in match
match value {
    case 1 { print("One") }
    case _ { print("Other") }
    case 2 { print("Two") }
}
// WARNING: Pattern is unreachable (shadowed by wildcard)
```

### 7.2 Lint Warnings

```aura
// aura lint main.aura

// Naming conventions
let MyVariable = 10
// LINT: Variable names should use snake_case, not PascalCase

class my_class {
}
// LINT: Class names should use PascalCase, not snake_case

// Complexity warnings
def complex_function(a, b, c, d, e, f, g, h) {
    // ... 200 lines of code
}
// LINT: Function is too complex (cyclomatic complexity: 25)
// LINT: Function has too many parameters (8 > 5)
// LINT: Function is too long (200 lines > 50)

// Code smell
if condition == true {
}
// LINT: Redundant comparison to boolean literal

let result = [] if items else []
// LINT: Both branches return the same value

// Performance warning
for i in range(len(list)) {
    print(list[i])
}
// LINT: Use 'for item in list' instead of indexing

// Security warning
password = "hardcoded123"
// LINT: Possible hardcoded password detected
```

### 7.3 Deprecation Warnings

```aura
@deprecated("Use new_function() instead")
def old_function() {
    // Implementation
}

old_function()
// WARNING: Call to deprecated function 'old_function'
// Use new_function() instead

@deprecated(since="2.0.0", remove_in="3.0.0")
class LegacyClass {
}

let obj = LegacyClass()
// WARNING: LegacyClass is deprecated since version 2.0.0
// Will be removed in version 3.0.0
```

### 7.4 Configuration

```toml
# aura.toml
[linting]
max_line_length = 100
max_function_length = 50
max_complexity = 10
max_parameters = 5

[warnings]
unused_variables = "error"    # Treat as error
unreachable_code = "warn"     # Show warning
unused_imports = "ignore"     # Suppress

[style]
naming_convention = "strict"
require_type_hints = true
```

---

## 8. Error Recovery Patterns

### 8.1 Retry Pattern

```aura
def retry<T, E>(
    operation: () -> Result<T, E>,
    max_attempts: int = 3,
    delay: float = 1.0
) -> Result<T, E> {
    let mut attempts = 0
    
    loop {
        attempts += 1
        
        match operation() {
            case Ok(value) {
                return Ok(value)
            }
            case Err(error) {
                if attempts >= max_attempts {
                    return Err(error)
                }
                
                print(f"Attempt {attempts} failed, retrying...")
                sleep(delay)
            }
        }
    }
}

// Usage
let result = retry(
    () => fetch_from_api(),
    max_attempts=5,
    delay=2.0
)
```

### 8.2 Fallback Pattern

```aura
def get_data_with_fallback() -> Data {
    return fetch_from_cache()
        .or(fetch_from_database())
        .or(fetch_from_api())
        .unwrap_or(default_data())
}

// With error accumulation
def get_data_verbose() -> Result<Data, list[str]> {
    let mut errors = []
    
    match fetch_from_cache() {
        case Ok(data) { return Ok(data) }
        case Err(e) { errors.append(f"Cache: {e}") }
    }
    
    match fetch_from_database() {
        case Ok(data) { return Ok(data) }
        case Err(e) { errors.append(f"Database: {e}") }
    }
    
    match fetch_from_api() {
        case Ok(data) { return Ok(data) }
        case Err(e) { errors.append(f"API: {e}") }
    }
    
    return Err(errors)
}
```

### 8.3 Circuit Breaker Pattern

```aura
class CircuitBreaker {
    failure_threshold: int
    reset_timeout: float
    failure_count: int = 0
    state: "closed" | "open" | "half_open" = "closed"
    last_failure_time: float? = null
    
    def call<T>(self, operation: () -> Result<T, str>) -> Result<T, str> {
        if self.state == "open" {
            if time.time() - self.last_failure_time > self.reset_timeout {
                self.state = "half_open"
            } else {
                return Err("Circuit breaker is open")
            }
        }
        
        match operation() {
            case Ok(value) {
                self.reset()
                return Ok(value)
            }
            case Err(error) {
                self.record_failure()
                return Err(error)
            }
        }
    }
    
    def record_failure(self) {
        self.failure_count += 1
        self.last_failure_time = time.time()
        
        if self.failure_count >= self.failure_threshold {
            self.state = "open"
        }
    }
    
    def reset(self) {
        self.failure_count = 0
        self.state = "closed"
    }
}

// Usage
let breaker = CircuitBreaker(failure_threshold=3, reset_timeout=60.0)

let result = breaker.call(() => fetch_from_api())
```

### 8.4 Timeout Pattern

```aura
async def with_timeout<T>(
    operation: async () -> T,
    timeout_seconds: float
) -> Result<T, str> {
    try {
        let result = await asyncio.wait_for(operation(), timeout_seconds)
        return Ok(result)
    } catch asyncio.TimeoutError {
        return Err(f"Operation timed out after {timeout_seconds}s")
    }
}

// Usage
let result = await with_timeout(
    async () => fetch_data(),
    timeout_seconds=5.0
)

match
```