//Implement a trie with insert, search, and startsWith methods.
//
//Example:
//
//Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // returns true
//trie.search("app");     // returns false
//trie.startsWith("app"); // returns true
//trie.insert("app");   
//trie.search("app");     // returns true
//Note:
//
//You may assume that all inputs are consist of lowercase letters a-z.
//All inputs are guaranteed to be non-empty strings.
//

class Trie {

    Trie[] node;
    boolean isEnd;
    
    /** Initialize your data structure here. */
    public Trie() {
        node = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word != null && word != "")
        {
            Trie child = this;
            for(int i = 0; i< word.length(); i++)
            {
                //insert rest of chaaracters
                if( child.node[word.charAt(i)-'a'] == null)
                    child.node[word.charAt(i)-'a'] = new Trie();                
                    
                child = child.node[word.charAt(i)-'a'];
                
            }
            child.isEnd = true;
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(this.node[word.charAt(0)-'a'] != null)
        {
            Trie child = this;
            
             for(int i = 0; i< word.length(); i++){
                 
                 if(child.node[word.charAt(i)-'a'] == null)
                        return false;
                 
                 child = child.node[word.charAt(i)-'a'];
             }
            
            if(child != null && child.isEnd == true)
                return true;
        }
        return false;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
       if(this.node[prefix.charAt(0)-'a'] != null)
       {
           Trie child = this; 
            for(int i = 0; i< prefix.length(); i++){
                if(child.node[prefix.charAt(i)-'a'] == null)
                    return false;
                child = child.node[prefix.charAt(i)-'a'];
            }
           return true;
       }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
