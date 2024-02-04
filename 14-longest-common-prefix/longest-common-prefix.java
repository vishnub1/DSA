public class TrieNode {
    TrieNode[] links = new TrieNode[26];
    boolean isEnd;
    int size;

    public TrieNode() { }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
        size++;
    }

    public int getLinks() {
        return size;
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        Trie trie = new Trie();
        for (int i = 0; i < strs.length; i++) {
            trie.insert(strs[i]);
        }
        return trie.searchLongestPrefix(strs[0]);
    }

    public class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // insert
        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch);
            }
            node.setEnd();
        }

        // Search longestPrefix
        public String searchLongestPrefix(String word) {
            TrieNode node = root;
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.getLinks() == 1 && !node.isEnd()) { // checking if one child is present
                    ans.append(ch);
                    node = node.get(ch);
                } else {
                    return ans.toString();
                }
            }
            return ans.toString();
        }
    }
}