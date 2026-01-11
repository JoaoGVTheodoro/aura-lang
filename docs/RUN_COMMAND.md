# Aura Run Command Guide

## Overview

The `aura run` command allows you to execute Aura programs directly without manually transpiling to Python first.

## Installation

The `aura` command is already available in the project root:

```bash
cd /Volumes/SSD_240G/blueprints/aura
```

## Basic Usage

### Method 1: Using main.py (Universal)
```bash
python3 main.py run <file.aura>
```

### Method 2: Using aura script (Shorter)
```bash
./aura run <file.aura>
```

## Examples

### Run Hello World
```bash
python3 main.py run examples/hello.aura
```
Output:
```
Hello, Aura World!
```

### Run with Verbose Output (see generated Python)
```bash
python3 main.py run examples/fibonacci.aura -v
```

This shows the transpiled Python code that gets executed:
```python
# Generated Python code:
# 1 | fib = lambda n: n if n <= 1 else fib(n-1) + fib(n-2)
# ...
```

### Run Any .aura File
```bash
python3 main.py run path/to/your/program.aura
python3 main.py run examples/list_ops.aura
python3 main.py run examples/prime_checker.aura
```

## Command Options

### `-v, --verbose`
Display the generated Python code before execution.

```bash
python3 main.py run examples/hello.aura -v
```

Useful for:
- Debugging transpilation issues
- Understanding how Aura translates to Python
- Learning how the transpiler works

## Exit Codes

- **0**: Success
- **1**: Runtime error (exception during execution)
- **2**: Compilation error (parsing or transpilation failed)

## Creating and Running Your Own Programs

### Step 1: Create a .aura file
```bash
cat > examples/my_program.aura << 'EOF'
// My first Aura program
let name = "Aura";
print("Hello from ");
print(name);
EOF
```

### Step 2: Run it
```bash
python3 main.py run examples/my_program.aura
```

## Workflow Example

### Development Cycle
1. Edit your `.aura` file in your editor
2. Run it with `python3 main.py run file.aura`
3. See output immediately
4. Make changes and repeat

### Debugging
If you encounter an error:
1. Run with `-v` to see generated Python: `python3 main.py run file.aura -v`
2. Check the error message
3. Compare your Aura code with working examples
4. Fix and re-run

## Common Patterns

### Print Output
```aura
print("Hello");
print(42);
print([1, 2, 3]);
```

### Loops
```aura
for i in 1..10 {
    print(i);
}
```

### Conditionals
```aura
if x > 0 {
    print("positive");
} else {
    print("non-positive");
}
```

### Lists
```aura
let items = [1, 2, 3];
for item in items {
    print(item);
}
```

### Dictionaries
```aura
let person = {"name": "Alice", "age": 30};
print(person["name"]);
```

## Tips & Tricks

### Quick Testing
Run small snippets by creating temporary `.aura` files:
```bash
echo 'print("test");' > /tmp/test.aura
python3 main.py run /tmp/test.aura
```

### Build Scripts
Create helper scripts to run multiple examples:
```bash
#!/bin/bash
echo "=== Example 1: Hello ==="
python3 main.py run examples/hello.aura

echo -e "\n=== Example 2: Sum ==="
python3 main.py run examples/sum_average.aura

echo -e "\n=== Example 3: Primes ==="
python3 main.py run examples/prime_checker.aura
```

### Integration with Other Tools
You can pipe Aura programs into other commands:
```bash
# Count lines in generated Python code
python3 main.py run examples/hello.aura -v 2>&1 | wc -l

# Search for specific patterns in output
python3 main.py run examples/list_ops.aura | grep "Doubled"
```

## Limitations & Known Issues

### Recursion
Direct function calls (recursion) may not work properly in some cases. Use iterative approaches instead:

❌ **Don't use:**
```aura
def factorial(n: int) -> int {
    if n <= 1 { return 1; }
    return n * factorial(n - 1);
}
```

✅ **Use instead:**
```aura
let result = 1;
for i in 1..n {
    result = result * i;
}
```

### Input/Output
The current version doesn't support user input. Use hardcoded values instead.

## Related Commands

### Transpile (output to file)
```bash
python3 main.py transpile examples/hello.aura -o /tmp/hello.py
python3 /tmp/hello.py
```

### Type Check
```bash
python3 main.py check examples/hello.aura
```

### Format Code
```bash
python3 main.py format examples/hello.aura
```

### Lint Code
```bash
python3 main.py lint examples/hello.aura
```

## Getting Help

```bash
python3 main.py run --help
python3 main.py --help
```

## Next Steps

1. Explore the [examples directory](./examples/README.md)
2. Try modifying existing examples
3. Create your own programs
4. Check the [Aura Language Guide](../LANGUAGE_GUIDE.md) for syntax reference

Happy coding! 🚀
