import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DotaJFrame extends JFrame {
    public void init(){
        JFrame frame = new JFrame("Background Image Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // 创建自定义面板并设置为窗口的内容面板
        BackgroundPanel backgroundPanel = new BackgroundPanel("test.jpg"); // 替换成你的图像文件路径
        frame.setContentPane(backgroundPanel);

        frame.setVisible(true);
//        // 獲得一個容器
//        Container contentPane = this.getContentPane();
//        contentPane.setBackground(Color.white);
//
//        JLabel label = new JLabel("Dota小遊戲！");
//        this.add(label);
//
//        // 水平居中標籤
//        label.setHorizontalAlignment(SwingConstants.CENTER);
//
//        this.setVisible(true);
//        this.setBounds(1,1,1000,500);
    }
}