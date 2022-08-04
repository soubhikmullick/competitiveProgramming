package google.recursions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Find all the possible subsets of an array
 */
public class AllSubsetsOfArray {
  public static void main(String[] args) {
    int array[] = {1,2,3};
    int ans[] = findSubsets(array, 0, new int[2^array.length+1], 0);
    for (int i = 0; i < ans.length; i++) {
      System.out.println(ans[i]);
    }
  }

  private static int[] findSubsets(int[] array, int index, int[] ans, int ansIndex) {
    if(index==array.length){
      ans[ansIndex++] = 0;
      return ans;
    }
    findSubsets(array, index+1, ans, ansIndex);
    ans[ansIndex++] = array[index];
    findSubsets(array, index+1, ans, ansIndex);
    return ans;
  }

}
