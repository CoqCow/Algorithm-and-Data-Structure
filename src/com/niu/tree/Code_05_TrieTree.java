package com.niu.tree;

import java.util.HashMap;

public class Code_05_TrieTree {
    public static class TreeNode {
        public int path;
        public int end;
        public HashMap<Character, TreeNode> hashMap;

        public TreeNode() {
            hashMap = new HashMap<>();
            path = 0;
            end = 0;
        }
    }

    public static class Trie {
        private TreeNode root;

        public Trie() {
            root = new TreeNode();
        }

        public void insert(String word) {
            if (word == null) return;
            char[] chars = word.toCharArray();
            TreeNode node = root;
            for (int i = 0; i < chars.length; i++) {
                if (node.hashMap.get(chars[i]) == null) {
                    node.hashMap.put(chars[i], new TreeNode());
                }
                node = node.hashMap.get(chars[i]);
                node.path++;
            }
            node.end++;
        }

        public int search(String word) {
            if (word == null) return 0;
            TreeNode node = root;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (node.hashMap.get(chars[i]) == null) {
                    return 0;
                }
                node = node.hashMap.get(chars[i]);
            }

            return node.end;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                TreeNode node = root;
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (--node.hashMap.get(chars[i]).path == 0) {
                        node.hashMap.remove(chars[i]);
                        return;
                    }
                    node = node.hashMap.get(chars[i]);
                }
                node.end--;
            }
        }

        public int prefixNumber(String pre) {
            if (pre == null) return 0;
            TreeNode node = root;
            char[] chars = pre.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (node.hashMap.get(chars[i]) == null) {
                    return 0;
                }
                node = node.hashMap.get(chars[i]);
            }
            return node.path;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNumber("zuo"));
    }
}
