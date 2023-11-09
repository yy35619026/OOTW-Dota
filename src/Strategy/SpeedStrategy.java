package Strategy;

import Enemy.Enemy;

public interface SpeedStrategy {
    void execute(Enemy enemy,float x, float y);
}
