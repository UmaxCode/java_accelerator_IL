package org.umaxcode.treesAndGraphs.exercise3;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isEndOfWord = true;
    }

    // Check if a word exists in the Trie
    public boolean search(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return current.isEndOfWord;
    }

    // Check if a prefix exists in the Trie
    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for (char c : prefix.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return true;
    }

    // Retrieve all words that start with a given prefix
    public List<String> getWordsStartingWith(String prefix) {
        TrieNode current = root;

        for (char c : prefix.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return new ArrayList<>(); // Return an empty list if prefix not found
            }
            current = current.children.get(c);
        }

        // Perform a DFS to collect all words starting from the current node
        List<String> result = new ArrayList<>();
        collectWords(current, new StringBuilder(prefix), result);
        return result;
    }

    // Helper method to perform DFS and collect words
    private void collectWords(TrieNode node, StringBuilder prefix, List<String> result) {
        if (node.isEndOfWord) {
            result.add(prefix.toString());
        }

        for (char c : node.children.keySet()) {
            prefix.append(c);
            collectWords(node.children.get(c), prefix, result);
            prefix.deleteCharAt(prefix.length() - 1); // Backtrack
        }
    }
}
