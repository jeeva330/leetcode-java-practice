# 724. Find Pivot Index
https://leetcode.com/problems/find-pivot-index/description/
## Difficulty

Easy

## Topic

- Array
- Prefix Sum
- Running Sum

---

## Problem Summary

Given an integer array `nums`, find the leftmost index where:

```text
Sum of elements to the left
=
Sum of elements to the right
```

The element at the pivot index is not included in either sum.

If no pivot index exists, return `-1`.

---

## Approach

- First calculate the total sum of the entire array.
- Maintain a `leftSum` starting from `0`.
- Calculate the right sum by subtracting the current element from the total sum.
- Compare `leftSum` and `rightSum`.
- If they are equal, the current index is the pivot index.
- Otherwise, add the current element to `leftSum` and continue.

---

## Algorithm

1. Calculate the total sum of the array.
2. Initialize:
   ```text
   leftSum = 0
   rightSum = total
   ```
3. Traverse the array.
4. Remove the current element from `rightSum`.
5. Check:
   ```text
   leftSum == rightSum
   ```
6. If equal, return the current index.
7. Add the current element to `leftSum`.
8. If no pivot is found, return `-1`.

---

## Dry Run

### Input

```text
nums = [1, 7, 3, 6, 5, 6]
```

### Step 1: Calculate Total

```text
total = 1 + 7 + 3 + 6 + 5 + 6
      = 28
```

Initial:

```text
leftSum = 0
rightSum = 28
```

### Index 0

Remove current element:

```text
rightSum = 28 - 1 = 27
```

Compare:

```text
leftSum = 0
rightSum = 27

0 != 27
```

Update:

```text
leftSum = 0 + 1 = 1
```

### Index 1

```text
rightSum = 27 - 7 = 20
```

```text
leftSum = 1
rightSum = 20

1 != 20
```

Update:

```text
leftSum = 1 + 7 = 8
```

### Index 2

```text
rightSum = 20 - 3 = 17
```

```text
leftSum = 8
rightSum = 17

8 != 17
```

Update:

```text
leftSum = 8 + 3 = 11
```

### Index 3

```text
rightSum = 17 - 6 = 11
```

Now:

```text
leftSum = 11
rightSum = 11
```

They are equal.

Therefore:

```text
Output = 3
```

---

## Java Solution

```java
class Solution {
    public int pivotIndex(int[] nums) {

        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        int leftSum = 0;
        int rightSum = total;

        for (int i = 0; i < nums.length; i++) {

            rightSum -= nums[i];

            if (leftSum == rightSum)
                return i;

            leftSum += nums[i];
        }

        return -1;
    }
}
```

---

## Time Complexity

**O(n)**

There are two separate loops:

### First loop

Calculates the total sum:

```text
O(n)
```

### Second loop

Finds the pivot index:

```text
O(n)
```

Therefore:

```text
O(n) + O(n)
= O(2n)
= O(n)
```

**Time Complexity = O(n)**

---

## Space Complexity

**O(1)**

Only a few variables are used:

```text
total
leftSum
rightSum
i
```

No additional array, list, or other data structure is created.

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

This is optimal because we need to examine the array elements to determine the pivot index.

---

## Important Concept

This problem is closely related to **Prefix Sum**.

From the previous problem:

### 1480. Running Sum

```text
nums[i] = nums[i - 1] + nums[i]
```

Here, instead of creating a prefix-sum array, you maintain:

```text
leftSum
rightSum
```

The key idea is:

```text
Total Sum = Left Sum + Current Element + Right Sum
```

Therefore:

```text
Right Sum = Total Sum - Left Sum - Current Element
```

Your code implements this efficiently using:

```java
rightSum -= nums[i];
```

---

## Why Do We Subtract Before Comparing?

This is very important.

Suppose:

```text
nums = [1, 7, 3, 6, 5, 6]
```

At index `3`:

```text
left = [1,7,3]
right = [5,6]
```

The current element `6` must **not** belong to either side.

Therefore, we first remove it:

```java
rightSum -= nums[i];
```

Then compare:

```java
if (leftSum == rightSum)
```

Only after checking do we add the current element to `leftSum`:

```java
leftSum += nums[i];
```

---

## Common Mistakes

- Including the pivot element in the left sum.
- Including the pivot element in the right sum.
- Forgetting to subtract `nums[i]` from `rightSum` before comparison.
- Updating `leftSum` before checking the pivot condition.
- Returning the last pivot instead of the leftmost pivot.

---

## Interview Keywords

- Prefix Sum
- Running Sum
- Array
- Left Sum
- Right Sum
- In-place Calculation
- Linear Traversal

---

