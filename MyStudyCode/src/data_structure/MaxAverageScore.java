package data_structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxAverageScore {
    public static void main(String[] args) {
        String scores[][] = {{"Ram","155"},
                {"Shyam","145"},
                {"Ram","156"},
                {"Balram","159"},
                {"Balram","150"},
                {"Ram","135"},
                {"Mira","156"},
                {"Mira","152"},
                {"Shyam","155"}};

        Map<String, Integer> nameAndScoreSum = new HashMap<>();
        Map<String, Integer> nameAndCount = new HashMap<>();
        for(String[] namesAndScores : scores) {
            if(!nameAndScoreSum.containsKey(namesAndScores[0])) {
                nameAndScoreSum.put(namesAndScores[0], Integer.parseInt(namesAndScores[1]));
                nameAndCount.put(namesAndScores[0], 1);
            } else {
                nameAndScoreSum.put(namesAndScores[0], nameAndScoreSum.get(namesAndScores[0])+
                        Integer.parseInt(namesAndScores[1]));
                nameAndCount.put(namesAndScores[0], nameAndCount.get(namesAndScores[0])+1);
            }
        }
        int maxAverage = 0;
        for(Map.Entry<String, Integer> nameAndScore : nameAndScoreSum.entrySet()) {
            maxAverage = (maxAverage < nameAndScoreSum.get(nameAndScore.getKey())/nameAndCount.get(nameAndScore.getKey()))?
                    nameAndScoreSum.get(nameAndScore.getKey())/nameAndCount.get(nameAndScore.getKey()) : maxAverage;
        }
        System.out.println(maxAverage);
    }
}
