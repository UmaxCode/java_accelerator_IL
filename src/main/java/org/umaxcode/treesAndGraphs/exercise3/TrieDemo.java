package org.umaxcode.treesAndGraphs.exercise3;

public class TrieDemo {

    public static void main(String[] args) {

        Trie trie = new Trie();

        // Insert words into the Trie
        trie.insert("apple");
        trie.insert("app");
        trie.insert("ape");
        trie.insert("apricot");
        trie.insert("bat");
        trie.insert("ball");
        trie.insert("banana");

        // Test search
        System.out.println("Search 'apple': " + trie.search("apple")); // true
        System.out.println("Search 'app': " + trie.search("app")); // true
        System.out.println("Search 'appl': " + trie.search("appl")); // false

        // Test prefix
        System.out.println("Starts with 'ap': " + trie.startsWith("ap")); // true
        System.out.println("Starts with 'bat': " + trie.startsWith("bat")); // true
        System.out.println("Starts with 'cat': " + trie.startsWith("cat")); // false

        // Retrieve words with a prefix
        System.out.println("Words starting with 'ap': " + trie.getWordsStartingWith("ap"));
        System.out.println("Words starting with 'ba': " + trie.getWordsStartingWith("ba"));
        System.out.println("Words starting with 'cat': " + trie.getWordsStartingWith("cat"));
    }
}
