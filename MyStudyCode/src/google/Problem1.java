package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/*
Problem Statement:
There is a Line (Like X axis) which we need to paint. you are given a list of pairs which is needs to be painted, such as (4, 10), (7, 13), (16,20), (1, 40). There is a cost to paint a particular area which is equal to the distance.
Such as for (4, 10) the cost is 10 - 4 = 6. and so on. you have write the code to calculate the cost required to paint each of the given pairs. note that if the area is already painted once, no need to paint it again.

Example.
first we paint (4, 10), which costs 6, then we paint (7, 13), but we already know that 7-10 is already painted, so we will paint only 10-13 which will cost us 3 only.
Then we will paint (16, 20) which will cost 4, and finally the pair (1-40) will be painted which will cost (40 - 1) - (10-4) - (13-10) - (20-16) which is 26. so the output array will be [6, 3, 4, 26]
 */
public class Problem1 {
  public static void main(String[] args) {
    int[][] input = {{4, 10}, {7, 13}, {16, 20}, {1, 40}};
    int[] ans = solution(input);
    for (int i = 0; i < input.length; i++) {
      System.out.println(ans[i]);
    }
  }

  private static int[] solution(int[][] input) {
    if (input.length == 0) {
      return new int[] {};
    }
//    int[][] lowHigh = {{input[0][0], input[0][1]}};
    List<int[]> lowHigh = new ArrayList<>();
    lowHigh.add(new int[] {input[0][0], input[0][1]});
    int[] ans = new int[input.length];
    int index = 0;
    ans[index] = input[0][1] - input[0][0];
    for (int[] line : input) {
      Arrays.sort(line);
      for(int[] lowHighPair : lowHigh) {
        if (line[0] < lowHighPair[0]) {
            if(line[1] < lowHighPair[0]) {
                ans[index] += line[1] - line[0];
                lowHighPair[0] = line[0];
            } else if(line[1] > lowHighPair[1]) {
                ans[index] += line[0] - lowHighPair[0];
                lowHighPair[0] = line[0];
                int i;
                for(i=0; i<lowHigh.size()-1 && line[1]>lowHigh.get(i)[1] &&  line[1]>lowHigh.get(i+1)[1]; i++) {
                    ans[index]+=lowHigh.get(i+1)[1]-lowHigh.get(i)[1];
                }
                ans[index]+=line[1]-lowHigh.get(i)[1];
                break;
            }
        } else if(line[0] > lowHighPair[1]) {
            ans[index] += line[1]-line[0];
            lowHigh.add(new int[] { line[0], line[1] });
            break;
        } else {
            if(line[1] < lowHighPair[0]) {
                ans[index] += line[1] - line[0];
                lowHighPair[0] = line[0];
            } else if(line[1] > lowHighPair[1]) {
                ans[index] += line[1] -lowHighPair[1];
                lowHighPair[1] = line[1];
            }
        }
      }
      index++;
    }
    return ans;
  }
}
