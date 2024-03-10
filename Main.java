import java.util.Scanner;
public class Main {
    private static String[][] board = {{" ", " ", " "},
                                       {" ", " ", " "},
                                       {" ", " ", " "}};
    private static boolean isEmpty = true;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to TicTacToe");
        System.out.println();

        boolean lastIsX = true;
        int counter = 0; 
        while (!isFinished()) {
            boolean isX = true;
            if (counter % 2 == 0) {
                System.out.println("X's turn");

            } else {
                System.out.println("O's turn");
                isX = false;
            } 
            System.out.println("Enter row");
            int row = console.nextInt();
            System.out.println("Enter column");
            int col = console.nextInt();
            if (isX) {
                board[row - 1][col - 1] = "X";
            } else {
                board[row - 1][col - 1] = "O";
            }
            isEmpty = false;
            printBoard();
            counter++;
            lastIsX = isX;
        }
        if (lastIsX) {
            System.out.println("X wins!");
        } else {
            System.out.println("O wins!");
        }
    } 

    public static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.println("+---+---+---+");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }

    }

    public static boolean isFinished() {
        if (isEmpty) return false;
        boolean oneRow = false, oneCol = false, oneDiag = true;
        String diag1 = board[0][0];
        String diag2 = board[0][2];
        for (int i = 0; i < board.length; i++) { // check columns
            boolean isSame = true;
            String firstString = board[i][0];
            for (int j = 0; j < board[i].length; j++) {
                if (!board[i][j].equals(firstString)) {
                    isSame = false;
                }
            }
            if (isSame && !firstString.equals(" "))  oneCol = true;
        }
        for (int j = 0; j < board[0].length; j++) { // check rows
            boolean isSame = true;
            String firstString = board[0][j];
            for (int i = 0; i < board.length; i++) {
                if (!board[i][j].equals(firstString)) {
                    isSame = false;
                }
            }
            if (isSame && !firstString.equals(" ")) oneRow = true;
        }
        boolean isSame1 = true;
        boolean isSame2 = true;
        for(int i = 1; i < board.length; i++) {
            if (!board[i][i].equals(diag1) || diag1.equals(" ")) isSame1 = false;
            if (!board[i][board.length - 1 - i].equals(diag2) || diag2.equals(" ")) isSame2 = false;
        }
        oneDiag = isSame1 || isSame2;
        return oneRow || oneCol || oneDiag;
    }
}
