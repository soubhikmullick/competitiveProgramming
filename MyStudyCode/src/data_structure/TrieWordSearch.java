package data_structure;

public class TrieWordSearch {

    public boolean isEndOfWord(Trie trie, String word) {
        for(int i=0; i<word.length(); i++) {
            if(!trie.containsKey(word.charAt(i)))
                return false;
            else
                trie = trie.get(word.charAt(i));
        }
        return trie.isEnd(word.charAt(word.length()-1));
    }

    public void insertWord(Trie trie, String word) {
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(trie.get(c) != null) {
                trie = trie.get(c);
            } else {
                trie.put(c);
                trie = trie.get(c);
            }
        }
        trie.setEnd(word.charAt(word.length()-1));
    }

    public static void main(String[] args) {
        String one = "one";
        String two = "two";
        String three = "two";
        Trie trie = new Trie();
        TrieWordSearch trieWordSearch = new TrieWordSearch();
        trieWordSearch.insertWord(trie, one);
        trieWordSearch.insertWord(trie, three);
        System.out.println(trieWordSearch.isEndOfWord(trie, two));
    }

}

class Trie{
    Trie[] trie;
    final int maxSize = 26;
    boolean endOfWord;

    Trie() {
        trie = new Trie[maxSize];
        endOfWord = false;
    }

    public boolean containsKey(char c) {
        return trie[c-'a'] != null;
    }

    public Trie get(char c) {
        return trie[c-'a'];
    }

    public void put(char c) {
        trie[c-'a'] = new Trie();
    }

    public void setEnd(char c) {
        endOfWord = true;
    }

    public boolean isEnd(char c) {
        return endOfWord;
    }
}
