package Attackenemy;

import Tower.*;

public interface Castle_Subject {
    void addObserver(Enemy_Observer o);
    void removeObserver(Enemy_Observer o);
    void notifyObservers();
    void updateStatus(String status);
}
