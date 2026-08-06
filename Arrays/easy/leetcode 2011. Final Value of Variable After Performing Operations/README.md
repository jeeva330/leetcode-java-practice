# 2114. Maximum Number of Words Found in Sentences

## Difficulty

Easy

## Topic

- String
- Array

---

## Problem Summary

You are given an array of strings `sentences`, where each string represents a sentence.

Return the maximum number of words present in a single sentence.

Words are separated by a single space.

---

## Approach

- Traverse each sentence in the array.
- Split the sentence using `" "` as the delimiter.
- Count the number of words using the length of the resulting array.
- Keep track of the maximum word count.
- Return the maximum value.

---

## Algorithm

1. Initialize `max = 0`.
2. Traverse every sentence.
3. Split the sentence using `" "`.
4. Compare the number of words with `max`.
5. Update `max` if needed.
6. Return `max`.

---

## Dry Run

### Input

```text
sentences = [
"I love programming",
"Java is awesome",
"LeetCode is fun"
]
```

Sentence 1

```text
Split -> ["I","love","programming"]

Words = 3

max = 3
```

Sentence 2

```text
Split -> ["Java","is","awesome"]

Words = 3

max = 3
```

Sentence 3

```text
Split -> ["LeetCode","is","fun"]

Words = 3

max = 3
```

### Output

```text
3
```

---

## Java Solution

```java
class Solution {
    public int mostWordsFound(String[] sentences) {

        int max = 0;

        for (int i = 0; i < sentences.length; i++) {

            String[] arr = sentences[i].split(" ");

            if (arr.length > max)
                max = arr.length;
        }

        return max;
    }
}
```

---

## Time Complexity

**O(n × m)**

Where:

- `n` = Number of sentences.
- `m` = Average length of each sentence.

Each sentence is scanned while performing `split()`, making the total time complexity **O(n × m)**.

---

## Space Complexity

**O(m)**

- `split()` creates a new array of words.
- The extra space depends on the number of words in the current sentence.

Therefore,

**Space Complexity = O(m)**

---

## Optimal Solution

Instead of using `split()`, count the number of spaces in each sentence.

Since:

```
Number of Words = Number of Spaces + 1
```

This avoids creating an extra array and reduces memory usage.

### Optimized Java Solution

```java
class Solution {
    public int mostWordsFound(String[] sentences) {

        int max = 0;

        for (String sentence : sentences) {

            int words = 1;

            for (char ch : sentence.toCharArray()) {
                if (ch == ' ')
                    words++;
            }

            max = Math.max(max, words);
        }

        return max;
    }
}
```

### Optimized Complexity

**Time Complexity:** `O(n × m)`

- Every character is visited once.

**Space Complexity:** `O(1)`

- No extra array is created.
- Only a few variables are used.
