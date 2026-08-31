# 867. Transpose Matrix
https://leetcode.com/problems/transpose-matrix/description/
## Difficulty

Easy

## Topic

- Array
- Matrix
- 2D Array
- Matrix Transpose

---

## Problem Summary

Given a 2D matrix, return its transpose.

In a transpose:

- Rows become columns.
- Columns become rows.

For a matrix with `m` rows and `n` columns, the transposed matrix will have:

```text
n rows × m columns
```

---

## Approach

- Create a new matrix with dimensions:
  ```text
  matrix[0].length × matrix.length
  ```
- Traverse every element of the original matrix.
- Place `matrix[i][j]` at `a[j][i]`.
- Return the new matrix.

The key idea is that the row and column indices are swapped.

```text
matrix[i][j] → transpose[j][i]
```

---

## Algorithm

1. Find the number of rows:
   ```text
   matrix.length
   ```
2. Find the number of columns:
   ```text
   matrix[0].length
   ```
3. Create a new matrix of size:
   ```text
   columns × rows
   ```
4. Use nested loops to visit every element.
5. Assign:
   ```java
   a[j][i] = matrix[i][j];
   ```
6. Return the transposed matrix.

---

## Dry Run

### Input

```text
matrix =
[
    [1, 2, 3],
    [4, 5, 6]
]
```

Original matrix:

```text
     columns
      0  1  2
    ┌─────────
0   │ 1  2  3
1   │ 4  5  6
```

The original matrix has:

```text
2 rows × 3 columns
```

So the result must have:

```text
3 rows × 2 columns
```

### Step 1

```text
matrix[0][0] = 1

a[0][0] = 1
```

### Step 2

```text
matrix[0][1] = 2

a[1][0] = 2
```

### Step 3

```text
matrix[0][2] = 3

a[2][0] = 3
```

### Step 4

```text
matrix[1][0] = 4

a[0][1] = 4
```

### Step 5

```text
matrix[1][1] = 5

a[1][1] = 5
```

### Step 6

```text
matrix[1][2] = 6

a[2][1] = 6
```

### Output

```text
[
    [1, 4],
    [2, 5],
    [3, 6]
]
```

---

## Java Solution

```java
class Solution {
    public int[][] transpose(int[][] matrix) {

        int[][] a = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                a[j][i] = matrix[i][j];
            }
        }

        return a;
    }
}
```

---

## Time Complexity

**O(m × n)**

Where:

- `m` = number of rows
- `n` = number of columns

The nested loops visit every element exactly once.

Total elements:

```text
m × n
```

Therefore:

```text
Time Complexity = O(m × n)
```

---

## Space Complexity

**O(m × n)**

A new matrix is created to store the transpose.

The new matrix contains the same number of elements as the original:

```text
m × n
```

Therefore:

```text
Space Complexity = O(m × n)
```

The output matrix is required, so this space cannot be avoided for a general rectangular matrix.

---

## Optimal Solution

**Is the current solution optimal?**

✅ Yes.

For this problem, the transpose must be returned as a new matrix.

Therefore:

```text
Time Complexity: O(m × n)
Space Complexity: O(m × n)
```

Every element must be read at least once, so `O(m × n)` time is necessary.

---

## Important Concept

The main idea is simply:

```text
Original:
matrix[i][j]

Transpose:
matrix[j][i]
```

Example:

```text
matrix[0][2]
```

becomes:

```text
transpose[2][0]
```

So:

```java
a[j][i] = matrix[i][j];
```

is the most important line in this problem.

---

## Matrix Dimensions

If the original matrix is:

```text
m × n
```

then the transpose is:

```text
n × m
```

Example:

```text
2 × 3
```

becomes:

```text
3 × 2
```

This is why you created:

```java
new int[matrix[0].length][matrix.length]
```

The first dimension is the original number of columns, and the second dimension is the original number of rows.

---

## Common Mistakes

- Creating the result matrix with the same dimensions as the original.
- Writing:
  ```java
  a[i][j] = matrix[i][j];
  ```
  instead of swapping the indices.
- Forgetting that rows and columns are reversed.
- Using `matrix.length` for both dimensions.

---

