package Bridge;

import Backpaint.BackgroundPanel;

import javax.swing.*;
import java.awt.*;

public abstract class GameScreen extends JFrame implements Runnable {
    protected JFrame frame;
    protected BackgroundPanel backgroundPanel;
    public void settings(){
        //視窗
        frame = new JFrame("第七組Tower Defence game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        frame.setLocationRelativeTo(null);

        // 自定義面板的基礎構建
        backgroundPanel = new BackgroundPanel("./res/test.jpg"); // 替换成你的图像文件路径
        backgroundPanel.setLayout(new GridBagLayout());
        frame.setContentPane(backgroundPanel);
    }
    public abstract void getScreen();
}
