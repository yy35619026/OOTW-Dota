package Attackenemy;

public interface Enemy_Observer {
    void update(String status);
    void update(ConcreteCastle concreteCastle, String status);
}
