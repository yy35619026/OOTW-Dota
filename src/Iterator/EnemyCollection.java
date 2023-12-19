package Iterator;

import Enemy.Enemy;

import java.util.Iterator;
//Aggregate
public interface EnemyCollection {
    void addEnemy(Enemy enemy);
    void removeEnemy(Enemy enemy);
    Iterator<Enemy> getIterator();
}