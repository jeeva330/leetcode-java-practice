# 1480. Running Sum of 1d Array

https://leetcode.com/problems/running-sum-of-1d-array/description/
## Difficulty

Easy

## Topic

- Array
- Prefix Sum
- In-place Array Manipulation

---

## Problem Summary

Given an integer array `nums`, calculate the running sum of the array.

The running sum at index `i` is the sum of all elements from index `0` to `i`.

For example:

```text
Input:
[1, 2, 3, 4]

Output:
[1, 3, 6, 10]
```

---

## Approach

- Start traversing the array from index `1`.
- Add the previous running sum to the current element.
- Store the result directly in the current position.
- Return the modified array.

This modifies the input array **in place**, so no additional array is required.

---

## Algorithm

1. Start the loop from index `1`.
2. Calculate:
   ```java
   nums[i] = nums[i - 1] + nums[i];
   ```
3. Continue until the last element.
4. Return `nums`.

---

## Dry Run

### Input

```text
nums = [1, 2, 3, 4]
```

### Initial

```text
[1, 2, 3, 4]
```

### i = 1

```text
nums[1] = nums[0] + nums[1]
        = 1 + 2
        = 3
```

Array:

```text
[1, 3, 3, 4]
```

### i = 2

```text
nums[2] = nums[1] + nums[2]
        = 3 + 3
        = 6
```

Array:

```text
[1, 3, 6, 4]
```

### i = 3

```text
nums[3] = nums[2] + nums[3]
        = 6 + 4
        = 10
```

Final array:

```text
[1, 3, 6, 10]
```

---

## Java Solution

```java
class Solution {
    public int[] runningSum(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }

        return nums;
    }
}
```

---

## Time Complexity

**O(n)**

- The array is traversed exactly once.
- Each iteration performs one addition and one assignment.

```text
Time Complexity = O(n)
```

---

## Space Complexity

**O(1)**

- No additional array is created.
- The result is calculated directly inside the input array.
- Only the loop variable is used.

```text
Space Complexity = O(1)
```

---

## Optimal Solution

**Is the current solution optimal?**

✅ Yes.

Your solution achieves:

```text
Time Complexity: O(n)
Space Complexity: O(1)
```

The array must be traversed to calculate every running sum, so `O(n)` time is necessary.

The result is stored in the input array itself, so no additional `O(n)` array is required.

---

## Important Concept: Prefix Sum

A running sum is a basic form of a **Prefix Sum**.

For:

```text
nums = [1, 2, 3, 4]
```

The prefix sums are:

```text
1
1 + 2 = 3
1 + 2 + 3 = 6
1 + 2 + 3 + 4 = 10
```

Therefore:

```text
[1, 3, 6, 10]
```

The important relationship is:

```text
nums[i] = nums[i - 1] + nums[i]
```

---

## Why Does the In-Place Approach Work?

After calculating an element, it contains the running sum up to that position.

For example:

```text
Before:
[1, 2, 3, 4]

After i = 1:
[1, 3, 3, 4]

After i = 2:
[1, 3, 6, 4]
```

When calculating `nums[2]`, `nums[1]` already contains the running sum:

```text
nums[1] = 3
```

Therefore:

```text
nums[2] = 3 + 3 = 6
```


- Why is the space complexity `O(1)`?
- What is a Prefix Sum?
- How would the solution change if modifying the input array was not allowed?
