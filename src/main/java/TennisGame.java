import model.Player;

public class TennisGame {

    Player playerOne;

    Player playerTwo;

    TennisGame(Player playerOne, Player playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String getScore() {
        return "";
    }

    public void playerOneScores() {
        playerOne.add();
    }

    public void playerTwoScores() {
        playerTwo.add();
    }

}
