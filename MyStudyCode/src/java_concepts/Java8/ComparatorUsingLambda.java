package java_concepts.Java8;

import java.util.*;

public class ComparatorUsingLambda {
    public static void main(String[] args) {
        Map<String, Integer> hm = new HashMap<>();
        hm.put("d", 4);
        hm.put("c", 3);
        hm.put("b", 2);
        hm.put("a", 1);

        List<Map.Entry<String, Integer>> list =  new ArrayList<>(hm.entrySet());
        Collections.sort(list, Comparator.comparingInt(Map.Entry::getValue));

        for(Map.Entry<String, Integer> ma : list){
            System.out.println(ma.getKey()+" "+ma.getValue());
        }
    }
}
