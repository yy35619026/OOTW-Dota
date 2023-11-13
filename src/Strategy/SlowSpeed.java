package Strategy;

import Enemy.Enemy;

public class SlowSpeed implements SpeedStrategy{

    private float speedX;
    private float speedY;

    @Override
    public void execute(Enemy enemy, float x, float y) {
        speedX = enemy.getSpeed();
        speedY = 0;

        speedX = enemy.getX()+(float) (0.5 * speedX);
        speedY = enemy.getY()+(float) (0.5 * speedY);

        enemy.setX(speedX);
        enemy.setY(speedY);
    }
}
