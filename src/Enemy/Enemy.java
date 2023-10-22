package Enemy;

import java.awt.*;

public abstract class Enemy {
    private float x,y;
    private Rectangle bounds;

    private int health;
    private int ID;
    private int enemyType;

    public Enemy(float x,float y,int id, int enemyType) {
        this.x=x;
        this.y=y;;
        this.ID=id;
        this.enemyType=enemyType;
        bounds = new Rectangle((int) x, (int) y, 32,32);
    }



    public void move(float x ,float y ){
        this.x += x;
        this.y += y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public int getHealth() {
        return health;
    }

    public int getID() {
        return ID;
    }

    public int getEnemyType() {
        return enemyType;
    }

}
