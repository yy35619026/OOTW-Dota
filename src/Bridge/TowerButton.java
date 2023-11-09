package Bridge;

import javax.swing.*;
import java.awt.*;

public class TowerButton implements ButtonSelector{
    @Override
    public JButton[] getButton(String image) {
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
}
