package Enemy;

public class FastEnemyFactory implements EnemyFactory{

    @Override
    public Enemy CreatEnemy(float x, float y, int id) {
        return new FastEnemy(x,y,id);
    }
    @Override
    public String getType() {
        return "fast";
    }
}
