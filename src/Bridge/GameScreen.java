package Bridge;

import Backpaint.BackgroundPanel;

import javax.swing.*;
import java.awt.*;

public abstract class GameScreen extends JFrame implements Runnable {
    protected ButtonSelector buttonSelector;
    protected JFrame frame;
    protected BackgroundPanel backgroundPanel;
    protected GridBagConstraints constraints;
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

        // GridBagConstraints物件的布局設置
        constraints = new GridBagConstraints();
        constraints.gridx = 0; // X軸位置為0
        constraints.insets = new Insets(50, 10, 10, 10);    // 設置按鈕周圍的間距
        constraints.anchor = GridBagConstraints.CENTER;                         // 設置按鈕在Y軸上居中對齊
    }
    public void setButtonSelector(ButtonSelector buttonSelector){
        this.buttonSelector = buttonSelector;
    }
    public abstract void getScreen();
}
