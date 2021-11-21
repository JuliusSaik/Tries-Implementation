
public class myTrie {

	public static void main(String[] args) {
		
		
		myTrie trie = new myTrie();
		
		trie.insert("ass");
		trie.insert("ligma");
		trie.insert("asparagus");

		trie.insert("fat");
		
		System.out.println(trie.search("asparagus"));
		
	}
	
	private Node root;
	
	public myTrie() {
		root = new Node('\0');
	}
	
	public void insert (String word) {
		Node curr = root;
		
		for(char c : word.toCharArray()) {
			
			if(curr.children[c - 'a'] == null) {
				
				curr.children[c - 'a'] = new Node(c);
				
			}
			
			curr = curr.children[c - 'a'];
			
		}
		curr.isWord = true;
	}
	
	
	public boolean search(String word) {
		Node node = getNode(word);
		return node != null && node.isWord;
	}
	
	public boolean startsWith(String prefix) {
		return getNode(prefix) != null;
	}
	
	
	private Node getNode(String word) {
		Node curr = root;
		for(char c : word.toCharArray()) {
			
			if(curr.children[c - 'a'] == null) return null;
			
			curr = curr.children [c - 'a'];
			
		}
		return curr;
	}
	
	
	class Node {
	
		private char character;
		public boolean isWord;
		public Node[] children;
		
		
		public Node (char c) {
			this.character = c;
			isWord = false;
			children = new Node[26];
		}
		
	}

}
