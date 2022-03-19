package chessgame;

public class Driver {

  public static void main(String[] args) {
    Game game = new Game();

    Bishop bishop = new Bishop(true, new Position(1, 3));
    bishop.showAvailableMovements(bishop.getPosition());
  }

}
