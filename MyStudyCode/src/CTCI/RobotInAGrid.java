package CTCI;

/* Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
The robot can only move in two directions, right and down, but certain cells are "off limits" such that the robot cannot step on them.
Design an algorithm to find a path for the robot from the top left to the bottom right.
*/

public class RobotInAGrid {
    public static void main(String[] args) {
        int robotGrid[][] ={
            {1,1,0},
            {1,0,0},
            {0,1,1}
        };
        boolean isPathPresent = true;
        System.out.println(pathFinder(robotGrid, robotGrid.length-1, robotGrid.length-1, isPathPresent));

    }

    private static boolean pathFinder(int[][] robotGrid, int row, int col, boolean isPathPresent) {
        if(row<0 || col<0) return false;

        if(row == 0 && col == 0) return true;

        if(robotGrid[row][col] == 1 && isPathPresent)
            return isPathPresent && pathFinder(robotGrid, row-1, col, isPathPresent) ||
                    pathFinder(robotGrid, row, col-1, isPathPresent);
        else return false;
    }
}
