package chessgame;

public class Bishop extends Piece {

  public Bishop(boolean isWhite, Position position, String shape) {
    super(isWhite, position,shape);
  }

  @Override
  public boolean isValidMovement(Position position) {
    int diagonalX = Math.abs(position.getRow()) - super.position.getRow();
    int diagonalY = Math.abs(position.getColumn() - super.position.getColumn());
    return diagonalX == diagonalY && diagonalX > 0;
  }

  @Override
  public void showAvailableMovements(Position position) {
    for (int idx = 0; idx < 7; idx++) {
      for (int jdx = 0; jdx < 7; jdx++) {
        int finalRowRight = position.getRow() + idx;
        int finalRowLeft = position.getRow() + idx;
        int finalColumnRight = position.getColumn() + jdx;
        int finalColumnLeft = position.getColumn() - jdx;
        String availableMoveRight = finalRowRight + String.valueOf(finalColumnRight);
        String availableMoveLeft = finalRowLeft + String.valueOf(finalColumnLeft);

//        System.out.println("Final row: " + finalRowLeft);
//        System.out.println("Final column: " + finalColumnLeft);

        if((finalColumnLeft - finalRowLeft == 0 || finalColumnLeft - finalRowLeft == -2 )
            && finalColumnLeft >= 1) {
          if(!super.availableMovements.contains(availableMoveLeft)) {
            super.availableMovements.add(availableMoveLeft);
          }
        }

        if(finalColumnRight - finalRowRight == 2 && finalRowRight < 7) {
          if(!super.availableMovements.contains(availableMoveRight)) {
            super.availableMovements.add(availableMoveRight);
          }
        }
//        System.out.println();
      }
    }
    System.out.println(String.format("Possible moves for %d%d:\n",
        position.getRow(), position.getColumn()) + super.availableMovements);
  }

  @Override
  public String toString() {
    return "Bishop{" +
        "isWhite=" + super.isWhite() +
        ", position=" + super.position +
        '}';
  }
}
