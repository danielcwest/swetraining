package dan.swetraining.trie;

import java.util.HashMap;

public class TrieNode {
    public HashMap<Character, TrieNode> children;
    public String content;
    public boolean isWord;

    public TrieNode(String content){
    	this.isWord = false;
        this.content = content;
    	this.children = new HashMap<Character, TrieNode>();
    }
    

    public void setEndOfWord(Boolean isEndOfWord){
        isWord = isEndOfWord;
    }

}