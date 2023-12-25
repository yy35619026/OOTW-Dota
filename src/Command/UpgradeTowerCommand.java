package Command;

import Tower.Tower;

public class UpgradeTowerCommand implements Command {
    private TowerCommand towerCommand;
    double money;

    public UpgradeTowerCommand(TowerCommand towerCommand) {
        this.towerCommand = towerCommand;
    }

    @Override
    public void execute(double money, Tower tower) {
        this.money = towerCommand.upgrade(money, tower);
    }
    public double getMoney() {
        return money;
    }
}
