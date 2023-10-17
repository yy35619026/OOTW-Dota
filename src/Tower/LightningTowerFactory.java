package Tower;
public class LightningTowerFactory implements TowerFactory {
    @Override
    public Tower createTower() {
        return new LightningTower(50, 35, 1);
    }
}