package Tower;

import Attackenemy.ConcreteCastle;

public interface Tower {
    double getCost();
    double getDamage();
    int getLevel();
    int getAlertRange();
    void update(ConcreteCastle enemy, String status);
}
