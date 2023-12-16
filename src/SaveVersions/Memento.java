package SaveVersions;

import Bridge.GameScreen;
import Bridge.Level_GUI;

public class Memento {
    private Level_GUI level;
    public Memento(Level_GUI level){
        this.level = level;
    }
    public Level_GUI getLevel(){
        return level;
    }
}
