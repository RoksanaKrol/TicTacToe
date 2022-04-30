import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isEnd = false;
        while (!isEnd) {
            System.out.println("-------Tic Tac Toe------- | --MOVES--");
            System.out.println("Enter '1' if one player   |   1 2 3");
            System.out.println("Enter '2' if two players  |   4 5 6");
            System.out.println("Enter '0' to close app    |   7 8 9");


            String choise = scanner.nextLine();
            Game game = new Game();

            switch (choise) {
                case "1" -> {
                    System.out.println("One player");
                }
                case "2" -> {
                    System.out.println("Two players");
                    game.twoPlayers();
                }
                default -> {
                    isEnd = true;
                }
            }
        }
    }
}
