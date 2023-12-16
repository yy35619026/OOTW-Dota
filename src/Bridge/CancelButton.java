package Bridge;

import javax.swing.*;
import java.awt.*;

public class CancelButton extends ButtonSelector{
    @Override
    public JButton[] getButton(String image) {
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

    @Override
    public void create() {

    }
}
