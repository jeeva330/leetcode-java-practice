# 557. Reverse Words in a String III

https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
## Difficulty

Easy

## Topic

- String
- Array
- Two Pointer
- StringBuilder

---

## Problem Summary

Given a string `s` containing words separated by spaces, reverse the characters of every word while keeping the order of the words unchanged.

For example:

```text
"Let's take LeetCode contest"
```

becomes:

```text
"s'teL ekat edoCteeL tsetnoc"
```

---

## Approach

- Split the sentence into individual words using `" "`.
- Traverse each word.
- Convert the word into a character array.
- Use two pointers to reverse the characters of the word.
- Add the reversed word to the result.
- Return the final string.

---

## Algorithm

1. Split the string using spaces.
2. Traverse each word.
3. Convert the word into a character array.
4. Initialize:
   - `left = 0`
   - `right = length - 1`
5. Swap characters while `left < right`.
6. Convert the reversed character array back into a string.
7. Add it to the result.
8. Return the final string.

---

## Dry Run

### Input

```text
s = "Let's take LeetCode contest"
```

Split:

```text
["Let's", "take", "LeetCode", "contest"]
```

Reverse each word:

```text
Let's      → s'teL
take       → ekat
LeetCode   → edoCteeL
contest    → tsetnoc
```

### Output

```text
"s'teL ekat edoCteeL tsetnoc"
```

---

## Java Solution

```java
class Solution {
    public String reverseWords(String s) {

        String a[] = s.split(" ");
        String result = "";

        for (int i = 0; i < a.length; i++) {

            char arr[] = a[i].toCharArray();

            int left = 0;
            int right = arr.length - 1;

            while (left < right) {

                char c = arr[left];
                arr[left] = arr[right];
                arr[right] = c;

                left++;
                right--;
            }

            String res = "";

            for (int j = 0; j < arr.length; j++) {
                res += arr[j];
            }

            result += res + " ";
        }

        return result.substring(0, result.length() - 1);
    }
}
```

---

## Time Complexity

### Current Solution

**O(n²)** in the worst case.

Although each word is reversed in linear time, the repeated use of:

```java
res += arr[j];
```

and:

```java
result += res + " ";
```

can repeatedly create new `String` objects because Java `String` objects are immutable.

Therefore, repeated string concatenation can make the overall solution **O(n²)** in the worst case.

---

## Space Complexity

**O(n)**

- `split()` creates an array of words.
- Character arrays are created for the words.
- The result string also requires space proportional to the input.
- Therefore, the overall space usage is proportional to the input size.

---

# Optimal Solution

Instead of repeatedly concatenating strings using `+=`, use `StringBuilder`.

`StringBuilder` is mutable, so characters can be appended without creating a new `String` for every concatenation.

```java
class Solution {
    public String reverseWords(String s) {

        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            char[] arr = words[i].toCharArray();

            int left = 0;
            int right = arr.length - 1;

            while (left < right) {

                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }

            result.append(arr);

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
```

---

## Optimal Complexity

### Time Complexity

**O(n)**

Where `n` is the total number of characters in the input string.

- Splitting the string → `O(n)`
- Reversing all characters → `O(n)`
- Building the result using `StringBuilder` → `O(n)`

Therefore:

```text
Time Complexity = O(n)
```

---

### Space Complexity

**O(n)**

- `split()` creates the words.
- Character arrays and the `StringBuilder` require space proportional to the input.

```text
Space Complexity = O(n)
```

---

## Optimization Comparison

| Approach | Time | Space |
|---|---:|---:|
| Current solution | O(n²) worst case | O(n) |
| StringBuilder solution | O(n) | O(n) |

---


