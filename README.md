# Anagram Grouping Kata (Java 17)

This kata implements a function that groups a list of words into **anagram clusters**.

Two words are anagrams if they contain the **same letters with the same frequencies**, only in a different order.

The solution groups words by a shared **signature** (e.g., sorted characters), then applies ordering rules:

- **Within each group**: words are sorted in **alphabetical order** (ascending)
- **Across groups**: groups are sorted by their **first element** (after sorting each group)

**Function signature**
`List<List<String>> groupAnagrams(List<String> words)`
