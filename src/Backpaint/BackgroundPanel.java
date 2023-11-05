package Backpaint;

import Enemy.EnemyTileManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundPanel extends JPanel {
    private BufferedImage backgroundImage;
    private int circleX, circleY, circleRadius;
    private boolean circleshouldDrawCircle, shouldCreateEnemy;
    public EnemyTileManager enemyTileManager;

    public void setCircle(int x, int y, int radius, boolean shouldDrawCircle) {
        circleX = x;
        circleY = y;
        circleRadius = radius;
        circleshouldDrawCircle = shouldDrawCircle;
    }
    public void setEnemy(boolean shouldCreateEnemy){
        this.shouldCreateEnemy = shouldCreateEnemy;
    }
    public BackgroundPanel(String imagePath) {
        enemyTileManager = new EnemyTileManager();
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //傳給其他需要enemyTileManager的class
    public EnemyTileManager getEnemymanager(){
        return enemyTileManager;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // 绘制背景图片
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
        if(shouldCreateEnemy){
            enemyTileManager.draw(g);
        }
        if(circleshouldDrawCircle){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(new Color(255, 0, 0, 100));
            g2d.setStroke(new BasicStroke(2.0f));
            g2d.drawOval(circleX - circleRadius / 2 + 25, circleY - circleRadius / 2 + 25, circleRadius, circleRadius);
        }
    }
}
