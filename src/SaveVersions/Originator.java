package SaveVersions;

import Bridge.GameScreen;
import Bridge.Level_GUI;

public class Originator {
    private Level_GUI level;
    public Memento save(){
        System.out.println("Success!");
        return new Memento(level);
    }
    public void restore(Memento m){
        this.level = m.getLevel();
    }
    public void setVersion(Level_GUI level){
        System.out.println("Save！");
        this.level = level;
    }
    public Level_GUI getLevel(){
        return level;
    }
}
