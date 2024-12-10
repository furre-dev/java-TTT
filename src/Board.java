import java.util.Objects;
import java.util.Scanner;


public class Board {
    private final String[][] board;
    private static final String EMPTY = " ";

    public Board(){
        this.board = new String[3][3];
        clearBoard();
    }

    public boolean placeSelection(int box, Player player){
        //we only have 9 boxes, so we retry if the input is netrual, negative or over 9.
        if(box < 1 || box > 9){
            System.out.println("Skriv in en siffra mellan 1 och 9, var säker på att boxen är tom");
            return false;
        }

        //This will make sure we mark the right box. I'm not a mathematical genius, got this from ChatGPT.
        int row = (box - 1) / 3;
        int col = (box - 1) % 3;

        if(board[row][col].equals(EMPTY)){
            board[row][col] = player.getMark();
            return true;
        }

        System.out.println("Detta");
        return false;
    };

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2] + " ");
            if (i < board.length - 1) {
                System.out.println("---+---+---");
            }
        }
    }

    public void clearBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public boolean boardIsFull() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j].equals(EMPTY)){
                    isFull = false;
                }
            }
        }
        return isFull;
    }

    public int checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals(EMPTY)) {
                return board[i][0].equals("X") ? 1 : 2; // Return player 1 or 2
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].equals(EMPTY)) {
                return board[0][i].equals("X") ? 1 : 2; // -||-
            }
        }

        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals(EMPTY)) {
            return board[0][0].equals("X") ? 1 : 2;  // -||-
        }
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals(EMPTY)) {
            return board[0][2].equals("X") ? 1 : 2;  // -||-
        }
        return 0;
    }

}
