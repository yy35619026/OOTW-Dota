package Enemy;

import javax.swing.*;
import java.awt.*;

public class EnemyTest extends JFrame implements Runnable {
    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;
    private Thread gameThread;

    private GameScreen gameScreen;

    public EnemyTest(){
        System.out.println("EnemyTest constructor called");
        setFrame();
        start();
    }

    private void setFrame() {
        gameScreen = new GameScreen();
        JFrame frame = new JFrame("關卡一");
        frame.setSize(800, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(gameScreen);
    }
    private void start(){
        gameThread = new Thread(this) {
        };

        gameThread.start();
    }

    private void updatesEnemy() {
        gameScreen.enemyTileManager.update();
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        long now;

        while (true) {
            now = System.nanoTime();

            // Render
            if (now - lastFrame >= timePerFrame) {
                gameScreen.repaint();
                lastFrame = now;
                frames++;
            }
            // Update
            if (now - lastUpdate >= timePerUpdate) {
                updatesEnemy();
                lastUpdate = now;
                updates++;
            }
            if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }
        }
    }
}
