package Tower1;
public class FlameTowerFactory implements TowerFactory {
    @Override
    public Tower createTower() {
        return new FlameTower(80, 50, 1, 50.0);
    }
}