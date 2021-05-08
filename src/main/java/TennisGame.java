import model.Player;

import java.util.function.BiPredicate;

public class TennisGame {

    private Player playerOne;

    private Player playerTwo;

    TennisGame(Player playerOne, Player playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    // Tennis rules
    private BiPredicate<Player,Player> isDeuce = (p1, p2) ->
            p1.getScore() >= 3 && p2.getScore() == p1.getScore();

    private BiPredicate<Player,Player> hasPlayerOneInAdvantage = (p1, p2) ->
            p1.getScore() >= 4 && p1.getScore() == p2.getScore() + 1;

    private BiPredicate<Player,Player> hasPlayerTwoInAdvantage = (p1,p2) ->
            p2.getScore() >= 4 && p2.getScore() == p1.getScore() + 1;

    private BiPredicate<Player,Player> whoLeads = (p1, p2) -> p1.getScore() > p2.getScore();

    private BiPredicate<Player,Player> isPlayerOneWins = (p1,p2) ->
            p1.getScore() >= 4 && p1.getScore() >= p2.getScore() + 2;

    private BiPredicate<Player,Player> isPlayerTwoWins = (p1,p2) ->
            p2.getScore() >= 4 && p2.getScore() >= p1.getScore() + 2;

    private Player playerWithHighestScore(Player playerOne, Player playerTwo) {
        if (whoLeads.test(playerOne,playerTwo)) {
            return playerOne;
        } else {
            return playerTwo;
        }
    }

    private String translateScore(int score) {
        switch (score) {
            case 0:
                return "Zero";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        throw new IllegalArgumentException("Illegal score: " + score);
    }

    public String getScore() {

        if (isPlayerOneWins.test(playerOne,playerTwo) || isPlayerTwoWins.test(playerOne,playerTwo)) {
            return playerWithHighestScore(playerOne,playerTwo).getName() + " wins";
        }

        if (hasPlayerOneInAdvantage.test(playerOne,playerTwo) || hasPlayerTwoInAdvantage.test(playerOne,playerTwo)) {
            return "Advantage " + playerWithHighestScore(playerOne,playerTwo).getName();
        }

        if (isDeuce.test(playerOne,playerTwo)) {
            return "Deuce";
        };
        return  translateScore(playerOne.getScore()) + "," + translateScore(playerTwo.getScore());
    }

    public void playerOneScores() {
        playerOne.add();
    }

    public void playerTwoScores() {
        playerTwo.add();
    }

}
