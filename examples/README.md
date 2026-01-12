# The Zen of Aura

*Explicit is better than implicit.*
*Simple is better than complex.*
*There should be one-- and preferably only one --obvious way to do it.*

Aura adheres to strict syntactic standards to ensure readability and maintainability.

## Standard Syntax

### Functions
Use `def` to define functions. `fn` is deprecated.

```aura
public def add(a: int, b: int) {
    return a + b
}
```

### Control Flow
Use `if`, `while`, and `match`.
Deprecated: `unless`, `until`, `loop`, `guard`.

```aura
// Correct
if !condition { ... }
while condition { ... }

// Incorrect (Deprecated)
// unless condition { ... }
// until !condition { ... }
```

### Pattern Matching
Use `match` for branching on values.

```aura
match value {
    case 1 { print("One") }
    case _ { print("Other") }
}
```

## Testing Philosophy
We verify Aura's correctness using a massive stochastic test suite (500,000+ tests) that generates structurally diverse code adhering to these principles.
