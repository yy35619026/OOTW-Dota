package Tower;

import Attackenemy.ConcreteCastle;

public class LightningTower implements Tower{
    double cost;
    double damage;
    int level;
    int alertRange;
    public LightningTower(double cost, double damage, int level, int alertRange) {
        this.cost = cost;
        this.damage = damage;
        this.level = level;
        this.alertRange = alertRange;
    }
    @Override
    public double getCost() {
        return cost;
    }
    @Override
    public double getDamage() {
        return damage;
    }
    @Override
    public int getLevel() {
        return level;
    }
    @Override
    public int getAlertRange() {
        return alertRange;
    }
    public void update(ConcreteCastle enemy, String status) {
        System.out.println("Archer Tower 收到通知，敵人狀態更新為: " + status);
    }
}
