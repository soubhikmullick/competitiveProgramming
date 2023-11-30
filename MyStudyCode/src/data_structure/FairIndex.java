package data_structure;

import java.io.IOException;
import java.util.*;


public class FairIndex {

    public static int fairIndex(int A[], int B[]) {
        int n = A.length;
        int count = 0;
        long sum1 = 0;
        long sum2 = 0;
        long[] prefixSumA = new long[n];
        long[] prefixSumB = new long[n];

        for (int i = 0; i < n; i++) {
            sum1 += A[i];
            sum2 += B[i];
            if (i != 0) {
                prefixSumA[i] = prefixSumA[i - 1] + A[i];
                prefixSumB[i] = prefixSumB[i - 1] + B[i];
            } else {
                prefixSumA[i] = A[i];
                prefixSumB[i] = B[i];
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (prefixSumA[i] == prefixSumB[i] && sum1 == 2 * prefixSumA[i] && sum2 == 2 * prefixSumB[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        int[] A1 = { 0, 4, -1, 0, 3 };
        int[] B1 = { 0, -2, 5, 0, 3 };
        System.out.println(fairIndex(A1, B1));
    }

}
