package others;

public class Knapsack {
    public int knapsack01(int w[], int v[], int size){
        int ans = 0;
        int[][] arr = new int[v.length+1][size+1];
        for(int i=0; i<v.length; i++) {
            for(int j=0; j<size; j++) {
                if(i==0 || j==0) {
                    arr[i][j] = 0;
                    continue;
                }
//                if(j)
            }
        }
        return arr[v.length][size];
    }
    public static void main(String[] args) {
        Knapsack k = new Knapsack();
//        int val[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
//        int wt[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
        int val[] = {2, 3, 4 ,5};
        int wt[] = {2, 5, 6, 7};
        int r = k.bottomUpDP(val, wt, 7);
        System.out.println(r);
    }

    public int bottomUpDP(int val[], int wt[], int W){
        int K[][] = new int[val.length+1][W+1];
        for(int i=0; i <= val.length; i++){
            for(int j=0; j <= W; j++){
                if(i == 0 || j == 0){
                    K[i][j] = 0;
                    continue;
                }
                if(j - wt[i-1] >= 0){
                    K[i][j] = Math.max(K[i-1][j], K[i-1][j-wt[i-1]] + val[i-1]);
                }else{
                    K[i][j] = K[i-1][j];
                }
            }
        }
        return K[val.length][W];
    }
}


/*
     0 1 2 3 4 5 6 7
 2 2 0 0 2 2 2 2 2 2
 5 3 0 0 2 5
 6 4 0
 7 5 0
 */