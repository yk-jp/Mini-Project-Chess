package chessgame;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Bishop extends Piece {

  public Bishop(boolean isWhite, Position position) {
    super(isWhite, position);
  }

  @Override
  public void getAvailableMoves(String boardPosition) {
    List<String> availableMoves = new LinkedList<>();

    System.out.print("Possible moves for " + boardPosition + ":\n" + availableMoves);
  }

  @Override
  public void move(Position position) {
    super.setPosition(position);
  }

  @Override
  public boolean isValidMove(Position finalPosition) {
    int diagonalX = Math.abs(finalPosition.getRow()) - super.position.getRow();
    int diagonalY = Math.abs(finalPosition.getColumn() - super.position.getColumn());

    if(diagonalX == diagonalY && diagonalX > 0){
      return true;
    }
    return false;
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
