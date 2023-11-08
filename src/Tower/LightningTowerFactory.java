package Tower;

import java.util.ArrayList;

public class LightningTowerFactory implements TowerFactory{
    static ArrayList<TowerPlacement> Towerlist = new ArrayList<>();
    @Override
    public Tower createTower() {
        return new LightningTower(50, 35, 1, 400);
    }

    public static void addTower(Tower tower, int x, int y) {
        TowerPlacement placement = new TowerPlacement(tower, x, y);
        Towerlist.add(placement);
    }

    public static ArrayList<TowerPlacement> getTowerlist() {
        return Towerlist;
    }
    public static void removeTower(int x, int y) {
        for(int i = 0; i < Towerlist.size(); i++){
            if(Towerlist.get(i).getX() == x && Towerlist.get(i).getY() == y){
                Towerlist.remove(i);
            }
        }
    }
}
