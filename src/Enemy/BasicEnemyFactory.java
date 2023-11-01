package Enemy;

public class BasicEnemyFactory implements EnemyFactory{


    @Override
    public Enemy CreatEnemy(float x,float y,int id) {
        return new BasicEnemy(x, y, id);
    }

    @Override
    public String getType() {
        return "basic";
    }
}