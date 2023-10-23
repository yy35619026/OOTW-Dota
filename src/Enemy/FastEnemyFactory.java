package Enemy;

public class FastEnemyFactory implements EnemyFactory{

    @Override
    public Enemy CreatEnemy(float x,float y,int id, int enemyType) {
        return new FastEnemy(x,y,id,enemyType);
    }
}
