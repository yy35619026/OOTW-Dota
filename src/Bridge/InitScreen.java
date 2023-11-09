package Bridge;

import javax.swing.*;
import java.awt.*;

public class InitScreen extends GameScreen{
    private JButton new_game, end_game;
    public InitScreen(){
        super();
    }
    @Override
    public void getScreen() {
        settings();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0; // X軸位置為0
        constraints.insets = new Insets(50, 10, 10, 10);    // 設置按鈕周圍的間距
        constraints.anchor = GridBagConstraints.CENTER;                         // 設置按鈕在Y軸上居中對齊
        //按鈕一些屬性設置
        Dimension buttonSize = new Dimension(150, 50);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        new_game = new JButton();
        end_game = new JButton();
        new_game.setFont(buttonFont);
        end_game.setFont(buttonFont);
        new_game.setPreferredSize(buttonSize);
        end_game.setPreferredSize(buttonSize);

        ImageIcon StartGame = new ImageIcon("./res/button/Start.png");
        Image scaledStartImage = StartGame.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledStartIcon = new ImageIcon(scaledStartImage);
        new_game.setIcon(scaledStartIcon);
        new_game.setFocusPainted(false);
        new_game.setOpaque(false);
        new_game.setContentAreaFilled(false);
        new_game.setBorderPainted(false);

        ImageIcon ExitGame = new ImageIcon("./res/button/Exit.png");
        Image scaledExitImage = ExitGame.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledExitIcon = new ImageIcon(scaledExitImage);
        end_game.setIcon(scaledExitIcon);
        end_game.setFocusPainted(false);
        end_game.setOpaque(false);
        end_game.setContentAreaFilled(false);
        end_game.setBorderPainted(false);


        constraints.gridy = 0; // Y軸位置為0
        backgroundPanel.add(new_game, constraints);
        constraints.gridy = 1; // Y軸位置為1
        backgroundPanel.add(end_game, constraints);

        frame.setVisible(true);

        new_game.addActionListener(e -> {
            VersionScreen versionScreen = new VersionScreen();
            versionScreen.getScreen();
//            new TowerSelector().Background();
            SwingUtilities.getWindowAncestor(new_game).dispose();
        });
        end_game.addActionListener(e -> {
            System.exit(0);
        });
    }
    @Override
    public void run() {
        throw new UnsupportedOperationException();
    }
}
