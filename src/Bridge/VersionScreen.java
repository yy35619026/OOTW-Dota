package Bridge;

import javax.swing.*;
import java.awt.*;

public class VersionScreen extends GameScreen{
    private JButton version1, version2,version3, version4;
    @Override
    public void getScreen() {
        settings();
        // GridBagConstraints物件的布局設置
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0; // X軸位置為0
        constraints.insets = new Insets(50, 10, 10, 10);    // 設置按鈕周圍的間距
        constraints.anchor = GridBagConstraints.CENTER;                         // 設置按鈕在Y軸上居中對齊
        //按鈕一些屬性設置
        Dimension buttonSize = new Dimension(150, 50);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        JButton[] versions = { version1, version2, version3, version4 };
        String[] versionsTexts = { "Version1", "Version2", "Version3", "Version4" };

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
//            Game_level1();
            SwingUtilities.getWindowAncestor(versions[0]).dispose();
        });
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException();
    }
}
