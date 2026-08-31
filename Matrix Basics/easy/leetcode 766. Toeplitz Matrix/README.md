# 766. Toeplitz Matrix
https://leetcode.com/problems/toeplitz-matrix/description/
## Difficulty

Easy

## Topic

- Array
- Matrix
- 2D Array
- Diagonal Traversal

---

## Problem Summary

A matrix is called a **Toeplitz Matrix** if every diagonal from the top-left to the bottom-right contains the same elements.

For example:

```text
[
    [1, 2, 3, 4],
    [5, 1, 2, 3],
    [9, 5, 1, 2]
]
```

The diagonals are:

```text
1 → 1 → 1
2 → 2 → 2
3 → 3
4

5 → 5
9
```

Therefore, it is a Toeplitz Matrix.

---

## Approach

Instead of checking every diagonal separately, compare each element with the element immediately **above and to the left**.

For every position `(i, j)`:

```text
matrix[i][j] == matrix[i-1][j-1]
```

If any pair is different, the matrix is not Toeplitz.

We start both loops from `1` because the first row and first column do not have a top-left diagonal neighbor.

---

## Algorithm

1. Start from row `1`.
2. Start from column `1`.
3. Compare:
   ```text
   matrix[i][j]
   ```
   with:
   ```text
   matrix[i-1][j-1]
   ```
4. If they are different, return `false`.
5. If all elements satisfy the condition, return `true`.

---

## Dry Run

### Input

```text
matrix =
[
    [1, 2, 3],
    [4, 1, 2],
    [5, 4, 1]
]
```

### Check `(1,1)`

```text
matrix[1][1] = 1
matrix[0][0] = 1

1 == 1 ✓
```

### Check `(1,2)`

```text
matrix[1][2] = 2
matrix[0][1] = 2

2 == 2 ✓
```

### Check `(2,1)`

```text
matrix[2][1] = 4
matrix[1][0] = 4

4 == 4 ✓
```

### Check `(2,2)`

```text
matrix[2][2] = 1
matrix[1][1] = 1

1 == 1 ✓
```

All comparisons match.

### Output

```text
true
```

---

## Java Solution

```java
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {

        for (int i = 1; i < matrix.length; i++) {

            for (int j = 1; j < matrix[0].length; j++) {

                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
```

---

## Time Complexity

**O(m × n)**

Where:

- `m` = number of rows
- `n` = number of columns

The nested loops check almost every element in the matrix.

```text
Time Complexity = O(m × n)
```

---

## Space Complexity

**O(1)**

- No additional array or data structure is created.
- Only the loop variables `i` and `j` are used.

```text
Space Complexity = O(1)
```

---

## Optimal Solution

**Is the current solution optimal?**

✅ Yes.

Your solution achieves:

```text
Time Complexity: O(m × n)
Space Complexity: O(1)
```

Every relevant matrix element needs to be checked, so `O(m × n)` time is optimal.

No extra matrix is required, so the auxiliary space is `O(1)`.

---

## Important Concept

The key observation is:

```text
Every element must be equal to its top-left neighbor.
```

For:

```text
matrix[i][j]
```

the diagonal neighbor is:

```text
matrix[i-1][j-1]
```

Therefore:

```java
matrix[i][j] != matrix[i - 1][j - 1]
```

means the Toeplitz property is violated.

---

## Why Do We Start From 1?

We use:

```java
for (int i = 1; i < matrix.length; i++)
```

and:

```java
for (int j = 1; j < matrix[0].length; j++)
```

because:

```text
matrix[0][0]
```

does not have a top-left neighbor.

Similarly, elements in the first row and first column don't have both `i-1` and `j-1` available.

So we start from:

```text
i = 1
j = 1
```

---

## Visual Pattern

For an element:

```text
        j-1   j
         ↓    ↓
i-1  →  [ A ] [ B ]
i    →  [ C ] [ D ]
```

We compare:

```text
D with A
```

That means:

```text
matrix[i][j]
        ↓
matrix[i-1][j-1]
```

---

## Common Mistakes

- Comparing with the top neighbor:
  ```java
  matrix[i-1][j]
  ```
  instead of the diagonal neighbor.

- Comparing with the left neighbor:
  ```java
  matrix[i][j-1]
  ```

- Starting the loops from `0`.

- Checking diagonals separately when a simple neighbor comparison is enough.

---


- Why is the time complexity `O(m × n)`?
- Why is the space complexity `O(1)`?
- Can this be solved without creating another matrix?
