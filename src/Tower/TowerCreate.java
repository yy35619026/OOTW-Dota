package Tower;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

public class TowerCreate {
    private JLabel imageLabel;
    private int offsetX, offsetY;
    public void TowerCreates(){
        // 創建火焰塔
        /*TowerFactory flameTowerFactory = new FlameTowerFactory();
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
                + ", Level: " + archerTower4.getLevel());*/

        JFrame frame = new JFrame("關卡一");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 450);

        // 自定義面板的基礎構建
        BackgroundPanel backgroundPanel = new BackgroundPanel("TowerDefenceGame_Map.jpg"); // 替换成你的图像文件路径
        backgroundPanel.setLayout(null);
        frame.setContentPane(backgroundPanel);

        ImageIcon icon = new ImageIcon("ArcherTower.png");
        final int newWidth = 90;
        final int newHeight = 160;
        Image originalImage = icon.getImage();
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(200, 200, newWidth, newHeight);
        backgroundPanel.add(imageLabel);
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
        });
        frame.setVisible(true);
    }
}