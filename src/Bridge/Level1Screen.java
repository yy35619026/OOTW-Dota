package Bridge;

import Backpaint.BackgroundPanel;
import Enemy.Enemy;
import SaveVersions.Caretaker;
import SaveVersions.Originator;
import Strategy.NormalSpeed;
import Strategy.SlowSpeed;
import Strategy.SpeedStrategy;
import Tower.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Level1Screen extends GameScreen{
    TowerFactory archerTowerFactory = new ArcherTowerFactory();
    Tower archerTower = archerTowerFactory.createTower();
    TowerFactory lightningTowerFactory = new LightningTowerFactory();
    Tower lightningTower = lightningTowerFactory.createTower();
    TowerFactory flameTowerFactory = new FlameTowerFactory();
    Tower flameTower = flameTowerFactory.createTower();
    private JButton RunGame, StopGame, SaveGame;
    final int[] Originalx = {300, 600, 900, 1200, 150, 450, 750, 1050};
    final int[] Originaly = {280, 280, 280, 280, 520, 520, 520, 520};
    private boolean shouldDrawCircle = false;
    private int circleX, circleY;
    private int circleRadius;
    private ArrayList<Enemy> enemy;
    private ArrayList<TowerPlacement> Towerlist;
    private volatile boolean isRunning = true;
    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;
    private Thread gameThread;
    SpeedStrategy normal = new NormalSpeed();
    SpeedStrategy slow = new SlowSpeed();

    @Override
    public void getScreen() {
        frame = new JFrame("關卡一");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        backgroundPanel = new BackgroundPanel("./res/TowerDefenceGame_Map.jpg");
        backgroundPanel.setLayout(null);
        frame.setContentPane(backgroundPanel);
        frame.setLocationRelativeTo(null);
        ButtonSelector cancelButton = new CancelButton();
        ButtonSelector chooseButton = new ChooseButton();
        ButtonSelector towerButton = new TowerButton();
        ButtonSelector functionButton = new FunctionButton();

        //+號按鈕
        JButton[] imageAddButton = cancelButton.getButton("./res/button/Add.png");
        //-號按鈕
        JButton[] imageCancelButton = cancelButton.getButton("./res/button/Cancel.png");
        //箭塔選項
        JButton[] imageArcherChooseButton = chooseButton.getButton("./res/Tower/tower1.png");
        //雷電塔選項
        JButton[] imageLightningChooseButton = chooseButton.getButton("./res/Tower/tower2.png");
        //可樂塔選項
        JButton[] imageColaChooseButton = chooseButton.getButton("./res/Tower/tower3.png");
        //箭塔生成
        JButton[] imageArcherButton = towerButton.getButton("./res/Tower/tower1.png");
        //雷電塔生成
        JButton[] imageLightningButton = towerButton.getButton("./res/Tower/tower2.png");
        //可樂塔生成
        JButton[] imageColaButton = towerButton.getButton("./res/Tower/tower3.png");
        //賣出按鈕
        JButton[] imageSellButton = functionButton.getButton("./res/button/Gold.png");
        //取消按鈕
        JButton[] imageEscapeButton = functionButton.getButton("./res/button/Escape.png");
        //升級按鈕
        JButton[] imageUpgradeButton = functionButton.getButton("./res/button/Upgrade.png");

        RunGame = new JButton();
        StopGame = new JButton();
        SaveGame = new JButton();
        ImageIcon RunGameIcon = new ImageIcon("./res/button/Continue.png");
        Image scaledRunImage = RunGameIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledRunIcon = new ImageIcon(scaledRunImage);
        RunGame.setIcon(scaledRunIcon);
        RunGame.setBounds(frame.getWidth() - 100, 0, 50, 50);
        frame.getContentPane().add(RunGame);

        ImageIcon stopGameIcon = new ImageIcon("./res/button/Pause.png");
        Image scaledStopImage = stopGameIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledStopIcon = new ImageIcon(scaledStopImage);
        StopGame.setIcon(scaledStopIcon);
        StopGame.setBounds(frame.getWidth() - 150, 0, 50, 50);
        frame.getContentPane().add(StopGame);

        ImageIcon saveGameIcon = new ImageIcon("./res/button/save.png");
        Image scaledSaveImage = saveGameIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledSaveIcon = new ImageIcon(scaledSaveImage);
        SaveGame.setIcon(scaledSaveIcon);
        SaveGame.setBounds(frame.getWidth() - 200, 0, 50, 50);
        frame.getContentPane().add(SaveGame);

        RunGame.addActionListener(e -> {
            GoRunning();
        });

        StopGame.addActionListener(e -> {
            stopRunning();
        });

        SaveGame.addActionListener(e -> {
            Originator originator = new Originator();
            Caretaker caretaker = new Caretaker(originator);

            Backpaint.GameScreen Level1 = new Backpaint.GameScreen();
            originator.setVersion(Level1);
            caretaker.saveMemento();
        });

        for (int i = 0; i < Originalx.length; i++) {
            backgroundPanel.add(imageAddButton[i]);
        }

        backgroundPanel.setEnemy(true);

        for (int i = 0; i < imageAddButton.length; i++) {
            final int index = i;
            imageAddButton[i].setActionCommand("change" + i);
            imageAddButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    backgroundPanel.add(imageArcherChooseButton[index]);
                    backgroundPanel.add(imageLightningChooseButton[index]);
                    backgroundPanel.add(imageColaChooseButton[index]);
                    backgroundPanel.add(imageCancelButton[index]);
                    backgroundPanel.remove(imageAddButton[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        for (int i = 0; i < imageCancelButton.length; i++) {
            final int index = i;
            imageCancelButton[i].setActionCommand("change" + i);
            imageCancelButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    backgroundPanel.add(imageAddButton[index]);
                    backgroundPanel.remove(imageArcherChooseButton[index]);
                    backgroundPanel.remove(imageLightningChooseButton[index]);
                    backgroundPanel.remove(imageColaChooseButton[index]);
                    backgroundPanel.remove(imageCancelButton[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        for (int i = 0; i < imageArcherChooseButton.length; i++) {
            final int index = i;
            imageArcherChooseButton[i].setActionCommand("change" + i);
            imageArcherChooseButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    backgroundPanel.add(imageArcherButton[index]);
                    ArcherTowerFactory.addTower(archerTower, Originalx[index], Originaly[index]);
                    backgroundPanel.remove(imageArcherChooseButton[index]);
                    backgroundPanel.remove(imageLightningChooseButton[index]);
                    backgroundPanel.remove(imageColaChooseButton[index]);
                    backgroundPanel.remove(imageCancelButton[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        for (int i = 0; i < imageLightningChooseButton.length; i++) {
            final int index = i;
            imageLightningChooseButton[i].setActionCommand("change" + i);
            imageLightningChooseButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    backgroundPanel.add(imageLightningButton[index]);
                    LightningTowerFactory.addTower(lightningTower, Originalx[index], Originaly[index]);
                    backgroundPanel.remove(imageArcherChooseButton[index]);
                    backgroundPanel.remove(imageLightningChooseButton[index]);
                    backgroundPanel.remove(imageColaChooseButton[index]);
                    backgroundPanel.remove(imageCancelButton[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        for (int i = 0; i < imageColaChooseButton.length; i++) {
            final int index = i;
            imageColaChooseButton[i].setActionCommand("change" + i);
            imageColaChooseButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    backgroundPanel.add(imageColaButton[index]);
                    FlameTowerFactory.addTower(flameTower, Originalx[index], Originaly[index]);
                    backgroundPanel.remove(imageArcherChooseButton[index]);
                    backgroundPanel.remove(imageLightningChooseButton[index]);
                    backgroundPanel.remove(imageColaChooseButton[index]);
                    backgroundPanel.remove(imageCancelButton[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        for (int i = 0; i < imageArcherButton.length; i++) {
            final int index = i;
            imageArcherButton[i].setActionCommand("change" + i);
            imageArcherButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    shouldDrawCircle = true;
                    circleX = Originalx[index];
                    circleY = Originaly[index];
                    backgroundPanel.setCircle(circleX, circleY, archerTower.getAlertRange(), shouldDrawCircle);
                    backgroundPanel.add(imageEscapeButton[index]);
                    backgroundPanel.add(imageSellButton[index]);
                    backgroundPanel.add(imageUpgradeButton[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        for (int i = 0; i < imageLightningButton.length; i++) {
            final int index = i;
            imageLightningButton[i].setActionCommand("change" + i);
            imageLightningButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    shouldDrawCircle = true;
                    circleX = Originalx[index];
                    circleY = Originaly[index];
                    backgroundPanel.setCircle(circleX, circleY, lightningTower.getAlertRange(), shouldDrawCircle);
                    backgroundPanel.add(imageEscapeButton[index]);
                    backgroundPanel.add(imageSellButton[index]);
                    backgroundPanel.add(imageUpgradeButton[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        for (int i = 0; i < imageColaButton.length; i++) {
            final int index = i;
            imageColaButton[i].setActionCommand("change" + i);
            imageColaButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    shouldDrawCircle = true;
                    circleX = Originalx[index];
                    circleY = Originaly[index];
                    backgroundPanel.setCircle(circleX, circleY, flameTower.getAlertRange(), shouldDrawCircle);
                    backgroundPanel.add(imageEscapeButton[index]);
                    backgroundPanel.add(imageSellButton[index]);
                    backgroundPanel.add(imageUpgradeButton[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        for (int i = 0; i < imageEscapeButton.length; i++) {
            final int index = i;
            imageEscapeButton[i].setActionCommand("change" + i);
            imageEscapeButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    shouldDrawCircle = false;
                    backgroundPanel.setCircle(circleX, circleY, 0, shouldDrawCircle);
                    backgroundPanel.remove(imageEscapeButton[index]);
                    backgroundPanel.remove(imageSellButton[index]);
                    backgroundPanel.remove(imageUpgradeButton[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        for (int i = 0; i < imageSellButton.length; i++) {
            final int index = i;
            imageSellButton[i].setActionCommand("change" + i);
            imageSellButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    shouldDrawCircle = false;
                    backgroundPanel.setCircle(circleX, circleY, 0, shouldDrawCircle);
                    LightningTowerFactory.removeTower(Originalx[index], Originaly[index]);
                    backgroundPanel.remove(imageEscapeButton[index]);
                    backgroundPanel.remove(imageSellButton[index]);
                    backgroundPanel.remove(imageUpgradeButton[index]);
                    backgroundPanel.remove(imageColaButton[index]);
                    backgroundPanel.remove(imageArcherButton[index]);
                    backgroundPanel.remove(imageLightningButton[index]);
                    backgroundPanel.add(imageAddButton[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        frame.setVisible(true);
        start();
        enemy = backgroundPanel.enemyTileManager.getEnemies();
        Towerlist = LightningTowerFactory.getTowerlist();
    }
    private void start(){
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
    private void updatesEnemy() {
        backgroundPanel.enemyTileManager.update();
    }
    private void updatesAttack() {
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
    private boolean isInRange(Enemy e, TowerPlacement t) {
        int range = GetHypoDistance(e.getX(),e.getY(),t.getX(),t.getY());
        //System.out.println("range:" + range + " ,tower:" + t.getTower().getAlertRange());
        return range < (t.getTower().getAlertRange()/2);
    }
    private static int GetHypoDistance(float x1, float y1 , int x2, int y2){
        float XDiff = Math.abs(x1-x2);
        float YDiff = Math.abs(y1-y2);

        return (int) Math.hypot(XDiff,YDiff);
    }
    private void checkHP() {
        for(Enemy e:enemy){
            if(e.getHealth()<e.getMaxhealth()*2/3){
                e.setStrategy(normal);
            }else if(e.getHealth()<e.getMaxhealth()/3) {
                e.setStrategy(slow);
            }
        }
    }
}
