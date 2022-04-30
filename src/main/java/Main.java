import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isEnd = false;
        while (!isEnd) {
            System.out.println("-------Tic Tac Toe------- | --MOVES--");
            System.out.println("Enter '1' to play         |   1 2 3");
            System.out.println("Enter '0' to close app    |   4 5 6");
            System.out.println("                          |   7 8 9");


            String choise = scanner.nextLine();
            Game game = new Game();

                if (choise.equals("1")) {
                    game.play();
                } else {
                    isEnd = true;
                }
        }
    }
}
