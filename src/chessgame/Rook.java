package chessgame;

public class Rook extends Piece {

    public Rook(boolean isWhite){
        super(isWhite);
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        if(!super.isValidMove()) return false;
//      validate unique movement from here

        int currRow = super.position.getRow();
        int currCol = super.position.getColumn();
        int newRow  = newPosition.getRow();
        int newCol  = newPosition.getColumn();

        if(currCol != newCol || currRow != newRow) {
            return false;
        }

        return true;
    }

    public void move() {

    }

    @Override
    public String toString(){
        return "Rook{" +
                "isWhite=" + this.getIsWhite() +
                ", position=" + this.getPosition() +
                "}";
    }
}
