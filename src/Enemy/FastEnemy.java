package Enemy;
import static Enemy.Constants.enemys.Fast;
public class FastEnemy extends Enemy {

    public FastEnemy(float x,float y,int id) {
        super(x,y,id,Fast);
        setStartHealth();
    }
}