package State;

import GameScreen.VersionScreen;

import javax.swing.*;

public class ConcreteStateRE extends State{

    public JButton[] buttons;
    public ConcreteStateRE(JButton[] buttons){
        this.buttons = buttons;
    }
    @Override
    public boolean Handle() {
        return false;
    }

    @Override
    public void ReGm() {
        VersionScreen versionScreen = new VersionScreen();
        versionScreen.getScreen();
        SwingUtilities.getWindowAncestor(buttons[3]).dispose();
    }

}
