package Tower1;

import Attackenemy.ConcreteEnemy;

public interface Tower {
    double getCost();
    double getDamage();
    int getLevel();
    int getAlertRange();
    void update(ConcreteEnemy enemy, String status);
}
