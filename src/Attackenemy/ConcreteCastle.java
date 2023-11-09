package Attackenemy;

import java.util.ArrayList;
import java.util.List;


public class ConcreteCastle implements Subjest {
    private List<Observer> observers = new ArrayList<>();
    private String states;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(states);
        }
    }
    @Override
    public void updateStatus(String states) {
        this.states = states;
        notifyObservers();
    }
}
