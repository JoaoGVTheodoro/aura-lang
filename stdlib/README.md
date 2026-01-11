# Aura Standard Library

The Aura Standard Library provides core functionality for common programming tasks.

## Modules

### collections

Provides list, dict, and set utilities.

```aura
import collections

// List operations
let numbers = [1, 2, 3, 4, 5]
let doubled = collections.list_map(fn(x) { x * 2 }, numbers)    // [2, 4, 6, 8, 10]
let even = collections.list_filter(fn(x) { x % 2 == 0 }, numbers)  // [2, 4]
let sum = collections.list_reduce(fn(a, b) { a + b }, numbers, 0)  // 15

// Dictionary operations
let user = {name: "Alice", age: 30}
let age = collections.dict_get(user, "age", 0)  // 30
let keys = collections.dict_keys(user)           // ["name", "age"]

// Set operations
let a = {1, 2, 3}
let b = {2, 3, 4}
let union = collections.set_union(a, b)         // {1, 2, 3, 4}
let inter = collections.set_intersection(a, b)  // {2, 3}
```

**Functions:**
- `list_map(fn, items)` - Map function over list
- `list_filter(predicate, items)` - Filter list
- `list_reduce(fn, items, initial)` - Reduce to single value
- `list_find(predicate, items)` - Find first match
- `list_any(predicate, items)` - Check if any match
- `list_all(predicate, items)` - Check if all match
- `list_take(n, items)` - Take first n items
- `list_drop(n, items)` - Drop first n items
- `list_zip(*iterables)` - Zip lists
- `list_flatten(items)` - Flatten nested lists
- `list_unique(items)` - Get unique items
- `list_sort(items, key, reverse)` - Sort list
- `list_reverse(items)` - Reverse list
- `list_chunk(n, items)` - Split into chunks
- `dict_get(d, key, default)` - Get with default
- `dict_keys(d)` - Get all keys
- `dict_values(d)` - Get all values
- `dict_items(d)` - Get key-value pairs
- `dict_merge(*dicts)` - Merge dicts
- `dict_filter(predicate, d)` - Filter dict
- `dict_map(fn, d)` - Map over values
- `set_union(*sets)` - Union of sets
- `set_intersection(*sets)` - Intersection
- `set_difference(a, *rest)` - Difference

### itertools

Provides iterator and sequence utilities.

```aura
import itertools

// Create ranges
for i in itertools.range_iter(0, 10) {
    print(i)
}

// Combinations and permutations
let items = [1, 2, 3]
let combos = itertools.combinations(items, 2)    // [[1,2], [1,3], [2,3]]
let perms = itertools.permutations(items, 2)     // [[1,2], [1,3], [2,1], ...]

// Chain iterables
let combined = itertools.chain([1,2], [3,4], [5,6])  // [1, 2, 3, 4, 5, 6]

// Grouping
let grouped = itertools.groupby([1,1,2,2,3])    // {1: [1,1], 2: [2,2], 3: [3]}
```

**Functions:**
- `range_iter(start, end, step)` - Create range
- `cycle(iterable)` - Cycle indefinitely
- `repeat(value, times)` - Repeat value
- `chain(*iterables)` - Chain together
- `combinations(iterable, r)` - Combinations
- `permutations(iterable, r)` - Permutations
- `product(*iterables, repeat)` - Cartesian product
- `count(start, step)` - Infinite counter
- `enumerate_iter(iterable, start)` - Enumerate
- `islice(iterable, *args)` - Slice iterator
- `takewhile(predicate, iterable)` - Take while true
- `dropwhile(predicate, iterable)` - Drop while true
- `groupby(iterable, key)` - Group by key
- `filterfalse(predicate, iterable)` - Keep false
- `starmap(fn, iterable)` - Apply to tuples
- `tee(iterable, n)` - Create n copies
- `zip_longest(*iterables, fillvalue)` - Zip with fill
- `pairwise(iterable)` - Consecutive pairs

### math

Provides mathematical functions and constants.

```aura
import math

// Constants
print(math.PI)     // 3.14159...
print(math.E)      // 2.71828...
print(math.TAU)    // 6.28318...

// Basic operations
let root = math.sqrt(16)    // 4.0
let power = math.pow(2, 8)  // 256.0
let logged = math.log(10)   // 2.302...

// Trigonometry (radians)
let angle = math.radians(90)
let sine = math.sin(angle)      // 1.0
let cosine = math.cos(angle)    // 0.0

// Combinatorics
let combinations = math.comb(10, 3)      // 120
let permutations = math.perm(10, 3)      // 720
let fact = math.factorial(5)              // 120
```

**Constants:**
- `PI` - Pi
- `E` - Euler's number
- `TAU` - 2*Pi
- `INF` - Infinity
- `NAN` - Not a number

