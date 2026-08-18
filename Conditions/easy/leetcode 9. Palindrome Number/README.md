# 9. Palindrome Number

https://leetcode.com/problems/palindrome-number/description/
## Difficulty

Easy

## Topic

- Math
- String
- Two Pointer
- Number Manipulation

---

## Problem Summary

Given an integer `x`, determine whether it reads the same from left to right and right to left.

A number is a palindrome if it remains the same when its digits are reversed.

Examples:

```text
121 → true
123 → false
```

---

## Approach

### My Approach

- Convert the integer into a `String`.
- Use two pointers:
  - `start` at the beginning.
  - `end` at the end.
- Compare the characters at both positions.
- Move both pointers toward the center.
- Count the number of matching pairs.
- If all pairs match, return `true`.

---

## Algorithm

1. Convert `x` into a string.
2. Set `start = 0`.
3. Set `end = length - 1`.
4. Compare `s.charAt(start)` and `s.charAt(end)`.
5. If they are equal, continue.
6. If they are different, the number is not a palindrome.
7. Move `start++` and `end--`.
8. Return the result.

---

## Dry Run

### Input

```text
x = 121
```

Convert to string:

```text
"121"
```

Comparison:

```text
s[0] = '1'
s[2] = '1'

Match
```

Move pointers:

```text
start = 1
end = 1
```

Loop ends.

```text
Output = true
```

---

## Java Solution

```java
class Solution {
    public boolean isPalindrome(int x) {

        String s = Integer.toString(x);

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {

            if (s.charAt(start) != s.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }
}
```

---

## Time Complexity

**O(n)**

Where `n` is the number of digits in `x`.

- Converting the number to a string takes `O(n)`.
- The two-pointer comparison takes `O(n)`.
- Therefore, the overall complexity is:

```text
Time Complexity = O(n)
```

---

## Space Complexity

**O(n)**

- The integer is converted into a `String`.
- The string requires space proportional to the number of digits.

```text
Space Complexity = O(n)
```

---

# Optimal Solution

We can solve the problem without converting the number to a string.

Instead, reverse the digits mathematically and compare the reversed number with the original number.

For example:

```text
x = 121

reverse = 0

1 → reverse = 1
2 → reverse = 12
1 → reverse = 121
```

Then:

```text
121 == 121
```

Therefore, it is a palindrome.

### Optimized Java Solution

```java
class Solution {
    public boolean isPalindrome(int x) {

        if (x < 0)
            return false;

        int original = x;
        int reverse = 0;

        while (x > 0) {

            int digit = x % 10;

            reverse = reverse * 10 + digit;

            x /= 10;
        }

        return original == reverse;
    }
}
```

---

## Optimized Complexity

### Time Complexity

**O(n)**

- Every digit is processed once.

```text
Time Complexity = O(n)
```

### Space Complexity

**O(1)**

- Only a few integer variables are used.
- No additional string, array, or collection is created.

```text
Space Complexity = O(1)
```

---

## Optimization Comparison

| Approach | Time | Space |
|---|---:|---:|
| String + Two Pointer | O(n) | O(n) |
| Mathematical Reversal | O(n) | O(1) |

---

