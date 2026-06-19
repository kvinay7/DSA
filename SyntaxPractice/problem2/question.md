# Problem 2 — Separate Strings and Numbers

## Problem Statement

Given a list of tokens containing both strings and numeric values, separate them into two collections:

1. Strings Collection
2. Numbers Collection

Maintain the original order of appearance. A token is considered a number if all its characters are digits (`0-9`). If the input list is null or empty, throw an exception.

---

## Example 1

### Input

```text
["John", "25", "Alice", "30", "Bob", "40"]
```

### Output

```text
Strings = ["John", "Alice", "Bob"]

Numbers = [25, 30, 40]
```

---

## Example 2

### Input

```text
["100", "200", "300"]
```

### Output

```text
Strings = []

Numbers = [100, 200, 300]
```

---

## Example 3

### Input

```text
["Java", "Python", "Spring"]
```

### Output

```text
Strings = ["Java", "Python", "Spring"]

Numbers = []
```

---

## Example 4

### Input

```text
[]
```

### Output

```text
InputValidationException:
Input list cannot be empty
```

---

## Constraints

```text
1 <= n <= 100000

1 <= token.length <= 100
```

