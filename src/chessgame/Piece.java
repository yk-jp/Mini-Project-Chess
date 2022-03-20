package chessgame;

import java.util.LinkedList;
import java.util.Objects;

public abstract class Piece {

    private boolean isWhite;
    protected LinkedList<String> availableMovements = new LinkedList<>();
    protected final int MAX_EDGE = 8;
    protected Position position;

    public Piece(boolean isWhite, Position position) {
        setWhite(isWhite);
        setPosition(position);
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void move(Position position) {
        setPosition(position);
    }

    public boolean isValidMovement(Position position) {
        if (position.getRow() > 0 && position.getColumn() > 0
                && position.getRow() < 8 && position.getColumn() < 8) {
            return true;
        } else {
            return false;
        }
    }

    public abstract void showAvailableMovements(Position position);

    @Override
    public String toString() {
        return "Piece{" +
                "isWhite=" + isWhite +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Piece piece = (Piece) o;
        return isWhite == piece.isWhite && Objects.equals(position, piece.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isWhite, position);
    }
}
