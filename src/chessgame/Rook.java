package chessgame;

public class Rook extends Piece {

    private boolean isFirstMove;

    public Rook(boolean isWhite, Position position, String shape) {
        super(isWhite, position, shape);
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
        if (!super.isValidMovement(position)) return false;

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
