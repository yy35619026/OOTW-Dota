package SaveVersions;

import Bridge.GameScreen;

public class Memento {
    private GameScreen gameScreen;
    public Memento(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }
    public GameScreen getGameScreen(){
        return gameScreen;
    }
}
