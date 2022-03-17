package chessgame;

import java.util.LinkedList;
import java.util.List;

public class Queen extends Piece {

    public Queen(boolean isWhite) {
        super(isWhite);
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

        int rowNum = Integer.parseInt(row);
        int colNum = Integer.parseInt(col);

//        all right diagonal spot except for current position
        while(rowNum < this.MAX_EDGE && colNum < this.MAX_EDGE) {
            rowNum++;
            colNum++;

            String availableMove = String.valueOf(rowNum) + String.valueOf(colNum);
            this.availableMoves.add(availableMove);
        }

        rowNum = Integer.parseInt(row);
        colNum = Integer.parseInt(col);
        while(rowNum > 0 && colNum > 0) {
            rowNum--;
            colNum--;

            String availableMove = String.valueOf(rowNum) + String.valueOf(colNum);
            this.availableMoves.add(availableMove);
        }

//        all left diagonal spot except for current position
        rowNum = Integer.parseInt(row);
        colNum = Integer.parseInt(col);
        while(rowNum > 0 && colNum < this.MAX_EDGE) {
            rowNum--;
            colNum++;

            String availableMove = String.valueOf(rowNum) + String.valueOf(colNum);
            this.availableMoves.add(availableMove);
        }

        rowNum = Integer.parseInt(row);
        colNum = Integer.parseInt(col);
        while(rowNum < this.MAX_EDGE  && colNum > 0) {
            rowNum++;
            colNum--;

            String availableMove = String.valueOf(rowNum) + String.valueOf(colNum);
            this.availableMoves.add(availableMove);
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

        //vertical or horizontal move
        if (currCol == newCol && currRow == newRow) {
            return false;
        }

        int offsetRow = newRow - currRow;
        int offsetCol = newCol - currCol;
        // diagonal move
        if (Math.abs(offsetRow) - Math.abs(offsetCol) == 0) {
            return true;
        }

        return false;
    }

    @Override
    public void move(Position position) {
        super.setPosition(position);
    }

    @Override
    public String toString() {
        return "Queen{" +
                "isWhite=" + this.getIsWhite() +
                ", position=" + this.getPosition() +
                "}";
    }
}
