package Enemy;

public class Constants {
    public static class enemys{
        public static final int Basic = 0;
        public static final int Fast = 1;

        public static float getSpeed(int enemyType){

            switch (enemyType){
                case Basic:
                    return 1f;
                case Fast:
                    return 0.75f;
            }
            return 0;
        }

        public static int GetStartHealth(int enemyType) {

            switch (enemyType){
                case Basic:
                    return 1000;
                case Fast:
                    return 100;
            }
            return 0;
        }
    }
}
