package chessgame;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Pawn extends Piece {

  public Pawn(boolean isWhite, Position position) {
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
  public boolean isValidMove(Position position) {
    int currentPositionRow = super.position.getRow();
    int currentPositionCol = super.position.getColumn();

    if(position.getRow() > currentPositionRow &&
        (position.getColumn() - currentPositionCol == 1 ||
            position.getColumn() + currentPositionCol == 1)) {
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return "Pawn{" +
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
    Pawn piece = (Pawn) obj;
    return super.isWhite() == piece.isWhite() &&
        Objects.equals(position, piece.position);
  }
}
