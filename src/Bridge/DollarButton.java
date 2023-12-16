package Bridge;

import javax.swing.*;
import java.awt.*;

public class DollarButton extends ButtonSelector{
    @Override
    public JButton[] getButton(String image) {
        JButton[] buttons = new JButton[Originalx.length];
        for (int i = 0; i < Originalx.length; i++) {
            ImageIcon chooseTower = new ImageIcon(image);
            Image originalchooseImage = chooseTower.getImage();
            Image scaledcloseImage = originalchooseImage.getScaledInstance(45, 20, Image.SCALE_AREA_AVERAGING);
            ImageIcon scaledcloseIcon = new ImageIcon(scaledcloseImage);
            JButton imageoptionButton = new JButton(scaledcloseIcon);
            if(image.equals("./res/Button/20dollar.png")){
                imageoptionButton.setBounds((Originalx[i] - 65), (Originaly[i] - 20), 45, 20);
            }else if(image.equals("./res/Button/50dollar.png")){
                imageoptionButton.setBounds((Originalx[i] - 65 + 67), (Originaly[i] - 20), 45, 20);
            }else if(image.equals("./res/Button/80dollar.png")){
                imageoptionButton.setBounds((Originalx[i] - 65 + 2 * 67), (Originaly[i] - 20), 45, 20);
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
