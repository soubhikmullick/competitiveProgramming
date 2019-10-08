package others;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Roads {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long arr[] = new long[N];
        for(int i=0; i<N; i++)
            arr[i] = sc.nextLong();
        long out = solve(arr, N);
        System.out.println(out);
    }
    public static long solve(long[] arr, long N){
        if(N==1) return 0l;

        HashMap<Long, Integer> hm = new HashMap<>();
        for(int i = 0; i<N; i++) {
            if(hm.containsKey(arr[i])){
                hm.put(arr[i], hm.get(arr[i])+1);
            } else
                hm.put(arr[i],1);
        }
        long count = 0;
        for(Map.Entry<Long,Integer> entry : hm.entrySet()) {
            if(hm.size() == 1 && entry.getKey() == 1l) return entry.getValue()*(entry.getValue()-1);
            if(entry.getKey() == 1l) count +=  entry.getValue()*(entry.getValue()-1);
            else if(hm.containsKey(entry.getKey()*entry.getKey())) {
                count += entry.getValue() * hm.get(entry.getKey()*entry.getKey());
            }
        }
        return count;

    }
}