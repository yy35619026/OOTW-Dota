package Backpaint;

import Enemy.EnemyTest;
import List.*;
import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame {
    JButton new_game, end_game;
    JButton enemy;//enemy測試

    public void init() {
        //視窗
        JFrame frame = new JFrame("第七組Tower Defence game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 450);
        frame.setLocationRelativeTo(null);

        // 自定義面板的基礎構建
        BackgroundPanel backgroundPanel = new BackgroundPanel("./res/test.jpg"); // 替换成你的图像文件路径
        backgroundPanel.setLayout(new GridBagLayout());
        frame.setContentPane(backgroundPanel);

        // GridBagConstraints物件的布局設置
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0; // X軸位置為0
        constraints.insets = new Insets(50, 10, 10, 10);    // 設置按鈕周圍的間距
        constraints.anchor = GridBagConstraints.CENTER;                         // 設置按鈕在Y軸上居中對齊
        //按鈕一些屬性設置
        Dimension buttonsize = new Dimension(150, 50);
        Font buttonfont = new Font("Arial", Font.BOLD, 16);
        new_game = new JButton("New Game");
        end_game = new JButton("Exit");
        new_game.setFont(buttonfont);
        end_game.setFont(buttonfont);
        new_game.setPreferredSize(buttonsize);
        end_game.setPreferredSize(buttonsize);

        constraints.gridy = 0; // Y軸位置為0
        backgroundPanel.add(new_game, constraints);
        constraints.gridy = 1; // Y軸位置為1
        backgroundPanel.add(end_game, constraints);

        frame.setVisible(true);

        new_game.addActionListener(e -> {
            new TowerSelector().Background();
            SwingUtilities.getWindowAncestor(new_game).dispose();
        });

        //just test enemy , it can delete.
        enemy = new JButton("Enemy Test");
        enemy.setFont(buttonfont);
        enemy.setPreferredSize(buttonsize);
        constraints.gridy = 2; // Y軸位置為2
        backgroundPanel.add(enemy, constraints);

        enemy.addActionListener(e -> {
            new EnemyTest();
        });
    }
}