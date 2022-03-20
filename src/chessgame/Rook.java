package chessgame;

import java.util.List;

public class Rook extends Piece {

  private boolean isFirstMove;

  public Rook(boolean isWhite, String pieceSymbol, Position position) {
    super(isWhite, pieceSymbol, position);
    this.isFirstMove = false;
  }

  public void setFirstMove(boolean firstMove) {
    this.isFirstMove = firstMove;
  }

  public boolean getIsFirstMove() {
    return isFirstMove;
  }

  @Override
  public boolean isValidMovement(Position position) {
    if (!super.isValidMovement(position)) return false;

    // validate unique movement from here
    int currRow = super.position.getRow();
    int currCol = super.position.getColumn();
    int newRow = position.getRow();
    int newCol = position.getColumn();

    if (currCol != newCol || currRow != newRow) {
      return false;
    }
    return true;
  }

  @Override
  public List<String> showAvailableMovements(Position position) {
    // all horizontal spot in the same row except for current position
    for (int i = 0; i < this.MAX_EDGE; i++) {
      String availableMove = i + String.valueOf(position.getRow());

      if (position.equals(availableMove)) continue;
            super.availableMovements.add(availableMove);
    }

    // all vertical spot in the same column except for current position
    for (int i = 0; i < this.MAX_EDGE; i++) {
      String availableMove = i + String.valueOf(position.getColumn());

      if (position.equals(availableMove)) continue;
      super.availableMovements.add(availableMove);
    }
    return super.availableMovements;
  }

  @Override
    public String toString() {
        return "Rook{" +
                "isWhite=" + super.isWhite() +
                ", position=" + super.position +
                "}";
    }
}
