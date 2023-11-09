package Attackenemy;

import Tower.*;

public interface Castle_Subject {
    void addObserver(Tower tower);
    void removeObserver(Tower tower);
    void notifyObservers();
    void updateStatus(String status);
}
