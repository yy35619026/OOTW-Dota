package Iterator;

import Enemy.Enemy;

import java.util.List;
//ConcreteIterator
public class EnemyTileManagerIterator implements EnemyIterator {
    private List<Enemy> enemies;
    private int index = -1;

    public EnemyTileManagerIterator(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    @Override
    public boolean hasNext() {
        return index < enemies.size() - 1;
    }

    @Override
    public Enemy first() {
        index = 0;
        return enemies.get(index);
    }

    @Override
    public Enemy next() {
        if (hasNext()) {
            index++;
            return enemies.get(index);
        }
        return null; // 或者拋出例外，視情況而定
    }

    @Override
    public Enemy previous() {
        if (index > 0) {
            index--;
            return enemies.get(index);
        }
        return null; // 或者拋出例外，視情況而定
    }

    @Override
    public Enemy last() {
        index = enemies.size() - 1;
        return enemies.get(index);
    }
}
