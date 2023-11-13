package Strategy;

import Enemy.Enemy;

public class FastSpeed implements SpeedStrategy {

    private float speedX;
    private float speedY;

    private float newX;
    private float newY;

    float minY;
    float maxY;

    boolean increasing;

    public FastSpeed(Enemy enemy) {
        minY = enemy.getY() - 10;
        maxY = enemy.getY() + 10;
        increasing = true;
    }

    @Override
    public void execute(Enemy enemy, float x, float y) {
        speedX = enemy.getSpeed();

        if (increasing) {
            speedY = 0.25f;
        } else {
            speedY = -0.25f;
        }

        float newY = enemy.getY() + speedY;

        if (enemy.getY() >= maxY) {
            increasing = false;
        } else if (enemy.getY() <= minY) {
            increasing = true;
        }

        float newX = enemy.getX() + (float) (1.2 * speedX);

        enemy.setX(newX);
        enemy.setY(newY);
    }
}
