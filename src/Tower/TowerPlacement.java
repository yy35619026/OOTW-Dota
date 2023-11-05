package Tower;

public class TowerPlacement {
    private Tower tower;
    private int x;
    private int y;

    public TowerPlacement(Tower tower, int x, int y) {
        this.tower = tower;
        this.x = x;
        this.y = y;
    }

    public Tower getTower() {
        return tower;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
