package Attackenemy;

public class ObserverEnemy implements Observer {
    private int count = 20;
    @Override
    public String update(String status) {
        if(count != 0){
            switch (status){
                case "敵人成功攻城":
                case "敵人死亡":
                    count--;
                    return String.valueOf(count);
            }
        }
        return null;
    }
}
