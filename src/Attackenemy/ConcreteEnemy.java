package Attackenemy;

public class ConcreteEnemy implements Enemy_Observer {
    private String name;
    public ConcreteEnemy(String name){
        this.name = name;
    }
    @Override
    public void update(String status) {
        switch (status){
            case "敵人成功攻城":
        }
        System.out.println(name + " 收到通知，敵人狀態更新為: " + status);
    }

    @Override
    public void update(ConcreteCastle concreteCastle, String status) {

    }
}
