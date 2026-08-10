# 1108. Defanging an IP Address

## Difficulty

Easy

## Topic

- String
- String Manipulation
- `replace()`

---

## Problem Summary

Given a valid IPv4 address, replace every `.` character with `[.]`.

For example:

```text
1.1.1.1
```

becomes:

```text
1[.]1[.]1[.]1
```

---

## Approach

- Use Java's `replace()` method.
- Replace every `.` character with `[.]`.
- Return the modified string.

---

## Algorithm

1. Take the given IP address.
2. Find every `.` character.
3. Replace each `.` with `[.]`.
4. Return the resulting string.

---

## Dry Run

### Input

```text
address = "1.1.1.1"
```

Replace:

```text
"." → "[.]"
```

Step by step:

```text
1.1.1.1
↓
1[.]1[.]1[.]1
```

### Output

```text
"1[.]1[.]1[.]1"
```

---

## Java Solution

```java
class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
```

---

## Time Complexity

**O(n)**

- `n` = length of the IP address.
- The string is traversed to find and replace the `.` characters.

```text
Time Complexity = O(n)
```

---

## Space Complexity

**O(n)**

- Java strings are immutable.
- `replace()` creates a new string containing the modified result.
- Therefore, the resulting string requires space proportional to the input size.

```text
Space Complexity = O(n)
```

---

## Optimal Solution

**Is the current solution optimal?**

✅ Yes, for this problem.

The `replace()` method provides a direct and simple way to perform the required string transformation.

```text
Time Complexity: O(n)
Space Complexity: O(n)
```

There is no need to manually traverse the string unless the problem specifically requires you to implement the replacement logic yourself.

---
