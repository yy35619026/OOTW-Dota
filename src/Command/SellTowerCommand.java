package Command;

import Tower.Tower;

public class SellTowerCommand implements Command {
    private TowerCommand towerCommand;
    double money;

    public SellTowerCommand(TowerCommand towerCommand) {
        this.towerCommand = towerCommand;
    }

    @Override
    public void execute(double money, Tower tower) {
        this.money = towerCommand.sell(money, tower);
    }
    public double getMoney() {
        return money;
    }
}
