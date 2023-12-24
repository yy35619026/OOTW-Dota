package Message;

import Bridge.Level1_GUI;
import Bridge.Level_GUI;

import javax.swing.*;

public class Failed extends Success{
    public void lose(Level_GUI level){
        settings();
        for (int i = 1; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonsTexts[i]);
            buttons[i].setFont(buttonFont);
            buttons[i].setPreferredSize(buttonSize);
            constraints.gridy = i;
            backgroundPanel.add(buttons[i], constraints);
        }
        jFrame.setVisible(true);
        //Restart the Game
        buttons[1].addActionListener(e -> {
            level.getScreen();
            level.dispose();
            SwingUtilities.getWindowAncestor(buttons[1]).dispose();
        });
    }

}
