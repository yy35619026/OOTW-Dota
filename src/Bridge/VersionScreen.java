package Bridge;

import SaveVersions.Caretaker;
import SaveVersions.Originator;

import javax.swing.*;
import java.awt.*;

public class VersionScreen extends GameScreen{
    protected static Originator originator = new Originator();
    protected static Caretaker caretaker = new Caretaker(originator);
    protected JButton new_game, version1, version2,version3, version4;
    protected JButton[] buttons = { new_game, version1, version2, version3, version4 };
    protected String[] versionsTexts = { "New Game", "Version1", "Version2", "Version3", "Version4" };
    @Override
    public void getScreen() {
        settings(1600, 900);

        //按鈕一些屬性設置
        Dimension buttonSize = new Dimension(150, 50);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(versionsTexts[i]);
            buttons[i].setFont(buttonFont);
            buttons[i].setPreferredSize(buttonSize);
            constraints.gridy = i;
            backgroundPanel.add(buttons[i], constraints);
        }

        frame.setVisible(true);
        //New Game
        buttons[0].addActionListener(e -> {
            Level1_GUI level1Screen = new Level1_GUI();
            level1Screen.getScreen();
            SwingUtilities.getWindowAncestor(buttons[0]).dispose();
        });
        buttons[1].addActionListener(e -> {
            if(caretaker.undo(0)){
                SwingUtilities.getWindowAncestor(buttons[1]).dispose();
            }
        });
        buttons[2].addActionListener(e -> {
            if (caretaker.undo(1)){
                SwingUtilities.getWindowAncestor(buttons[2]).dispose();
            }
        });
        buttons[3].addActionListener(e -> {
            if(caretaker.undo(2)){
                SwingUtilities.getWindowAncestor(buttons[3]).dispose();
            }
        });
        buttons[4].addActionListener(e -> {
            if (caretaker.undo(3)){
                SwingUtilities.getWindowAncestor(buttons[4]).dispose();
            }
        });
    }
}
