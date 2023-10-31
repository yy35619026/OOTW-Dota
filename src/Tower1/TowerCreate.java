package Tower1;

import javax.swing.*;
import java.awt.*;

public class TowerCreate {
    final int closeW = 50;
    final int closeH = 50;
    final int[] addpx = {300, 600};
    final int[] addpy = {150, 150};
    public void TowerCreates(){
        TowerFactory flameTowerFactory = new FlameTowerFactory();
        Tower flameTower1 = flameTowerFactory.createTower();
        Tower flameTower2 = flameTowerFactory.createTower();

        // 列印塔的屬性
        System.out.println("Flame Towers:");
        System.out.println("Tower 1 - Cost: " + flameTower1.getCost() + ", Damage: " + flameTower1.getDamage()
                + ", Level: " + flameTower1.getLevel());
        System.out.println("Tower 2 - Cost: " + flameTower2.getCost() + ", Damage: " + flameTower2.getDamage()
                + ", Level: " + flameTower2.getLevel());

        JFrame frame = new JFrame("關卡一");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 450);

        BackgroundPanel backgroundPanel = new BackgroundPanel("test.jpg");
        backgroundPanel.setLayout(null);
        frame.setContentPane(backgroundPanel);

        JButton[] imagechange1Button = getaddclosejButton("ChangeTower.png");
        JButton[] imageclose1Button = getaddclosejButton("CloseChange.png");
        JButton[] imagearcherchooseButton = getTowerChoosejButton("ArcherTowerPreview.png", 0);
        JButton[] imagelightningchooseButton = getTowerChoosejButton("LightningTower.png", 1);
        JButton[] imagearcherButton = getTowerjButton("ArcherTower.png");
        JButton[] imagelightningButton = getTowerjButton("LightningTower.png");
        backgroundPanel.add(imagechange1Button[0]);
        backgroundPanel.add(imagechange1Button[1]);

        for (int i = 0; i < imagechange1Button.length; i++) {
            final int index = i;
            imagechange1Button[i].setActionCommand("change" + i);

            imagechange1Button[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    backgroundPanel.add(imagearcherchooseButton[index]);
                    backgroundPanel.add(imagelightningchooseButton[index]);
                    backgroundPanel.add(imageclose1Button[index]);
                    backgroundPanel.remove(imagechange1Button[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        for (int i = 0; i < imageclose1Button.length; i++) {
            final int index = i;
            imageclose1Button[i].setActionCommand("change" + i);

            imageclose1Button[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    backgroundPanel.add(imagechange1Button[index]);
                    backgroundPanel.remove(imagearcherchooseButton[index]);
                    backgroundPanel.remove(imagelightningchooseButton[index]);
                    backgroundPanel.remove(imageclose1Button[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        for (int i = 0; i < imagearcherchooseButton.length; i++)  {
            final int index = i;
            imagearcherchooseButton[i].setActionCommand("change" + i);

            imagearcherchooseButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    backgroundPanel.add(imagearcherButton[index]);
                    backgroundPanel.add(imagechange1Button[index]);
                    backgroundPanel.remove(imagearcherchooseButton[index]);
                    backgroundPanel.remove(imagelightningchooseButton[index]);
                    imagechange1Button[index].setEnabled(false);
                    backgroundPanel.remove(imageclose1Button[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        for (int i = 0; i < imagelightningchooseButton.length; i++)  {
            final int index = i;
            imagelightningchooseButton[i].setActionCommand("change" + i);

            imagelightningchooseButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    backgroundPanel.add(imagelightningButton[index]);
                    backgroundPanel.add(imagechange1Button[index]);
                    backgroundPanel.remove(imagearcherchooseButton[index]);
                    backgroundPanel.remove(imagelightningchooseButton[index]);
                    imagechange1Button[index].setEnabled(false);
                    backgroundPanel.remove(imageclose1Button[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        for (int i = 0; i < imagearcherButton.length; i++)  {
            final int index = i;
            imagearcherButton[i].setActionCommand("change" + i);

            imagearcherButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        for (int i = 0; i < imagelightningButton.length; i++)  {
            final int index = i;
            imagelightningButton[i].setActionCommand("change" + i);

            imagelightningButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }
        frame.setVisible(true);
    }
    private JButton[] getaddclosejButton(String image) {
        JButton[] buttons = new JButton[addpx.length];
        for(int i = 0; i < addpx.length; i++){
            ImageIcon closeTower = new ImageIcon(image);
            Image originalcloseImage = closeTower.getImage();
            Image scaledcloseImage = originalcloseImage.getScaledInstance(closeW, closeH, Image.SCALE_SMOOTH);
            ImageIcon scaledcloseIcon = new ImageIcon(scaledcloseImage);
            JButton imagecloseButton = new JButton(scaledcloseIcon);
            imagecloseButton.setBounds(addpx[i], addpy[i], closeW, closeH);
            buttons[i] = imagecloseButton;
        }
        return buttons;
    }
    private JButton[] getTowerChoosejButton(String image, int d) {
        JButton[] buttons = new JButton[addpx.length];
        for(int i = 0; i < addpx.length; i++){
            ImageIcon closeTower = new ImageIcon(image);
            Image originalcloseImage = closeTower.getImage();
            Image scaledcloseImage = originalcloseImage.getScaledInstance(closeW + 20, closeH + 60, Image.SCALE_SMOOTH);
            ImageIcon scaledcloseIcon = new ImageIcon(scaledcloseImage);
            JButton imagecloseButton = new JButton(scaledcloseIcon);
            imagecloseButton.setBounds(addpx[i] - 90 + d * 80, addpy[i] - 120, closeW + 20, closeH + 60);
            buttons[i] = imagecloseButton;
        }
        return buttons;
    }
    private JButton[] getTowerjButton(String image) {
        JButton[] buttons = new JButton[addpx.length];
        for(int i = 0; i < addpx.length; i++){
            ImageIcon closeTower = new ImageIcon(image);
            Image originalcloseImage = closeTower.getImage();
            Image scaledcloseImage = originalcloseImage.getScaledInstance(90, 160, Image.SCALE_SMOOTH);
            ImageIcon scaledcloseIcon = new ImageIcon(scaledcloseImage);
            JButton imagecloseButton = new JButton(scaledcloseIcon);
            if(image.equals("ArcherTower.png")){
                imagecloseButton.setBounds(addpx[i]-20, addpy[i]-160, 90, 160);
            } else if (image.equals("LightningTower.png")) {
                imagecloseButton.setBounds(addpx[i]-20, addpy[i]-102, 90, 102);
            }
            buttons[i] = imagecloseButton;
        }
        return buttons;
    }
}