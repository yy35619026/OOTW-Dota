package Attackenemy;

public interface Subjest {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
    void updateStatus(String status);
}