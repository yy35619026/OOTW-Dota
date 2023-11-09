package SaveVersions;

import Backpaint.GameScreen;

public class Originator {
    private GameScreen gameScreen;
    public Memento save(){
        return new Memento(gameScreen);
    }
    public void restore(Memento m){
        this.gameScreen = m.getGameScreen();
    }
    public void setVersion(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }
    public GameScreen getGameScreen(){
        return gameScreen;
    }
}
