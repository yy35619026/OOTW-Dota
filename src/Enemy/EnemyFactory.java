package Enemy;

public interface EnemyFactory {
    Enemy CreatEnemy(float x,float y,int id);
    String getType();
}
