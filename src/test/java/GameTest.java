import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game();
    Game game2 = new Game();
    String x = "x";
    String o = "o";

    @Test
    void move() {
        String[][] board = new String[][]{new String[]{"x",null,null},
                                        new String[]{null,"o",null},
                                        new String[]{null,null,"x"}};
        game2.setBoard(board);
        game.move(0,0,x);
        game.move(1,1,o);
        game.move(2,2,x);

        assertEquals(Arrays.deepToString(game.getBoard()), Arrays.deepToString(game2.getBoard()));
    }
    @Test
    void move2() {
        String[][] board = new String[][]{new String[]{"o",null,"o"},
                                          new String[]{"x",null,null},
                                          new String[]{null,"x",null},
        };
        game2.setBoard(board);
        game.move(0,0,o);
        game.move(0,2,o);
        game.move(1,0,x);
        game.move(2,1,x);

        assertEquals(Arrays.deepToString(game.getBoard()), Arrays.deepToString(game2.getBoard()));
    }
    @Test
    void winner() {
        String[][] board = new String[][]{new String[]{"x", null, "o"},
                new String[]{"x", "x", "o"},
                new String[]{null, "x", "x"},
        };
        game.setBoard(board);
        assertEquals("x", game.winner());
    }
    @Test
    void winner2() {
        String[][] board = new String[][]{  new String[]{"x", "o", "o"},
                                            new String[]{"x", "o", "o"},
                                            new String[]{null, "o", "x"},
        };
        game.setBoard(board);
        assertEquals("o", game.winner());
    }
}