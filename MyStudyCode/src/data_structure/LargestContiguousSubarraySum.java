package data_structure;

public class LargestContiguousSubarraySum {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int sum = largestSum(arr);
        System.out.println(sum);
    }

    private static int largestSum(int[] arr) {
        int currMax = arr[0];
        int maxResult = arr[0];

        for(int i=1; i<arr.length; i++) {
            currMax = Math.max(arr[i], currMax+arr[i]);
            maxResult = Math.max(maxResult, currMax);
        }

        return maxResult;

    }
}