**Functions:**
- `sqrt(x)` - Square root
- `pow(x, y)` - Power
- `exp(x)` - e^x
- `log(x, base)` - Logarithm
- `log10(x)` - Base 10 log
- `log2(x)` - Base 2 log
- `sin(x)`, `cos(x)`, `tan(x)` - Trigonometry
- `asin(x)`, `acos(x)`, `atan(x)` - Inverse trig
- `sinh(x)`, `cosh(x)`, `tanh(x)` - Hyperbolic
- `degrees(x)`, `radians(x)` - Angle conversion
- `floor(x)`, `ceil(x)` - Rounding
- `round(x, ndigits)` - Round
- `abs(x)`, `min(*vals)`, `max(*vals)` - Comparison
- `gcd(*numbers)` - Greatest common divisor
- `lcm(*numbers)` - Least common multiple
- `factorial(n)` - Factorial
- `comb(n, k)` - Combinations
- `perm(n, k)` - Permutations
- `is_finite(x)`, `is_infinite(x)`, `is_nan(x)` - Checks

### string

Provides string manipulation functions.

```aura
import string

// Case conversion
let upper = string.upper("hello")        // "HELLO"
let lower = string.lower("HELLO")        // "hello"
let title = string.title("hello world")  // "Hello World"

// Trimming and padding
let trimmed = string.trim("  hello  ")   // "hello"
let padded = string.pad_right("hi", 5, '-')  // "hi---"

// Splitting and joining
let parts = string.split("a,b,c", ",")  // ["a", "b", "c"]
let joined = string.join(["a", "b", "c"], "-")  // "a-b-c"

// Searching
if string.starts_with("hello", "he") {
    print("Starts with 'he'")
}

let index = string.index_of("hello", "ll")  // 2

// Replacement
let replaced = string.replace("hello", "l", "L")  // "heLLo"
```

**Functions:**
- `upper(s)` - Uppercase
- `lower(s)` - Lowercase
- `title(s)` - Title case
- `capitalize(s)` - Capitalize first char
- `reverse(s)` - Reverse
- `trim(s)` - Remove whitespace
- `trim_left(s)` - Remove left whitespace
- `trim_right(s)` - Remove right whitespace
- `pad_left(s, length, char)` - Pad left
- `pad_right(s, length, char)` - Pad right
- `pad(s, length, char)` - Pad both sides
- `repeat_string(s, times)` - Repeat
- `split(s, separator, limit)` - Split
- `join(strings, separator)` - Join
- `starts_with(s, prefix)` - Check prefix
- `ends_with(s, suffix)` - Check suffix
- `contains(s, substring)` - Check contains
- `index_of(s, substring)` - Find first
- `last_index_of(s, substring)` - Find last
- `replace(s, old, new, count)` - Replace
- `slice_string(s, start, end)` - Slice
- `substring(s, start, length)` - Substring
- `char_at(s, index)` - Get char
- `format_string(template, *args)` - Format
- `is_empty(s)` - Check empty
- `is_blank(s)` - Check blank
- `length(s)` - Get length
- `is_alpha(s)`, `is_alphanumeric(s)`, `is_digit(s)` - Checks
- `is_space(s)`, `is_lower(s)`, `is_upper(s)` - Checks
- `lines(s)` - Split into lines
- `unlines(lines)` - Join lines

## Using the Standard Library

### Import Specific Module

```aura
import collections
let doubled = collections.list_map(fn(x) { x * 2 }, [1, 2, 3])
```

### Import Specific Function

```aura
import collections { list_map, list_filter }
let doubled = list_map(fn(x) { x * 2 }, [1, 2, 3])
let even = list_filter(fn(x) { x % 2 == 0 }, doubled)
```

### Import Everything

```aura
import collections::*
let doubled = list_map(fn(x) { x * 2 }, [1, 2, 3])
```

## Examples

### Working with Lists

```aura
import collections { list_map, list_filter, list_reduce }

let numbers = [1, 2, 3, 4, 5]

// Chain operations
let result = numbers
    |> list_map(fn(x) { x * 2 })      // [2, 4, 6, 8, 10]
    |> list_filter(fn(x) { x > 4 })   // [6, 8, 10]
    |> list_reduce(fn(a,b) { a + b }, 0)  // 24
```

### String Processing

```aura
import string { split, map, join, upper }

let text = "hello world"
let words = split(text, " ")        // ["hello", "world"]
let upper_words = list_map(upper, words)  // ["HELLO", "WORLD"]
let result = join(upper_words, "-")  // "HELLO-WORLD"
```

### Mathematical Operations

```aura
import math { sqrt, pow, PI }

let radius = 5.0
let area = PI * pow(radius, 2)   // 78.54
let diagonal = sqrt(pow(5, 2) + pow(5, 2))  // 7.07
```

## Adding to stdlib

To add a new standard library module:

1. Create `stdlib/mymodule.py` with functions
2. Add to `stdlib/__init__.py` imports
3. Document in this README
4. Test with examples

## Performance Notes

- All collection functions are optimized for Pythonic idioms
- Generator-based functions return lists (not iterators) for compatibility
- Consider using `itertools` functions for large datasets
- String operations use native Python implementations

## Future Additions

Planned standard library modules:
- `json` - JSON parsing and serialization
- `time` - Date and time utilities
- `file` - File I/O
- `network` - HTTP and networking
- `crypto` - Cryptography utilities
- `database` - Database utilities
