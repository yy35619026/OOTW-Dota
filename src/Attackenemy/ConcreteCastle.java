package Attackenemy;

import java.util.ArrayList;
import java.util.List;

import Enemy.Enemy;
import Tower.*;
public class ConcreteCastle implements Castle_Subject {
    private List<Enemy_Observer> observers = new ArrayList<>();
    private String status;
    @Override
    public void addObserver(Enemy_Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Enemy_Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Enemy_Observer o : observers) {
            o.update(this, status);
        }
    }

    @Override
    public void updateStatus(String status) {
        this.status = status;
        notifyObservers();
    }
}
