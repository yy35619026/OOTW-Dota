package Command;

import Tower.*;

public class TowerCommand {
    public void upgrade() {
        System.out.println("Tower upgraded");
    }

    public double sell(double money, Tower tower) {
        if (tower instanceof ArcherTower) {
            System.out.println("ArcherTower sold");
            money += 16;
        }else if(tower instanceof LightningTower) {
            System.out.println("LightningTower sold");
            money += 40;
        } else if(tower instanceof FlameTower) {
            System.out.println("FlameTower sold");
            money += 64;
        }
        return money;
    }
}