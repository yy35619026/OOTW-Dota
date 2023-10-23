package Tower;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class TowerCreate {
    final int closeW = 50;
    final int closeH = 50;
    final int addx1 = 300;
    final int addy1 = 150;


    public void TowerCreates(){
        TowerFactory flameTowerFactory = new FlameTowerFactory();
        Tower flameTower1 = flameTowerFactory.createTower();
        Tower flameTower2 = flameTowerFactory.createTower();

        // 創建雷電塔
        TowerFactory lightningTowerFactory = new LightningTowerFactory();
        Tower lightningTower = lightningTowerFactory.createTower();

        // 創建箭塔
        TowerFactory archerTowerFactory = new ArcherTowerFactory();
        Tower archerTower = archerTowerFactory.createTower();

        // 列印塔的屬性
        System.out.println("Flame Towers:");
        System.out.println("Tower 1 - Cost: " + flameTower1.getCost() + ", Damage: " + flameTower1.getDamage()
                + ", Level: " + flameTower1.getLevel());
        System.out.println("Tower 2 - Cost: " + flameTower2.getCost() + ", Damage: " + flameTower2.getDamage()
                + ", Level: " + flameTower2.getLevel());

        JFrame frame = new JFrame("關卡一");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 450);

        backgroundPanel.setLayout(null);
        frame.setContentPane(backgroundPanel);
        JButton imagechangeButton = getjButton("ChangeTower.png");
        JButton imagecloseButton = getjButton("CloseChange.png");
        JButton imagearcherchooseButton = getTowerChoosejButton("ArcherTowerPreview.png", 0);
        JButton imagelightningchooseButton = getTowerChoosejButton("LightningTower.png", 1);
        JButton imagearcherButton = getTowerjButton("ArcherTower.png");
        JButton imagelightningButton = getTowerjButton("LightningTower.png");
        backgroundPanel.add(imagechangeButton);

        ImageIcon gifIcon = new ImageIcon("4cbe8d_f1ed2800a49649848102c68fc5a66e53mv2.gif"); // 替换为你的GIF图像文件路径
        JLabel gifLabel = new JLabel(gifIcon);
        gifLabel.setBounds(100, 100, gifIcon.getIconWidth(), gifIcon.getIconHeight());
        frame.getContentPane().add(gifLabel);


        imagechangeButton.addActionListener(e -> {
            backgroundPanel.add(imagearcherchooseButton);
            backgroundPanel.add(imagelightningchooseButton);
            backgroundPanel.add(imagecloseButton);
            backgroundPanel.remove(imagechangeButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imagecloseButton.addActionListener(e -> {
            backgroundPanel.remove(imagearcherchooseButton);
            backgroundPanel.remove(imagelightningchooseButton);
            backgroundPanel.add(imagechangeButton);
            backgroundPanel.remove(imagecloseButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imagearcherchooseButton.addActionListener(e -> {
            backgroundPanel.remove(imagearcherchooseButton);
            backgroundPanel.remove(imagelightningchooseButton);
            backgroundPanel.add(imagearcherButton);
            backgroundPanel.add(imagechangeButton);
            imagechangeButton.setEnabled(false);
            System.out.println("Tower 1 - Cost: " + archerTower.getCost() + ", Damage: " + archerTower.getDamage()
                    + ", Level: " + archerTower.getLevel());
            backgroundPanel.remove(imagecloseButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imagelightningchooseButton.addActionListener(e -> {
            backgroundPanel.remove(imagearcherchooseButton);
            backgroundPanel.remove(imagelightningchooseButton);
            backgroundPanel.add(imagelightningButton);
            backgroundPanel.add(imagechangeButton);
            imagechangeButton.setEnabled(false);
            System.out.println("Tower 1 - Cost: " + lightningTower.getCost() + ", Damage: " + lightningTower.getDamage()
                    + ", Level: " + lightningTower.getLevel());
            backgroundPanel.remove(imagecloseButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imagearcherButton.addActionListener(e -> {
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imagelightningButton.addActionListener(e -> {
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        frame.setVisible(true);
    }
    private JButton getjButton(String image) {
        ImageIcon closeTower = new ImageIcon(image);
        Image originalcloseImage = closeTower.getImage();
        Image scaledcloseImage = originalcloseImage.getScaledInstance(closeW, closeH, Image.SCALE_SMOOTH);
        ImageIcon scaledcloseIcon = new ImageIcon(scaledcloseImage);
        JButton imagecloseButton = new JButton(scaledcloseIcon);
        imagecloseButton.setBounds(addx1, addy1, closeW, closeH);
        return imagecloseButton;
    }
    private JButton getTowerChoosejButton(String image, int d) {
        ImageIcon closeTower = new ImageIcon(image);
        Image originalcloseImage = closeTower.getImage();
        Image scaledcloseImage = originalcloseImage.getScaledInstance(closeW + 20, closeH + 60, Image.SCALE_SMOOTH);
        ImageIcon scaledcloseIcon = new ImageIcon(scaledcloseImage);
        JButton imagecloseButton = new JButton(scaledcloseIcon);
        imagecloseButton.setBounds(addx1 - 90 + d * 80, addy1 - 120, closeW + 20, closeH + 60);
        return imagecloseButton;
    }
    private JButton getTowerjButton(String image) {
        ImageIcon closeTower = new ImageIcon(image);
        Image originalcloseImage = closeTower.getImage();
        Image scaledcloseImage = originalcloseImage.getScaledInstance(90, 160, Image.SCALE_SMOOTH);
        ImageIcon scaledcloseIcon = new ImageIcon(scaledcloseImage);
        JButton imagecloseButton = new JButton(scaledcloseIcon);
        if(image.equals("./pic_src/ArcherTower.png")){
            imagecloseButton.setBounds(addx1-20, addy1-160, 90, 160);
        } else if (image.equals("./pic_src/LightningTower.png")) {
            imagecloseButton.setBounds(addx1-20, addy1-102, 90, 102);
        }
        return imagecloseButton;
    }
}