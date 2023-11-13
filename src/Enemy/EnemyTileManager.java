package Enemy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import Attackenemy.*;
import Strategy.SlowSpeed;
import Strategy.SpeedStrategy;
import Tower.*;

public class EnemyTileManager {
    Random random = new Random();
    private BufferedImage[] enemyImgs;
    private ArrayList<Enemy> enemies= new ArrayList<>();
    private int HPBarWidth = 40;
    Subjest concreteCastle = new ConcreteCastle();
    ObserverCastleHP observerCastleHP = new ObserverCastleHP();
    ObserverEnemy observerEnemy = new ObserverEnemy();
    boolean EnemyDown = false;
    private double money;

    EnemyFactory basicenemyfactory = new BasicEnemyFactory();
    EnemyFactory fastenemyfactory = new FastEnemyFactory();



    public EnemyTileManager(){
        
        
        
        concreteCastle.addObserver(observerCastleHP);
        concreteCastle.addObserver(observerEnemy);

        enemyImgs = new BufferedImage[6];

        loadEnemyImgs();
    }


    private void loadEnemyImgs() {
        BufferedImage atals = LoadTile.getSpriteAtlas();

        for (int i =0; i<4; i++){
            enemyImgs[i]= atals.getSubimage(64*i,0,64,64);
        }
    }


    public void TimeSpawnEnemy() {
        int randomInRange = random.nextInt(2);
        if(randomInRange == 0){
            enemies.add(basicenemyfactory.CreatEnemy(32, 400, 0));
        }else if(randomInRange == 1){
            enemies.add(fastenemyfactory.CreatEnemy(32, 400, 1));
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

    public void update(double money) {
        Iterator<Enemy> iterator = enemies.iterator();
        while (iterator.hasNext()) {
            Enemy e = iterator.next();
            e.move();

            if (e.getHealth() <= 0) {
                concreteCastle.updateStatus("敵人死亡");
                EnemyDown = true;
                money += 20.0;
                this.money = money;
                iterator.remove();
            }else if(e.getX() >= 1500){
                concreteCastle.updateStatus("敵人成功攻城");
                iterator.remove();
            }
        }
    }

    public double getMoney(){
        EnemyDown = false;
        return money;
    }

    public boolean isEnemyDown() {
        return EnemyDown;
    }

    //傳出去enemies陣列 可以去抓enemies的各種數值
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    private int getNewHPBarWidth(Enemy e){
        return (int)(HPBarWidth * e.getHealthFloat());
    }
}
