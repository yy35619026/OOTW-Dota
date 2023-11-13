package Bridge;

import Backpaint.BackgroundPanel;
import Enemy.Enemy;
import SaveVersions.Caretaker;
import SaveVersions.Originator;
import Strategy.*;
import Tower.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Level_GUI extends GameScreen{
    protected ButtonSelector buttonSelector;
    TowerFactory archerTowerFactory = new ArcherTowerFactory();
    Tower archerTower = archerTowerFactory.createTower();
    TowerFactory lightningTowerFactory = new LightningTowerFactory();
    Tower lightningTower = lightningTowerFactory.createTower();
    TowerFactory flameTowerFactory = new FlameTowerFactory();
    Tower flameTower = flameTowerFactory.createTower();
    TowerArray towerArray = new TowerArray();
    protected JButton SaveGame, StopGame, RunGame;
    protected JButton[] buttons = {SaveGame, StopGame, RunGame};
    protected String[] icons = {"./res/button/save.png", "./res/button/Pause.png", "./res/button/Continue.png"};
    final int[] Originalx = {300, 600, 900, 1200, 150, 450, 750, 1050};
    final int[] Originaly = {280, 280, 280, 280, 520, 520, 520, 520};
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
    protected JLabel moneyLabel, GoldLab;
    public void setButtonSelector(ButtonSelector buttonSelector){
        this.buttonSelector = buttonSelector;
    }
    protected void settings(){
        //視窗
        frame = new JFrame("關卡一");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        backgroundPanel = new BackgroundPanel("./res/TowerDefenceGame_Map.jpg");
        backgroundPanel.setLayout(null);
        frame.setContentPane(backgroundPanel);
        frame.setLocationRelativeTo(null);

        moneyLabel = new JLabel("Money" + money);
        moneyLabel.setBounds(frame.getWidth() / 2 + 50, 0, 100, 50);
        frame.getContentPane().add(moneyLabel);

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
            System.out.println("Save!");
            Originator originator = new Originator();
            Caretaker caretaker = new Caretaker(originator);

            Level1_GUI Level1 = new Level1_GUI();
            originator.setVersion(Level1);
            caretaker.saveMemento();
        });

        buttons[1].addActionListener(e -> {
            stopRunning();
        });

        buttons[2].addActionListener(e -> {
            GoRunning();
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

                    for (Enemy e : enemy) {
                        //System.out.println(e.getX());
                        //System.out.println(e.getHealth());
                        if (e.getX() > 1500) {
                            System.out.println("HP-1");
                        }
                    }
                }
            }
        }
    }
    protected void updatesEnemy() {
        backgroundPanel.enemyTileManager.update(money);
        if(backgroundPanel.enemyTileManager.isEnemyDown()){
            money = backgroundPanel.enemyTileManager.getMoney();
        }
        updateMoneyLabel();
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
        //System.out.println("range:" + range + " ,tower:" + t.getTower().getAlertRange());
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
}
