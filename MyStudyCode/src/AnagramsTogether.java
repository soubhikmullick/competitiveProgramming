import java.util.*;

public class AnagramsTogether {
    public static void main(String[] args) {
        String[] words = {"cat", "dog", "tac", "god"};
        Map<Integer, String> dupmap = new HashMap<>();
        Map<Integer, String> map = new HashMap<>();

        for(int i=0; i<words.length; i++) {
            dupmap.put(i, words[i]);
            map.put(i, words[i]);
        }
        for(String word : words) {
            List<Map.Entry<Integer, String>> list = new ArrayList<>(dupmap.entrySet());
            list.sort(Comparator.comparing(Map.Entry::getValue));
            System.out.println(dupmap);
        }
    }
}
