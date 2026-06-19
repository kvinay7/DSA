# Solution

## Problem Statement
Read n integers, print sum and average.

## Approach
1. Validate input (n > 0, all integers)
2. Calculate sum in single pass
3. Calculate average = sum / n
4. Print result with exact format

## Key Code Pattern
```java
int sum = 0;
for(int num : arr) {
    sum += num;
}
double avg = (double) sum / n;  // Avoid integer division
System.out.println(sum + " " + avg);
```

## Design
```
Main.java
  ↓
Service.java (business logic)
  ↓
Model.java (data structure)
Exception Handling → InputValidationException
Logging → Logger.java
```

## Complexity
- **Time:** O(n) — single pass
- **Space:** O(1) — only variables

## Edge Cases
- n = 0 → throw InputValidationException
- n = 1 → avg = sum
- Negative integers → allowed (test with -5, 10, 3)
- Integer overflow → use long if needed
- Floating point precision → print with 2 decimals

