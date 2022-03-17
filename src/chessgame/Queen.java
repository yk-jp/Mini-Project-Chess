package chessgame;

public class Queen extends Piece {

    public Queen(boolean isWhite) {
        super(isWhite);
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
        if (Math.abs(offsetRow) / Math.abs(offsetCol) == 0) {
            return true;
        }

        return false;
    }

    public void move() {

    }

    @Override
    public String toString() {
        return "Queen{" +
                "isWhite=" + this.getIsWhite() +
                ", position=" + this.getPosition() +
                "}";
    }
}
