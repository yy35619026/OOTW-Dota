package Tower1;

import static Tower1.LightningTowerFactory.Towerlist;

public class FlameTowerFactory implements TowerFactory{
    @Override
    public Tower createTower() {
        return new FlameTower(80, 50, 1, 350);
    }

    public static void addTower(Tower tower, int x, int y) {
        TowerPlacement placement = new TowerPlacement(tower, x, y);
        Towerlist.add(placement);
    }
}
