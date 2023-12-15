package Command;

import Tower.Tower;

public class UpgradeTowerCommand implements Command {
    private TowerCommand towerCommand;

    public UpgradeTowerCommand(TowerCommand towerCommand) {
        this.towerCommand = towerCommand;
    }

    @Override
    public void execute(double money, Tower tower) {
        towerCommand.upgrade();
    }
}
