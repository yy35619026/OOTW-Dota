package Bridge;

import Backpaint.BackgroundPanel;
import Enemy.Enemy;
import GameScreen.VersionScreen;
import Message.Failed;
import Message.Success;
import Strategy.*;
import Tower.*;
import Command.*;
import Adapter.*;
import State.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Level_GUI extends JFrame implements Runnable {
    protected JFrame frame;
    protected BackgroundPanel backgroundPanel;
    protected ButtonSelector buttonSelector;
    TowerFactory archerTowerFactory = new ArcherTowerFactory();
    Tower archerTower = archerTowerFactory.createTower();
    TowerFactory lightningTowerFactory = new LightningTowerFactory();
    Tower lightningTower = lightningTowerFactory.createTower();
    TowerFactory flameTowerFactory = new FlameTowerFactory();
    Tower flameTower = flameTowerFactory.createTower();
    TowerArray towerArray = new TowerArray();
    protected JButton SaveGame, StopGame, RunGame, InitGame;
    protected JButton[] buttons = { SaveGame, StopGame, RunGame, InitGame };
    protected String[] icons = { "./res/button/save.png", "./res/button/Pause.png", "./res/button/Continue.png",
            "./res/button/Back.png" };
    protected boolean shouldDrawCircle = false;
    protected int circleX, circleY;
    protected ArrayList<Enemy> enemy;
    public ArrayList<TowerPlacement> Towerlist;
    public volatile boolean isRunning = true;
    protected final double FPS_SET = 120.0;
    protected final double UPS_SET = 60.0;
    protected Thread gameThread;
    SpeedStrategy normal = new NormalSpeed();
    SpeedStrategy slow = new SlowSpeed();
    protected double money = 100.0;
    protected JLabel moneyLabel, enemynumberLabel, castlehpLabel, GoldLab, EnemyNumberLab, CastleHPLab;
    protected int limit = 0, enemynumber = 20, castlehp = 10;
    TowerCommand tower = new TowerCommand();
    UpgradeTowerCommand upgradeCommand = new UpgradeTowerCommand(tower);
    SellTowerCommand sellCommand = new SellTowerCommand(tower);
    CancelTowerCommand cancelCommand = new CancelTowerCommand(tower);
    TowerController controller = new TowerController();
    private State state;

    public void setButtonSelector(ButtonSelector buttonSelector) {
        this.buttonSelector = buttonSelector;
    }

    public abstract void getScreen();
    public final void MainExecute(){
        frame = new JFrame();
        settings();
        getScreen();
        start();
        enemy = backgroundPanel.enemyTileManager.getEnemies();
        Towerlist = LightningTowerFactory.getTowerlist();
    }
    protected void settings() {
        // 視窗
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        frame.setLocationRelativeTo(null);

        backgroundPanel = new BackgroundPanel("./res/TowerDefenceGame_Map.jpg");
        backgroundPanel.setLayout(null);
        frame.setContentPane(backgroundPanel);

        // 創建JLabel
        moneyLabel = createLabel(String.valueOf(money), frame.getWidth() / 2 + 50, 0);
        enemynumberLabel = createLabel(String.valueOf(enemynumber), frame.getWidth() / 2 - 350, 0);
        castlehpLabel = createLabel(String.valueOf(castlehp), frame.getWidth() / 2 - 750, 0);

        // 創建JLabel with icon
        GoldLab = createImageLabel("./res/button/Gold.png", frame.getWidth() / 2, 0);
        EnemyNumberLab = createImageLabel("./res/button/GG.png", frame.getWidth() / 2 - 400, 0);
        CastleHPLab = createImageLabel("./res/button/Heart.png", frame.getWidth() / 2 - 800, 0);

        // 將JLabel添加到JFrame
        frame.getContentPane().add(moneyLabel);
        frame.getContentPane().add(enemynumberLabel);
        frame.getContentPane().add(castlehpLabel);
        frame.getContentPane().add(GoldLab);
        frame.getContentPane().add(EnemyNumberLab);
        frame.getContentPane().add(CastleHPLab);

        for (int i = 0; i < buttons.length; i++) {
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

        buttons[1].addActionListener(e -> {
            setState(new ConcreteStateStop(isRunning));
            isRunning = state.Handle();
        });

        buttons[2].addActionListener(e -> {
            setState(new ConcreteStateGo(isRunning));
            isRunning = state.Handle();
        });
        buttons[3].addActionListener(e -> {
            setState(new ConcreteStateRE(buttons));
            state.ReGm();
        });
        //Command按鈕
        TowerCommand tower;
        Command upgradeCommand;
        SellTowerCommand sellCommand;
        Command cancelCommand;
        TowerController controller;
    }

    protected void start() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 100, 50);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        return label;
    }

    private JLabel createImageLabel(String imagePath, int x, int y) {
        JLabel label = new JLabel();
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        label.setIcon(scaledIcon);
        label.setBounds(x, y, 100, 50);
        return label;
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
            if (isRunning) {
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
                    // System.out.println("FPS: " + frames + " | UPS: " + updates);
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
        if (limit < 20) {
            backgroundPanel.enemyTileManager.TimeSpawnEnemy();
            limit++;
        }
    }

    protected void updatesEnemy() {
        backgroundPanel.enemyTileManager.update(money);
        if (backgroundPanel.enemyTileManager.isEnemyDown()) {
            money = backgroundPanel.enemyTileManager.getMoney();
        }
        updateMoneyLabel();
        updateEnemyNumber();
        updateCastleHP();
        if (updateEnemyNumber() == 0) {
            Success success = new Success();
            success.win(new Level2_GUI());
            Towerlist.clear();
            isRunning = false;
        }
        if (updateCastleHP() == 0) {
            Failed failed = new Failed();
            failed.lose(new Level1_GUI());
            Towerlist.clear();
            isRunning = false;
        }
    }

    protected void updatesAttack() {
        for (Enemy e : enemy) {
            for (TowerPlacement t : Towerlist) {
                if (isInRange(e, t)) {
                    e.beAttack(t.getTower().getDamage());
                } else {
                    // System.out.println("No");
                }
            }
        }
    }

    protected boolean isInRange(Enemy e, TowerPlacement t) {
        int range = GetHypoDistance(e.getX(), e.getY(), t.getX(), t.getY());
        return range < (t.getTower().getAlertRange() / 2);
    }

    protected static int GetHypoDistance(float x1, float y1, int x2, int y2) {
        float XDiff = Math.abs(x1 - x2);
        float YDiff = Math.abs(y1 - y2);

        return (int) Math.hypot(XDiff, YDiff);
    }

    protected void checkHP() {
        for (Enemy e : enemy) {
            if (e.getHealth() < e.getMaxhealth() * 2 / 3) {
                e.setStrategy(normal);
            } else if (e.getHealth() < e.getMaxhealth() / 3) {
                e.setStrategy(slow);
            }
        }
    }

    protected void updateMoneyLabel() {
        moneyLabel.setText(String.valueOf(money));
    }

    protected void upgradecommandbutton(int x, int y) {
        controller.setCommand(upgradeCommand, money, towerArray.getTower(x, y));
        controller.performAction();
        money = upgradeCommand.getMoney();
        updateMoneyLabel();
    }

    protected void sellcommandbutton(int x, int y) {
        controller.setCommand(sellCommand, money, towerArray.getTower(x, y));
        controller.performAction();
        money = sellCommand.getMoney();
        updateMoneyLabel();
    }

    protected void cancelcommandbutton(int x, int y) {
        controller.setCommand(cancelCommand, money, towerArray.getTower(x, y));
        controller.performAction();
    }

    protected int updateEnemyNumber() {
        enemynumberLabel.setText(String.valueOf(backgroundPanel.enemyTileManager.getObserverEnemy().getEnemyNumber()));
        return backgroundPanel.enemyTileManager.getObserverEnemy().getEnemyNumber();
    }

    protected int updateCastleHP() {
        castlehpLabel.setText(String.valueOf(backgroundPanel.enemyTileManager.getObserverCastleHP().getCastleHP()));
        return backgroundPanel.enemyTileManager.getObserverCastleHP().getCastleHP();
    }

    protected void Towerlvlup(int x, int y) {
        Adapter adapter = new Adapter();
        Tower t = new ArcherTowerFactory().createTower();
        AdapterController adc = new AdapterController(adapter, money, towerArray.getTower(x, y));
        adc.towerlvlup();
        money = adapter.getMoney();
        updateMoneyLabel();
    }

    public boolean getIsRunning() {
        return isRunning;
    }

    public void setState(State state) {
        this.state = state;
    }

}
