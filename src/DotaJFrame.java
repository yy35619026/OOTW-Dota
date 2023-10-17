import Tower.TowerCreate;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DotaJFrame extends JFrame {
    JButton new_game, end_game;
    public void init(){
        //視窗
        JFrame frame = new JFrame("第七組Tower Defence game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);

        // 自定義面板的基礎構建
        BackgroundPanel backgroundPanel = new BackgroundPanel("test.jpg"); // 替换成你的图像文件路径
        backgroundPanel.setLayout(new GridBagLayout());
        frame.setContentPane(backgroundPanel);

        // GridBagConstraints物件的布局設置
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0; // X軸位置為0
        constraints.insets = new Insets(50, 10, 10, 10);    // 設置按鈕周圍的間距
        constraints.anchor = GridBagConstraints.CENTER;                         // 設置按鈕在Y軸上居中對齊
        //按鈕一些屬性設置
        Dimension buttonsize = new Dimension(150, 50);
        Font buttonfont = new Font("Arial",Font.BOLD, 16);
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
            new TowerCreate().TowerCreates();
            SwingUtilities.getWindowAncestor(new_game).dispose();
        });
    }
}