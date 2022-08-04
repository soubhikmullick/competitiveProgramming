package google.arrays;

public class MaxSumInContiguousArray {
  public static void main(String[] args) {
    int[] array = {1,3,-1,-1,1};
    System.out.println(kadane(array));
  }

    private static int kadane(int[] array) {
      int maxSoFar = 0;
      int maxEndingHere = Integer.MIN_VALUE;
      for(int i:array) {
          maxEndingHere = Math.max(maxEndingHere+i, i);
          maxSoFar = Math.max(maxEndingHere, maxSoFar);
      }
      return maxSoFar;
    }
}
