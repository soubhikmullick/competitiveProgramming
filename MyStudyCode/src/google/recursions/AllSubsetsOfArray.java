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

  public void recur(int[] nums, int i, List<Integer> list, List<List<Integer>> solution) {
    if(i == nums.length) {
      solution.add(list);
      return;
    } else {
      list.add(nums[i]);
      recur(nums, i + 1, new ArrayList<>(list), solution);

      list.remove(list.size()-1);
      recur(nums, i + 1, new ArrayList<>(list), solution);
    }
  }
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    recur(nums, 0, new ArrayList<>(), ans);
    return ans;
  }

}
