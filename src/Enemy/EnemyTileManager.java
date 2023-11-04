package Enemy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import Attackenemy.*;
import Tower1.*;

public class EnemyTileManager {
    private BufferedImage[] enemyImgs;
    private ArrayList<Enemy> enemies= new ArrayList<>();
    private int HPBarWidth = 40;

    public EnemyTileManager(){
        EnemyFactory basicenemyfactory = new BasicEnemyFactory();
        EnemyFactory fastenemyfactory = new FastEnemyFactory();
        enemyImgs = new BufferedImage[6];
        addEnemy(32,300,basicenemyfactory);
        addEnemy(32,400,fastenemyfactory);
        loadEnemyImgs();
    }


    private void loadEnemyImgs() {
        BufferedImage atals = LoadTile.getSpriteAtlas();

        for (int i =0; i<4; i++){
            enemyImgs[i]= atals.getSubimage(64*i,0,64,64);
        }
    }

    private void addEnemy(int x, int y,EnemyFactory factory) {
        switch (factory.getType()){
            case ("basic"):
                enemies.add(factory.CreatEnemy(x,y,0));
                /*for(int i = 0; i < 8; i++){
                    Enemy_Subject.addObserver(Tower);
                }*/
                break;
            case ("fast"):
                enemies.add(factory.CreatEnemy(x,y,1));
                break;
        }
    }

    public void draw(Graphics g){
        for(Enemy e:enemies){
            drawEnemy(e,g);
            drawHealthBar(e,g);
        }
    }

    private void drawHealthBar(Enemy e, Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)e.getX() + 32 - (getNewHPBarWidth(e) / 2) ,(int)e.getY() - 10,getNewHPBarWidth(e),3);
    }

    private void drawEnemy(Enemy e, Graphics g) {
        switch (e.getEnemyType()){
            case 0:
                g.drawImage(enemyImgs[0],(int)e.getX(),(int)e.getY(),null );
                break;
            case 1:
                g.drawImage(enemyImgs[1],(int)e.getX(),(int)e.getY(),null );
                break;
        }
    }



    public void update() {
        for(Enemy e:enemies){
            switch (e.getEnemyType()){
                case 0:
                    e.move(e.getSpeed(0),0);
                    break;
                case 1:
                    e.move(e.getSpeed(1),0);
                    break;
            }
        }
    }

    //傳出去enemies陣列 可以去抓enemies的各種數值
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
    private int getNewHPBarWidth(Enemy e){
        return (int)(HPBarWidth * e.getHealthFloat());
    }
}
