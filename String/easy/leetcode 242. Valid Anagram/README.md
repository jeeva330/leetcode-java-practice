# 242. Valid Anagram
https://leetcode.com/problems/valid-anagram/description/
## Difficulty

Easy

## Topic

- String
- Array
- Hashing
- Frequency Counting

---

## Problem Summary

Given two strings `s` and `t`, determine whether `t` is an anagram of `s`.

Two strings are anagrams if they contain the same characters with the same frequencies, but the characters can appear in a different order.

Example:

```text
s = "anagram"
t = "nagaram"
```

Both strings contain the same characters with the same frequencies.

Therefore:

```text
true
```

---

## Approach

Use a frequency array of size `26` because the problem contains lowercase English letters.

- Increment the frequency for every character in `s`.
- Decrement the frequency for every character in `t`.
- If both strings are anagrams, every frequency should become `0`.
- If any value is not `0`, the strings are not anagrams.

---

## Algorithm

1. Check whether the lengths of `s` and `t` are equal.
2. If lengths are different, return `false`.
3. Create an integer array of size `26`.
4. Traverse `s` and increment the corresponding character count.
5. Traverse `t` and decrement the corresponding character count.
6. Check every position in the frequency array.
7. If any value is not `0`, return `false`.
8. Otherwise, return `true`.

---

## Dry Run

### Input

```text
s = "anagram"
t = "nagaram"
```

Frequency after processing `s`:

```text
a → 3
g → 1
m → 1
n → 1
r → 1
```

Then process `t` and decrease the corresponding frequencies.

After processing both strings:

```text
All frequencies = 0
```

Therefore:

```text
Output = true
```

---

## Java Solution

```java
class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                return false;
        }

        return true;
    }
}
```

---

## Time Complexity

**O(n)**

- First loop processes every character of `s` → `O(n)`.
- Second loop processes every character of `t` → `O(n)`.
- Final loop checks the fixed-size array of `26` elements → `O(26) = O(1)`.

Therefore:

```text
O(n) + O(n) + O(26)
= O(n)
```

**Time Complexity = O(n)**

---

## Space Complexity

**O(1)**

The frequency array always has exactly `26` elements:

```java
int[] arr = new int[26];
```

Since `26` is a constant:

```text
O(26) = O(1)
```

**Space Complexity = O(1)**

---

# Optimal Solution

**Is the current solution optimal?**

✅ Yes, for the given constraints.

Your frequency-array approach achieves:

```text
Time Complexity: O(n)
Space Complexity: O(1)
```

There is no need to use `HashMap` because the problem is restricted to lowercase English letters.

---

## Alternative Approach

Another common approach is sorting both strings.

Example:

```java
char[] a = s.toCharArray();
char[] b = t.toCharArray();

Arrays.sort(a);
Arrays.sort(b);

return Arrays.equals(a, b);
```

### Sorting Complexity

```text
Time Complexity: O(n log n)
Space Complexity: O(n)
```

Therefore, your frequency-array approach is better:

```text
Frequency Array → O(n)
Sorting          → O(n log n)
```

---

## Important Concept

This line:

```java
arr[s.charAt(i) - 'a']++;
```

converts a character into an array index.

Example:

```text
'a' - 'a' = 0
'b' - 'a' = 1
'c' - 'a' = 2
...
'z' - 'a' = 25
```

Therefore:

```text
'a' → index 0
'b' → index 1
...
'z' → index 25
```

This allows us to store the frequency of every lowercase letter.

---

## Why Do We Increment and Decrement?

For `s`:

```java
arr[s.charAt(i) - 'a']++;
```

For `t`:

```java
arr[t.charAt(i) - 'a']--;
```

If the strings contain exactly the same characters:

```text
Increment + Decrement = 0
```

Example:

```text
s = "aab"
t = "baa"
```

Frequency:

```text
a → +2 -2 = 0
b → +1 -1 = 0
```

All values become `0`, so they are anagrams.

---
