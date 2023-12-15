package Message;

import Backpaint.BackgroundPanel;
import Bridge.Level_GUI;

import javax.swing.*;
import java.awt.*;

public class Success {
    protected JFrame jFrame;
    protected BackgroundPanel backgroundPanel;
    protected GridBagConstraints constraints;
    protected Dimension buttonSize;
    protected Font buttonFont;
    protected JButton next_game, restart_game;
    protected JButton[] buttons = {next_game, restart_game};
    protected String[] buttonsTexts = {"Next Game", "Restart"};
    protected void settings(){
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(300, 300);
        jFrame.setLocationRelativeTo(null);

        // 自定義面板的基礎構建
        backgroundPanel = new BackgroundPanel("./res/test.jpg");
        backgroundPanel.setLayout(new GridBagLayout());
        jFrame.setContentPane(backgroundPanel);

        // GridBagConstraints物件的布局設置
        constraints = new GridBagConstraints();
        constraints.gridx = 0; // X軸位置為0
        constraints.insets = new Insets(50, 10, 10, 10);
        constraints.anchor = GridBagConstraints.CENTER;

        //按鈕一些屬性設置
        buttonSize = new Dimension(150, 50);
        buttonFont = new Font("Arial", Font.BOLD, 16);
    }
    public void win(Level_GUI level){
        settings();
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonsTexts[i]);
            buttons[i].setFont(buttonFont);
            buttons[i].setPreferredSize(buttonSize);
            constraints.gridy = i;
            backgroundPanel.add(buttons[i], constraints);
        }
        jFrame.setVisible(true);
        //Next Game
        buttons[0].addActionListener(e -> {
            level.getScreen();
            level.dispose();
            SwingUtilities.getWindowAncestor(buttons[0]).dispose();
        });
        //Next Game
        buttons[1].addActionListener(e -> {
            level.getScreen();
            level.dispose();
            SwingUtilities.getWindowAncestor(buttons[1]).dispose();
        });
    }
}
