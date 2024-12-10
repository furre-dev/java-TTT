import java.util.Scanner;

public class Game {
        private final Player player1;
        private final Player player2;
        private final Board board;

        public Game(String player1name, String player2name){
            player1 = new Player(player1name,"X");
            player2 = new Player(player2name, "O");
            board = new Board();
        }


        public void startGame(Scanner sc){
            boolean gameOver = false;
            int currentPlayer = 1;
            System.out.println("Välkommen till Furkan's tic tac toe!");
            while(true){
                if(gameOver){
                    System.out.print("Vill du fortsätta spela? (JA/NEJ)");
                    String answer = sc.next().toUpperCase();
                    if(answer.equals("NEJ")){
                        break;
                    }
                    //Clears the board and sets gameOver to false to begin a new game.
                    board.clearBoard();
                    gameOver = false;
                }

                Player current = (currentPlayer == 1) ? player1 : player2;
                System.out.println("Spelar nu: " + current.getName() + " (" + current.getMark() + ")");
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
                            System.out.println("Vinnaren blev: "+ winnerPlayer.getName() + " (" + winnerPlayer.getMark() + ")");
                            board.printBoard();
                            gameOver = true;
                        };

                        if(board.boardIsFull()){
                            System.out.println("Det blev oavgjort!");
                            gameOver = true;
                };
                currentPlayer = (currentPlayer == 1) ? 2 : 1;
            }
        }
}
