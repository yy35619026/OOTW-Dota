package Command;

import Tower.Tower;

public interface Command {
    void execute(double money, Tower tower);
}
