import java.util.*;

public class TestSolution {

    // { 3,6,19,11,10,9,7,1} - 19
    // first increase, then descrease
    // mid ele -> part of the decreasing, actual answer, part of the increasing
    // 3,6,19,11,10,10,10,10,10,9
    public static void main(String[] args) {
        int[] arr = new int[]{3,6,19,11,10,9,7,1,2,8,100}; // mid = part of the descending,
        int low = 0, high=arr.length-1;
        int mid = 0;
        int ans = Integer.MIN_VALUE;

        while(low<=high && low>=0 && high<=arr.length-1) {
            mid = low+(high-low)/2;
            //part of the decreasing
            if((mid-1>=0 && arr[mid]<arr[mid-1]) && (mid+1<=arr.length-1 && arr[mid]>arr[mid+1])) {
                high = mid;
            }
            //part of the increasing
            else if((mid-1>=0 && arr[mid]>arr[mid-1]) && (mid+1<=arr.length-1 && arr[mid]<arr[mid+1])) {
                low = mid;
            } else if((mid-1>=0 && arr[mid]>=arr[mid-1]) && (mid+1<=arr.length-1 && arr[mid]>=arr[mid+1])) {
                ans = mid;
                break;
            }
        }
        System.out.println(arr[ans]);
    }


}
