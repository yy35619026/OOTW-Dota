package Backpaint;

import Enemy.Enemy;
import SaveVersions.Caretaker;
import SaveVersions.Originator;
import Tower.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameScreen extends JFrame implements Runnable{
    TowerFactory archerTowerFactory = new ArcherTowerFactory();
    Tower archerTower = archerTowerFactory.createTower();
    TowerFactory lightningTowerFactory = new LightningTowerFactory();
    Tower lightningTower = lightningTowerFactory.createTower();
    TowerFactory flameTowerFactory = new FlameTowerFactory();
    Tower flameTower = flameTowerFactory.createTower();
    private JButton new_game, end_game;
//    private JButton enemy;//enemy測試
    private JFrame frame;
    private BackgroundPanel backgroundPanel;
    private TowerSelector selector = new TowerSelector();
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


    public void init() {
        //視窗
        frame = new JFrame("第七組Tower Defence game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        frame.setLocationRelativeTo(null);

        // 自定義面板的基礎構建
        backgroundPanel = new BackgroundPanel("./res/test.jpg"); // 替换成你的图像文件路径
        backgroundPanel.setLayout(new GridBagLayout());
        frame.setContentPane(backgroundPanel);

        // GridBagConstraints物件的布局設置
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0; // X軸位置為0
        constraints.insets = new Insets(50, 10, 10, 10);    // 設置按鈕周圍的間距
        constraints.anchor = GridBagConstraints.CENTER;                         // 設置按鈕在Y軸上居中對齊
        //按鈕一些屬性設置
        Dimension buttonsize = new Dimension(150, 50);
        Font buttonfont = new Font("Arial", Font.BOLD, 16);
        new_game = new JButton("New Game");
        end_game = new JButton("Exit");
        new_game.setFont(buttonfont);
        end_game.setFont(buttonfont);
        new_game.setPreferredSize(buttonsize);
        end_game.setPreferredSize(buttonsize);

        constraints.gridy = 0; // Y軸位置為0
        backgroundPanel.add(new_game, constraints);
        constraints.gridy = 1; // Y軸位置為1
        backgroundPanel.add(end_game, constraints);

        frame.setVisible(true);

        new_game.addActionListener(e -> {
            Game_level1();
//            new TowerSelector().Background();
            SwingUtilities.getWindowAncestor(new_game).dispose();
        });
        end_game.addActionListener(e -> {
            System.exit(0);
        });

        //just test enemy , it can delete.
//        enemy = new JButton("Enemy Test");
//        enemy.setFont(buttonfont);
//        enemy.setPreferredSize(buttonsize);
//        constraints.gridy = 2; // Y軸位置為2
//        backgroundPanel.add(enemy, constraints);
//
//        enemy.addActionListener(e -> {
//            new EnemyTest();
//        });
    }
    public void Game_ChooseVersion(){
        frame = new JFrame("第七組Tower Defence game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        frame.setLocationRelativeTo(null);

        // 自定義面板的基礎構建
        backgroundPanel = new BackgroundPanel("./res/test.jpg"); // 替换成你的图像文件路径
        backgroundPanel.setLayout(new GridBagLayout());
        frame.setContentPane(backgroundPanel);

        // GridBagConstraints物件的布局設置
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0; // X軸位置為0
        constraints.insets = new Insets(50, 10, 10, 10);    // 設置按鈕周圍的間距
        constraints.anchor = GridBagConstraints.CENTER;                         // 設置按鈕在Y軸上居中對齊
        //按鈕一些屬性設置
        Dimension buttonsize = new Dimension(150, 50);
        Font buttonfont = new Font("Arial", Font.BOLD, 16);
        JButton version1 = new JButton("Version1");
        JButton version2 = new JButton("Version2");
        JButton version3 = new JButton("Version3");
        JButton version4 = new JButton("Version4");
        version1.setFont(buttonfont);
        version2.setFont(buttonfont);
        version3.setFont(buttonfont);
        version4.setFont(buttonfont);
        version1.setPreferredSize(buttonsize);
        version2.setPreferredSize(buttonsize);
        version3.setPreferredSize(buttonsize);
        version4.setPreferredSize(buttonsize);

        constraints.gridy = 0; // Y軸位置為0
        backgroundPanel.add(new_game, constraints);
        constraints.gridy = 1; // Y軸位置為1
        backgroundPanel.add(end_game, constraints);

        frame.setVisible(true);
    }
    public void Game_level1(){
        frame = new JFrame("關卡一");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        backgroundPanel = new BackgroundPanel("./res/TowerDefenceGame_Map.jpg");
        backgroundPanel.setLayout(null);
        frame.setContentPane(backgroundPanel);
        frame.setLocationRelativeTo(null);

        //+號按鈕
        JButton[] imageAddButton = selector.getAddCanceljButton("./res/button/Add.png");
        //-號按鈕
        JButton[] imageCancelButton = selector.getAddCanceljButton("./res/button/Cancel.png");
        //箭塔選項
        JButton[] imageArcherChooseButton = selector.getTowerChoosejButton("./res/ArcherTower.png", 0);
        //雷電塔選項
        JButton[] imageLightningChooseButton = selector.getTowerChoosejButton("./res/LightningTower.png", 1);
        //可樂塔選項
        JButton[] imageColaChooseButton = selector.getTowerChoosejButton("./res/ColaTower.png", 2);
        //箭塔生成
        JButton[] imageArcherButton = selector.getTowerjButton("./res/ArcherTower.png");
        //雷電塔生成
        JButton[] imageLightningButton = selector.getTowerjButton("./res/LightningTower.png");
        //可樂塔生成
        JButton[] imageColaButton = selector.getTowerjButton("./res/ColaTower.png");
        //賣出按鈕
        JButton[] imageSellButton = selector.getSellEscapejButton("./res/button/Gold.png");
        //取消按鈕
        JButton[] imageEscapeButton = selector.getSellEscapejButton("./res/button/Escape.png");
        //升級按鈕
        JButton[] imageUpgradeButton = selector.getSellEscapejButton("./res/button/Upgrade.png");

        JButton RunGame = new JButton();
        JButton StopGame = new JButton();
        JButton SaveGame = new JButton();

        ImageIcon RunGameIcon = new ImageIcon("./res/button/run.jpg");
        Image scaledRunImage = RunGameIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledRunIcon = new ImageIcon(scaledRunImage);
        RunGame.setIcon(scaledRunIcon);
        RunGame.setBounds(frame.getWidth() - 50, 0, 50, 50);
        frame.getContentPane().add(RunGame);

        ImageIcon stopGameIcon = new ImageIcon("./res/button/stop.jpg");
        Image scaledStopImage = stopGameIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledStopIcon = new ImageIcon(scaledStopImage);
        StopGame.setIcon(scaledStopIcon);
        StopGame.setBounds(frame.getWidth() - 100, 0, 50, 50);
        frame.getContentPane().add(StopGame);

        ImageIcon saveGameIcon = new ImageIcon("./res/button/save.jpg");
        Image scaledSaveImage = saveGameIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledSaveIcon = new ImageIcon(scaledSaveImage);
        SaveGame.setIcon(scaledSaveIcon);
        SaveGame.setBounds(frame.getWidth() - 150, 0, 50, 50);
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

            GameScreen Level1 = new GameScreen();
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
    private void updatesEnemy() {
        backgroundPanel.enemyTileManager.update();
    }

    private void start(){
        gameThread = new Thread(this) {
        };
        gameThread.start();
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
    public void GoRunning(){
        isRunning = true;
    }
    public void stopRunning() {
        isRunning = false;
    }
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
}