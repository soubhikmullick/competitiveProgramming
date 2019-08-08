import java.util.HashMap;

public class devil {
    public static void main(String[] args) {
//        long[] arr = new long[]{16,10,13,4,8,7,15,20};
        long[] arr = new long[]{1};
        long left = 1, right = 2; int step = 3;



        HashMap<Long,Integer> hm = new HashMap<>();
        long max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(hm.containsKey(arr[i])){
                hm.put(arr[i], hm.get(arr[i])+1);
            } else
                hm.put(arr[i],1);
            max = Math.max(max, arr[i]);
        }
        int leftCount = 0, rightCount = 0;

        while(left<=max || right<=max) {
            if(hm.containsKey(left)) leftCount += 1*hm.get(left);
            if(hm.containsKey(right)) rightCount += 1*hm.get(right);
            left+=step;
            right+=step;
        }
        System.out.println(leftCount +" " +rightCount);
    }
}
