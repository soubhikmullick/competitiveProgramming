import java.util.ArrayList;
import java.util.List;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ans = 0;
        if(!wordList.contains(endWord)) ans = 0;
        else {
            int charCount = beginWord.length();
            for(String word : wordList){

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("hot");
        words.add("dot");
        words.add("dog");
        words.add("lot");
        words.add("log");
        words.add("cog");
        ladderLength("hit", "cog", words);
    }
}
