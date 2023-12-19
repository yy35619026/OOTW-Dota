package Iterator;

import Enemy.Enemy;

import java.util.Iterator;
//Iterator
public interface EnemyIterator extends Iterator<Enemy> {
    Enemy first();
    Enemy next();
    Enemy previous();
    Enemy last();
    boolean hasNext();
}
