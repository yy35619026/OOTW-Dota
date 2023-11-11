package Bridge;

import javax.swing.*;
import java.awt.*;

public class VersionScreen extends GameScreen{
    private JButton version1, version2,version3, version4;
    private JButton[] versions = { version1, version2, version3, version4 };
    private String[] versionsTexts = { "Version1", "Version2", "Version3", "Version4" };
    @Override
    public void getScreen() {
        settings();

        //按鈕一些屬性設置
        Dimension buttonSize = new Dimension(150, 50);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        for (int i = 0; i < versions.length; i++) {
            versions[i] = new JButton(versionsTexts[i]);
            versions[i].setFont(buttonFont);
            versions[i].setPreferredSize(buttonSize);
            constraints.gridy = i;
            backgroundPanel.add(versions[i], constraints);
        }

        frame.setVisible(true);
        //Version1
        versions[0].addActionListener(e -> {
            Level1Screen level1Screen = new Level1Screen();
            level1Screen.getScreen();
            SwingUtilities.getWindowAncestor(versions[0]).dispose();
        });
    }
    @Override
    public void run() {
        throw new UnsupportedOperationException();
    }
}
