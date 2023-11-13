package Bridge;

import javax.swing.*;
import java.awt.*;

public class InitScreen extends GameScreen{
    private JButton new_game, end_game;
    private JButton[] buttons = {new_game, end_game};
    private String[] icons = {"./res/button/Start.png", "./res/button/Exit.png"};
    public InitScreen(){
        super();
    }
    @Override
    public void getScreen() {
        settings(1600, 900);

        for(int i = 0 ; i < buttons.length ; i++){
            buttons[i] = new JButton();
            ImageIcon icon = new ImageIcon(icons[i]);
            Image scaledImage = icon.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            buttons[i].setIcon(scaledIcon);
            buttons[i].setFocusPainted(false);
            buttons[i].setOpaque(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorderPainted(false);
            constraints.gridy = i;
            backgroundPanel.add(buttons[i], constraints);
        }

        frame.setVisible(true);

        buttons[0].addActionListener(e -> {
            VersionScreen versionScreen = new VersionScreen();
            versionScreen.getScreen();
            SwingUtilities.getWindowAncestor(buttons[0]).dispose();
        });
        buttons[1].addActionListener(e -> {
            System.exit(0);
        });
    }
}
