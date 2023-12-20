package Command;

import Tower.Tower;

public class CancelTowerCommand implements Command {
    private TowerCommand towerCommand;
    public CancelTowerCommand(TowerCommand towerCommand) {
        this.towerCommand = towerCommand;
    }
    @Override
    public void execute(double money, Tower tower) {
        towerCommand.cancel();
    }
}
