package SaveVersions;

import Bridge.GameScreen;

public class Originator {
    private GameScreen gameScreen;
    public Memento save(){
        System.out.println("Success!");
        return new Memento(gameScreen);
    }
    public void restore(Memento m){
        this.gameScreen = m.getGameScreen();
    }
    public void setVersion(GameScreen gameScreen){
        System.out.println("Save！");
        this.gameScreen = gameScreen;
    }
    public GameScreen getGameScreen(){
        return gameScreen;
    }
}
