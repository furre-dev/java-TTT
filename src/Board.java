import java.util.Scanner;


public class Board {
    private String[][] board;
    private static final String EMPTY = " ";

    public Board(){
        this.board = new String[3][3];
        clearBoard();
    }

    public boolean placeSelection(int box, Player player){
        if(box < 1 || box > 9){
            System.out.println("Skriv in en siffra mellan 1 och 9");
            return false;
        }

        if(box <= 3) {
            board[0][box-1] = player.getMark();
            return true;
        }else if(box <= 6){
            board[1][box-4] = player.getMark();
            return true;
        }else {
            board[2][box-7] = player.getMark();
            return true;
        }
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
                if(board[i][j] == EMPTY){
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
