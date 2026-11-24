package com.wiseassblog.sudoku.computationlogic;

import com.wiseassblog.sudoku.constants.GameState;

// İlk boş hücreyi bulunca true döner

public class GameLogic {
    public static boolean tilesAreNotFilled(int[][] grid) {
        for (int[] line : grid) {
            for (int value : line) {
                if (value == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    // İlk satır içi tekrarı bulunca true döner

    public static boolean rowsAreInvalid(int[][] grid) {
        for (int[] row : grid) {
            boolean[] seen = new boolean[10];

            for (int value : row) {
                if (value == 0) {
                    continue;
                }

                if (seen[value]) {
                    return true;
                }

                seen[value] = true;
            }
        }

        return false;
    }

    // Bir sütunda aynı sayı iki kere varsa true dönecek

    public static boolean columnsAreInvalid(int[][] grid) {
        for (int col = 0; col < 9; col++) {
            boolean[] seen = new boolean[10]; // burada 10 tane oluşturma sebebimiz 0 dan başlaması ve biz 1 görünce 1e true yazcaz 9 görünce 9a,
            // kafamız karışmasın diye 0ı kendi kendine takılcak

            for (int row = 0; row < 9; row++) {
                int value = grid[row][col];

                if (value == 0) {
                    continue;
                }

                if(seen[value]) {
                    return true;
                }

                seen[value] = true;
            }
        }

        return false;
    }

    // 3x3 kutular için kontrol aynı kutuda tekrar eden değer varsa true döner
    // private çünkü tek bir kutuyu kontrol etmek GameLogic sınıfının kendi içinde kullandığı bir adım
    private static boolean squareIsInvalid(int[][] grid, int startRow, int startCol) {
        boolean[] seen = new boolean[10];

        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++){
                int value = grid[row][col];

                if (value == 0){
                    continue;
                }

                if (seen[value]){
                    return true;
                }

                seen[value] = true;
            }
        }

        return false;
    }

    // tüm kutuları kontrol edecek o metod
    // hepsi kontrolden geçerse false dönüyor

    public static boolean squaresAreInvalid(int[][] grid) {
        for (int startRow = 0; startRow < 9; startRow += 3) {
            for (int startCol = 0; startCol < 9; startCol += 3) {
                if (squareIsInvalid(grid, startRow, startCol)){
                    return true;
                }
            }
        }
    return false;
    }

    // Oyunun devam veya bitiş durumuna karar verme
    // Tahtada boş hücre veya kural ihlali varsa oyun devam edecek (ACTIVE)
    // Tahta tamamen dolu ve kurallara uygunsa oyun tamamlanır (COMPLETE)

    public static GameState checkForCompletion(int[][] grid) {
        if (tilesAreNotFilled(grid)){
            return GameState.ACTIVE;
        }

        if (sudokuIsInvalid(grid)) {
            return GameState.ACTIVE;
        }

        return GameState.COMPLETE;
    }

    // Tahta yarımken eklenilen bir sayının herhangi bir kuralla çakışıp çakışmadığını kontrol eden metot
    public static boolean sudokuIsInvalid(int[][] grid) {
        return rowsAreInvalid(grid) || columnsAreInvalid(grid) || squaresAreInvalid(grid);
    }

}
