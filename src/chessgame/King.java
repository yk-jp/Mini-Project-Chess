package chessgame;

import java.util.List;

public class King extends Piece{
    private boolean isFirstMove;

    public King(boolean isWhite, String pieceSymbol, Position position) {
        super(isWhite, pieceSymbol, position);
        this.isFirstMove = false;
    }

    @Override
    public boolean isValidMovement(Position position) {
        int currentPositionRow = super.position.getRow();
        int currentPositionCol = super.position.getColumn();
        // conditional (simplified by Intellij)
        // checking all the positions around the king.
        return Math.abs(position.getRow() - currentPositionRow) == 1 &&
            Math.abs(position.getColumn() - currentPositionCol) == 1 ||
            Math.abs(position.getColumn() - currentPositionCol) == 1
                && position.getRow() == currentPositionRow ||
            Math.abs(position.getRow() - currentPositionRow) == 1 &&
                position.getColumn() == currentPositionCol;
    }

    @Override
    public List<String> showAvailableMovements(Position position) {
        // 2d array for king's full range of movement
        Integer [][] availableMovesKing = {{0,1,2},{0,1,2},{0,1,2}};
        for (int i = 0; i < 2; i ++){
            for (int j = 0; j < 2; j ++){
                String availableMove = String.valueOf(availableMovesKing[i][j]);
                super.availableMovements.add(availableMove);
            }
        }
        return super.availableMovements;
    }

    @Override
    public String toString() {
        return "Piece{" +
            "isWhite=" + super.isWhite() +
            ", position=" + super.position +
            '}';
    }

    public void setFirstMove(boolean firstMove) {
        isFirstMove = firstMove;
    }
    public boolean getIsFirstMove() {
        return isFirstMove;
    }
}
