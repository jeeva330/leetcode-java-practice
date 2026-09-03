# 191. Number of 1 Bits

**LeetCode:** [Number of 1 Bits – LeetCode](https://leetcode.com/problems/number-of-1-bits/description/?utm_source=chatgpt.com)

**Difficulty:** Easy

**Topics:** Bit Manipulation, Divide and Conquer

---

## Problem Summary

Given a positive integer `n`, return the number of `1` bits in its binary representation.

This is also called the **Hamming Weight** of a number.

### Example

```text
Input:  n = 11
Binary: 1011

Output: 3
```

Because:

```text
1011
 ↑ ↑↑
 1 11
```

There are **three `1` bits**.

---

## Approach

I converted the number into its binary representation **digit by digit** using `% 2` and `/ 2`.

For every iteration:

1. `n % 2` gives the last binary digit.
2. If the remainder is `1`, increment `count`.
3. `n /= 2` removes the last binary digit.
4. Continue until `n` becomes `0`.

---

## Algorithm

1. Initialize `count = 0`.
2. While `n != 0`:

   * Find the last binary bit:

     ```java
     int rem = n % 2;
     ```
   * If `rem == 1`, increment `count`.
   * Remove the last bit:

     ```java
     n /= 2;
     ```
3. Return `count`.

---

## Dry Run

### Input

```text
n = 11
```

Binary representation:

```text
11 = 1011
```

| `n` | `n % 2` | `count` | `n / 2` |
| --: | ------: | ------: | ------: |
|  11 |       1 |       1 |       5 |
|   5 |       1 |       2 |       2 |
|   2 |       0 |       2 |       1 |
|   1 |       1 |       3 |       0 |

Now `n = 0`, so the loop stops.

```text
Answer = 3
```

---

## My Solution

```java
class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        while(n != 0){
            int rem = n % 2;

            if(rem == 1)
                count++;

            n /= 2;
        }

        return count;
    }
}
```

---

## Time Complexity

Every division by `2` removes one binary digit.

If `n` has `k` binary bits:

**Time Complexity: O(k)**

Since `k = log₂(n)`:

**Time Complexity: O(log n)**

For Java's fixed 32-bit integer, this can also be considered **O(1)** in terms of the fixed integer size.

---

## Space Complexity

Only the variables `count` and `rem` are used.

**Space Complexity: O(1)**

---

## Optimal Solution

Since this is a **bit manipulation** problem, we can directly work with the bits instead of using `% 2` and `/ 2`.

### Important Operators

```text
n & 1
```

gets the **last bit** of `n`.

Example:

```text
n = 1010

1010
0001
----
0000
```

So:

```text
1010 & 1 = 0
```

For:

```text
1011 & 1 = 1
```

We can therefore check whether the last bit is `1`.

Then:

```java
n >>>= 1;
```

shifts all bits one position to the right.

### Optimized Code

```java
class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        while(n != 0){
            count += n & 1;
            n >>>= 1;
        }

        return count;
    }
}
```

This follows the same idea as your solution:

```text
Your approach:

n % 2  → get last bit
n / 2  → remove last bit

Bit approach:

n & 1  → get last bit
n >>> 1 → remove last bit
```

---

## Even Better Solution — Brian Kernighan's Algorithm

There is an even more efficient bit-manipulation technique:

```java
class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        while(n != 0){
            n = n & (n - 1);
            count++;
        }

        return count;
    }
}
```

### Why does `n & (n - 1)` work?

It removes the **rightmost `1` bit**.

Example:

```text
n     = 1011
n - 1 = 1010

  1011
& 1010
------
  1010
```

The rightmost `1` is removed.

Again:

```text
  1010
& 1001
------
  1000
```

Again:

```text
  1000
& 0111
------
  0000
```

There were three `1`s, so:

```text
Answer = 3
```

---

## Complexity Comparison

| Approach          |                            Time | Space |
| ----------------- | ------------------------------: | ----: |
| `% 2` and `/ 2`   |                        O(log n) |  O(1) |
| `& 1` and `>>> 1` |                        O(log n) |  O(1) |
| `n & (n - 1)`     | O(k) where k = number of 1 bits |  O(1) |

The **Brian Kernighan approach** is especially efficient when the number contains relatively few `1` bits because it loops only once per set bit.

---

## Key Learning

### 1. `% 2` Gives the Last Binary Bit

```java
n % 2
```

For binary numbers:

```text
even number → 0
odd number  → 1
```

So it tells us whether the last bit is `0` or `1`.

---

### 2. `/ 2` Removes the Last Binary Bit

Example:

```text
1011₂ = 11

11 / 2 = 5
```

```text
1011
 ↓
101
```

So repeated division by 2 is effectively moving through the binary representation from right to left.

---

### 3. `n & 1`

This directly checks the last bit:

```text
1011
0001
----
0001
```

Therefore:

```text
1011 & 1 = 1
```

---

### 4. `n & (n - 1)`

This removes the **rightmost set bit**.

This is one of the most important patterns in bit manipulation.

---

## Common Mistakes

* Confusing `% 2` with `% 10`.

  * `% 10` is commonly used for decimal digits.
  * `% 2` helps identify binary parity/last bit.
* Forgetting to update `n`.
* Using `n >> 1` without considering signed integers.
* Forgetting that the problem uses a **32-bit integer** representation.
* Thinking `n & (n - 1)` changes every bit. It only removes the rightmost `1` bit.

---

## Interview Keywords

* Bit Manipulation
* Hamming Weight
* Set Bit
* Binary Representation
* Bitwise AND
* Right Shift
* Brian Kernighan's Algorithm
* `n & (n - 1)`

---

## Revision Questions

1. What does `n % 2` give?
2. Why does dividing by `2` remove the last binary digit?
3. What does `n & 1` do?
4. What does `n >>> 1` do?
5. Why does `n & (n - 1)` remove the rightmost `1`?
6. What is a set bit?
7. What is the difference between `% 2` and `& 1`?
8. What is the time complexity of Brian Kernighan's algorithm?
9. For `n = 1010`, what does `n & 1` return?
10. For `n = 1010`, how many times will `n & (n - 1)` execute?

---

## Quick Revision

```text
Problem: Number of 1 Bits

Goal:
Count the number of 1s in the binary representation.

Your approach:
1. n % 2 → get last bit
2. If remainder == 1 → count++
3. n /= 2 → remove last bit
4. Repeat until n == 0

Bit approach:
n & 1 → get last bit
n >>> 1 → remove last bit

Best bit trick:
n & (n - 1)

This removes the rightmost 1 bit.

Example:

1011
↓
1010
↓
1000
↓
0000

Number of iterations = number of 1 bits

Time:
O(log n) normally
O(1) for fixed 32-bit integer

Space:
O(1)
```
