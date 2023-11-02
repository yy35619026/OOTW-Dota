package Enemy;
import static Enemy.Constants.enemys.Basic;
public class BasicEnemy extends Enemy{

    public BasicEnemy(float x,float y,int id) {
        super(x,y,id,Basic);
        setStartHealth();
    }
}
