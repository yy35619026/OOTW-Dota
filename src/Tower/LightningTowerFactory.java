package Tower;

import java.util.ArrayList;

public class LightningTowerFactory implements TowerFactory{
    @Override
    public Tower createTower() {
        return new LightningTower(50, 35, 1, 400);
    }

    public void addTower(Tower tower, int x, int y) {
        TowerPlacement placement = new TowerPlacement(tower, x, y);
        Towerlist.add(placement);
    }

    public static ArrayList<TowerPlacement> getTowerlist() {
        return Towerlist;
    }
}
