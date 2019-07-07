import java.util.Scanner;

public class FindingShortestDist2DArr {

    public static Scanner in = new Scanner(System.in);
    public static int row, column = 0;
    public static int arr[][];
    public static boolean flag = true;
    public static int source, destination = 0;
    public static int sourceRow, sourceCol = 0;
    public static int destinationRow, destinationColumn = 0;
    public static int answer = 0;

    public static void main(String[] args) {
        System.out.println(-3*-3);
        row = in.nextInt();
        column = in.nextInt();
        source = in.nextInt();
        destination = in.nextInt();
        arr = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                arr[i][j] = in.nextInt();
                if (arr[i][j] == source) {
                    sourceRow = i;
                    sourceCol = j;
                } else if (arr[i][j] == destination) {
                    destinationRow = i;
                    destinationColumn = j;
                }
            }
        }

        while (arr[sourceRow][sourceCol] != arr[destinationRow][destinationColumn]){
            if (flag == true)
                goRight();
            else
                goDown();
        }

        System.out.println(answer);
    }

    public static void goRight() {
        if (sourceRow == destinationRow)
            flag = true;
        if (sourceCol < destinationColumn) {
            sourceCol++;
            answer++;
            return;
        }
        flag = false;
        return;
    }

    public static void goDown() {
        if (sourceCol == destinationColumn) {
            flag = false;
        }
        if (sourceRow < destinationRow) {
            sourceRow++;
            answer++;
            return;
        }
        flag = true;
        return;
    }
}
