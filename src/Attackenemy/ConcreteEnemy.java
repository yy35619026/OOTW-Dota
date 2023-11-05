package Attackenemy;

import java.util.ArrayList;
import java.util.List;
import Tower.*;
public class ConcreteEnemy implements Enemy_Subject {
    private List<Tower> observers = new ArrayList<>();
    private String status;
    @Override
    public void addObserver(Tower tower) {
        observers.add(tower);
    }

    @Override
    public void removeObserver(Tower tower) {
        observers.remove(tower);
    }

    @Override
    public void notifyObservers() {
        for (Tower tower : observers) {
            tower.update(this, status);
        }
    }

    @Override
    public void updateStatus(String status) {
        this.status = status;
        notifyObservers();
    }
}
