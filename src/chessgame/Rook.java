package chessgame;

public class Rook extends Piece {

  private boolean isFirstMove;

  public Rook(boolean isWhite, Position position) {
    super(isWhite, position);
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
    // TODO: update condition
//    if (!super.isValidMove()) return false;

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
  public void showAvailableMovements(Position position) {
    // all horizontal spot in the same row except for current position
    for (int i = 0; i < this.MAX_EDGE; i++) {
      String availableMove = i + String.valueOf(position.getRow());

      // TODO: update condition
//      if (boardPosition.equals(availableMove)) continue;
      //      super.availableMovements.add(); //TODO: Add what here?
    }

    // all vertical spot in the same column except for current position
    for (int i = 0; i < this.MAX_EDGE; i++) {
      String availableMove = i + String.valueOf(position.getColumn());

      // TODO: update condition
//      if (boardPosition.equals(availableMove)) continue;
//      super.availableMovements.add(); //TODO: Add what here?
    }
    System.out.println(String.format("Possible moves for %d%d:\n",
        position.getRow(), position.getColumn()) + super.availableMovements);
  }

  @Override
    public String toString() {
        return "Rook{" +
                "isWhite=" + super.isWhite() +
                ", position=" + super.position +
                "}";
    }
}
