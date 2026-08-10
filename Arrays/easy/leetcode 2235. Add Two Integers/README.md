# 2235. Add Two Integers

## Difficulty

Easy

## Topic

- Math
- Basic Operations

---

## Problem Summary

Given two integers `num1` and `num2`, return their sum.

---

## Approach

- Take the two given integers.
- Use the `+` operator to calculate their sum.
- Return the result.

---

## Algorithm

1. Receive `num1` and `num2`.
2. Add `num1` and `num2`.
3. Return the result.

---

## Dry Run

### Input

```text
num1 = 12
num2 = 5
```

Calculation:

```text
12 + 5 = 17
```

### Output

```text
17
```

---

## Java Solution

```java
class Solution {
    public int sum(int num1, int num2) {
        return num1 + num2;
    }
}
```

---

## Time Complexity

**O(1)**

- Only one addition operation is performed.
- The execution time does not depend on the input values.

---

## Space Complexity

**O(1)**

- No additional data structure is created.
- Only the input variables are used.

---

## Optimal Solution

**Is the solution optimal?**

✅ Yes.

The current solution is already optimal because:

- Only one arithmetic operation is required.
- No loop is required.
- No additional data structure is required.

### Optimal Complexity

```text
Time Complexity: O(1)
Space Complexity: O(1)
```
