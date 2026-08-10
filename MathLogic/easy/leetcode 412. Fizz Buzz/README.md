# 412. Fizz Buzz

https://leetcode.com/problems/fizz-buzz/description/
## Difficulty

Easy

## Topic

- Array
- String
- Simulation
- Modulo Operator

---

## Problem Summary

Given an integer `n`, return a list of strings containing the numbers from `1` to `n`.

For each number:

- If divisible by both `3` and `5`, add `"FizzBuzz"`.
- If divisible by `3`, add `"Fizz"`.
- If divisible by `5`, add `"Buzz"`.
- Otherwise, add the number itself as a string.

---

## Approach

- Create an empty `List<String>` to store the result.
- Traverse numbers from `1` to `n`.
- Check divisibility using the modulo `%` operator.
- Add the appropriate string to the list.
- Return the list.

---

## Algorithm

1. Initialize an empty `List<String>`.
2. Loop from `1` to `n`.
3. Check if the number is divisible by both `3` and `5`.
4. Otherwise, check if it is divisible by `3`.
5. Otherwise, check if it is divisible by `5`.
6. If none of the conditions match, add the number as a string.
7. Return the list.

---

## Dry Run

### Input

```text
n = 15
```

| Number | Condition | Result |
|---:|---|---|
| 1 | None | `"1"` |
| 2 | None | `"2"` |
| 3 | Divisible by 3 | `"Fizz"` |
| 4 | None | `"4"` |
| 5 | Divisible by 5 | `"Buzz"` |
| 6 | Divisible by 3 | `"Fizz"` |
| 7 | None | `"7"` |
| 8 | None | `"8"` |
| 9 | Divisible by 3 | `"Fizz"` |
| 10 | Divisible by 5 | `"Buzz"` |
| 11 | None | `"11"` |
| 12 | Divisible by 3 | `"Fizz"` |
| 13 | None | `"13"` |
| 14 | None | `"14"` |
| 15 | Divisible by 3 and 5 | `"FizzBuzz"` |

### Output

```text
["1","2","Fizz","4","Buzz","Fizz","7","8",
 "Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
```

---



---

## Time Complexity

**O(n)**

- The loop runs from `1` to `n`.
- Each number is processed once.
- The modulo and comparison operations take constant time.

Therefore:

```text
Time Complexity = O(n)
```

---

## Space Complexity

**O(n)**

- The result `List<String>` stores `n` elements.
- Therefore, the output requires space proportional to `n`.

```text
Space Complexity = O(n)
```

> Note: The **auxiliary space excluding the output** is `O(1)`, because only a few variables are used.

---

## Optimal Solution

**Is the current solution optimal?**

✅ **Yes, asymptotically.**

The problem requires returning `n` results, so we must process and store `n` elements.

```text
Time Complexity: O(n)
Space Complexity: O(n)
Auxiliary Space: O(1)
```

There is no meaningful Big-O improvement over this approach.

---

## Key Learning

- Using the modulo `%` operator to check divisibility.
- Handling multiple conditions using `if-else if`.
- Checking the combined condition (`3 and 5`) before individual conditions.
- Converting an integer to a string using `Integer.toString()`.

---

## Important Point

The order of the conditions matters.

Correct:

```java
if (i % 3 == 0 && i % 5 == 0)
```

must be checked **before**:

```java
else if (i % 3 == 0)
```

and:

```java
else if (i % 5 == 0)
```

Otherwise, `15` would be identified as `"Fizz"` before reaching `"FizzBuzz"`.

---

## Common Mistakes

- Checking `i % 3 == 0` before the `FizzBuzz` condition.
- Using `i < n` instead of `i <= n`.
- Forgetting to convert normal numbers to strings.
- Forgetting to return the result list.

---
