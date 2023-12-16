package Bridge;

import javax.swing.*;
import java.awt.*;

public class ChooseButton extends ButtonSelector{
    @Override
    public JButton[] getButton(String image) {
        JButton[] buttons = new JButton[Originalx.length];
        for (int i = 0; i < Originalx.length; i++) {
            ImageIcon chooseTower = new ImageIcon(image);
            Image originalchooseImage = chooseTower.getImage();
            Image scaledcloseImage = originalchooseImage.getScaledInstance(45, 80, Image.SCALE_AREA_AVERAGING);
            ImageIcon scaledcloseIcon = new ImageIcon(scaledcloseImage);
            JButton imageoptionButton = new JButton(scaledcloseIcon);
            if(image.equals("./res/Tower/tower1.png")){
                imageoptionButton.setBounds((Originalx[i] - 65 + 0 * 67), (Originaly[i] - 100), 45, 80);
            }else if(image.equals("./res/Tower/tower2.png")){
                imageoptionButton.setBounds((Originalx[i] - 65 + 1 * 67), (Originaly[i] - 100), 45, 80);
            } else if(image.equals("./res/Tower/tower3.png")){
                imageoptionButton.setBounds((Originalx[i] - 65 + 2 * 67), (Originaly[i] - 100), 45, 80);
            }
            imageoptionButton.setFocusPainted(false);
            imageoptionButton.setOpaque(false);
            imageoptionButton.setContentAreaFilled(false);
            imageoptionButton.setBorderPainted(false);
            buttons[i] = imageoptionButton;
        }
        return buttons;
    }

    @Override
    public void create() {

    }
}
