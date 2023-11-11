package Tower;

import java.util.ArrayList;

public interface TowerFactory {
    static ArrayList<TowerPlacement> Towerlist = new ArrayList<>();

    Tower createTower();

    void addTower(Tower Tower, int x, int y);
}
