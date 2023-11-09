package Strategy;

import Enemy.Enemy;

public class FastSpeed implements SpeedStrategy {

    private float speedX;
    private float speedY;

    private float newX;
    private float newY;

    float minY; // 你的最小 Y 值
    float maxY; // 你的最大 Y 值

    boolean increasing;

    public FastSpeed(Enemy enemy) {
        // 初始时获取敌人的 Y 值，用它来设置 minY 和 maxY
        minY = enemy.getY() - 10;
        maxY = enemy.getY() + 10; // 例如，设置最大值为当前值 + 10，你可以根据需要调整这个值
        increasing = true;
    }

    @Override
    public void execute(Enemy enemy, float x, float y) {
        speedX = enemy.getSpeed(enemy.getEnemyType());

        if (increasing) {
            speedY = 0.25f;
        } else {
            speedY = -0.25f;
        }

        // 控制 speedY 的递增和递减
        float newY = enemy.getY() + speedY;

        // 判断是否达到边界值，如果是则切换递增和递减的方向
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
