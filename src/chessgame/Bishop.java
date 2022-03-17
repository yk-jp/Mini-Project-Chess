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
    availableMoves.add("e8");
    System.out.println(String.format("Possible moves for %d%d:\n",
        currentPosition.getRow(), currentPosition.getColumn()) + availableMoves);
  }

  @Override
  public void move(Position position) {
    super.setPosition(position);
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
        "isWhite=" + super.isWhite() +
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
    return super.isWhite() == piece.isWhite() &&
        Objects.equals(position, piece.position);
  }
}
