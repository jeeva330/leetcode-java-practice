# 566. Reshape the Matrix

[LeetCode – Reshape the Matrix](https://leetcode.com/problems/reshape-the-matrix/description/)

## Difficulty

Easy

## Topic

- Array
- Matrix
- 2D Array
- Index Mapping

---

## Problem Summary

Given a matrix `mat` with `m × n` elements, reshape it into a matrix of size `r × c`.

The elements must remain in the same order.

If the number of elements in the original matrix is not equal to the number of elements in the new matrix, return the original matrix.

---

## Approach

### My Approach

1. Check whether the number of elements in the original matrix is equal to the required size.
2. Create a new matrix of size `r × c`.
3. Store all elements of the original matrix in an `ArrayList`.
4. Traverse the new matrix.
5. Fill it using the elements stored in the list.
6. Return the new matrix.

---

## Algorithm

1. Calculate:
   ```text
   Original elements = rows × columns
   ```
2. Check:
   ```text
   mat.length × mat[0].length != r × c
   ```
3. If the sizes are different, return `mat`.
4. Create a new matrix:
   ```java
   new int[r][c]
   ```
5. Copy all elements from `mat` into an `ArrayList`.
6. Traverse the new matrix.
7. Fill each position using the list.
8. Return the reshaped matrix.

---

## Dry Run

### Input

```text
mat =
[
    [1, 2],
    [3, 4]
]

r = 1
c = 4
```

Original size:

```text
2 × 2 = 4
```

New size:

```text
1 × 4 = 4
```

Sizes are equal, so reshaping is possible.

### Store Elements

```text
[1, 2, 3, 4]
```

Fill the new matrix:

```text
matrix[0][0] = 1
matrix[0][1] = 2
matrix[0][2] = 3
matrix[0][3] = 4
```

### Output

```text
[
    [1, 2, 3, 4]
]
```

---

## Java Solution

```java
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        if (mat.length * mat[0].length != r * c)
            return mat;

        int[][] matrix = new int[r][c];

        ArrayList<Integer> li = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                li.add(mat[i][j]);
            }
        }

        int k = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = li.get(k);
                k++;
            }
        }

        return matrix;
    }
}
```

---

## Time Complexity

**O(m × n)**

Where:

- `m` = number of rows in the original matrix
- `n` = number of columns in the original matrix

We traverse every element to:

1. Store it in the `ArrayList`.
2. Copy it into the new matrix.

Therefore:

```text
O(m × n) + O(r × c)
```

Since the number of elements is the same:

```text
m × n = r × c
```

Therefore:

```text
Time Complexity = O(m × n)
```

---

## Space Complexity

**O(m × n)**

Your solution creates:

1. The new matrix:
   ```text
   O(r × c)
   ```

2. The `ArrayList` containing all original elements:
   ```text
   O(m × n)
   ```

Therefore:

```text
Space Complexity = O(m × n)
```

---

# Optimal Solution

The `ArrayList` is unnecessary.

We can directly map every element from the original matrix to the reshaped matrix.

The important idea is to treat the matrix as a **1D sequence**.

For every original element:

```text
mat[i][j]
```

we can calculate its 1D index:

```text
index = i × originalColumns + j
```

Then find its position in the new matrix:

```text
newRow = index / c
newColumn = index % c
```

---

## Optimized Java Solution

```java
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int rows = mat.length;
        int cols = mat[0].length;

        if (rows * cols != r * c)
            return mat;

        int[][] result = new int[r][c];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                int index = i * cols + j;

                int newRow = index / c;
                int newCol = index % c;

                result[newRow][newCol] = mat[i][j];
            }
        }

        return result;
    }
}
```

---

## Optimized Complexity

### Time Complexity

Every element is visited once:

```text
O(m × n)
```

### Space Complexity

Only the output matrix is created:

```text
O(r × c)
```

The **auxiliary space excluding the output** is:

```text
O(1)
```

---

## Optimization Comparison

| Approach | Time | Extra Space |
|---|---:|---:|
| My Solution | O(m × n) | O(m × n) |
| Optimized | O(m × n) | O(1) |

> Both solutions have the same time complexity. The optimized solution removes the unnecessary `ArrayList`.

---

## Important Concept: 2D → 1D Index

This is the most important learning from this problem.

For a matrix:

```text
[
    [1, 2, 3],
    [4, 5, 6]
]
```

we can think of it as:

```text
[1, 2, 3, 4, 5, 6]
```

The 1D index of:

```text
mat[i][j]
```

is:

```text
index = i × cols + j
```

---

## Converting 1D Index → New Matrix Position

Once we have:

```text
index
```

we can find the new position:

```text
row = index / c
column = index % c
```

For example:

```text
index = 5
c = 4
```

Then:

```text
row = 5 / 4 = 1
column = 5 % 4 = 1
```

So:

```text
result[1][1]
```

---

## Important Formula

Remember this pattern:

```text
2D → 1D

index = row × numberOfColumns + column
```

and:

```text
1D → 2D

row = index / numberOfColumns
column = index % numberOfColumns
```

This is a very useful **matrix index-mapping pattern**.

---

## Why Do We Check the Size First?

Suppose:

```text
mat = 2 × 3
```

Number of elements:

```text
2 × 3 = 6
```

If:

```text
r = 2
c = 2
```

New size:

```text
2 × 2 = 4
```

The number of elements is different:

```text
6 != 4
```

So reshaping is impossible.

Therefore:

```java
return mat;
```

---

## Common Mistakes

- Forgetting to check whether the total number of elements is equal.
- Changing the order of elements.
- Creating the new matrix with incorrect dimensions.
- Using `r` instead of `c` in:
  ```text
  index / c
  ```
- Using `r` instead of `c` in:
  ```text
  index % c
  ```

---

## Interview Keywords

- Matrix
- 2D Array
- Index Mapping
- 1D Index
- Row and Column
- Division
- Modulo
- In-place Mapping

---

## Revision Questions

- Why must `m × n == r × c`?
- Why is an `ArrayList` unnecessary?
- How do you convert `matrix[i][j]` into a 1D index?
- How do you convert a 1D index back into row and column?
- Why do we use `index / c` for the new row?
- Why do we use `index % c` for the new column?
- What is the difference between output space and auxiliary space?
