# 1431. Kids With the Greatest Number of Candies

https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/
## Difficulty

Easy

## Topic

- Array
- Simulation

---

## Problem Summary

You are given an integer array `candies`, where each element represents the number of candies a child has, and an integer `extraCandies`.

For each child, determine whether giving all the extra candies to that child would make them have the greatest number of candies among all children.

Return a list of boolean values.

---

## Approach

- Find the maximum number of candies among all children.
- Traverse the array again.
- For each child, check if:
  
  `candies[i] + extraCandies >= maximumCandies`

- If true, add `true` to the result list; otherwise, add `false`.

---

## Algorithm

1. Find the maximum element in the array.
2. Create an empty `List<Boolean>`.
3. Traverse the array again.
4. Compare `candies[i] + extraCandies` with the maximum value.
5. Store the comparison result in the list.
6. Return the list.

---

## Dry Run

### Input

```text
candies = [2,3,5,1,3]
extraCandies = 3
```

Maximum Candies

```text
max = 5
```

Comparisons

```text
2 + 3 >= 5 → true
3 + 3 >= 5 → true
5 + 3 >= 5 → true
1 + 3 >= 5 → false
3 + 3 >= 5 → true
```

### Output

```text
[true, true, true, false, true]
```

---

## Time Complexity

**O(n)**

- First traversal finds the maximum element.
- Second traversal checks every child.
- Total operations = `n + n = 2n`.
- Ignoring constants, the time complexity is **O(n)**.

---

## Space Complexity

**O(n)**

- A `List<Boolean>` of size `n` is created to store the result.
- Apart from the output list, only a few variables are used.
- Therefore, the extra space required is **O(n)**.

---

