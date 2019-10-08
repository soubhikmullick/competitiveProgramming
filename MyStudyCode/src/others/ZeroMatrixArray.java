package others;

public class ZeroMatrixArray {
    public static void main(String[] args) {
        int[][] arr = { {1,1,1},
                        {1,0,1},
                        {1,1,1}};
        for(int row=0;row<arr.length; row++){
            for(int col=0; col<arr[row].length; col++) {
                if(arr[row][col] == 0){
                    changeRowValueToNegative(arr, arr[row], col);
                    changeColValueToNegative(arr, col, row);
                    arr[row][col] = -1;
                }
            }
        }

        for(int row=0;row<arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if(arr[row][col] == -1) {
                    arr[row][col] = 0;
                }
                System.out.print(arr[row][col]+" ");
            }
            System.out.println();
        }
    }

    private static void changeRowValueToNegative(int[][] arr, int[] ints, int col) {
        for(int rowToChange=0; rowToChange<arr.length; rowToChange++){
            if(col == rowToChange) continue;
            if(ints[rowToChange] != -1 || ints[rowToChange] !=0){
                ints[rowToChange] = -1;
            }
        }
    }

    private static void changeColValueToNegative(int[][] arr, int row, int col) {
        for(int colToChange=0; colToChange<arr.length; colToChange++){
            if(row == colToChange) continue;
            if(arr[colToChange][col] != -1 || arr[colToChange][col] !=0){
                arr[colToChange][col] = -1;
            }
        }
    }
}
