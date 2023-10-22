package List;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundPanel extends JPanel {
    private BufferedImage backgroundImage;

    public BackgroundPanel(String imagePath) {
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 添加滑鼠監聽器到 BackgroundPanel 物件

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // 繪制背景圖片
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
