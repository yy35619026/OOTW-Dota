package Attackenemy;

public class ObserverCastleHP implements Observer {
    private int count = 10;
    @Override
    public String update(String status) {
        if(count != 0){
            switch (status){
                case "敵人成功攻城":
                    count--;
                    return String.valueOf(count);
                case "敵人死亡":

            }
        }
        return null;
    }
}
