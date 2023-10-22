package Enemy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyTileManager {
    private BufferedImage[] enemyImgs;
    private Enemy testEnemy;
    private ArrayList<Enemy> enemies= new ArrayList<>();

    public EnemyTileManager(){
        enemyImgs = new BufferedImage[6];
        createEnemy();
        addEnemy(1*32,2*32);
        loadEnemyImgs();
    }

    private void createEnemy() {
        EnemyFactory basicenemyfactory = new BasicEnemyFactory();
        testEnemy = basicenemyfactory.CreatEnemy(32*1,32*1,0,0);
    }

    private void loadEnemyImgs() {
        BufferedImage atals = LoadTile.getSpriteAtlas();
        enemyImgs[0]= atals.getSubimage(0,0,64,64);
        enemyImgs[1]= atals.getSubimage(1*32,0,64,64);
        enemyImgs[2]= atals.getSubimage(2*32,0,64,64);
        enemyImgs[3]= atals.getSubimage(3*32,0,64,64);
    }

    private void addEnemy(int x, int y) {
        EnemyFactory basicenemyfactory = new BasicEnemyFactory();
        testEnemy = basicenemyfactory.CreatEnemy(x,y,0,0);
        enemies.add(testEnemy);
    }
    public void draw(Graphics g){
        for(Enemy e:enemies){
            drawEnemy(e,g);
        }
    }

    private void drawEnemy(Enemy e, Graphics g) {
        g.drawImage(enemyImgs[0],(int)e.getX(),(int)e.getY(),null );
    }

    public void update() {
        for(Enemy e:enemies){
            e.move(0.5f,0);
        }
    }
}
