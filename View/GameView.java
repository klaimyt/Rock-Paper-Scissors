package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameView extends JFrame {
    private JPanel mainPanel;
    private JPanel aiPanel;
    private JLabel aiLabel;
    private JLabel playerLabel;
    private JButton rock;
    private JButton paper;
    private JButton scissors;
    private JPanel playerPanel;

    public GameView() {
        super("Rock, Paper, Scissors!");
        this.setContentPane(mainPanel);
        aiPanel.setOpaque(false);
        playerPanel.setOpaque(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
    }

    public void setPlayerLabel(String s) {
        playerLabel.setText(s);
    }

    public void setAiLabel(String s) { aiLabel.setText(s); }

    public void setBackgroundColor(Color c) { mainPanel.setBackground(c); }

    public void showAlertWithText(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    public void addActionButtonListener(ActionListener listenerForActionButton) {
        rock.addActionListener(listenerForActionButton);
        paper.addActionListener(listenerForActionButton);
        scissors.addActionListener(listenerForActionButton);
    }
}
