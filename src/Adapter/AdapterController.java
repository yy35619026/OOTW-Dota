package Adapter;
import Tower.Tower;

public class AdapterController {
    private Adapter adapter;
    private double money;
    private Tower tower;

    public AdapterController(Adapter adapter, double money, Tower tower) {
        this.adapter = adapter;
        this.money = money;
        this.tower = tower;
    }

    public void towerlvlup() {
        adapter.lvlup(money, tower);
    }
}
