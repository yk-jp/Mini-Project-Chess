package chessgame;

public class Knight extends Piece {

  public Knight(boolean isWhite, Position position,String shape) {
    super(isWhite, position, shape);
  }

  @Override
  public boolean isValidMovement(Position position) {
    int baseXComparison = (super.position.getRow() - position.getRow());
    int baseYComparison = (super.position.getColumn() - position.getColumn());
    return Math.abs(baseXComparison * baseYComparison) == 2;
  }

  @Override
  public void showAvailableMovements(Position position) {
    int[] rows = {2, 2, -2, -2, 1, 1, -1, -1};
    int[] cols = {-1, 1, 1, -1, 2, -2, 2, -2};

    for (int index = 0; index <= 7; index++) {
      int finalRow = position.getRow() + rows[index];
      int finalColumn = position.getColumn() + cols[index];
      String availableMove = finalRow + String.valueOf(finalColumn);

      if((position.getColumn() > 0 && position.getColumn() < 7) &&
          (position.getRow() > 0 && position.getRow() < 7)) {
        super.availableMovements.add(availableMove);
      }
    }
    System.out.println(String.format("Possible moves for %d%d:\n",
        position.getRow(), position.getColumn()) + super.availableMovements);
  }

  @Override
  public String toString() {
    return "Knight{" +
        "isWhite=" + super.isWhite() +
        ", position=" + super.position +
        '}';
  }
}
