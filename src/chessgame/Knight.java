package chessgame;

import java.util.LinkedList;
import java.util.Objects;

public class Knight extends Piece {

  private LinkedList<String> availableMoves = new LinkedList<>();

  public Knight(boolean isWhite, Position position) {
    super(isWhite, position);
  }

  @Override
  public void getAvailableMoves(Position currentPosition) {
    int[] rows = {2, 2, -2, -2, 1, 1, -1, -1};
    int[] cols = {-1, 1, 1, -1, 2, -2, 2, -2};

    for (int index = 0; index <= 7; index++) {
      int finalRow = currentPosition.getRow() + rows[index];
      int finalColumn = currentPosition.getColumn() + cols[index];
      String availableMove = finalRow + String.valueOf(finalColumn);
      this.availableMoves.add(availableMove);
    }
    availableMoves.add("e8");
    System.out.println(String.format("Possible moves for %d%d:\n",
        currentPosition.getRow(), currentPosition.getColumn()) + availableMoves);
  }

  @Override
  public void move(Position position) {
    super.setPosition(position);
  }

  @Override
  public boolean isValidMove(Position newPosition) {
    int baseXComparison = (super.position.getRow() - newPosition.getRow());
    int baseYComparison = (super.position.getColumn() - newPosition.getColumn());
    return Math.abs(baseXComparison * baseYComparison) == 2;
  }

  @Override
  public String toString() {
    return "Knight{" +
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
    Knight piece = (Knight) obj;
    return super.isWhite() == piece.isWhite() &&
        Objects.equals(position, piece.position);
  }
}
