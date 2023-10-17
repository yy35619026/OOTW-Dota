package Tower;
public abstract class Tower {
    protected double cost;
    protected double damage;
    protected int level;

    public Tower(double cost, double damage, int level) {
        this.cost = cost;
        this.damage = damage;
        this.level = level;
    }

    public double getCost() {
        return cost;
    }

    public double getDamage() {
        return damage;
    }

    public int getLevel() {
        return level;
    }
}
