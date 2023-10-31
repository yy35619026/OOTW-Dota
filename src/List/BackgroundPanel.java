package List;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundPanel extends JPanel {
    private BufferedImage backgroundImage;
    private int circleX, circleY, circleRadius;
    private boolean circleshouldDrawCircle;
    public void setCircle(int x, int y, int radius, boolean shouldDrawCircle) {
        circleX = x;
        circleY = y;
        circleRadius = radius;
        circleshouldDrawCircle = shouldDrawCircle;
    }

    public BackgroundPanel(String imagePath) {
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
        System.out.println(circleX + " " + circleY);
        if(circleshouldDrawCircle){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(new Color(255, 0, 0, 100));
            g2d.setStroke(new BasicStroke(2.0f));
            g2d.drawOval(circleX - circleRadius / 2, circleY - circleRadius / 2, circleRadius, circleRadius);
        }

    }
}
