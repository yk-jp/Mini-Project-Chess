package chessgame;

import java.util.LinkedList;
import java.util.Objects;

public class Bishop extends Piece {

  LinkedList<String> availableMoves = new LinkedList<>();

  public Bishop(boolean isWhite, Position position) {
    super(isWhite, position);
  }

  @Override
  public void getAvailableMoves(Position currentPosition) {
    for (int idx = 0; idx < 7; idx++) {
      for (int jdx = idx; jdx < 7; jdx++) {
        int finalRow = currentPosition.getRow() + idx;
        int finalColumn = currentPosition.getColumn() + jdx;
        String availableMove = finalRow + String.valueOf(finalColumn);

        System.out.println("Current column: " + super.position.getColumn());
        System.out.println("Final column: " + finalColumn);
        System.out.println("Available move: " + availableMove);

        this.availableMoves.add(availableMove);
//        if(super.position.getColumn() - finalColumn == 1) {
//          this.availableMoves.add(availableMove);
//        }
        System.out.println();
      }
    }
    System.out.println(String.format("Possible moves for %d%d:\n",
        currentPosition.getRow(), currentPosition.getColumn()) + availableMoves);
  }

  @Override
  public boolean isValidMove(Position finalPosition) {
    int diagonalX = Math.abs(finalPosition.getRow()) - super.position.getRow();
    int diagonalY = Math.abs(finalPosition.getColumn() - super.position.getColumn());
    return diagonalX == diagonalY && diagonalX > 0;
  }

  @Override
  public String toString() {
    return "Bishop{" +
        "isWhite=" + super.getColor() +
        ", position=" + super.getPosition() +
        '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Bishop piece = (Bishop) obj;
    return super.getColor() == piece.getColor() &&
        Objects.equals(position, piece.position);
  }
}
