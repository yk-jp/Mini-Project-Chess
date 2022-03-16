package chessgame;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Knight extends Piece {

  private List<String> availableMoves = new LinkedList<>();

  public Knight(boolean isWhite, Position position) {
    super(isWhite, position);
  }

  @Override
  public void getAvailableMoves(String boardPosition) {
    int[] rows = {2, 2, -2, -2, 1, 1, -1, -1};
    int[] cols = {-1, 1, 1, -1, 2, -2, 2, -2};

    String row = boardPosition.substring(boardPosition.length() / 2);
    String column = boardPosition.substring(0, boardPosition.length() / 2);

    for (int index = 0; index <= 7; index++) {
      int finalRow = Integer.parseInt(row) + rows[index];
      int finalColumn = Integer.parseInt(column) + cols[index];
      String availableMove = finalRow + String.valueOf(finalColumn);
      this.availableMoves.add(availableMove);
    }
    System.out.print("Possible moves for " + boardPosition + ":\n" + availableMoves);
  }

  @Override
  public void move(Position position) {
    super.setPosition(position);
  }

  @Override
  public boolean isValidMove(Position newPosition) {
    int baseXComparison = (super.position.getRow() - newPosition.getRow());
    int baseYComparison = (super.position.getColumn() - newPosition.getColumn());

    if (Math.abs(baseXComparison * baseYComparison) == 2) {
      return true;
    }
    return false;
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
