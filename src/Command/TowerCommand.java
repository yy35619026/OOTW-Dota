package Command;

import Tower.*;

public class TowerCommand {
    public double upgrade(double money, Tower tower) {
        if (tower instanceof ArcherTower && money >= 10) {
            System.out.println("ArcherTower upgrade");
            ((ArcherTower) tower).upgrade();
            System.out.println(tower.getCost());
            money -= 10;
        }else if(tower instanceof LightningTower && money >= 30) {
            System.out.println("LightningTower upgrade");
            ((LightningTower) tower).upgrade();
            money -= 30;
        } else if(tower instanceof FlameTower && money >= 50) {
            System.out.println("FlameTower upgrade");
            ((FlameTower) tower).upgrade();
            money -= 50;
        }
        return money;
    }
    public double sell(double money, Tower tower) {
        if (tower instanceof ArcherTower) {
            System.out.println("ArcherTower sold");
            money += tower.getCost() * 0.8;
        }else if(tower instanceof LightningTower) {
            System.out.println("LightningTower sold");
            money += tower.getCost() * 0.8;
        } else if(tower instanceof FlameTower) {
            System.out.println("FlameTower sold");
            money += tower.getCost() * 0.8;
        }
        return money;
    }
    public void cancel() {
        System.out.println("Cancel choose");
    }
}
