package Controller;

import Model.GameModel;
import Model.RockPaperScissor;
import View.GameView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewController {
    GameModel rps;
    GameView view;

    public ViewController(GameView v, GameModel m) {
        this.view = v;
        this.rps = m;

        this.view.addActionButtonListener(new ActionButtonListener());
        this.view.showAlertWithText("Choose your action");
    }

    private void updateUI(RockPaperScissor playerChoose) {
        try {
            view.setAiLabel(rpsToEmoji(rps.getAiChoose()));
            view.setPlayerLabel(rpsToEmoji(playerChoose));
            switch (rps.getResult()) {
                case Win:
                    view.setBackgroundColor(Color.GREEN);
                    view.showAlertWithText("Win");
                    break;
                case Lose:
                    view.setBackgroundColor(Color.RED);
                    view.showAlertWithText("Lose");
                    break;
                case Draw:
                    view.setBackgroundColor(Color.ORANGE);
                    view.showAlertWithText("Draw");
                    break;
            }
        } catch(IllegalArgumentException a) {
            System.out.println("Update UI error");
        }
    }

    //Programming duct tape fix :)
    private String rpsToEmoji(RockPaperScissor rps) {
        switch (rps) {
            case ROCK:
                return "✊";
            case PAPER:
                return "✋";
            case SCISSORS:
                return "✌";
        }
        return null;
    }

    private RockPaperScissor emojiToRPS(String s) {
        switch (s) {
            case "✊":
                return RockPaperScissor.ROCK;
            case "✋":
                return RockPaperScissor.PAPER;
            case "✌":
                return RockPaperScissor.SCISSORS;
        }
        return null;
    }

    private void actionButtonPressed(String buttonName) {
        RockPaperScissor playerChoose = emojiToRPS(buttonName);
        rps.play(playerChoose);
        updateUI(playerChoose);
    }

    class ActionButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonName = e.getActionCommand().toUpperCase();
            actionButtonPressed(buttonName);
        }
    }
}
