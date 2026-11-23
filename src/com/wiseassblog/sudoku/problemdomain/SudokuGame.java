package com.wiseassblog.sudoku.problemdomain;

import com.wiseassblog.sudoku.constants.GameState;
import com.wiseassblog.sudoku.computationlogic.SudokuUtilities;

public class SudokuGame {

    // bu değer sınıfa ait --> static
    // bu değer sabit --> final
    public static final int GRID_BOUNDARY = 9; // tahtanın bir kenarının uzunluğu

    // bu iki değer her oyun nesnesine ayrı ayrı ait
    private final GameState gameState;
    private final int[][] gridState;

    // Bu nesneyi şu şekilde oluşturduğumuzu hayal et:
    // int[][] board = new int[SudokuGame.GRID_BOUNDARY][SudokuGame.GRID_BOUNDARY];
    // board[0][0] = 5;
    // SudokuGame game = new SudokuGame(GameState.NEW, board);

    public SudokuGame(GameState gameState, int[][] gridState) {
        this.gameState = gameState;
        this.gridState = gridState;
    }

    // Kopya oluşturuyoruz ki dışarıdaki diziyi değiştirince oyunun tahtası da değişmesin.
    public int[][] getCopyOfGameState() {
        return SudokuUtilities.copyToNewArray(gridState);
    }

}
