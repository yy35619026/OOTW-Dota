package Attackenemy;

public class ConcreteTower implements Tower_Observer {
    private String name;

    public ConcreteTower(String name) {
        this.name = name;
    }

    @Override
    public void update(Enemy_Subject enemy, String status) {
        System.out.println(name + " 收到通知，敵人狀態更新為: " + status);
    }
}
