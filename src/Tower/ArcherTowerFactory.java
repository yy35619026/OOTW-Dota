package Tower;

public class ArcherTowerFactory implements TowerFactory{
    @Override
    public Tower createTower() {
        return new ArcherTower(20, 20, 1, 500);
    }

    public void addTower(Tower tower, int x, int y) {
        TowerPlacement placement = new TowerPlacement(tower, x, y);
        System.out.println(tower.getLevel());
        Towerlist.add(placement);
    }
}
