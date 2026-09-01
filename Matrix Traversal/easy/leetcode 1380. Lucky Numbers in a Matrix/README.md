# 1380. Lucky Numbers in a Matrix


https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/
## Difficulty

Easy

## Topic

- Array
- Matrix
- 2D Array
- Row Minimum
- Column Maximum

---

## Problem Summary

A lucky number is an element in a matrix that is:

- The **minimum element in its row**, and
- The **maximum element in its column**.

Return all lucky numbers in the matrix.

---

## Approach

### My Approach

For each row:

1. Find the minimum element in that row.
2. Store the column index of that minimum element.
3. Traverse that column.
4. Check whether the selected element is greater than or equal to every element in that column.
5. If it is the maximum in the column, add it to the result.

---

## Algorithm

1. Create an empty result list.
2. Traverse every row.
3. Assume the first element is the minimum.
4. Find the minimum element and its column index.
5. Traverse the selected column.
6. Check whether the minimum element is the maximum in that column.
7. If yes, add it to the result.
8. Return the result.

---

## Dry Run

### Input

```text
matrix =
[
    [3, 7, 8],
    [9, 11, 13],
    [15, 16, 17]
]
```

### Row 1

```text
[3, 7, 8]

Minimum = 3
Column = 0
```

Column 0:

```text
3
9
15
```

`3` is not the maximum.

So:

```text
3 → Not Lucky
```

### Row 2

```text
[9, 11, 13]

Minimum = 9
Column = 0
```

Column 0:

```text
3
9
15
```

`9` is not the maximum.

So:

```text
9 → Not Lucky
```

### Row 3

```text
[15, 16, 17]

Minimum = 15
Column = 0
```

Column 0:

```text
3
9
15
```

`15` is the maximum.

Therefore:

```text
15 → Lucky Number
```

### Output

```text
[15]
```

---

## Java Solution

```java
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {

            int element = matrix[i][0];
            int column = 0;

            // Find minimum element in the row
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] < element) {
                    element = matrix[i][j];
                    column = j;
                }
            }

            // Check if it is maximum in the column
            int count = 0;

            for (int j = 0; j < matrix.length; j++) {

                if (element >= matrix[j][column]) {
                    count++;
                }
            }

            if (count == matrix.length) {
                result.add(element);
            }
        }

        return result;
    }
}
```

---

## Time Complexity

Let:

- `m` = number of rows
- `n` = number of columns

### Finding row minimums

For every row, we traverse all columns:

```text
O(m × n)
```

### Checking the selected column

For every row, we traverse one column:

```text
O(m × m)
= O(m²)
```

Therefore:

```text
Time Complexity = O(m × n + m²)
```

For a square matrix where `m = n`:

```text
O(n²)
```

---

## Space Complexity

**O(1)** auxiliary space.

Apart from the output list, only a few variables are used:

```text
element
column
count
i
j
```

Therefore:

```text
Auxiliary Space = O(1)
```

The result list itself can contain lucky numbers, so including the output:

```text
Output Space = O(min(m, n))
```

---

# Optimal Solution

We can improve the approach by finding:

1. The **minimum value of every row**.
2. The **maximum value of every column**.

Then we only need to check:

```text
matrix[i][j] == rowMin[i]
AND
matrix[i][j] == colMax[j]
```

This avoids scanning the selected column repeatedly.

### Optimized Java Solution

```java
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int[] rowMin = new int[m];
        int[] colMax = new int[n];

        // Find minimum of every row
        for (int i = 0; i < m; i++) {

            rowMin[i] = matrix[i][0];

            for (int j = 1; j < n; j++) {
                rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
            }
        }

        // Find maximum of every column
        for (int j = 0; j < n; j++) {

            colMax[j] = matrix[0][j];

            for (int i = 1; i < m; i++) {
                colMax[j] = Math.max(colMax[j], matrix[i][j]);
            }
        }

        // Find lucky numbers
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == rowMin[i] &&
                    matrix[i][j] == colMax[j]) {

                    result.add(matrix[i][j]);
                }
            }
        }

        return result;
    }
}
```

---

## Optimized Complexity

### Time Complexity

Finding row minimums:

```text
O(m × n)
```

Finding column maximums:

```text
O(m × n)
```

Checking the matrix:

```text
O(m × n)
```

Therefore:

```text
O(m × n) + O(m × n) + O(m × n)
= O(m × n)
```

**Time Complexity = O(m × n)**

---

### Space Complexity

We create:

```text
rowMin → O(m)
colMax → O(n)
```

Therefore:

```text
Space Complexity = O(m + n)
```

excluding the output list.

---

## Optimization Comparison

| Approach | Time | Auxiliary Space |
|---|---:|---:|
| My Solution | O(m × n + m²) | O(1) |
| Optimized | O(m × n) | O(m + n) |

### Trade-off

Your solution:

```text
Time:  O(m × n + m²)
Space: O(1)
```

Optimized solution:

```text
Time:  O(m × n)
Space: O(m + n)
```

So the optimized approach **uses more memory to reduce the time complexity**.

---

## Important Concept

The definition of a lucky number can be rewritten as:

```text
Lucky Number
     ↓
Minimum in its row
     AND
Maximum in its column
```

So think:

```text
Row → Minimum
Column → Maximum
```

This is the main pattern for this problem.

---

## Why Does Your `count` Work?

You used:

```java
if (element >= matrix[j][column]) {
    count++;
}
```

If `element` is greater than or equal to every element in that column:

```text
count == matrix.length
```

then it is the maximum element of that column.

So this:

```java
count == matrix.length
```

is effectively checking:

```text
element >= every value in the column
```

A simpler version would be:

```java
boolean isMax = true;

for (int j = 0; j < matrix.length; j++) {
    if (element < matrix[j][column]) {
        isMax = false;
        break;
    }
}
```

This also allows us to stop immediately when a larger value is found.

---

## Common Mistakes

- Finding the maximum in the row instead of the minimum.
- Finding the minimum in the column instead of the maximum.
- Losing the column index of the row minimum.
- Checking the wrong column.
- Forgetting that the lucky number must satisfy **both conditions**.

---


- How can row minimums and column maximums improve the solution?
- What is the space-time tradeoff between the two approaches?
- Why can there be at most `min(m, n)` lucky numbers?
