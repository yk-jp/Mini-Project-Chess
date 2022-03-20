package chessgame;

import java.util.List;

public class Queen extends Piece {

    public Queen(boolean isWhite, String pieceSymbol, Position position) {
        super(isWhite, pieceSymbol, position);
    }

    @Override
    public boolean isValidMovement(Position position) {

        if (!super.isValidMovement(position)) return false;

        // validate unique movement from here
        int currRow = super.position.getRow();
        int currCol = super.position.getColumn();
        int newRow = position.getRow();
        int newCol = position.getColumn();

        // vertical or horizontal move
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
    public List<String> showAvailableMovements(Position position) {
        // all horizontal spot in the same row except for current position
        for (int i = 0; i < this.MAX_EDGE; i++) {
            String availableMove = String.valueOf(position.getRow()) + i;

            if (position.equals(availableMove)) continue;
            if(super.isSamePosition(new Position(position.getRow(),i))) continue;

            super.availableMovements.add(availableMove);
        }

        // all vertical spot in the same column except for current position
        for (int i = 0; i < this.MAX_EDGE; i++) {
            String availableMove = i + String.valueOf(position.getColumn());

            if (position.equals(availableMove)) continue;
            if(super.isSamePosition(new Position(i,position.getColumn()))) continue;

            super.availableMovements.add(availableMove);
        }

        int rowNum = position.getRow() + 1;
        int colNum = position.getColumn() + 1;

        // all right diagonal spot except for current position
        while (rowNum < this.MAX_EDGE && colNum < this.MAX_EDGE) {

            String availableMove = rowNum + String.valueOf(colNum);
            super.availableMovements.add(availableMove);
            rowNum++;
            colNum++;
        }

        rowNum = position.getRow()-1;
        colNum = position.getColumn()-1;
        while (rowNum >= 0 && colNum >= 0) {

            String availableMove = rowNum + String.valueOf(colNum);
            super.availableMovements.add(availableMove);
            rowNum--;
            colNum--;
        }

        // all left diagonal spot except for current position
        rowNum = position.getRow() -1;
        colNum = position.getColumn() + 1;
        while (rowNum >= 0 && colNum < this.MAX_EDGE) {

            String availableMove = rowNum + String.valueOf(colNum);
            super.availableMovements.add(availableMove);
            rowNum--;
            colNum++;
        }

        rowNum = position.getRow() + 1;
        colNum = position.getColumn() - 1;
        while (rowNum < this.MAX_EDGE && colNum >= 0) {

            String availableMove = rowNum + String.valueOf(colNum);
            super.availableMovements.add(availableMove);
            rowNum++;
            colNum--;
        }
        return super.availableMovements;
    }

    @Override
    public String toString() {
        return "Queen{" +
                "isWhite=" + super.isWhite() +
                ", position=" + super.position +
                "}";
    }
}
