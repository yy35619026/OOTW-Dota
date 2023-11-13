package Bridge;

import Backpaint.BackgroundPanel;
import Enemy.Enemy;
import SaveVersions.Caretaker;
import SaveVersions.Originator;
import Strategy.*;
import Tower.*;
import Attackenemy.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Level_GUI extends GameScreen implements Runnable{
    protected ButtonSelector buttonSelector;
    TowerFactory archerTowerFactory = new ArcherTowerFactory();
    Tower archerTower = archerTowerFactory.createTower();
    TowerFactory lightningTowerFactory = new LightningTowerFactory();
    Tower lightningTower = lightningTowerFactory.createTower();
    TowerFactory flameTowerFactory = new FlameTowerFactory();
    Tower flameTower = flameTowerFactory.createTower();
    TowerArray towerArray = new TowerArray();
    protected JButton SaveGame, StopGame, RunGame, InitGame;
    protected JButton[] buttons = {SaveGame, StopGame, RunGame, InitGame};
    protected String[] icons = {"./res/button/save.png", "./res/button/Pause.png", "./res/button/Continue.png", "./res/button/GG.png"};
    protected boolean shouldDrawCircle = false;
    protected int circleX, circleY;
    protected ArrayList<Enemy> enemy;
    protected ArrayList<TowerPlacement> Towerlist;
    protected volatile boolean isRunning = true;
    protected final double FPS_SET = 120.0;
    protected final double UPS_SET = 60.0;
    protected Thread gameThread;
    SpeedStrategy normal = new NormalSpeed();
    SpeedStrategy slow = new SlowSpeed();
    protected double money = 100.0;
    protected JLabel moneyLabel, enemynumberLabel, castlehpLabel, GoldLab;
    public void setButtonSelector(ButtonSelector buttonSelector){
        this.buttonSelector = buttonSelector;
    }
    private int limit = 0, enemynumber = 20, castlehp = 10;
    ObserverEnemy observerenemy;
    ObserverCastleHP observercastlehp;
    protected void settings(){
        //視窗
        frame = new JFrame("關卡一");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        backgroundPanel = new BackgroundPanel("./res/TowerDefenceGame_Map.jpg");
        backgroundPanel.setLayout(null);
        frame.setContentPane(backgroundPanel);
        frame.setLocationRelativeTo(null);

        moneyLabel = new JLabel(String.valueOf(money));
        moneyLabel.setBounds(frame.getWidth() / 2 + 50, 0, 100, 50);
        frame.getContentPane().add(moneyLabel);

        enemynumberLabel = new JLabel("敵人數量剩餘：" + String.valueOf(enemynumber));
        enemynumberLabel.setBounds(frame.getWidth() / 2 - 400, 0, 120, 50);
        frame.getContentPane().add(enemynumberLabel);

        castlehpLabel = new JLabel("剩餘生命：" + String.valueOf(castlehp));
        castlehpLabel.setBounds(frame.getWidth() / 2 - 800, 0, 100, 50);
        frame.getContentPane().add(castlehpLabel);

        GoldLab = new JLabel();
        ImageIcon Gold = new ImageIcon("./res/button/Gold.png");
        Image scaledGoldImage = Gold.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledGoldIcon = new ImageIcon(scaledGoldImage);
        GoldLab.setIcon(scaledGoldIcon);
        GoldLab.setBounds(frame.getWidth() / 2, 0, 100, 50);
        frame.getContentPane().add(GoldLab);

        for(int i = 0 ; i < buttons.length ; i++){
            buttons[i] = new JButton();
            ImageIcon icon = new ImageIcon(icons[i]);
            Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            buttons[i].setIcon(scaledIcon);
            buttons[i].setFocusPainted(false);
            buttons[i].setOpaque(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorderPainted(false);
            buttons[i].setBounds(frame.getWidth() - (100 + 50 * i), 0, 50, 50);
            frame.getContentPane().add(buttons[i]);
        }

        buttons[0].addActionListener(e -> {
            SaveLevel saveLevel = new SaveLevel();
            saveLevel.setLevel(this);
            saveLevel.getScreen();
        });

        buttons[1].addActionListener(e -> {
            stopRunning();
        });

        buttons[2].addActionListener(e -> {
            GoRunning();
        });
        buttons[3].addActionListener(e -> {
            VersionScreen versionScreen = new VersionScreen();
            versionScreen.getScreen();
            SwingUtilities.getWindowAncestor(buttons[3]).dispose();
        });
    }
    protected void start(){
        gameThread = new Thread(this) {
        };
        gameThread.start();
    }
    public void GoRunning(){
        isRunning = true;
    }
    public void stopRunning() {
        isRunning = false;
    }
    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        long now;

        while (true) {
            now = System.nanoTime();
            if(isRunning) {
                // Render
                if (now - lastFrame >= timePerFrame) {
                    backgroundPanel.repaint();
                    lastFrame = now;
                    frames++;
                }
                // Update
                if (now - lastUpdate >= timePerUpdate) {
                    updatesEnemy();
                    lastUpdate = now;
                    updates++;
                }
                if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
                    //System.out.println("FPS: " + frames + " | UPS: " + updates);
                    frames = 0;
                    updates = 0;
                    lastTimeCheck = System.currentTimeMillis();

                    updatesAttack();
                    checkHP();
                    checkTime();

                    for (Enemy e : enemy) {
                        if (e.getX() > 1500) {
                            System.out.println("HP-1");
                        }
                    }
                }
            }
        }
    }

    private void checkTime() {
        if(limit <20){
            backgroundPanel.enemyTileManager.TimeSpawnEnemy();
            limit++;
        }
    }

    protected void updatesEnemy() {
        backgroundPanel.enemyTileManager.update(money);
        if(backgroundPanel.enemyTileManager.isEnemyDown()){
            money = backgroundPanel.enemyTileManager.getMoney();
        }
        updateMoneyLabel();
        updateEnemyNumber();
        updateCastleHP();
    }
    protected void updatesAttack() {
        for(Enemy e:enemy){
            for (TowerPlacement t:Towerlist) {
                if(isInRange(e,t)){
                    e.beAttack(t.getTower().getDamage());
                }else{
                    //System.out.println("No");
                }
            }
        }
    }
    protected boolean isInRange(Enemy e, TowerPlacement t) {
        int range = GetHypoDistance(e.getX(),e.getY(),t.getX(),t.getY());
        return range < (t.getTower().getAlertRange()/2);
    }
    protected static int GetHypoDistance(float x1, float y1 , int x2, int y2){
        float XDiff = Math.abs(x1-x2);
        float YDiff = Math.abs(y1-y2);

        return (int) Math.hypot(XDiff,YDiff);
    }
    protected void checkHP() {
        for(Enemy e:enemy){
            if(e.getHealth()<e.getMaxhealth()*2/3){
                e.setStrategy(normal);
            }else if(e.getHealth()<e.getMaxhealth()/3) {
                e.setStrategy(slow);
            }
        }
    }
    protected void updateMoneyLabel(){
        moneyLabel.setText(String.valueOf(money));
    }
    protected void updateEnemyNumber(){
        enemynumberLabel.setText("敵人數量剩餘： " + String.valueOf(backgroundPanel.enemyTileManager.getObserverEnemy().getEnemyNumber()));
    }
    protected void updateCastleHP(){
        castlehpLabel.setText("剩餘生命： " + String.valueOf(backgroundPanel.enemyTileManager.getObserverCastleHP().getCastleHP()));
    }
}
