# AEP-001: The Zen of Aura

*   **Author**: Aura Core Team
*   **Status**: Active
*   **Created**: 2026-01-11

## Abstract

This proposal establishes the "Zen of Aura" — a set of core principles and strict syntax rules designed to eliminate ambiguity and enforce a single, obvious way to write code.

## The Zen

1.  **Uniformity**: There should be one way to do it.
2.  **Clarity**: Explicit is better than implicit.
3.  **Simplicity**: Simple is better than complex.

## Strict Syntax Standards

### 1. Function Definition matches Python
*   **Correct**: `def foo() { ... }`
*   **Incorrect**: `fn foo() { ... }` (Removed)

### 2. Class Inheritance matches Python
Inheritance must use parentheses. The `extends` keyword and colon syntax are strictly forbidden.

*   **Correct**: `class Dog(Animal) { ... }`
*   **Incorrect**: `class Dog : Animal { ... }`
*   **Incorrect**: `class Dog extends Animal { ... }`

### 3. Generics use Square Brackets
To align with Python's type hinting and avoid parser ambiguity with comparison operators, generics use `[...]`.

*   **Correct**: `class Box[T] { ... }`
*   **Correct**: `def map[T, U](list: [T]) -> [U] { ... }`
*   **Incorrect**: `class Box<T> { ... }`

### 4. Explicit Modifiers
Visibility must be explicit or default to `public`.

*   `public` (Default)
*   `private` (Module-private or Class-private `__`)
*   `protected` (Family-private `_`)
*   `static` (Static method/property)

## Rationale

By removing `fn`, `extends`, `<>`, and alternative syntaxes, we reduce the cognitive load on the developer and simplify the parser. This aligns Aura closer to its host language (Python) while maintaining its own block-based identity.
