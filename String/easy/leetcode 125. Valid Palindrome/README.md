# 125. Valid Palindrome

https://leetcode.com/problems/valid-palindrome/description/
## Difficulty

Easy

## Topic

- String
- Two Pointer
- Character Manipulation

---

## Problem Summary

Given a string `s`, determine whether it is a palindrome after:

- Converting uppercase letters to lowercase.
- Removing all non-alphanumeric characters.

A palindrome reads the same forward and backward.

---

## Approach

### My Approach

1. Convert the string to lowercase.
2. Traverse the string.
3. Keep only lowercase letters and digits.
4. Store the valid characters in a new string.
5. Use two pointers to compare characters from both ends.
6. If any characters are different, return `false`.
7. If all characters match, return `true`.

---

## Algorithm

1. Convert `s` to lowercase.
2. Create an empty string `a`.
3. Traverse every character of `s`.
4. Add the character to `a` if it is:
   - `a-z`
   - `0-9`
5. Set:
   - `left = 0`
   - `right = a.length() - 1`
6. Compare `a[left]` and `a[right]`.
7. Move `left` forward and `right` backward.
8. If a mismatch occurs, return `false`.
9. Otherwise, return `true`.

---

## Dry Run

### Input

```text
s = "A man, a plan, a canal: Panama"
```

After converting to lowercase:

```text
"a man, a plan, a canal: panama"
```

Remove non-alphanumeric characters:

```text
"amanaplanacanalpanama"
```

Now compare from both ends:

```text
a == a
m == m
a == a
n == n
...
```

All characters match.

### Output

```text
true
```

---

## Java Solution

```java
class Solution {
    public boolean isPalindrome(String s) {

        String a = "";

        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {

            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||
                (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {

                a += s.charAt(i);
            }
        }

        int left = 0;
        int right = a.length() - 1;

        while (left < right) {

            if (a.charAt(left) != a.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}
```

---

## Time Complexity

### Current Solution

**O(n²)** in the worst case.

The palindrome comparison itself takes `O(n)`, but:

```java
a += s.charAt(i);
```

is repeated many times.

Since Java `String` is immutable, repeated concatenation can create new strings repeatedly.

Therefore, the overall worst-case time can become:

```text
Time Complexity = O(n²)
```

---

## Space Complexity

**O(n)**

- A new string `a` is created to store the filtered characters.
- The size of `a` can be proportional to `n`.

```text
Space Complexity = O(n)
```

---

# Optimal Solution

We can avoid creating the filtered string completely.

Use **two pointers directly on the original string**:

- `left` starts from the beginning.
- `right` starts from the end.
- Skip non-alphanumeric characters.
- Compare the lowercase versions of the valid characters.

### Optimized Java Solution

```java
class Solution {
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
```

---

## Optimal Complexity

### Time Complexity

**O(n)**

- Each character is visited at most a constant number of times.
- `left` moves from left to right.
- `right` moves from right to left.

```text
Time Complexity = O(n)
```

### Space Complexity

**O(1)**

- No new string, array, or collection is created.
- Only `left` and `right` variables are used.

```text
Space Complexity = O(1)
```

---

## Optimization Comparison

| Approach | Time | Space |
|---|---:|---:|
| My Solution | O(n²) worst case | O(n) |
| Two-Pointer Optimized | O(n) | O(1) |

---
