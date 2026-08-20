# 231. Power of Two

https://leetcode.com/problems/power-of-two/description/
## Difficulty

Easy

## Topic

- Math
- Number Manipulation
- Bit Manipulation

---

## Problem Summary

Given an integer `n`, determine whether `n` is a power of `2`.

A number is a power of two if it can be represented as:

```text
2^x
```

where `x` is a non-negative integer.

Examples:

```text
1  = 2^0
2  = 2^1
4  = 2^2
8  = 2^3
16 = 2^4
```

---

## Approach

- First check whether `n` is positive.
- Repeatedly divide `n` by `2` while it is exactly divisible by `2`.
- If the final value becomes `1`, then the original number is a power of `2`.
- Otherwise, it is not a power of `2`.

---

## Algorithm

1. If `n <= 0`, return `false`.
2. While `n` is divisible by `2`:
   - Divide `n` by `2`.
3. After the loop, check whether `n == 1`.
4. Return the result.

---

## Dry Run

### Input

```text
n = 16
```

Process:

```text
16 % 2 == 0
16 / 2 = 8

8 % 2 == 0
8 / 2 = 4

4 % 2 == 0
4 / 2 = 2

2 % 2 == 0
2 / 2 = 1
```

Now:

```text
n = 1
```

Therefore:

```text
Output = true
```

---

### Another Example

```text
n = 12
```

Process:

```text
12 / 2 = 6
6 / 2 = 3
```

Now:

```text
3 % 2 != 0
```

Loop stops.

```text
n = 3
```

Since:

```text
3 != 1
```

Output:

```text
false
```

---

## Java Solution

```java
class Solution {
    public boolean isPowerOfTwo(int n) {

        if (n <= 0)
            return false;

        while (n % 2 == 0)
            n /= 2;

        return n == 1;
    }
}
```

---

## Time Complexity

**O(log n)**

- Each iteration divides `n` by `2`.
- Therefore, the number of iterations is approximately `log₂(n)`.

```text
Time Complexity = O(log n)
```

---

## Space Complexity

**O(1)**

- Only the input variable `n` is modified.
- No additional array, list, or data structure is created.

```text
Space Complexity = O(1)
```

---

## Optimal Solution

**Is the current solution optimal?**

### For the iterative approach:

✅ Yes.

```text
Time Complexity: O(log n)
Space Complexity: O(1)
```

However, this problem has an even more efficient **bit manipulation** solution.

---

## Bit Manipulation Approach

A positive power of two has exactly **one `1` bit** in its binary representation.

Examples:

```text
1  → 0001
2  → 0010
4  → 0100
8  → 1000
16 → 10000
```

For a power of two:

```text
n & (n - 1) == 0
```

### Why?

Example:

```text
n = 8

8     = 1000
8 - 1 = 0111

1000
&
0111
----
0000
```

Therefore:

```text
8 & 7 == 0
```

### Optimized Java Solution

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
```

---

## Bit Manipulation Complexity

```text
Time Complexity: O(1)
Space Complexity: O(1)
```

This is better than repeated division because it checks the property using a single bitwise operation.

---

## Optimization Comparison

| Approach | Time | Space |
|---|---:|---:|
| Repeated Division | O(log n) | O(1) |
| Bit Manipulation | O(1) | O(1) |

---

## Key Learning

- Powers of two can be identified through repeated division.
- `% 2` checks whether a number is divisible by `2`.
- `/= 2` removes one factor of `2`.
- Powers of two have exactly one set bit (`1`) in binary.
- `n & (n - 1)` removes the lowest set bit.

---

## Important Pattern

You can connect this problem with:

### Power of Three

```java
while (n % 3 == 0)
    n /= 3;
```

### Power of Two

```java
while (n % 2 == 0)
    n /= 2;
```

The general pattern is:

```text
Check divisibility
        ↓
Divide by base
        ↓
Repeat
        ↓
Check whether result = 1
```

---

inary representation of `16`?
- What is the difference between the division and bit manipulation approaches?
