package dan.swetraining.trie;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrieTest {
    
    @Test
    public void testInsert(){
        Trie t = new Trie();

        t.insert("aaa");
        
        t.insert("aab");
        
        
        assertEquals(true, t.root.children.containsKey('a'));
        assertEquals("a", t.root.children.get('a').content);
        assertEquals(true, t.root.children.get('a').children.containsKey('a'));
        assertEquals(true, t.root.children.get('a').children.get('a').children.containsKey('a'));
        assertEquals(true, t.root.children.get('a').children.get('a').children.get('a').isWord);
        
        assertEquals(true, t.root.children.get('a').children.get('a').children.containsKey('b'));
        assertEquals("aab", t.root.children.get('a').children.get('a').children.get('b').content);
    }

    @Test
    public void testFindNode(){
        Trie t = new Trie();

        t.insert("aaa");

        TrieNode result = t.findNode("a");

        assertEquals("a", result.content);
    }

    @Test
    public void testPrintNode(){
        Trie t = new Trie();

        t.insert("aaa");
        t.insert("aab");
        t.insert("aac");
        t.insert("aba");
        t.insert("aca");
        t.insert("baa");
        t.insert("caa");

        TrieNode result = t.findNode("a");


        t.printNode(result);

    }
}
