# 1672. Richest Customer Wealth

https://leetcode.com/problems/richest-customer-wealth/description/
## Difficulty

Easy

## Topic

- Array
- Matrix (2D Array)

---

## Problem Summary

You are given a 2D integer array `accounts`, where each row represents a customer and each column represents the amount of money in a bank account.

Return the maximum wealth among all customers.

Customer Wealth = Sum of all bank accounts of that customer.

---

## Approach

- Traverse each customer (row) in the matrix.
- Calculate the total wealth by summing all bank account values.
- Compare the current customer's wealth with the maximum wealth found so far.
- Return the maximum wealth.

---

## Algorithm

1. Initialize `max = 0`.
2. Traverse each row of the matrix.
3. Calculate the sum of each row.
4. Update `max` if the current sum is greater.
5. Return `max`.

---

## Dry Run

### Input

```text
accounts = [[1,2,3],
            [3,2,1]]
```

Customer 1

```text
1 + 2 + 3 = 6

max = 6
```

Customer 2

```text
3 + 2 + 1 = 6

max = 6
```

### Output

```text
6
```


---

## Time Complexity

**O(m × n)**

- `m` = Number of customers (rows)
- `n` = Number of bank accounts (columns)
- Every element in the matrix is visited exactly once.

---

## Space Complexity

**O(1)**

- No extra data structure is used.
- Only two variables (`sum` and `max`) are maintained.

---
