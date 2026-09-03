# 190. Reverse Bits

**LeetCode:** [Reverse Bits – LeetCode](https://leetcode.com/problems/reverse-bits/description/?utm_source=chatgpt.com)

**Difficulty:** Easy

**Topics:** Bit Manipulation, Divide and Conquer

---

## Problem Summary

Reverse the bits of a given **32-bit unsigned integer**.

For example:

```text
Input:
00000010100101000001111010011100

Output:
00111001011110000010100101000000
```

The first bit becomes the last bit, the second bit becomes the second-last bit, and so on.

---

## Approach

I process all **32 bits** of the integer one by one.

For every bit:

1. Get the last bit using:

   ```java
   n % 2
   ```
2. Add that bit to `result` by shifting the existing result left:

   ```java
   result = result * 2 + bit;
   ```
3. Remove the last bit from `n`:

   ```java
   n = n / 2;
   ```
4. Repeat this exactly **32 times**.

The important idea is that the bits are extracted from right to left and added to `result` from left to right, which naturally reverses their order.

---

## Algorithm

1. Initialize:

   ```java
   result = 0;
   ```
2. Repeat 32 times:

   * Extract the last bit:

     ```java
     bit = n % 2;
     ```
   * Shift the current result left by one position and add the extracted bit:

     ```java
     result = result * 2 + bit;
     ```
   * Remove the last bit from `n`:

     ```java
     n = n / 2;
     ```
3. Return `result`.

---

## Dry Run

Consider a smaller example to understand the logic:

```text
n = 1011
```

We want to reverse it:

```text
1011 → 1101
```

### Step 1

Last bit:

```text
1011 % 2 = 1
```

```text
result = 0 * 2 + 1
       = 1
```

Remove last bit:

```text
1011 → 101
```

### Step 2

```text
101 % 2 = 1
```

```text
result = 1 * 2 + 1
       = 3
```

Binary:

```text
11
```

Remove last bit:

```text
101 → 10
```

### Step 3

```text
10 % 2 = 0
```

```text
result = 3 * 2 + 0
       = 6
```

Binary:

```text
110
```

Remove last bit:

```text
10 → 1
```

### Step 4

```text
1 % 2 = 1
```

```text
result = 6 * 2 + 1
       = 13
```

Binary:

```text
1101
```

So:

```text
1011 → 1101
```

---

## My Solution

```java
class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int bit = n % 2;

            result = result * 2 + bit;

            n = n / 2;
        }

        return result;
    }
}
```

---

## Why `result = result * 2 + bit`?

This is an important part of the solution.

Multiplying a binary number by `2` is equivalent to shifting it **one position to the left**.

For example:

```text
result = 101

101 × 2 = 1010
```

Then adding the new bit:

```text
1010 + 1 = 1011
```

So:

```java
result = result * 2 + bit;
```

is effectively:

```text
result = (result << 1) | bit
```

---

## Time Complexity

The problem always deals with exactly **32 bits**.

```text
Loop runs exactly 32 times
```

Therefore:

**Time Complexity: O(32) = O(1)**

In a general `k`-bit representation:

**Time Complexity: O(k)**

---

## Space Complexity

Only `result`, `bit`, and the loop variable are used.

**Space Complexity: O(1)**

---

## Optimal Solution

We can perform the same operation using **bitwise operators** instead of `% 2` and `/ 2`.

```java
class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int bit = n & 1;

            result = (result << 1) | bit;

            n >>>= 1;
        }

        return result;
    }
}
```

### Comparison

Your approach:

```text
n % 2       → get last bit
n / 2       → remove last bit
result*2     → shift result left
+ bit        → add bit
```

Bitwise approach:

```text
n & 1        → get last bit
n >>>= 1     → remove last bit
result << 1  → shift result left
| bit        → add bit
```

Both have:

```text
Time:  O(1)
Space: O(1)
```

But the bitwise version expresses the actual **bit manipulation** more directly.

---

## Important Difference: `>>` vs `>>>`

In Java:

```text
>>   → signed right shift
>>>  → unsigned right shift
```

For this problem, using:

```java
n >>>= 1;
```

is safer because the problem treats `n` as a **32-bit unsigned integer**.

The `>>>` operator fills the leftmost position with `0`.

---

## Key Learning

### 1. Extracting the Last Bit

Using arithmetic:

```java
n % 2
```

Using bit manipulation:

```java
n & 1
```

---

### 2. Removing the Last Bit

Using arithmetic:

```java
n = n / 2;
```

Using bit manipulation:

```java
n >>>= 1;
```

---

### 3. Building the Reversed Number

```java
result = result * 2 + bit;
```

is equivalent to:

```java
result = (result << 1) | bit;
```

This pattern is very useful when constructing a number bit by bit.

---

### 4. Why Exactly 32 Iterations?

An integer in this problem has exactly:

```text
32 bits
```

Even if the number looks small, we must process all 32 positions, including leading zeros.

---

## Common Mistakes

* Looping only while `n != 0`.
* Forgetting that the input is **32 bits**.
* Not processing leading zeros.
* Using `>>` when an unsigned shift `>>>` is more appropriate.
* Forgetting to shift `result` before adding the next bit.
* Confusing:

  ```text
  result << 1
  ```

  with:

  ```text
  n >>> 1
  ```

---

## Interview Keywords

* Bit Manipulation
* Reverse Bits
* Binary Representation
* Bitwise AND
* Left Shift
* Unsigned Right Shift
* `& 1`
* `<<`
* `>>>`
* 32-bit Integer

---

## Revision Questions

1. Why does `n % 2` give the last binary bit?
2. What does `n & 1` do?
3. Why do we loop exactly 32 times?
4. Why do we use `result * 2 + bit`?
5. What is the bitwise equivalent of `result * 2 + bit`?
6. What does `n >>>= 1` do?
7. What is the difference between `>>` and `>>>`?
8. Why can't we stop when `n == 0`?
9. Why are leading zeros important in this problem?
10. What are the time and space complexities?

---

## Quick Revision

```text
Problem: Reverse Bits

Input:
32-bit integer

Goal:
Reverse all 32 bits.

Your approach:

1. Get last bit:
   n % 2

2. Add it to result:
   result = result * 2 + bit

3. Remove last bit:
   n = n / 2

4. Repeat 32 times.

Bitwise approach:

bit = n & 1

result = (result << 1) | bit

n >>>= 1

Important:

n % 2   → last bit
n / 2   → remove last bit

n & 1   → last bit
n >>> 1 → remove last bit

result * 2
        ↓
result << 1

Time:  O(1)
Space: O(1)
```
