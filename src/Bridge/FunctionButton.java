package Bridge;

import javax.swing.*;
import java.awt.*;

public class FunctionButton implements ButtonSelector{
    @Override
    public JButton[] getButton(String image) {
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
