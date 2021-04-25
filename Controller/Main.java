package Controller;

import Model.GameModel;
import View.GameView;

public class Main {
    public static void main(String[] args) {
        GameView view = new GameView();
        GameModel model = new GameModel();
        view.setSize(800, 600);
        ViewController vc = new ViewController(view, model);
    }
}
