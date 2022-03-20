package chessgame;

public class Queen extends Piece {

    public Queen(boolean isWhite, Position position,String shape) {
        super(isWhite, position, shape);
    }

    @Override
    public boolean isValidMovement(Position position) {

        // TODO: update condition
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
    public void showAvailableMovements(Position position) {
        // all horizontal spot in the same row except for current position
        for (int i = 0; i < this.MAX_EDGE; i++) {
            String availableMove = i + String.valueOf(position.getRow());

            // TODO: update condition
            if (position.equals(availableMove)) continue;
            super.availableMovements.add(availableMove);
        }

        // all vertical spot in the same column except for current position
        for (int i = 0; i < this.MAX_EDGE; i++) {
            String availableMove = i + String.valueOf(position.getColumn());

            // TODO: update condition
            if (position.equals(availableMove)) continue;
            super.availableMovements.add(availableMove);
        }

        int rowNum = position.getRow();
        int colNum = position.getColumn();

        // all right diagonal spot except for current position
        while (rowNum < this.MAX_EDGE && colNum < this.MAX_EDGE) {
            rowNum++;
            colNum++;

            String availableMove = rowNum + String.valueOf(colNum);
            super.availableMovements.add(availableMove);
        }

        rowNum = position.getRow();
        colNum = position.getColumn();
        while (rowNum > 0 && colNum > 0) {
            rowNum--;
            colNum--;

            String availableMove = rowNum + String.valueOf(colNum);
            super.availableMovements.add(availableMove);
        }

        // all left diagonal spot except for current position
        rowNum = position.getRow();
        colNum = position.getColumn();
        while (rowNum > 0 && colNum < this.MAX_EDGE) {
            rowNum--;
            colNum++;

            String availableMove = rowNum + String.valueOf(colNum);
            super.availableMovements.add(availableMove);
        }

        rowNum = position.getRow();
        colNum = position.getColumn();
        while (rowNum < this.MAX_EDGE && colNum > 0) {
            rowNum++;
            colNum--;

            String availableMove = rowNum + String.valueOf(colNum);
            super.availableMovements.add(availableMove);
        }

        System.out.println(String.format("Possible moves for %d%d:\n",
                position.getRow(), position.getColumn()) + super.availableMovements);
    }

    @Override
    public String toString() {
        return "Queen{" +
                "isWhite=" + super.isWhite() +
                ", position=" + super.position +
                "}";
    }
}
