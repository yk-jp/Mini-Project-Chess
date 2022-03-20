package chessgame;

import java.util.*;

public class Game {
    private Piece[][] board;

    private boolean isWhiteTurn;

    private enum PIECE_COLOR {
        WHITE,
        BLACK
    }

    private enum COMMAND_OPTIONS {
        HELP,
        BOARD,
        RESIGN,
        MOVES,
        SQUARE,
        UCI
    }

    private static final Set<Integer> rowIndex = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)); // or a,b,c...
    private static final Set<Integer> colIndex = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));


    public Game() {
        System.out.println("Starting gaming...\n");
        this.board = Game.populateGameBoard();
        this.isWhiteTurn = true;
    }

    public static Piece[][] populateGameBoard() {
        Piece[][] populatedGameBoard = new Piece[8][8];

        for(int idx = 0; idx < 7; idx++) {
            for(int jdx = 0; jdx < 7; jdx++) {

            }
        }
    }


    /**
     * conditions to end this game.
     * 1.when either of  users resigned
     * 2.when either of users lost by checkmate
     * 3.when game is a draw.
     */
    public void start() {
        String userInput = this.mainMenu();

        while (true) {

            // get user input conditionally

            // 1. help command
            if (userInput.toUpperCase().equals(COMMAND_OPTIONS.HELP)) {
                this.helpMenu();

            } else {
                // 2. user entered position data properly


            }

            isWhiteTurn = !isWhiteTurn;
        }

    }


    /**
     * @return String: user's input data
     */
    public String mainMenu() {
        PIECE_COLOR pieceColor = isWhiteTurn ? PIECE_COLOR.WHITE : PIECE_COLOR.BLACK;

        System.out.printf("%s to move\n", pieceColor);
        System.out.print("Enter UCI (type 'help' for help): ");

        return ;
    }

    public String helpMenu() {
        System.out.println("* type 'help' for help");
        System.out.println("* type 'board' to see the board again");
        System.out.println("* type 'resign' to resign");
        System.out.println("* type 'moves' to list all possible moves");
        System.out.println("* type a square (e.g. b1, e2) to list possible moves for that square");
        System.out.println("* type UCI (e.g.  b1c3, e7e8q) to make a move");

        String userInput;

        // get user input here

        return userInput;
    }


//    /**
//     * receive a position to move for piece instance
//     *
//     * @return string: input data
//     */
//
//    public String UCICommandUserInput() {
//
//        String userInput = this.baseUserInput();
//        // conditional


    public Game() {
        System.out.println("Starting gaming...\n");
        this.board = new Piece[8][8];
        this.isWhiteTurn = true;
    }

    /**
     * conditions to end this game.
     * 1.when either of  users resigned
     * 2.when either of users lost by checkmate
     * 3.when game is a draw.
     */
    public void start() {
        String userInput = this.mainMenu();

        while (true) {

            // get user input conditionally

            // 1. help command
            if (userInput.toUpperCase().equals(COMMAND_OPTIONS.HELP)) {
                this.helpMenu();

            } else {
                // 2. user entered position data properly


            }

            isWhiteTurn = !isWhiteTurn;
        }

    }


    /**
     * @return String: user's input data
     */
    public String mainMenu() {
        PIECE_COLOR pieceColor = isWhiteTurn ? PIECE_COLOR.WHITE : PIECE_COLOR.BLACK;

        System.out.printf("%s to move\n", pieceColor);
        System.out.print("Enter UCI (type 'help' for help): ");

        return;
    }

    public String helpMenu() {
        System.out.println("* type 'help' for help");
        System.out.println("* type 'board' to see the board again");
        System.out.println("* type 'resign' to resign");
        System.out.println("* type 'moves' to list all possible moves");
        System.out.println("* type a square (e.g. b1, e2) to list possible moves for that square");
        System.out.println("* type UCI (e.g.  b1c3, e7e8q) to make a move");

        String userInput;

        // get user input here

        return userInput;
    }


//    /**
//     * receive a position to move for piece instance
//     *
//     * @return string: input data
//     */
//
//    public String UCICommandUserInput() {
//
//        String userInput = this.baseUserInput();
//        // conditional
//
//
//        return userInput;
//    }

    /**
     * help command options
     *
     * @return string: input data
     */
    public void helpCommandUserInput() {

        String userInput;
        while (true) {
            userInput = this.baseUserInput().toUpperCase();

            if (userInput.equals(COMMAND_OPTIONS.HELP)) {
                this.helpMenu();
                break;
            } else if (userInput.equals(COMMAND_OPTIONS.BOARD)) {
//                this.boardStatus(); //alex works on it. method name could be changed . method name could be changed
                break;
            } else if (userInput.equals(COMMAND_OPTIONS.RESIGN)) {
                break;
            }
//            else if(userInput.equals(COMMAND_OPTIONS.MOVES)){  // think about it later
//              break;
//            } else if(userInput.equals(COMMAND_OPTIONS.SQUARE)){ // think about it later
//              break;
//            }

            // invalid input
            System.out.println("invalid input, please try again");

            continue; // change it later
        }
    }

    /**
     * @return String: input data. validate only empty string
     */
    public String baseUserInput() {
        String userInput;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextLine();

            if (userInput.length() == 2 &&
                    rowIndex.contains(userInput.substring(0, 1)) &&
                    colIndex.contains(userInput.substring(1, 2))) {

                    break;
            }
            if (userInput.toUpperCase().equals(COMMAND_OPTIONS.HELP)) break;


            System.out.println("Invalid input, Please try again");
            continue;
        }

        return userInput;
    }
}
