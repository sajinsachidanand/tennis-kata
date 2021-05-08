import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisGameTest {

    private Player playerOne = new Player("Nadal");
    private Player playerTwo = new Player("Federer");

    private TennisGame game = new TennisGame(playerOne, playerTwo);

    @Test
    public void testNewGameShouldReturnZeroAll() {
        String score = game.getScore();

        assertEquals("Zero,Zero", score);
    }

    @Test
    public void testPlayerOneWinsFirstBall() {
        game.playerOneScores();

        String score = game.getScore();
        assertEquals("Fifteen,Zero", score);
    }

    @Test
    public void testFifteenAll() {
        game.playerOneScores();
        game.playerTwoScores();

        String score = game.getScore();
        assertEquals("Fifteen,Fifteen", score);
    }


    @Test
    public void testPlayersAreDeuce() {
        createScore(3, 3);

        String score = game.getScore();
        assertEquals("Deuce", score);
    }


    @Test
    public void testPlayersAreDuce4() {
        createScore(4, 4);
        String score = game.getScore();
        assertEquals("Deuce", score);
    }

    @Test
    public void testPlayerTwoAdvantage() {
        createScore(4, 5);

        String score = game.getScore();
        assertEquals("Advantage " + playerTwo.getName(), score);
    }

    @Test
    public void testPlayerOneAdvantage() {
        createScore(5, 4);

        String score = game.getScore();
        assertEquals("Advantage " + playerOne.getName(), score);
    }

    @Test
    public void testPlayerTwoWins() {
        createScore(2, 6);
        String score = game.getScore();
        assertEquals(playerTwo.getName() + " wins", score);
    }

    @Test
    public void testPlayerOneWins() {
        createScore(6, 2);
        String score = game.getScore();
        assertEquals(playerOne.getName() + " wins", score);
    }

    @Test
    public void testPlayerTwoWinsAfterAdvantage() {
        createScore(6, 8);
        String score = game.getScore();
        assertEquals(playerTwo.getName() + " wins", score);
    }

    @Test
    public void testPlayerOneWinsAfterAdvantage() {
        createScore(8, 6);
        String score = game.getScore();
        assertEquals(playerOne.getName() + " wins", score);
    }


    private void createScore(int playerOneBalls, int playerTwoBalls) {
        for (int i = 0; i < playerOneBalls; i++) {
            game.playerOneScores();
        }
        for (int i = 0; i < playerTwoBalls; i++) {
            game.playerTwoScores();
        }
    }


}