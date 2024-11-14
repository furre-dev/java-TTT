import java.util.Scanner;

public class Game {
        private Player player1;
        private Player player2;
        private Board board;

        public Game(String player1name, String player2name){
            player1 = new Player(player1name,"X");
            player2 = new Player(player2name, "O");
            board = new Board();
        }


        public void startGame(Scanner sc){
            boolean gameOver = false;
            int currentPlayer = 1;
            System.out.println("Välkommen till Furkan's tic tac toe!");
            while(!gameOver){
                Player current = (currentPlayer == 1) ? player1 : player2;
                System.out.println("Spelar nu:" + current.getName());
                board.printBoard();

                boolean selectionPlaced = false;
                while(!selectionPlaced){
                System.out.print("Skriv in en siffra från 1 till 9: ");
                int marker = sc.nextInt();
                selectionPlaced = board.placeSelection(marker, current);
                if (!selectionPlaced) {
                    System.out.println("Ogiltigt val, försök igen!");
                    }
                }

                int winner = board.checkWinner();
                if(winner != 0){
                    Player winnerPlayer = (winner == 1) ? player1 : player2;
                    System.out.println("Vinnaren blev: "+ winnerPlayer.getName());
                    board.printBoard();
                    gameOver = true;
                };

                if(board.boardIsFull()){
                    System.out.println("Det blev oavgjort!");
                    board.printBoard();
                    gameOver = true;
                };
                currentPlayer = (currentPlayer == 1) ? 2 : 1;
            }
        }


//    public static void startGame(){
//        boolean gameOver = false;
//        int player = 1;
//        System.out.println("Välkommen till Furkan's tic tac toe!");
//        while(!gameOver){
//            System.out.println("Spelar nu:" + getPlayerMark(player));
//            printBoard();
//
//            boolean selectionPlaced = false;
//            while(!selectionPlaced){
//                System.out.print("Skriv in en siffra från 1 till 9: ");
//                int marker = sc.nextInt();
//                selectionPlaced = placeSelection(marker, player);
//                if (!selectionPlaced) {
//                    System.out.println("Ogiltigt val, försök igen!");
//                }
//            }
//
//            int winner = checkWinner();
//            if(winner != 0){
//                System.out.println("Vinnaren blev: "+ winner);
//                printBoard();
//                break;
//            };
//
//            if(boardIsFull()){
//                System.out.println("Det blev oavgjort!");
//                printBoard();
//                break;
//            };
//            player = (player == 1) ? 2 : 1;
//        }
//    }
}
