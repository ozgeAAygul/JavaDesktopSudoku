package com.wiseassblog.sudoku.computationlogic;

public class SudokuUtilities {

    public static int[][] copyToNewArray(int[][] original) {
        int[][] copy = new int[original.length][];

        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone(); // İç dizileri ayrı ayrı cloneluyoruz
        }

        return copy;
    }
}
