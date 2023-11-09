package SaveVersions;

import Backpaint.GameScreen;

public class Memento {
    private GameScreen gameScreen;
    public Memento(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }
    public GameScreen getGameScreen(){
        return gameScreen;
    }
}
