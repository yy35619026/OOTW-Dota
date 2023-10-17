package Tower;
public class FlameTowerFactory implements TowerFactory {
    @Override
    public Tower createTower() {
        return new FlameTower(80, 50, 1);
    }
}