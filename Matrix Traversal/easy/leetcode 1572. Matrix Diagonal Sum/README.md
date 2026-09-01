# 1572. Matrix Diagonal Sum


https://leetcode.com/problems/matrix-diagonal-sum/description/
## Difficulty

Easy

## Topic

- Array
- Matrix
- 2D Array
- Diagonal Traversal

---

## Problem Summary

Given a square matrix, calculate the sum of:

- The primary diagonal
- The secondary diagonal

If the matrix has an odd number of rows, the center element belongs to both diagonals, so it should be counted only once.

---

## Approach

### My Approach

- Traverse the entire matrix using nested loops.
- If `i == j`, the element belongs to the primary diagonal.
- If `i + j == n - 1`, the element belongs to the secondary diagonal.
- Use `i != j` in the secondary diagonal condition to avoid counting the center element twice.
- Add the diagonal elements to `sum`.

---

## Algorithm

1. Initialize `sum = 0`.
2. Traverse every element of the matrix.
3. Check whether:
   ```text
   i == j
   ```
   If true, add the element to `sum`.
4. Check whether:
   ```text
   i + j == n - 1
   ```
   and `i != j`.
5. If true, add the element to `sum`.
6. Return `sum`.

---

## Dry Run

### Input

```text
mat =
[
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]
```

### Primary Diagonal

Condition:

```text
i == j
```

Elements:

```text
1 + 5 + 9 = 15
```

### Secondary Diagonal

Condition:

```text
i + j == n - 1
```

Elements:

```text
3 + 5 + 7
```

The center element `5` is common to both diagonals, so it should only be counted once.

Therefore:

```text
3 + 7 = 10
```

### Final Sum

```text
15 + 10 = 25
```

### Output

```text
25
```

---

## Java Solution

```java
class Solution {
    public int diagonalSum(int[][] mat) {

        int sum = 0;

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[0].length; j++) {

                if (i == j)
                    sum += mat[i][j];

                if ((i + j) == mat.length - 1 && i != j)
                    sum += mat[i][j];
            }
        }

        return sum;
    }
}
```

---

## Time Complexity

**O(n²)**

Where `n` is the number of rows/columns.

The nested loops visit every element of the matrix:

```text
n × n = n²
```

Therefore:

```text
Time Complexity = O(n²)
```

---

## Space Complexity

**O(1)**

- No additional array or data structure is created.
- Only the `sum` variable and loop variables are used.

```text
Space Complexity = O(1)
```

---

# Optimal Solution

We don't actually need to visit every element.

We only need the elements on the two diagonals.

For a square matrix of size `n × n`:

### Primary Diagonal

```text
mat[i][i]
```

### Secondary Diagonal

```text
mat[i][n - 1 - i]
```

We can traverse only once and directly access both diagonal elements.

### Optimized Java Solution

```java
class Solution {
    public int diagonalSum(int[][] mat) {

        int n = mat.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum += mat[i][i];

            if (i != n - 1 - i) {
                sum += mat[i][n - 1 - i];
            }
        }

        return sum;
    }
}
```

---

## Optimized Complexity

### Time Complexity

**O(n)**

Only one loop is required, and each iteration accesses the two diagonal elements directly.

```text
Time Complexity = O(n)
```

### Space Complexity

**O(1)**

Only a few variables are used.

```text
Space Complexity = O(1)
```

---

## Optimization Comparison

| Approach | Time | Space |
|---|---:|---:|
| My Solution | O(n²) | O(1) |
| Optimized Solution | O(n) | O(1) |

---

## Important Concept

There are two diagonal formulas to remember.

### Primary Diagonal

```text
i == j
```

or directly:

```java
mat[i][i]
```

Example:

```text
[1] 2  3
 4 [5] 6
 7  8 [9]
```

### Secondary Diagonal

```text
i + j == n - 1
```

or directly:

```java
mat[i][n - 1 - i]
```

Example:

```text
1  2 [3]
4 [5] 6
[7] 8  9
```

---

## Why `i != n - 1 - i`?

In an odd-sized matrix, the center element belongs to both diagonals.

For:

```text
3 × 3
```

the center is:

```text
mat[1][1]
```

Primary diagonal:

```text
mat[1][1]
```

Secondary diagonal:

```text
mat[1][3 - 1 - 1]
= mat[1][1]
```

Without the condition:

```java
if (i != n - 1 - i)
```

the center would be counted twice.

---

## Common Mistakes

- Counting the center element twice.
- Using `mat[i][n - i]` instead of:
  ```java
  mat[i][n - 1 - i]
  ```
- Forgetting that the matrix is square.
- Traversing the entire matrix when only the diagonals are required.

---

- Why should the center element be counted only once?
- Why is your solution `O(n²)`?
- How can the solution be improved to `O(n)`?
