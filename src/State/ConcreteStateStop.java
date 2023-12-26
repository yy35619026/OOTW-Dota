package State;

public class ConcreteStateStop extends State {
    public boolean isRunning;
    public ConcreteStateStop(boolean isRunning){
        this.isRunning = isRunning;
    }

    @Override
    public boolean Handle() {
        isRunning = false;
        return isRunning;
    }

    @Override
    public void  ReGm() {

    }
}
