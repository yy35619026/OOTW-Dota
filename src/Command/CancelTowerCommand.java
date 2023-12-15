package Command;

import Tower.Tower;

public class CancelTowerCommand implements Command {
    // No specific tower needed for cancel operation

    @Override
    public void execute(double money, Tower tower) {
        // Logic for cancel operation
        System.out.println("Cancel operation");
    }
}
