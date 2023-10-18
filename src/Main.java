import Enemy.BasicEnemyFactory;
import Enemy.Enemy;
import Enemy.EnemyFactory;
import Enemy.FastEnemyFactory;

public class Main {
    public static void main(String[] args) {
        new DotaJFrame().init();


        //enemy factory test
        EnemyFactory enemyFactoryB = new BasicEnemyFactory();
        Enemy enemyB = enemyFactoryB.CreatEnemy();
        EnemyFactory enemyFactoryF = new FastEnemyFactory();
        Enemy enemyF = enemyFactoryF.CreatEnemy();

        System.out.println("BasicEnemy Health is : " + enemyB.getHealth());
        System.out.println("FastEnemy Health is : " + enemyF.getHealth());
    }
}