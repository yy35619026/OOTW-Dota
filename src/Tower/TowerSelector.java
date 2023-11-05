package Tower;

import javax.swing.*;
import java.awt.*;

public class TowerSelector{
    final int AddCancelButW = 50;
    final int AddCancelButH = 50;
    final int[] Originalx = {300, 600, 900, 1200, 150, 450, 750, 1050};
    final int[] Originaly = {280, 280, 280, 280, 520, 520, 520, 520};
    //創建＋-符號
    public JButton[] getAddCanceljButton(String image) {
        JButton[] buttons = new JButton[Originalx.length];
        for (int i = 0; i < Originalx.length; i++) {
            ImageIcon imageOptionPath = new ImageIcon(image);
            Image originaloptionbut = imageOptionPath.getImage();
            Image scaledchosenImage = originaloptionbut.getScaledInstance(AddCancelButW, AddCancelButH, Image.SCALE_SMOOTH);
            ImageIcon scaledoptionIcon = new ImageIcon(scaledchosenImage);
            JButton imageoptionButton = new JButton(scaledoptionIcon);
            imageoptionButton.setFocusPainted(false);
            imageoptionButton.setOpaque(false);
            imageoptionButton.setContentAreaFilled(false);
            imageoptionButton.setBorderPainted(false);
            imageoptionButton.setBounds(Originalx[i], Originaly[i], AddCancelButW, AddCancelButH);
            buttons[i] = imageoptionButton;
        }
        return buttons;
    }

    //創建防禦塔選項
    public JButton[] getTowerChoosejButton(String image, int d) {
        JButton[] buttons = new JButton[Originalx.length];
        for (int i = 0; i < Originalx.length; i++) {
            ImageIcon chooseTower = new ImageIcon(image);
            Image originalchooseImage = chooseTower.getImage();
            Image scaledcloseImage = originalchooseImage.getScaledInstance(45, 80, Image.SCALE_AREA_AVERAGING);
            ImageIcon scaledcloseIcon = new ImageIcon(scaledcloseImage);
            JButton imageoptionButton = new JButton(scaledcloseIcon);
            imageoptionButton.setBounds((Originalx[i] - 65 + d * 67), (Originaly[i] - 80), 45, 80);
            imageoptionButton.setFocusPainted(false);
            imageoptionButton.setOpaque(false);
            imageoptionButton.setContentAreaFilled(false);
            imageoptionButton.setBorderPainted(false);
            buttons[i] = imageoptionButton;
        }
        return buttons;
    }

    //創建已生成的防禦塔按鈕
    public JButton[] getTowerjButton(String image) {
        JButton[] buttons = new JButton[Originalx.length];
        for (int i = 0; i < Originalx.length; i++) {
            ImageIcon chosenTower = new ImageIcon(image);
            Image originalcloseImage = chosenTower.getImage();
            Image scaledcloseImage = originalcloseImage.getScaledInstance(135, 240, Image.SCALE_AREA_AVERAGING);
            ImageIcon scaledcloseIcon = new ImageIcon(scaledcloseImage);
            JButton imageoptionButton = new JButton(scaledcloseIcon);
            imageoptionButton.setBounds(Originalx[i] - 42, Originaly[i] - 170, 135, 240);
            imageoptionButton.setFocusPainted(false);
            imageoptionButton.setOpaque(false);
            imageoptionButton.setContentAreaFilled(false);
            imageoptionButton.setBorderPainted(false);
            buttons[i] = imageoptionButton;
        }
        return buttons;
    }

    //創建X和賣出按鈕
    public JButton[] getSellEscapejButton(String image) {
        JButton[] buttons = new JButton[Originalx.length];
        for (int i = 0; i < Originalx.length; i++) {
            ImageIcon imageoptionbut = new ImageIcon(image);
            Image originaloptionbut = imageoptionbut.getImage();
            Image scaledchosenImage = originaloptionbut.getScaledInstance(AddCancelButW, AddCancelButH, Image.SCALE_AREA_AVERAGING);
            ImageIcon scaledoptionIcon = new ImageIcon(scaledchosenImage);
            JButton imageoptionButton = new JButton(scaledoptionIcon);
            switch (image) {
                case "./res/button/Gold.png":
                    imageoptionButton.setBounds(Originalx[i] - 60, Originaly[i] + 80, 50, 50);
                    break;
                case "./res/button/Upgrade.png":
                    imageoptionButton.setBounds(Originalx[i], Originaly[i] + 80, 50, 50);
                    break;
                case "./res/button/Escape.png":
                    imageoptionButton.setBounds(Originalx[i] + 60, Originaly[i] + 80, 50, 50);
                    break;
            }
                imageoptionButton.setFocusPainted(false);
                imageoptionButton.setOpaque(false);
                imageoptionButton.setContentAreaFilled(false);
                imageoptionButton.setBorderPainted(false);
                buttons[i] = imageoptionButton;
            }
        return buttons;
    }
}
