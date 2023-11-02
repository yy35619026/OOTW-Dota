package Tower1;

public class ArcherTower implements Tower{
    double cost;
    double damage;
    int level;
    double alertRange;
    public ArcherTower(double cost, double damage, int level, double alertRange) {
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
    public double getAlertRange() {
        return alertRange;
    }
}