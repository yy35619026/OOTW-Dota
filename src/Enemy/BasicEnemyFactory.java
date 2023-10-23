package Enemy;

public class BasicEnemyFactory implements EnemyFactory{


    @Override
    public Enemy CreatEnemy(float x,float y,int id, int enemyType) {
        return new BasicEnemy(x, y, id, enemyType);
    }
}