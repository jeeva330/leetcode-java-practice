# 771. Jewels and Stones

https://leetcode.com/problems/jewels-and-stones/description/
## Difficulty

Easy

## Topic

- String
- String Searching

---

## Problem Summary

You are given two strings:

- `jewels` - characters that represent jewels.
- `stones` - characters that represent the stones you have.

Find how many characters in `stones` are also present in `jewels`.

Each character in `stones` is counted separately.

---

## Approach

- Traverse each character in the `stones` string.
- Check whether the current character exists in the `jewels` string.
- Use `indexOf()` to search for the character.
- If the character exists, increment `count`.
- Return the total count.

---

## Algorithm

1. Initialize `count = 0`.
2. Traverse every character in `stones`.
3. Check whether the current character exists in `jewels`.
4. If it exists, increment `count`.
5. Return `count`.

---

## Dry Run

### Input

```text
jewels = "aA"
stones = "aAAbbbb"
```

### Checking Each Character

```text
a → found in jewels → count = 1
A → found in jewels → count = 2
A → found in jewels → count = 3
b → not found
b → not found
b → not found
b → not found
```

### Output

```text
3
```

---

## Java Solution

```java
class Solution {
    public int numJewelsInStones(String jewels, String stones) {

        int count = 0;

        for (int i = 0; i < stones.length(); i++) {

            if (jewels.indexOf(stones.charAt(i)) > -1)
                count++;
        }

        return count;
    }
}
```

---

## Time Complexity

**O(n × m)**

Where:

- `n` = length of `stones`
- `m` = length of `jewels`

For every character in `stones`, `indexOf()` may search through the `jewels` string.

Therefore:

```text
Time Complexity = O(n × m)
```

However, since the problem constraints limit the number of possible characters, `m` is very small. In practice, this solution is very efficient.

---

## Space Complexity

**O(1)**

- No additional array, list, or data structure is created.
- Only the `count` variable and loop variable are used.

```text
Space Complexity = O(1)
```

---

## Optimal Solution

**Is the current solution optimal?**

### Time Complexity

For the given constraints, your solution is effectively efficient because `jewels` contains only a small number of distinct characters.

A `HashSet` can provide average `O(1)` lookup, giving:

```text
O(n + m)
```

time complexity.

### HashSet Approach

```java
class Solution {
    public int numJewelsInStones(String jewels, String stones) {

        Set<Character> jewelSet = new HashSet<>();

        for (char jewel : jewels.toCharArray()) {
            jewelSet.add(jewel);
        }

        int count = 0;

        for (char stone : stones.toCharArray()) {
            if (jewelSet.contains(stone))
                count++;
        }

        return count;
    }
}
```

### HashSet Complexity

```text
Time Complexity: O(n + m)
Space Complexity: O(m)
```

Where:

- `n` = number of stones
- `m` = number of jewels

---

## Key Learning

- `String.charAt()` is used to access a character at a specific index.
- `String.indexOf()` can be used to search for a character inside a string.
- Each occurrence in `stones` must be counted separately.
- Character matching is case-sensitive.

---

## Important Concept

These are different characters:

```text
'a'
'A'
```

For example:

```text
jewels = "a"
stones = "Aa"
```

Only lowercase `'a'` is a jewel.

Output:

```text
1
```

---
