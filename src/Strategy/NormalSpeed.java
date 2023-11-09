package Strategy;


import Enemy.Enemy;

public class NormalSpeed implements SpeedStrategy{

    private float speedX;
    private float speedY;


    @Override
    public void execute(Enemy enemy, float x, float y) {
        speedX = enemy.getSpeed();
        speedY = 0;

        speedX = enemy.getX()+(float) (1 * speedX);
        speedY = enemy.getY()+(float) (1 * speedY);

        enemy.setX(speedX);
        enemy.setY(speedY);
    }
}
