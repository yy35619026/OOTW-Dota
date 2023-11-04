package Tower1;

public class ArcherTowerFactory implements TowerFactory{
    @Override
    public Tower createTower() {
        return new ArcherTower(20, 20, 1, 100.0);
    }
}
