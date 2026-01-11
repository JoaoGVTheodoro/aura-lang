# Aura Language Examples

Welcome to the Aura language example programs! These are simple programs demonstrating various features of Aura.

## Running Examples

To run any example, use the `aura run` command:

```bash
python3 main.py run examples/hello.aura
# or
./aura run examples/hello.aura
```

## Available Examples

### 1. **hello.aura** - Hello World
Classic "Hello, World!" program.
```bash
python3 main.py run examples/hello.aura
```
Output:
```
Hello, Aura World!
```

### 2. **sum_average.aura** - Sum & Average Calculator
Calculates sum and average of a list of numbers.
```bash
python3 main.py run examples/sum_average.aura
```
Output:
```
Numbers: 
[10, 20, 30, 40, 50]
Sum: 
150
Average: 
30.0
```

### 3. **list_ops.aura** - List Operations
Demonstrates filtering and transforming lists.
```bash
python3 main.py run examples/list_ops.aura
```
Features:
- Filtering even numbers
- Doubling values
- Appending to lists

### 4. **fibonacci.aura** - Fibonacci Sequence
Generates the first 10 Fibonacci numbers using iteration.
```bash
python3 main.py run examples/fibonacci.aura
```
Output:
```
Fibonacci sequence:
0
1
1
2
3
5
8
13
21
34
```

### 5. **factorial.aura** - Factorial Calculator
Calculates factorials of numbers 1-5.
```bash
python3 main.py run examples/factorial.aura
```
Output:
```
1
2
6
24
120
```

### 6. **prime_checker.aura** - Prime Number Checker
Finds all prime numbers between 1 and 30.
```bash
python3 main.py run examples/prime_checker.aura
```
Output:
```
Prime numbers between 1 and 30:
2
3
5
7
11
13
17
19
23
29
```

### 7. **dict_ops.aura** - Dictionary Operations
Demonstrates dictionary/map operations.
```bash
python3 main.py run examples/dict_ops.aura
```
Features:
- Creating dictionaries
- Accessing values by key
- Iterating over entries

### 8. **class_counter.aura** - Class Counter
Simple class-based example with state management.
```bash
python3 main.py run examples/class_counter.aura
```
Features:
- Class definition
- Methods
- State management
- Encapsulation

### 9. **guessing_game.aura** - Guessing Game
Interactive number guessing game logic.
```bash
python3 main.py run examples/guessing_game.aura
```
Features:
- Loops with conditions
- Guard statements
- Counter/attempt tracking

### 10. **pattern_matching.aura** - Pattern Matching
Demonstrates if/else, guard, and unless patterns.
```bash
python3 main.py run examples/pattern_matching.aura
```
Features:
- If/else conditionals
- Guard expressions
- Unless conditions

## Learning Path

If you're new to Aura, follow this order:

1. **hello.aura** - Start simple
2. **sum_average.aura** - Learn basic loops and arithmetic
3. **list_ops.aura** - Understand list operations
4. **pattern_matching.aura** - Learn control flow
5. **fibonacci.aura** - Practice iteration
6. **prime_checker.aura** - More complex logic
7. **dict_ops.aura** - Learn dictionaries
8. **class_counter.aura** - Introduction to OOP
9. **guessing_game.aura** - Practical game logic
10. **factorial.aura** - Advanced iteration

## Creating Your Own Examples

To create a new example:

1. Create a new `.aura` file in the `examples/` directory
2. Write your Aura code
3. Run it with: `python3 main.py run examples/your_file.aura`
4. Use `-v` flag to see generated Python code: `python3 main.py run examples/your_file.aura -v`

## Troubleshooting

### Common Issues

**Error: File not found**
- Make sure you're in the aura directory
- Check the file path is correct

**Syntax error in generated code**
- Use the `-v` flag to see the generated Python code
- Check your Aura syntax

**Runtime error**
- Review the error message and compare with example files
- Check for undefined variables or missing initialization

## Tips

- Use `print()` to debug your programs
- Test with simple examples first before trying complex logic
- Comment your code with `//` for documentation
- Use variable names that describe their purpose

Happy coding with Aura! 🚀
