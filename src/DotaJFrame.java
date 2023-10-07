import javax.swing.*;
import java.awt.*;

public class DotaJFrame extends JFrame {
    public void init(){
        // 獲得一個容器
        Container contentPane = this.getContentPane();
        contentPane.setBackground(Color.white);

        JLabel label = new JLabel("Dota小遊戲！");
        this.add(label);

        // 水平居中標籤
        label.setHorizontalAlignment(SwingConstants.CENTER);

        this.setVisible(true);
        this.setBounds(1,1,1000,500);
    }
}
