package chessgame;

public class Rook extends Piece {

    public Rook(boolean isWhite){
        super(isWhite);
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        if(!super.isValidMove()) return false;
//      validate unique movement from here

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
