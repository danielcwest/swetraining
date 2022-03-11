package dan.swetraining.trie;

public class Trie {
    public TrieNode root;

    public Trie() {
    	root = new TrieNode("");
    }
    /**
     * Set a current node as a root node
    Set the current letter as the first letter of the word
    If the current node has already an existing reference to the current letter (through one of the elements in the “children” field), then set current node to that referenced node. Otherwise, create a new node, set the letter equal to the current letter, and also initialize current node to this new node
    Repeat step 3 until the key is traversed 
    */
    public void insert(String word){

    	TrieNode current = root;
    	String content = "";

        for (char l: word.toCharArray()) {
            content += l;
        	if(!current.children.containsKey(l)) {
                current.children.put(l, new TrieNode(content));
        	}
            current = current.children.get(l);
        }
        
        current.isWord = true;
    }

    public TrieNode findNode(String search){
        TrieNode node = this.root;

        for (char l: search.toCharArray()) {
            if(node.children.containsKey(l)){
                node = node.children.get(l);
            }else{
                return null;
            }
        }

       // if(node.content.equalsIgnoreCase(search))

        return node;
    }

    public void printNode(TrieNode node){

        if(node.isWord){
            System.out.println(node.content);
        }
        else
            node.children.values().forEach(n -> {
                printNode(n);
            });
    }
}
