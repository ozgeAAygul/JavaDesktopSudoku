package com.wiseassblog.sudoku.computationlogic;

public class SudokuSolver {
    private static int[] findEmptyCell(int[][] grid) {
        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[row].length; col++){
                if (grid[row][col] == 0) {
                    return new int[]{row, col};
                }
            }
        }

        return null;
    }
}
