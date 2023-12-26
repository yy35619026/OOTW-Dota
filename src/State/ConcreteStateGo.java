package State;

public class ConcreteStateGo extends State {
    public boolean isRunning;
    public ConcreteStateGo(boolean isRunning){
        this.isRunning = isRunning;
    }

    @Override
    public boolean Handle() {
        isRunning = true;
        return isRunning;
    }

    @Override
    public void  ReGm() {

    }

}