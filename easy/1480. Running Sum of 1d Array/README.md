# 1480. Running Sum of 1d Array
https://leetcode.com/problems/running-sum-of-1d-array/description/
## Difficulty
Easy

## Topic
- Array
- Prefix Sum (Basic)

---

## Problem Summary

Given an integer array `nums`, return the running sum of the array.

The running sum at index `i` is equal to the sum of all elements from index `0` to `i`.

---

## Approach

- Traverse the array from index `1`.
- Add the previous element's running sum to the current element.
- Store the updated value in the same array.
- Return the modified array.

---

## Algorithm

1. Start from index `1`.
2. Update `nums[i] = nums[i] + nums[i - 1]`.
3. Continue until the last element.
4. Return `nums`.

---

## Dry Run

**Input**

```text
nums = [1,2,3,4]
```

Iteration 1

```text
nums[1] = 2 + 1 = 3

[1,3,3,4]
```

Iteration 2

```text
nums[2] = 3 + 3 = 6

[1,3,6,4]
```

Iteration 3

```text
nums[3] = 4 + 6 = 10

[1,3,6,10]
```

**Output**

```text
[1,3,6,10]
```

---



## Time Complexity

**O(n)**

- The array is traversed only once.
- Each iteration performs one constant-time addition.

---

## Space Complexity

**O(1)**

- No extra array is created.
- The running sum is calculated by modifying the input array itself.
- Only a single loop variable is used.

---
