package leetcode;

public class leetcode1695 {
    public static void main(String[] args) {
        int[] nums = {558,508,782,32,187,103,370,607,619,267,984,10};
        if (nums.length == 1) {
            System.out.println(nums[0]);
        }
        ;
        int[] prefixSum = new int[nums.length+1];
        prefixSum[0]=0;
        for(int i=0; i<nums.length; i++) {
            prefixSum[i+1]=prefixSum[i]+nums[i];
        }
        int s=0;
        int[] M = new int[10001];
        int ans = nums[0];
        for(int i=1; i<nums.length; i++) {
            s=Math.max(s, M[nums[i]]+1);
            ans=Math.max(ans,prefixSum[i+1]-prefixSum[s]);
            M[nums[i]]=i;
        }
        System.out.println(ans);
    }
}
