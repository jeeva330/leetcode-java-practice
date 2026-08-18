# 202. Happy Number

https://leetcode.com/problems/happy-number/description/
## Difficulty

Easy

## Topic

- Math
- HashSet
- Cycle Detection
- Digit Manipulation

---

## Problem Summary

A happy number is a number that eventually becomes `1` when repeatedly replaced by the sum of the squares of its digits.

If the process enters a cycle and never reaches `1`, the number is not a happy number.

Example:

```text
19

1² + 9² = 82
8² + 2² = 68
6² + 8² = 100
1² + 0² + 0² = 1
```

Therefore:

```text
19 is a Happy Number
```

---

## Approach

- Use a `HashSet` to store numbers that have already appeared.
- Repeatedly calculate the sum of the squares of the digits.
- If the result becomes `1`, return `true`.
- If a number appears again, a cycle exists, so return `false`.

---

## Algorithm

1. Create an empty `HashSet`.
2. Start with `num = n`.
3. Continue while `num != 1`.
4. Check whether `num` already exists in the set.
5. If it exists, a cycle is detected → return `false`.
6. Add `num` to the set.
7. Extract each digit using `% 10`.
8. Add the square of each digit to `total`.
9. Set `num = total`.
10. Repeat until `num == 1`.
11. Return `true`.

---

## Dry Run

### Input

```text
n = 19
```

### Step 1

```text
19

1² + 9²
= 1 + 81
= 82
```

```text
num = 82
HashSet = {19}
```

### Step 2

```text
82

8² + 2²
= 64 + 4
= 68
```

```text
num = 68
HashSet = {19, 82}
```

### Step 3

```text
68

6² + 8²
= 36 + 64
= 100
```

### Step 4

```text
100

1² + 0² + 0²
= 1
```

Therefore:

```text
Output = true
```

---

## Cycle Example

### Input

```text
n = 2
```

The sequence eventually becomes:

```text
2 → 4 → 16 → 37 → 58 → 89
→ 145 → 42 → 20 → 4 → ...
```

`4` appears again.

Therefore, a cycle exists:

```text
Output = false
```

The `HashSet` detects this repeated value.

---

## Java Solution

```java
class Solution {
    public boolean isHappy(int n) {

        int num = n;
        HashSet<Integer> hs = new HashSet<>();

        while (num != 1) {

            if (hs.contains(num))
                return false;

            hs.add(num);

            int total = 0;

            while (num > 0) {
                int digit = num % 10;
                total += digit * digit;
                num /= 10;
            }

            num = total;
        }

        return true;
    }
}
```

---

## Time Complexity

**O(log n)**

Let `d` be the number of digits in `n`.

- Extracting the digits of a number takes `O(d)`.
- Each transformation reduces the number to the sum of the squares of its digits.
- After the first transformation, the values become much smaller and eventually enter either `1` or a cycle.
- The `HashSet` provides average `O(1)` lookup and insertion.

Therefore, under the standard analysis:

```text
Time Complexity = O(log n)
```

---

## Space Complexity

**O(log n)**

- The `HashSet` stores previously encountered numbers.
- The number of distinct states that need to be stored grows with the number of digits.

Therefore:

```text
Space Complexity = O(log n)
```

---

## Optimization

**Is the current approach optimal?**

### Your approach

```text
HashSet + Cycle Detection
```

is a good and straightforward solution.

However, there is another approach that detects the cycle using **Floyd's Cycle Detection Algorithm (Slow and Fast Pointers)** without using a `HashSet`.

### Floyd's Cycle Detection

```java
class Solution {

    private int getNext(int n) {

        int total = 0;

        while (n > 0) {
            int digit = n % 10;
            total += digit * digit;
            n /= 10;
        }

        return total;
    }

    public boolean isHappy(int n) {

        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }
}
```

### Floyd's Complexity

```text
Time Complexity: O(log n)
Space Complexity: O(1)
```

So the comparison is:

| Approach | Time | Space |
|---|---:|---:|
| HashSet | O(log n) | O(log n) |
| Floyd Cycle Detection | O(log n) | O(1) |

---

## Key Learning

- Use a `HashSet` to detect repeated states.
- Repeated values indicate a cycle.
- `% 10` extracts the last digit.
- `/ 10` removes the last digit.
- This is a **cycle detection** problem disguised as a digit-manipulation problem.

---

## Important Code Observation

Your original code contains:

```java
int len = (int)Math.log10(n) + 1;
```

and later:

```java
len = (int)Math.log10(total) + 1;
```

But `len` is never used anywhere in the algorithm.

Therefore, it can be safely removed.

You also don't need:

```java
System.out.println(...)
```

comments in your final GitHub solution.

---

- How does `/ 10` remove a digit?
- Why can the process not continue forever without either reaching `1` or entering a cycle?
- How can Floyd's Cycle Detection reduce the space complexity to `O(1)`?
