package Enemy;

public class FastEnemyFactory implements EnemyFactory{

    @Override
    public Enemy CreatEnemy() {
        return new FastEnemy("light",50,10);
    }
}
