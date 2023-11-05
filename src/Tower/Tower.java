package Tower;

import Attackenemy.ConcreteEnemy;

public interface Tower {
    double getCost();
    double getDamage();
    int getLevel();
    double getAlertRange();
    void update(ConcreteEnemy enemy, String status);
}
