package Command;

import Tower.*;

public class TowerController {
    private Command command;
    private double money;
    private Tower tower;

    public void setCommand(Command command, double money, Tower tower) {
        this.command = command;
        this.money = money;
        this.tower = tower;
    }

    public void performAction() {
        command.execute(money, tower);
    }
}
