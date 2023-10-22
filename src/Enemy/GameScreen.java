package Enemy;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {
    EnemyTileManager enemyTileManager;

    public GameScreen(){
        enemyTileManager = new EnemyTileManager();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        enemyTileManager.draw(g);
    }
}
