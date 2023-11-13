package Bridge;

import javax.swing.*;
import java.awt.*;

public class SaveLevel extends VersionScreen{
    private Level_GUI level;
    @Override
    public void getScreen() {
        settings(300, 600);

        Dimension buttonSize = new Dimension(150, 50);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        for (int i = 1 ; i < buttons.length; i++) {
            buttons[i] = new JButton(versionsTexts[i]);
            buttons[i].setFont(buttonFont);
            buttons[i].setPreferredSize(buttonSize);
            constraints.gridy = i;
            backgroundPanel.add(buttons[i], constraints);
        }
        //Versions
        buttons[1].addActionListener(e -> {
            originator.setVersion(level);
            caretaker.saveMemento(0);
            SwingUtilities.getWindowAncestor(buttons[1]).dispose();
        });
        buttons[2].addActionListener(e -> {
            originator.setVersion(level);
            caretaker.saveMemento(1);
            SwingUtilities.getWindowAncestor(buttons[2]).dispose();
        });
        buttons[3].addActionListener(e -> {
            originator.setVersion(level);
            caretaker.saveMemento(2);
            SwingUtilities.getWindowAncestor(buttons[3]).dispose();
        });
        buttons[4].addActionListener(e -> {
            originator.setVersion(level);
            caretaker.saveMemento(3);
            SwingUtilities.getWindowAncestor(buttons[4]).dispose();
        });

        frame.setVisible(true);
    }
    public void setLevel(Level_GUI level){
        this.level = level;
    }
}
