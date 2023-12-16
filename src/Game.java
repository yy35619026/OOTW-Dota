import Bridge.GameScreen;
import Bridge.InitScreen;
import Bridge.VersionScreen;

public class Game {
    public static void main(String[] args) {
        GameScreen Game = new InitScreen();
        Game.getScreen();
    }
}