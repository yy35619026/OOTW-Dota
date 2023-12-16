package Bridge;

import javax.swing.*;

public abstract class ButtonSelector implements GameInfo{
    final int AddCancelButW = 50;
    final int AddCancelButH = 50;
    final int[] Originalx = {300, 600, 900, 1200, 150, 450, 750, 1050};
    final int[] Originaly = {280, 280, 280, 280, 520, 520, 520, 520};
    public abstract JButton[] getButton(String image);
}
