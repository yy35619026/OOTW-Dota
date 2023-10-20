package Tower;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

public class TowerCreate {
    final int closeW = 50;
    final int closeH = 50;
    public void TowerCreates(){
        TowerFactory flameTowerFactory = new FlameTowerFactory();
        Tower flameTower1 = flameTowerFactory.createTower();
        Tower flameTower2 = flameTowerFactory.createTower();

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
        JButton imagechangeButton = getjButton("ChangeTower.png");
        JButton imagecloseButton = getjButton("CloseChange.png");
        JButton imagearcherButton = getTowerjButton("ArcherTower.png", 0);
        JButton imagelightningButton = getTowerjButton("LightningTower.png", 1);
        backgroundPanel.add(imagechangeButton);

        imagechangeButton.addActionListener(e -> {
            backgroundPanel.add(imagearcherButton);
            backgroundPanel.add(imagelightningButton);
            backgroundPanel.add(imagecloseButton);
            backgroundPanel.remove(imagechangeButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imagecloseButton.addActionListener(e -> {
            backgroundPanel.remove(imagearcherButton);
            backgroundPanel.remove(imagelightningButton);
            backgroundPanel.add(imagechangeButton);
            backgroundPanel.remove(imagecloseButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imagearcherButton.addActionListener(e -> {
        });

        imagelightningButton.addActionListener(e -> {
        });
        frame.setVisible(true);
    }
    private JButton getjButton(String image) {
        ImageIcon closeTower = new ImageIcon(image);
        Image originalcloseImage = closeTower.getImage();
        Image scaledcloseImage = originalcloseImage.getScaledInstance(closeW, closeH, Image.SCALE_SMOOTH);
        ImageIcon scaledcloseIcon = new ImageIcon(scaledcloseImage);
        JButton imagecloseButton = new JButton(scaledcloseIcon);
        imagecloseButton.setBounds(300, 150, closeW, closeH);
        return imagecloseButton;
    }
    private JButton getTowerjButton(String image, int d) {
        ImageIcon closeTower = new ImageIcon(image);
        Image originalcloseImage = closeTower.getImage();
        Image scaledcloseImage = originalcloseImage.getScaledInstance(closeW, closeH, Image.SCALE_SMOOTH);
        ImageIcon scaledcloseIcon = new ImageIcon(scaledcloseImage);
        JButton imagecloseButton = new JButton(scaledcloseIcon);
        imagecloseButton.setBounds(240 + d*60, 90, closeW, closeH);
        return imagecloseButton;
    }
}