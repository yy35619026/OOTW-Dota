package Enemy;

public abstract class Enemy {
    private String type;     // 敌人类型
    private int health;      // 血量
    private int speed;       // 移动速度
    private int x, y;        // 当前位置
    private boolean isAlive; // 存活状态

    public Enemy(String type, int health, int speed) {
        this.type = type;
        this.health = health;
        this.speed = speed;
        this.isAlive = true;
    }

    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            isAlive = false;
        }
    }

    public void move(int deltaX, int deltaY) {
        // 根据速度移动敌人
        x += deltaX;
        y += deltaY;
    }
}
