package chessgame;

import java.util.List;

public class Pawn extends Piece {

  private boolean isFirstMove;

  public Pawn(boolean isWhite, String pieceSymbol, Position position) {
    super(isWhite, pieceSymbol, position);
    this.isFirstMove = false;
  }

  @Override
  public boolean isValidMovement(Position position) {
    int currentPositionRow = super.position.getRow();
    int currentPositionCol = super.position.getColumn();

    if (position.getRow() > currentPositionRow &&
            (position.getColumn() - currentPositionCol == 1 ||
                    position.getColumn() + currentPositionCol == 1)) {
      return true;
    }
    return false;
  }

  @Override
  public List<String> showAvailableMovements(Position position) {
    String availableMove;

    if (super.position.getColumn() < 7 && super.position.getRow() < 7) {
      availableMove =
              (super.position.getRow() + 1) + String.valueOf(super.position.getColumn() + 1);
      super.availableMovements.add(availableMove);
    }

    if (super.position.getColumn() > 0 && super.position.getRow() < 7) {
      availableMove =
              (super.position.getRow() + 1) + String.valueOf(super.position.getColumn() - 1);
      super.availableMovements.add(availableMove);
    }

    if (super.position.getColumn() > 0 &&
            super.position.getColumn() < 7 &&
            super.position.getRow() < 7) {
      availableMove =
              (super.position.getRow() + 1) + String.valueOf(super.position.getColumn());
      super.availableMovements.add(availableMove);
    }
    return super.availableMovements;
  }

  @Override
  public String toString() {
    return "Pawn{" +
            "isWhite=" + super.isWhite() +
            ", position=" + super.position +
            '}';
  }

  public void setFirstMove(boolean firstMove) {
    this.isFirstMove = firstMove;
  }

  public boolean getIsFirstMove() {
    return isFirstMove;
  }
}