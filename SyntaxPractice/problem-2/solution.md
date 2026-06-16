# Solution

## Approach

1. Validate input.
2. Create two collections:

   * Strings
   * Numbers
3. Iterate through each token.
4. Determine whether the token contains only digits.
5. If numeric:

   * Convert to Integer
   * Add to Numbers collection
6. Otherwise:

   * Add to Strings collection
7. Return the result.

---

## Design

### Models

  * SeparationRequest - Stores the input tokens.

  * SeparationResult - Stores the separated output.

---

### Service

#### TokenSeparationService

Responsibilities:

* Validate input
* Separate tokens
* Convert numeric strings to integers
* Preserve insertion order
* Return SeparationResult

---

### Exception

#### InputValidationException

Thrown when:

* Input is null
* Input is empty

---

### Logging

Responsibilities:

* Log processing start
* Log processing completion
* Log validation failures

---

## Algorithm

```text
Validate input

Initialize:
    strings = []
    numbers = []

For each token:

    If token is numeric:
        numbers.add(Integer.parseInt(token))
    Else:
        strings.add(token)

Return SeparationResult
```

---

## Time Complexity

```text
O(n × m)
```

Where:

* n = number of tokens
* m = average token length

---

## Space Complexity

```text
O(n)
```

