package chessgame;

import java.util.LinkedList;
import java.util.List;

public class Rook extends Piece {
    private boolean isFirstMove;

    public Rook(boolean isWhite) {
        super(isWhite);
        this.isFirstMove = false;
    }

    @Override
    public void getAvailableMoves(String boardPosition) {
        String row = boardPosition.substring(boardPosition.length() / 2);
        String col = boardPosition.substring(0, boardPosition.length() / 2);

//      all horizontal spot in the same row except for current position

        for (int i = 0; i < this.MAX_EDGE; i++) {
            String availableMove = i + row;
            if (boardPosition.equals(availableMove)) continue;
            availableMoves.add();
        }

//      all vertical spot in the same column except for current position
        for (int i = 0; i < this.MAX_EDGE; i++) {
            String availableMove = i + col;
            if (boardPosition.equals(availableMove)) continue;
            this.availableMoves.add();
        }

        System.out.print("Possible moves for " + boardPosition + ":\n" + availableMoves);
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        if (!super.isValidMove()) return false;
//      validate unique movement from here

        int currRow = super.position.getRow();
        int currCol = super.position.getColumn();
        int newRow = newPosition.getRow();
        int newCol = newPosition.getColumn();

        if (currCol != newCol || currRow != newRow) {
            return false;
        }

        return true;
    }

    @Override
    public void move(Position position) {
        super.setPosition(position);
    }

    @Override
    public String toString() {
        return "Rook{" +
                "isWhite=" + this.getIsWhite() +
                ", position=" + this.getPosition() +
                "}";
    }

    public void setFirstMove(boolean firstMove) {
        isFirstMove = firstMove;
    }

    public boolean getIsFirstMove() {
        return this.isFirstMove;
    }
}
