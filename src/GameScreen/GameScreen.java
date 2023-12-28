package GameScreen;

import Backpaint.BackgroundPanel;

import javax.swing.*;
import java.awt.*;

public abstract class GameScreen extends JFrame{
    protected JFrame frame;
    protected BackgroundPanel backgroundPanel;
    protected GridBagConstraints constraints;
    protected void settings(int width, int height){
        //視窗
        frame = new JFrame("第七組Tower Defence game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);

        // 自定義面板的基礎構建
        backgroundPanel = new BackgroundPanel("./res/test.jpg");
        backgroundPanel.setLayout(new GridBagLayout());
        frame.setContentPane(backgroundPanel);

        // GridBagConstraints物件的布局設置
        constraints = new GridBagConstraints();
        constraints.gridx = 0; // X軸位置為0
        constraints.insets = new Insets(50, 10, 10, 10);
        constraints.anchor = GridBagConstraints.CENTER;
    }
    public abstract void getScreen();
}
