import model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisGameTest {

    Player playerOne = new Player("Nadal");
    Player playerTwo = new Player("Federer");

    TennisGame game = new TennisGame(playerOne, playerTwo);

    @Test
    public void testNewGameShouldReturnZeroAll() {
        String score = game.getScore();

        assertEquals("Zero all", score);
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
        assertEquals("Fifteen all", score);
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


    private void createScore(int playerOneBalls, int playerTwoBalls) {

    }


}