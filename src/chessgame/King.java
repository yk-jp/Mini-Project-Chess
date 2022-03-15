package chessgame;

public class King extends Piece{

    public King(boolean color) {
        super(color);
    }

    @Override
    public void move() {
        // The King is able to move one space at a time in any direction
        //I need to know how I'm going to establish its original position
        // And I need to get the movement from the user by using a scanner
        // Then I add a validation of the position class to review if it's free.
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
