package CTCI;

/*
** 8.1 Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
** Implement a method to count how many possible ways the child can run up the stairs.
*/

import java.util.Arrays;

public class TripleStep {
    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n + 1];
        System.out.println(tripleStepCalculator(n, dp));

        // book way//
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        System.out.println(countWays(n, dp));

    }

    private static int tripleStepCalculator(int n, int[] dp) {
        if(n==0) return 1;
        else if(n<0) return 0;
        if(dp[n] != 0) return dp[n];
        else dp[n] = tripleStepCalculator(n-1, dp)+tripleStepCalculator(n-2, dp)+tripleStepCalculator(n-3, dp);
        return dp[n];
    }


/* book way */
    private static int countWays(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) +
                    countWays(n - 3, memo);
            return memo[n];
        }
    }

}
