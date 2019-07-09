package DynamicProgramming;

public class TrappingRainWater {
    public static void main(String[] args) {
//        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; //6
        int arr[] = {3, 0, 0, 2, 0, 4}; //10
        if(arr.length == 0) System.out.println(0);
        int ans[] = new int[arr.length];
        int max = arr[0];
        ans[0] = 0;
        for(int i=1; i<arr.length; i++) {
            if(max<arr[i]) {
                ans[i] = 0;
                max = arr[i];
            } else if(max>=arr[i]) {
                ans[i] = max - arr[i];
            }
        }

        max = arr[arr.length-1];
        ans[arr.length-1] = Math.min(ans[arr.length-1], 0);
        int sum = 0;
        for(int i=arr.length-2; i>=0; i--) {
            if(max<arr[i]) {
                ans[i] = Math.min(ans[i], 0);
                max = arr[i];
            } else if(max>=arr[i]) {
                ans[i] = Math.min(max - arr[i], ans[i]);
            }
            sum+=ans[i];
        }
        System.out.println(sum);
    }
}
