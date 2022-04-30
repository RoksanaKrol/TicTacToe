import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isEnd = false;
        while (!isEnd) {
            System.out.println("-------Tic Tac Toe-------");
            System.out.println("Enter '1' if one player");
            System.out.println("Enter '2' if two players");
            System.out.println("Enter '0' to close app");

            String choise = scanner.nextLine();

            switch (choise) {
                case "1" -> {
                    System.out.println("One player");
                }
                case "2" -> {
                    System.out.println("Two players");
                }
                default -> {
                    isEnd = true;
                }
            }
        }
    }
}
