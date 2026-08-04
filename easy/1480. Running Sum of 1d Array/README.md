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

## Key Learning

- Updating an array in place reduces extra space.
- Each element depends on the previously computed running sum.
- This is a basic application of the Prefix Sum concept.

---

## Common Mistakes

- Starting the loop from index `0` instead of `1`.
- Using `nums[i+1]` instead of `nums[i-1]`.
- Creating an unnecessary extra array.

---

## Interview Keywords

- Array
- Prefix Sum
- In-place Update
- Linear Traversal

---

## Similar Problems

- 303. Range Sum Query - Immutable
- 724. Find Pivot Index
- 238. Product of Array Except Self
- 560. Subarray Sum Equals K

---

## Revision Questions

- Why does the loop start from index `1`?
- Why is the space complexity `O(1)`?
- Can this be solved without creating another array?
- What is a Prefix Sum?
