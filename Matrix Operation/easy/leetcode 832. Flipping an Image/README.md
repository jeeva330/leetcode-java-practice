# 832. Flipping an Image

**LeetCode:** [Flipping an Image – LeetCode](https://leetcode.com/problems/flipping-an-image/description/?utm_source=chatgpt.com)

**Difficulty:** Easy

**Topics:** Array, Matrix, Two Pointers, Simulation, Bit Manipulation

---

## Problem Summary

Given an `n x n` binary matrix, perform two operations on every row:

1. **Flip** the row horizontally.
2. **Invert** every value:

   * `0 → 1`
   * `1 → 0`

Return the resulting matrix.

---

## Approach

I processed the matrix **row by row**.

For each row:

1. Used **two pointers**, `start` and `end`, to reverse the row.
2. Swapped the elements from both ends until the pointers met.
3. Traversed the row again and inverted every element:

   * If it is `0`, change it to `1`.
   * Otherwise, change it to `0`.

Finally, returned the modified matrix.

---

## Algorithm

1. Iterate through every row.
2. Set:

   * `start = 0`
   * `end = last column`
3. While `start < end`:

   * Swap `image[i][start]` and `image[i][end]`.
   * Increment `start`.
   * Decrement `end`.
4. Traverse the row again.
5. Invert each element:

   * `0 → 1`
   * `1 → 0`
6. Return the modified matrix.

---

## Dry Run

### Input

```text
image =
[
  [1,1,0],
  [1,0,1],
  [0,0,0]
]
```

### Row 1

Original:

```text
[1,1,0]
```

Flip:

```text
[0,1,1]
```

Invert:

```text
[1,0,0]
```

### Row 2

Original:

```text
[1,0,1]
```

Flip:

```text
[1,0,1]
```

Invert:

```text
[0,1,0]
```

### Row 3

Original:

```text
[0,0,0]
```

Flip:

```text
[0,0,0]
```

Invert:

```text
[1,1,1]
```

### Output

```text
[
  [1,0,0],
  [0,1,0],
  [1,1,1]
]
```

---

## My Solution

```java
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        for(int i=0; i<image.length; i++){

            int start = 0;
            int end = image[0].length - 1;

            while(start < end){

                int num = image[i][start];
                image[i][start] = image[i][end];
                image[i][end] = num;

                start++;
                end--;
            }

            for(int j=0; j<image[0].length; j++){
                if(image[i][j] == 0)
                    image[i][j] = 1;
                else
                    image[i][j] = 0;
            }
        }

        return image;
    }
}
```

---

## Time Complexity

Let the matrix contain `m × n` elements.

* Flipping each row: **O(m × n)**
* Inverting each element: **O(m × n)**

Therefore:

**Time Complexity: O(m × n)**

---

## Space Complexity

The matrix is modified **in-place**.

**Auxiliary Space: O(1)**

The returned matrix itself requires **O(m × n)** space, but this is the input/output matrix rather than additional working space.

---

## Optimal Solution

We can combine **flipping and inversion into the same two-pointer loop**.

Instead of:

```text
1. Flip
2. Traverse again
3. Invert
```

we can do both operations while swapping.

For binary values, we need:

```text
new left  = 1 - old right
new right = 1 - old left
```

### Optimized Code

```java
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        for(int i = 0; i < image.length; i++){

            int start = 0;
            int end = image[i].length - 1;

            while(start <= end){

                int temp = image[i][start];

                image[i][start] = 1 - image[i][end];
                image[i][end] = 1 - temp;

                start++;
                end--;
            }
        }

        return image;
    }
}
```

### Complexity

**Time:** O(m × n)

**Space:** O(1)

The optimized solution has the **same Big-O time complexity**, but avoids the second traversal of every row and combines both operations into one pass.

---

## Key Learning

### 1. Two Pointer Technique

For reversing an array or row:

```java
int start = 0;
int end = length - 1;

while(start < end) {
    // swap
    start++;
    end--;
}
```

### 2. Binary Inversion

For a binary value:

```java
0 → 1
1 → 0
```

we can use:

```java
1 - value
```

Example:

```text
1 - 0 = 1
1 - 1 = 0
```

### 3. In-Place Modification

The matrix can be modified directly without creating another matrix, giving:

```text
O(1) auxiliary space
```

### 4. Combining Operations

When a problem asks for multiple transformations, check whether they can be performed in **one traversal** instead of making separate passes.

---

## Common Mistakes

* Forgetting to invert the values after flipping.
* Using `start < end` without handling the middle element during the combined optimized approach.
* Creating an unnecessary second matrix.
* Using the wrong last index:

  ```java
  image[i].length - 1
  ```
* Confusing **flip** with **invert**:

  * Flip → reverse the order.
  * Invert → change `0 ↔ 1`.

---

## Interview Keywords

* Two Pointers
* Matrix
* Array
* In-Place
* Simulation
* Binary Matrix
* Reverse Array
* Bit Manipulation
* Space Optimization

---

## Revision Questions

1. What is the difference between flipping and inverting?
2. Why are two pointers useful for reversing a row?
3. What is the time complexity of this solution?
4. Why is the auxiliary space O(1)?
5. How can flipping and inversion be performed in one pass?
6. Why does `1 - value` invert a binary value?
7. Why do we use `image[i].length - 1` for the last column?
8. What happens to the middle element when the row has an odd number of elements?

---

## Quick Revision

```text
Problem: Flipping an Image

1. Process each row.
2. Reverse the row using two pointers.
3. Invert every binary value.
4. Modify the matrix in-place.

Basic approach:
Flip → Invert

Optimized approach:
Flip + Invert together

Time:  O(m × n)
Space: O(1) auxiliary

Binary inversion:
1 - 0 = 1
1 - 1 = 0
```
