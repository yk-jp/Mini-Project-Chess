package chessgame;

import java.util.Objects;

public abstract class Piece {

    private boolean color;

    public Piece (boolean color){
        this.color = color;
        setColor(color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return color == piece.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }


    public abstract void move ();


    @Override
    public String toString() {
        return "Piece{" +
                "color=" + color +
                '}';
    }

    public void setColor(boolean color) {
        this.color = color;
    }
}
