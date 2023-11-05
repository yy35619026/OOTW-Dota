package Enemy;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadTile {
    public static BufferedImage getSpriteAtlas() {
        BufferedImage img = null;
        InputStream is = LoadTile.class.getClassLoader().getResourceAsStream("sprites/Free Sprites 4x.png");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
