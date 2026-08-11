# 709. To Lower Case

https://leetcode.com/problems/to-lower-case/description/
## Difficulty

Easy

## Topic

- String
- String Manipulation
- `toLowerCase()`

---

## Problem Summary

Given a string `s`, convert all uppercase English letters in the string to lowercase and return the resulting string.

---

## Approach

- Use Java's built-in `toLowerCase()` method.
- The method converts uppercase characters to lowercase.
- Return the resulting string.

---

## Algorithm

1. Take the given string `s`.
2. Apply the `toLowerCase()` method.
3. Return the converted string.

---

## Dry Run

### Input

```text
s = "Hello"
```

Apply:

```java
s.toLowerCase()
```

Result:

```text
"hello"
```

### Output

```text
"hello"
```

---

## Java Solution

```java
class Solution {
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
}
```

---

## Time Complexity

**O(n)**

- `n` = length of the string.
- Each character may need to be checked and converted.

```text
Time Complexity = O(n)
```

---

## Space Complexity

**O(n)**

- Java `String` objects are immutable.
- `toLowerCase()` returns a new string.
- Therefore, the resulting string requires space proportional to the input length.

```text
Space Complexity = O(n)
```

---

## Optimal Solution

**Is the current solution optimal?**

✅ Yes, for practical Java usage.

The built-in `toLowerCase()` method directly performs the required operation in a clean and readable way.

```text
Time Complexity: O(n)
Space Complexity: O(n)
```

---

## Alternative Approach

If the problem requires implementing the conversion manually without using `toLowerCase()`, we can use character manipulation.

For English uppercase letters:

```text
'A' → 'a'
'B' → 'b'
...
'Z' → 'z'
```

The difference between uppercase and lowercase ASCII values is:

```text
'a' - 'A' = 32
```

Example:

```java
class Solution {
    public String toLowerCase(String s) {

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] = (char)(arr[i] + 32);
            }
        }

        return new String(arr);
    }
}
```

### Alternative Complexity

```text
Time Complexity: O(n)
Space Complexity: O(n)
```

The `char[]` requires `O(n)` space and the resulting `String` also requires space.

---
