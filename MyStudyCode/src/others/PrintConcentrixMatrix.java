package others;

import java.util.ArrayList;

public class PrintConcentrixMatrix {
    public static ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int sqA = A * A;
        for (int i = 1; i <= A; i++) {
            int j = i;
            goRightAndLeft(matrix, i, j, A - i + 1);

            goRightAndLeft(matrix, sqA - j, j, A - i + 1);

            goUpAndDown(matrix, i, j, A - i + 1);

            goUpAndDown(matrix, i, sqA - j, A - i + 1);
        }
        return matrix;
    }

    private static void  goRightAndLeft(ArrayList<ArrayList<Integer>> matrix, int row, int col, int count) {
        ArrayList<Integer> colArray = new ArrayList<>();
        for (int colVal = col; colVal <= col; colVal++) {
            colArray.add(colVal, count);
        }
        matrix.add(row, colArray);
    }

    private static void  goUpAndDown(ArrayList<ArrayList<Integer>> matrix, int row, int col, int count) {
        ArrayList<Integer> colArray = new ArrayList<>();
        for (int colVal = col; colVal <= col; colVal++) {
            colArray.add(colVal, count);
        }
        matrix.add(row, colArray);
    }

    public static void main(String[] args) {
        System.out.println(prettyPrint(4));
    }
}
