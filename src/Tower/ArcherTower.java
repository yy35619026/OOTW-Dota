package Tower;

public class ArcherTower implements Tower{
    double cost;
    double damage;
    int level;
    int alertRange;
    public ArcherTower(double cost, double damage, int level, int alertRange) {
        this.cost = cost;
        this.damage = damage;
        this.level = level;
        this.alertRange = alertRange;
    }
    public void upgrade() {
        this.level++;
        this.cost += 10;
        this.damage += (level - 1) * 12;
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
}
