package chessgame;

import java.util.Arrays;

public class Game {

  public Game() {
    System.out.println("Starting gaming...\n");
  }

  public void board(){
    // 2D array for the board
    String [][] board = new String[8][8];
    // Black Pieces
    String rookB = "♜";
    String knightB = "♞";
    String bishopB = "♝";
    String kingB = "♛";
    String queenB = "♚";
    board[0][0] = rookB;
    board[0][1] = knightB;
    board[0][2] = bishopB;
    board[0][3] = kingB;
    board[0][4] = queenB;
    board[0][5] = bishopB;
    board[0][6] = knightB;
    board[0][7] = rookB;

    for (int i = 0; i < 8; i++){
      String pawnB = "♟";
      board[1][i] = pawnB;
    }
    // White Pieces
    for (int j = 0; j < 8; j++){
      String pawnW = "♙";
      board[6][j] = pawnW;
    }

    String rookW = "♖";
    String knightW = "♘";
    String bishopW = "♗";
    String kingW = "♕";
    String queenW = "♔";
    board[7][0] = rookW;
    board[7][1] = knightW;
    board[7][2] = bishopW;
    board[7][3] = kingW;
    board[7][4] = queenW;
    board[7][5] = bishopW;
    board[7][6] = knightW;
    board[7][7] = rookW;

    // Middle of the board
    for (int k = 2; k <= 5; k++){
      for (int l = 0; l < 8; l++){
        board[k][l] = "*";
      }
    }

    System.out.println(Arrays.deepToString(board));
  }

}
