package CTCI;

public class TravelInStar {

    static class Var {
        int count = 0;
    }

    public static void main(String[] args) {
        int row = 0, col = 0;
        char grid[][] =
                { { '0', '*', '*', 's' }, { '*', '0', '*', '*' }, { '0', '*', '*', '*' }, { 'd', '*', '*', '*' } };
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'd') {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        Var var = new Var();
        func(grid, row, col, var, 0);
        System.out.println(var.count);
    }

    private static void func(char[][] grid, int row, int col, Var var, int count) {
        System.out.println("row = " + row + "col = " + col);
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            count = 0;
            return;
        } else {

            if (grid[row][col] == 's') {
                var.count = Math.min(var.count, count);
            }
            if (grid[row][col] == '0') {
                count = 0;
            }
            if (grid[row][col] == '*') {
                count++;
            }

            func(grid, row + 1, col, var, count);
            func(grid, row, col + 1, var, count);
            func(grid, row - 1, col, var, count);
            func(grid, row, col - 1, var, count);
        }

    }

}
