package SaveVersions;
import java.util.ArrayList;

public class Caretaker {
    private Originator originator;
    private ArrayList<Memento> history = new ArrayList<Memento>(5);
    public Caretaker(Originator originator){
        this.originator = originator;
    }
    public void saveMemento(int index){
        if (index >= 0 && index <= history.size()) {
            history.add(index, originator.save());
        } else {
            System.out.println("Invalid index!");
        }
    }
    public boolean undo(int index){
        if(!history.isEmpty() && index >= 0 && index < history.size()){
            originator.restore(history.get(index));
            System.out.println("目前狀態： " + originator.getGameScreen());
            originator.getGameScreen().getScreen();
            return true;
        }else {
            System.out.println("History is null!");
            return false;
        }
    }
}
