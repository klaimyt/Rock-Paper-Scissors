package Model;

import java.util.Random;
/**
 * The model of RPS game. <br>
 * This model <b><em>REQUIRES</em></b> to implement
 * <em>play(RockPaperScissors)</em> method that set the player's and ai's choose action. <br>
 * <br>
 * AI's choose action randomly sets value each time when <em>play(RockPaperScissors)</em> method requested<br>
 * <hr>
 * <em>getResult</em> returns GameResult enum with game result. <br>
 * <em>getAiChoose</em> returns RockPaperScissor enum with AI's action choose <br>
 *
 * @author Ivan Klimenkov
 * @since 04.03.2021
 */

public class GameModel {
    private RockPaperScissor playerChoose, aiChoose;
    private final Random r = new Random();
    private GameResult result;

    public void play(RockPaperScissor playerChoose) {
        setAiChoose();
        setPlayerChoose(playerChoose);
    }

    public GameResult getResult() {
        setResult();
        return result;
    }

    public RockPaperScissor getAiChoose() {
        return aiChoose;
    }

    private void setPlayerChoose(RockPaperScissor choose) {
        this.playerChoose = choose;
    }

    private void setResult() {
        if (playerChoose.equals(aiChoose)) {
            this.result = GameResult.Draw;
            return;
        }

        switch (playerChoose) {
            case ROCK:
                switch (aiChoose) {
                    case PAPER:
                        this.result = GameResult.Lose;
                        break;
                    case SCISSORS:
                        this.result = GameResult.Win;
                        break;
                }
                break;
            case PAPER:
                switch (aiChoose) {
                    case SCISSORS:
                        this.result = GameResult.Lose;
                        break;
                    case ROCK:
                        this.result = GameResult.Win;
                        break;
                }
                break;
            case SCISSORS:
                switch (aiChoose) {
                    case ROCK:
                        this.result = GameResult.Lose;
                        break;
                    case PAPER:
                        this.result = GameResult.Win;
                        break;
                }
                break;
        }
    }

    private void setAiChoose() {
        RockPaperScissor[] rps = RockPaperScissor.values();
        this.aiChoose = rps[r.nextInt(rps.length)];
    }
}
