package google.recursions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
  public static void main(String[] args) {
    int[] temp = {1,2,3};
    System.out.println(permute(temp));
  }

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    return findSolution(nums, list, 0);
  }

  private static List<List<Integer>> findSolution(int[] nums, List<List<Integer>> list, int index) {
    if (index == nums.length) {
      list.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
      return list;
    }
    for (int i = index; i < nums.length; i++) {
      findSolution(swap(nums, i, index), list, index + 1);
      swap(nums, i, index);
    }
    return list;
  }

  private static int[] swap(int[] nums, int index, int swapped) {
    int temp = nums[index];
    nums[index] = nums[swapped];
    nums[swapped] = temp;
    return nums;
  }
}
