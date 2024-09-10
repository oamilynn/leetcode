package com.leetcode.grind75.week4;

import java.util.*;

public class ImplementTrie_208 {

    // TODO: make faster
    class Trie {

        private Map<Character, Trie> children = new HashMap(28);
        private boolean isTerminal = false;

        public Trie() {
        }

        public void insert(String word) {
            Map<Character, Trie> nodeChildren = children;
            Trie child = this;
            for (char c: word.toCharArray()) {
                child = nodeChildren.get(c);
                if (child == null) {
                    child = new Trie();
                    nodeChildren.put(c, child);
                }
                nodeChildren = child.children;
            }
            child.isTerminal = true;
        }

        public boolean search(String word) {
            Map<Character, Trie> nodeChildren = children;
            Trie child = this;
            for (char c: word.toCharArray()) {
                child = nodeChildren.get(c);
                if (child == null) {
                    return false;
                }
                nodeChildren = child.children;
            }
            return child.isTerminal;
        }

        public boolean startsWith(String prefix) {
            Map<Character, Trie> nodeChildren = children;
            Trie child = this;
            for (char c: prefix.toCharArray()) {
                child = nodeChildren.get(c);
                if (child == null) {
                    return false;
                }
                nodeChildren = child.children;
            }
            return true;
        }

    }
}
