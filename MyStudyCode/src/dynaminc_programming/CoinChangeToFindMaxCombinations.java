package dynaminc_programming;

public class CoinChangeToFindMaxCombinations {
    public static void main(String[] args) {
        CoinChangeToFindMaxCombinations coinChangeToFindMaxCombinations = new CoinChangeToFindMaxCombinations();
        int[] arr = new int[] {1,2,5};
        coinChangeToFindMaxCombinations.coinSolution(12, arr);
    }

    public void coinSolution(int amount, int[] coins) {
        int[] solutionArr = new int[amount+1];
        solutionArr[0] = 1;
        for(int coin : coins) {
            for(int i=1;i<solutionArr.length;i++) {
                if(i>=coin) {
                    solutionArr[i] += solutionArr[i - coin];
                }
            }
        }
        System.out.println(solutionArr[amount]);
    }
}
