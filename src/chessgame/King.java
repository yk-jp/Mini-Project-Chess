package chessgame;

import java.util.LinkedList;
import java.util.List;

public class King extends Piece{

    // List for available moves method
    List<String> availableMoves = new LinkedList<>();

    public King(boolean color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position position) {
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
    public void getAvailableMoves(String boardPosition) {
        // 2d array for king's full range of movement
        Integer [][] availableMovesKing = {{0,1,2},{0,1,2},{0,1,2}};
        for (int i = 0; i < 2; i ++){
            for (int j = 0; j < 2; j ++){
                String availableMove = String.valueOf(availableMovesKing[i][j]);
                this.availableMoves.add(availableMove);
            }
        }
        System.out.print("Possible moves for " + boardPosition + ":\n" + availableMoves);
    }


    public void move(Position position, Position newPosition) {
        // King movement is a 2D array where King is always in the 1,1 position
        // and the array moves across the board basically
        // King is allowed to move only one square at a time in any direction.

        //conditional to first validate if movement is possible
        if (isValidMove(position)){
            // conditionals to establish the movement input from player

            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
