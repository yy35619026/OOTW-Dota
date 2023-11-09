package SaveVersions;

import java.util.LinkedList;

public class Caretaker {
    private Originator originator;
    private LinkedList<Memento> history = new LinkedList<Memento>();
    public Caretaker(Originator originator){
        this.originator = originator;
    }
    public void saveMemento(){
        history.push(originator.save());
    }
    public void undo(){
        if(!history.isEmpty()){
            originator.restore(history.pop());
            System.out.println("目前狀態： " + originator.getGameScreen());
        }else {
            System.out.println("History is null!");
        }
    }
}
