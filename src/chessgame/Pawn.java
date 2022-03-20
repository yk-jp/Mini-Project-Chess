package chessgame;

public class Pawn extends Piece {

    public Pawn(boolean isWhite, Position position, String shape) {
        super(isWhite, position, shape);
    }

    @Override
    public boolean isValidMovement(Position position) {
        int currentPositionRow = super.position.getRow();
        int currentPositionCol = super.position.getColumn();

        if (position.getRow() > currentPositionRow &&
                (position.getColumn() - currentPositionCol == 1 ||
                        position.getColumn() + currentPositionCol == 1)) {
            return true;
        }
        return false;
    }

    @Override
    public void showAvailableMovements(Position position) {
        String availableMove;

        if (super.position.getColumn() < 7 && super.position.getRow() < 7) {
            availableMove =
                    (super.position.getRow() + 1) + String.valueOf(super.position.getColumn() + 1);
            super.availableMovements.add(availableMove);
        }

        if (super.position.getColumn() > 0 && super.position.getRow() < 7) {
            availableMove =
                    (super.position.getRow() + 1) + String.valueOf(super.position.getColumn() - 1);
            super.availableMovements.add(availableMove);
        }

        if (super.position.getColumn() > 0 &&
                super.position.getColumn() < 7 &&
                super.position.getRow() < 7) {
            availableMove =
                    (super.position.getRow() + 1) + String.valueOf(super.position.getColumn());
            super.availableMovements.add(availableMove);
        }

        System.out.println(String.format("Possible moves for %d%d:\n",
                position.getRow(), position.getColumn()) + super.availableMovements);
    }

    @Override
    public String toString() {
        return "Pawn{" +
                "isWhite=" + super.isWhite() +
                ", position=" + super.position +
                '}';
    }
}
