package chessgame;

public class Queen extends Piece {

    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        if(!super.isValidMove()) return false;
//      validate unique movement from here

        return true;
    }

    public void move(){

    }

    @Override
    public String toString(){
        return "Queen{" +
                "isWhite=" + this.getIsWhite() +
                ", position=" + this.getPosition() +
                "}";
    }
}
