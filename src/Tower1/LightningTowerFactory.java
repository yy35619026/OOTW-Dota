package Tower1;

public class LightningTowerFactory implements TowerFactory{
    @Override
    public Tower createTower() {
        return new LightningTower(50, 35, 1, 80.0);
    }
}
