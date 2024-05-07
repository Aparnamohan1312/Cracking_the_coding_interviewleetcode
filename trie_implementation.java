import java.util.*;
import java.lang.*;
public class trie_implementation {
    public static class Node{
        private final char character;
        private Map<Character, Node> children = new HashMap<>();
        public boolean isEndofWord;
        public Node(char character) {
            this.character = character;
        }

        public Map<Character, Node> getChildren() {
            return children;
        }

        public void setEndofWord(boolean isEndOfWord) {
            this.isEndofWord = isEndOfWord;
        }

        public boolean isEndofWord() {
            return isEndofWord;
        }

        public char getCharacter() {
            return character;
        }
    }
    public interface Tree{
        public boolean contains(String word);
        public void delete(String word);
        Tree insert(String word);
        public boolean containsPrefix(String prefix, Node root);
        List<String> wordswithPrefix(String prefix,Node root);
    }
    public static class Trie implements Tree{
        public Node root;
        public Trie(){
            root = new Node(' ');
        }
    
    public Tree insert(String word){
        Node currentNode = root;
        Map<Character, Node> children = root.getChildren();
        for(char c:word.toCharArray()){
            if(children.containsKey(c))
            currentNode = children.get(c);
            else{
                currentNode = new Node(c);
                children.put(c,currentNode);
            }
            children = currentNode.getChildren();
        }
        currentNode.setEndofWord(true);
        return this;
    }
    public Node search(String word){
        Node currentNode = null;
        Map<Character, Node> children = root.getChildren();
        for(char c: word.toCharArray()){
            if(!children.containsKey(c))
                return null;
            currentNode = children.get(c);
            children = currentNode.getChildren();
        }
        return currentNode;
    }
    public boolean contains(String word){
        Node lastPresentNode = search(word);
        return lastPresentNode!=null && lastPresentNode.isEndofWord();
    }
    public boolean containsPrefix(String prefix, Node root){
        return search(prefix)!=null;
    }
    public List<String> wordswithPrefix(String prefix,Node root){
        List<String> words = new ArrayList<>();
        Node prefixNode = search(prefix);
        if(prefixNode!=null){
            addWords(prefixNode, prefix,words);
        }
        return words;

    }
    public void addWords(Node node, String prefix, List<String> wordList){
        if(node.isEndofWord())
            wordList.add(prefix);
        node.getChildren().values().forEach(child->{
            String character = String.valueOf(child.getCharacter());
            addWords(child,prefix.concat(character),wordList);
        });
    }
    public void delete(String word){
        List<Node> list = new ArrayList<>();
        Map<Character, Node> children = root.getChildren();

        for(char c:word.toCharArray()){
            if(!children.containsKey(c))
                break;
        Node currentNode = children.get(c);
        children = currentNode.getChildren();
        list.add(currentNode);
        }
        if(list.isEmpty() && list.size()!=word.length())
        return;
        list.get(list.size() - 1).setEndofWord(false);
        for(int i=list.size()-1;i>0;i--){
            Node current = list.get(i);
            if(current.getChildren().isEmpty() ){
                list.get(i-1).getChildren().remove(current.getCharacter());

            }
            else if(current.isEndofWord()){
                break;
            }
        }
    }
}
    public static void main(String[] args){
        Trie tr = new Trie();
        tr.insert("Google");
        tr.insert("Apple");
        tr.insert("App");
        System.out.println("Contains prefix" + tr.containsPrefix("Ap", tr.root));
        System.out.println("Contains" + tr.contains("Google"));
        List<String> words = tr.wordswithPrefix("App", tr.root);
        System.out.println("Words with prefix 'App': " + words);
      
        // Test delete functionality
        System.out.println("\nTesting delete:");
        tr.delete("App");
    }
}
