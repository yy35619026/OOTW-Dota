package Tower;
import Bridge.*;

public abstract class Tower{
    public abstract double getCost();
    abstract double getDamage();
    abstract int getLevel();
    public abstract int getAlertRange();
}
