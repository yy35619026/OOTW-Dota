package Enemy;

public class BasicEnemyFactory implements EnemyFactory{


    @Override
    public Enemy CreatEnemy() {
        return new BasicEnemy("light" ,100,5);
    }
}
