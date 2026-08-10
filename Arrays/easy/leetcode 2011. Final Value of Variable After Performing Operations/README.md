# 2011. Final Value of Variable After Performing Operations

https://leetcode.com/problems/final-value-of-variable-after-performing-operations/description/
## Difficulty

Easy

## Topic

- String
- Simulation

---

## Problem Summary

You are given an array of strings `operations`, where each operation is one of:

- `"++X"`
- `"X++"`
- `"--X"`
- `"X--"`

Initially, the value of `X` is `0`.

Increment `X` for `"++X"` and `"X++"`, and decrement `X` for `"--X"` and `"X--"`.

Return the final value of `X`.

---

## Approach

- Initialize `x = 0`.
- Traverse each operation in the array.
- Check the operation using string comparison.
- Increment or decrement `x` accordingly.
- Return the final value.

---

## Algorithm

1. Initialize `x = 0`.
2. Traverse the operations array.
3. If the operation is increment, increase `x`.
4. If the operation is decrement, decrease `x`.
5. Return `x`.

---

## Dry Run

### Input

```text
operations = ["--X","X++","X++"]
```

Initial

```text
x = 0
```

Iteration 1

```text
"--X"

x = -1
```

Iteration 2

```text
"X++"

x = 0
```

Iteration 3

```text
"X++"

x = 1
```

### Output

```text
1
```

---

## Java Solution

```java
class Solution {
    public int finalValueAfterOperations(String[] operations) {

        int x = 0;

        for (int i = 0; i < operations.length; i++) {

            String s = operations[i];

            if (s.equals("++X"))
                ++x;
            else if (s.equals("X++"))
                x++;
            else if (s.equals("--X"))
                --x;
            else if (s.equals("X--"))
                x--;
        }

        return x;
    }
}
```

---

## Time Complexity

**O(n)**

Where:

- `n` = Number of operations.

Each operation is checked exactly once.

---

## Space Complexity

**O(1)**

- No extra data structure is created.
- Only a single integer variable (`x`) is used.

---

## Optimal Solution

Instead of comparing all four possible strings, observe that the middle character determines the operation.

If the second character is `'+'`, increment `x`; otherwise, decrement `x`.

### Optimized Java Solution

```java
class Solution {
    public int finalValueAfterOperations(String[] operations) {

        int x = 0;

        for (String operation : operations) {

            if (operation.charAt(1) == '+')
                x++;
            else
                x--;
        }

        return x;
    }
}
```

---

## Optimized Complexity

### Time Complexity

**O(n)**

- Each operation is visited once.

### Space Complexity

**O(1)**

- Only one integer variable is used.
