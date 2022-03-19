package chessgame;

import java.util.LinkedList;
import java.util.Objects;

public class Pawn extends Piece {

  LinkedList<String> availableMoves = new LinkedList<>();

  public Pawn(boolean isWhite, Position position) {
    super(isWhite, position);
  }

  @Override
  public void getAvailableMoves(Position currentPosition) {
    String availableMove;

    if(super.position.getColumn() < 7 && super.position.getRow() < 7) {
      availableMove =
          (super.position.getRow() + 1) + String.valueOf(super.position.getColumn() + 1);
      availableMoves.add(availableMove);
    }

    if(super.position.getColumn() > 0 && super.position.getRow() < 7) {
      availableMove =
          (super.position.getRow() + 1) + String.valueOf(super.position.getColumn() - 1);
      availableMoves.add(availableMove);
    }

    if(super.position.getColumn()> 0 && super.position.getColumn() < 7 && super.position.getRow() < 7) {
      availableMove =
          (super.position.getRow() + 1) + String.valueOf(super.position.getColumn());
      availableMoves.add(availableMove);
    }

    System.out.println(String.format("Possible moves for %d%d:\n",
        currentPosition.getRow(), currentPosition.getColumn()) + availableMoves);
  }

  @Override
  public boolean isValidMove(Position newPosition) {
    int currentPositionRow = super.position.getRow();
    int currentPositionCol = super.position.getColumn();
    return newPosition.getRow() > currentPositionRow &&
        (newPosition.getColumn() - currentPositionCol == 1 ||
            newPosition.getColumn() + currentPositionCol == 1);
  }

  @Override
  public String toString() {
    return "Pawn{" +
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
    Pawn piece = (Pawn) obj;
    return super.getColor() == piece.getColor() &&
        Objects.equals(position, piece.position);
  }
}
