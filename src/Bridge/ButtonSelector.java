package Bridge;

import javax.swing.*;

public abstract class ButtonSelector{
    final int AddCancelButW = 50;
    final int AddCancelButH = 50;
    protected int[] Originalx;
    protected int[] Originaly;
    public ButtonSelector(int[] Originalx, int[] Originaly){
        this.Originalx = Originalx;
        this.Originaly = Originaly;
    }
    public abstract JButton[] getButton(String image);
}
