import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Skriv ett namn för spelare 1: ");
        String name1 = sc.next();
        System.out.print("Skriv ett namn för spelare 2: ");
        String name2 = sc.next();


        Game game = new Game(name1, name2);
        game.startGame(sc);
    }
}
