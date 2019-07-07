import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LongestCharacterSequence {
    public static void main(String[] args) {
        int[] charArray = new int[256];
        String s = "aabbbbcc";
        int sum = 0;
        for(char character : s.toCharArray()) {
            charArray[character]++;
            sum = Math.max(sum, charArray[character]);
            System.out.println(charArray[character] + " sum = " + sum);
        }
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(1,4);
        System.out.println(hm.get(1));
    }
}
