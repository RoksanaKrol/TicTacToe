import java.util.Objects;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    String[][] board;

    public Game() {
        this.board = new String[3][3];
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public void move(int y, int x, String player) {
        if (board[y][x] == null) {
            board[y][x] = player;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void printBoard() {
        System.out.println("----------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j]);
                    System.out.print(" ");
                } else {
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
        System.out.println("----------------");
    }
    public String winner() {
        String winner = null;
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != null && Objects.equals(board[i][0],board[i][1]) && Objects.equals(board[i][0],board[i][2])) {
                winner = board[i][0];
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != null && Objects.equals(board[0][i],board[1][i]) && Objects.equals(board[0][i],board[2][i])) {
                winner = board[0][i];
            }
        }
        if (board[0][0] != null && Objects.equals(board[0][0], board[1][1]) && Objects.equals(board[0][0],board[2][2])) {
            winner = board[0][0];
        }
        if(Objects.equals(board[0][0], board[1][1]))
        if (board[0][2] != null && Objects.equals(board[0][0],board[1][1]) && Objects.equals(board[0][0],board[2][0])) {
            winner = board[0][0];
        }

        return winner;
    }

    public void playerMove(String player) {
        boolean movedSuccesfully = false;
        while(!movedSuccesfully) {
            int move = 0;
            System.out.print(player+": ");
            while (move == 0) {
                try {
                    move = Integer.parseInt(scanner.nextLine());
                    if (move > 9 || move < 1) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println("Try again (Choose number between 1 and 9)");
                }
            }
            try {
                switch (move) {
                    case 1 -> {
                        move(0, 0, player);
                        movedSuccesfully = true;
                    }
                    case 2 -> {
                        move(0, 1, player);
                        movedSuccesfully = true;
                    }
                    case 3 -> {
                        move(0, 2, player);
                        movedSuccesfully = true;
                    }
                    case 4 -> {
                        move(1, 0, player);
                        movedSuccesfully = true;
                    }
                    case 5 -> {
                        move(1, 1, player);
                        movedSuccesfully = true;
                    }
                    case 6 -> {
                        move(1, 2, player);
                        movedSuccesfully = true;
                    }
                    case 7 -> {
                        move(2, 0, player);
                        movedSuccesfully = true;
                    }
                    case 8 -> {
                        move(2, 1, player);
                        movedSuccesfully = true;
                    }
                    case 9 -> {
                        move(2, 2, player);
                        movedSuccesfully = true;
                    }
                }
            } catch (Exception e) {
                System.out.println("This filed is alredy taken. Choose another one.");
            }
        }
    }

    public void twoPlayers() {
        int round = 0;
        while (winner() == null) {
            if (round % 2 == 0) {
                playerMove("x");
            } else {
                playerMove("o");
            }
            printBoard();
            if (round == 8) {
                System.out.println("REMIS");
                break;
            }
            round++;
        }
        if (round != 8) {
            if (round % 2 == 0) {
                System.out.println("WINNER: 0");
            } else {
                System.out.println("WINNER: X");
            }
        }
    }
}
