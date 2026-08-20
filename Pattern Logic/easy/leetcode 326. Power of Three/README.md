# 326. Power of Three


https://leetcode.com/problems/power-of-three/description/
## Difficulty

Easy

## Topic

- Math
- Number Manipulation
- Division

---

## Problem Summary

Given an integer `n`, determine whether `n` is a power of `3`.

A number is a power of three if it can be written as:

```text
3^x
```

where `x` is a non-negative integer.

Examples:

```text
1  = 3^0
3  = 3^1
9  = 3^2
27 = 3^3
```

---

## Approach

### My Approach

- Reject negative values.
- Keep dividing `n` by `3`.
- Count how many times the division happens.
- Calculate `3^count`.
- Compare it with the original number.

If they are equal, the number is a power of three.

---

## Algorithm

1. If `n < 0`, return `false`.
2. Store the original value in `num`.
3. Initialize `count = 0`.
4. While `n > 1`:
   - Divide `n` by `3`.
   - Increment `count`.
5. Calculate `3^count`.
6. Compare it with the original number.
7. Return the result.

---

## Dry Run

### Input

```text
n = 27
```

Initially:

```text
num = 27
count = 0
```

First iteration:

```text
27 / 3 = 9
count = 1
```

Second:

```text
9 / 3 = 3
count = 2
```

Third:

```text
3 / 3 = 1
count = 3
```

Now:

```text
3^3 = 27
```

Compare:

```text
num == 3^count
27 == 27
```

### Output

```text
true
```

---

## Java Solution

```java
class Solution {
    public boolean isPowerOfThree(int n) {

        if (n < 0)
            return false;

        int count = 0;
        int num = n;

        while (n > 1) {
            n /= 3;
            count++;
        }

        return num == (int) Math.pow(3, count);
    }
}
```

---

## Time Complexity

**O(log₃ n)**

- The loop divides `n` by `3` in every iteration.
- Therefore, the number of iterations is approximately `log₃(n)`.

```text
Time Complexity = O(log n)
```

---

## Space Complexity

**O(1)**

- Only a few integer variables are used.
- No additional array, list, or collection is created.

```text
Space Complexity = O(1)
```

---

# Optimal Solution

Your solution can be simplified.

You don't actually need `count`, `Math.pow()`, or the original number.

If a number is a power of three, repeatedly dividing it by `3` should eventually produce exactly `1`.

However, we must also check that every division is exact.

### Optimized Java Solution

```java
class Solution {
    public boolean isPowerOfThree(int n) {

        if (n <= 0)
            return false;

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}
```

---

## Why the Optimized Solution Works

Consider:

```text
n = 27
```

```text
27 % 3 = 0 → divide
27 / 3 = 9

9 % 3 = 0 → divide
9 / 3 = 3

3 % 3 = 0 → divide
3 / 3 = 1
```

Now:

```text
n == 1
```

Therefore:

```text
true
```

For:

```text
n = 45
```

```text
45 % 3 = 0
45 / 3 = 15

15 % 3 = 0
15 / 3 = 5
```

Now:

```text
5 % 3 != 0
```

The loop stops.

```text
5 != 1
```

Therefore:

```text
false
```

---

## Optimized Complexity

**Time Complexity:** `O(log n)`

**Space Complexity:** `O(1)`

---

## Optimization Comparison

| Approach | Time | Space |
|---|---:|---:|
| Your Solution | O(log n) | O(1) |
| Repeated Division | O(log n) | O(1) |

Both have the same Big-O complexity.

The optimized version is better because it:

- Uses fewer variables.
- Doesn't use `Math.pow()`.
- Doesn't need to calculate the exponent.
- Directly checks whether the number can be repeatedly divided by `3`.

