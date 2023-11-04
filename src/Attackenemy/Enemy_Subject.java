package Attackenemy;

import Tower1.*;

public interface Enemy_Subject {
    void addObserver(Tower tower);
    void removeObserver(Tower tower);
    void notifyObservers();
    void updateStatus(String status);
}
