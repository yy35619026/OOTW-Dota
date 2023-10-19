package Tower;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

public class TowerCreate {
    private JLabel imageLabel;
    private int offsetX, offsetY;
    public void TowerCreates(){
        TowerFactory flameTowerFactory = new FlameTowerFactory();
        Tower flameTower1 = flameTowerFactory.createTower();
        Tower flameTower2 = flameTowerFactory.createTower();
        Tower flameTower3 = flameTowerFactory.createTower();
        Tower flameTower4 = flameTowerFactory.createTower();

        // 創建雷電塔
        TowerFactory lightningTowerFactory = new LightningTowerFactory();
        Tower lightningTower1 = lightningTowerFactory.createTower();
        Tower lightningTower2 = lightningTowerFactory.createTower();
        Tower lightningTower3 = lightningTowerFactory.createTower();

        // 創建箭塔
        TowerFactory archerTowerFactory = new ArcherTowerFactory();
        Tower archerTower1 = archerTowerFactory.createTower();
        Tower archerTower2 = archerTowerFactory.createTower();
        Tower archerTower3 = archerTowerFactory.createTower();
        Tower archerTower4 = archerTowerFactory.createTower();

        // 列印塔的屬性
        System.out.println("Flame Towers:");
        System.out.println("Tower 1 - Cost: " + flameTower1.getCost() + ", Damage: " + flameTower1.getDamage()
                + ", Level: " + flameTower1.getLevel());
        System.out.println("Tower 2 - Cost: " + flameTower2.getCost() + ", Damage: " + flameTower2.getDamage()
                + ", Level: " + flameTower2.getLevel());

        System.out.println("Lightning Towers:");
        System.out.println("Tower 1 - Cost: " + lightningTower1.getCost() + ", Damage: " + lightningTower1.getDamage()
                + ", Level: " + lightningTower1.getLevel());
        System.out.println("Tower 2 - Cost: " + lightningTower2.getCost() + ", Damage: " + lightningTower2.getDamage()
                + ", Level: " + lightningTower2.getLevel());
        System.out.println("Tower 3 - Cost: " + lightningTower3.getCost() + ", Damage: " + lightningTower3.getDamage()
                + ", Level: " + lightningTower3.getLevel());

        System.out.println("Archer Towers:");
        System.out.println("Tower 1 - Cost: " + archerTower1.getCost() + ", Damage: " + archerTower1.getDamage()
                + ", Level: " + archerTower1.getLevel());
        System.out.println("Tower 2 - Cost: " + archerTower2.getCost() + ", Damage: " + archerTower2.getDamage()
                + ", Level: " + archerTower2.getLevel());
        System.out.println("Tower 3 - Cost: " + archerTower3.getCost() + ", Damage: " + archerTower3.getDamage()
                + ", Level: " + archerTower3.getLevel());
        System.out.println("Tower 4 - Cost: " + archerTower4.getCost() + ", Damage: " + archerTower4.getDamage()
                + ", Level: " + archerTower4.getLevel());

        JFrame frame = new JFrame("關卡一");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 450);

        BackgroundPanel backgroundPanel = new BackgroundPanel("test.jpg"); // 替换成你的图像文件路径
        backgroundPanel.setLayout(null);
        frame.setContentPane(backgroundPanel);
/*
        ImageIcon iconTower = new ImageIcon("ArcherTower.png");
        final int TowerWidth = 90;
        final int TowerHeight = 160;
        Image originalTowerImage = iconTower.getImage();
        Image scaledTowerImage = originalTowerImage.getScaledInstance(TowerWidth, TowerHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledTowerIcon = new ImageIcon(scaledTowerImage);
        imageLabel = new JLabel(scaledTowerIcon);
        imageLabel.setBounds(200, 200, TowerWidth, TowerHeight);
        backgroundPanel.add(imageLabel);
*/
        ImageIcon addTower = new ImageIcon("addTower.png");
        final int addW = 50;
        final int addH = 50;
        Image originaladdImage = addTower.getImage();
        Image scaledaddImage = originaladdImage.getScaledInstance(addW, addH, Image.SCALE_SMOOTH);
        ImageIcon scaledaddIcon = new ImageIcon(scaledaddImage);
        imageLabel = new JLabel(scaledaddIcon);
        imageLabel.setBounds(300, 150, addW, addH);
        backgroundPanel.add(imageLabel);
/*
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                offsetX = e.getX();
                offsetY = e.getY();
            }
        });

        imageLabel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int mouseX = e.getXOnScreen();
                int mouseY = e.getYOnScreen();

                imageLabel.setLocation(mouseX - offsetX, mouseY - offsetY);
            }
        });*/
        frame.setVisible(true);
    }
}