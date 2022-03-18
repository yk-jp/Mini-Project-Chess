package chessgame;

import java.util.Objects;

public abstract class Piece {

    private boolean isWhite;

    public Piece (boolean isWhite){
        this.isWhite = isWhite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return isWhite == piece.isWhite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isWhite);
    }


    public void move (){}


    public abstract boolean isValidMove(Position position);

    public abstract void getAvailableMoves(String boardPosition);

    @Override
    public String toString() {
        return "Piece{" +
                "color=" + isWhite +
                '}';
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }
}
