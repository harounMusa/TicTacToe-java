import java.util.Scanner;

public class TicTacToe {

    private boolean hasWinner = true;
    private String[][] gameBoard = {
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", " ", " "}};

    public void playGame(){
        System.out.println("####################### WELCOME TO TIC TAC TOE GAME #######################");
        displayGameBoard(gameBoard);
        while(hasWinner){
            // Player X is Turn
            playTurn(gameBoard, "X");
            hasWinner = checkWinner(gameBoard);
            if(!hasWinner) return;

            // Player O is Turn
            playTurn(gameBoard, "O");
            hasWinner = checkWinner(gameBoard);
            if(!hasWinner) return;
        }
    }

    private void playTurn(String[][] gameBoard, String player){
        Scanner scanner = new Scanner(System.in);
        boolean isValidChoice = true;
        System.out.println("Player ("+ player +")'s turn: ");
        while(isValidChoice) {
            int playerC = 0;
            // Validate Column Choice
            while (true) {
                System.out.print("Choice Column 1, 2, or 3: ");
                if (scanner.hasNextInt()) {
                    playerC = scanner.nextInt();
                    if (playerC > 0 && playerC <= 3) {
                        break; // Valid input, exit loop
                    } else {
                        System.out.println("Please choose a number between 1 and 3.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next(); // Clear invalid input
                }
            }

//            System.out.print("Choice Row 1, 2, or 3: ");
//            int playerR = scanner.nextInt();
            int playerR = 0;
            // Validate Row Choice
            while (true) {
                System.out.print("Choice Row 1, 2, or 3: ");
                if (scanner.hasNextInt()) {
                    playerR = scanner.nextInt();
                    if (playerR > 0 && playerR <= 3) {
                        break; // Valid input, exit loop
                    } else {
                        System.out.println("Please choose a number between 1 and 3.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next(); // Clear invalid input
                }
            }

            if (gameBoard[playerR - 1][playerC - 1].equals("X") || gameBoard[playerR - 1][playerC - 1].equals("O")) {
                System.out.println("You can't play here, choice anther square...");
            }
            else{
                gameBoard[playerR - 1][playerC - 1] = player;
                isValidChoice = false;
            }
        }
        displayGameBoard(gameBoard);
    }

    private boolean checkWinner(String[][] gameBoard){
        boolean hasWinner = true;
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (!gameBoard[row][0].equals(" ") &&
                    gameBoard[row][0].equals(gameBoard[row][1]) &&
                    gameBoard[row][1].equals(gameBoard[row][2])) {
                System.out.println("The Winner is " + gameBoard[row][0] + "🥳🥳🥳");
                hasWinner = false; // Game ends
                break; // Stop further check
            }
        }

// Check columns
        for (int col = 0; col < 3; col++) {
            if (!gameBoard[0][col].equals(" ") &&
                    gameBoard[0][col].equals(gameBoard[1][col]) &&
                    gameBoard[1][col].equals(gameBoard[2][col])) {
                System.out.println("The Winner is " + gameBoard[0][col] + "🥳🥳🥳");
                hasWinner = false; // Game ends
                break; // Stop further checks
            }
        }

// Check diagonals
        if (!gameBoard[0][0].equals(" ") &&
                gameBoard[0][0].equals(gameBoard[1][1]) &&
                gameBoard[1][1].equals(gameBoard[2][2])) {
            System.out.println("The Winner is " + gameBoard[0][0] + "🥳🥳🥳");
            hasWinner = false; // Game ends
        }

        if (!gameBoard[0][2].equals(" ") &&
                gameBoard[0][2].equals(gameBoard[1][1]) &&
                gameBoard[1][1].equals(gameBoard[2][0])) {
            System.out.println("The Winner is " + gameBoard[0][2] + "🥳🥳🥳");
            hasWinner = false; // Game ends
        }
        return hasWinner;
    }

    private void displayGameBoard(String[][] gameBoard){
        System.out.println("" +
                "0  1     2     3 \n" +
                "1  " + gameBoard[0][0] + "  |  " + gameBoard[0][1] + "  |  " + gameBoard[0][2] + "  \n" +
                " ----- ----- -----\n" +
                "2  " + gameBoard[1][0] + "  |  " + gameBoard[1][1] + "  |  " + gameBoard[1][2] + "  \n" +
                " ----- ----- -----\n" +
                "3  " + gameBoard[2][0] + "  |  " + gameBoard[2][1] + "  |  " + gameBoard[2][2] + "  \n");
    }
}
