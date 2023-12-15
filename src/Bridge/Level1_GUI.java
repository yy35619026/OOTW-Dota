package Bridge;

import Tower.*;
import Command.*;
import javax.swing.*;

public class Level1_GUI extends Level_GUI{
    final int[] Originalx = {300, 600, 900, 1200, 150, 450, 750, 1050};
    final int[] Originaly = {280, 280, 280, 280, 520, 520, 520, 520};
    @Override
    public void getScreen() {
        settings();
        buttons[0].addActionListener(e -> {
            SaveLevel saveLevel = new SaveLevel();
            saveLevel.setLevel(this);
            saveLevel.getScreen();
        });
        //Command按鈕
        TowerCommand tower = new TowerCommand();
        Command upgradeCommand = new UpgradeTowerCommand(tower);
        Command sellCommand = new SellTowerCommand(tower);
        Command cancelCommand = new CancelTowerCommand();
        TowerController controller = new TowerController();
        //+-號按鈕
        setButtonSelector(new CancelButton());
        JButton[] imageAddButton = buttonSelector.getButton("./res/button/Add.png");
        JButton[] imageCancelButton = buttonSelector.getButton("./res/button/Cancel.png");

        //箭塔選項(雷電塔、可樂塔)
        setButtonSelector(new ChooseButton());
        JButton[] imageArcherChooseButton = buttonSelector.getButton("./res/Tower/tower1.png");
        JButton[] imageLightningChooseButton = buttonSelector.getButton("./res/Tower/tower2.png");
        JButton[] imageColaChooseButton = buttonSelector.getButton("./res/Tower/tower3.png");

        //箭塔金額(雷電塔、可樂塔)
        setButtonSelector(new DollarButton());
        JButton[] imageArcherGoldChooseButton = buttonSelector.getButton("./res/Button/20dollar.png");
        JButton[] imageLightningGoldChooseButton = buttonSelector.getButton("./res/Button/50dollar.png");
        JButton[] imageColaGoldChooseButton = buttonSelector.getButton("./res/Button/80dollar.png");

        //箭塔、雷電塔、可樂塔生成
        setButtonSelector(new TowerButton());
        JButton[] imageArcherButton = buttonSelector.getButton("./res/Tower/tower1.png");
        JButton[] imageLightningButton = buttonSelector.getButton("./res/Tower/tower2.png");
        JButton[] imageColaButton = buttonSelector.getButton("./res/Tower/tower3.png");

        //賣出、取消、升級按鈕
        setButtonSelector(new FunctionButton());
        JButton[] imageSellButton = buttonSelector.getButton("./res/button/Gold.png");
        JButton[] imageEscapeButton = buttonSelector.getButton("./res/button/Escape.png");
        JButton[] imageUpgradeButton = buttonSelector.getButton("./res/button/Upgrade.png");

        for (int i = 0; i < Originalx.length; i++) {
            backgroundPanel.add(imageAddButton[i]);
        }

        backgroundPanel.setEnemy(true);

        for (int i = 0; i < imageAddButton.length; i++) {
            final int index = i;
            imageAddButton[i].setActionCommand("change" + i);
            imageAddButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    backgroundPanel.add(imageArcherChooseButton[index]);
                    backgroundPanel.add(imageArcherGoldChooseButton[index]);
                    backgroundPanel.add(imageLightningChooseButton[index]);
                    backgroundPanel.add(imageLightningGoldChooseButton[index]);
                    backgroundPanel.add(imageColaChooseButton[index]);
                    backgroundPanel.add(imageColaGoldChooseButton[index]);
                    backgroundPanel.add(imageCancelButton[index]);
                    backgroundPanel.remove(imageAddButton[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        for (int i = 0; i < imageCancelButton.length; i++) {
            final int index = i;
            imageCancelButton[i].setActionCommand("change" + i);
            imageCancelButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    backgroundPanel.add(imageAddButton[index]);
                    backgroundPanel.remove(imageArcherChooseButton[index]);
                    backgroundPanel.remove(imageArcherGoldChooseButton[index]);
                    backgroundPanel.remove(imageLightningChooseButton[index]);
                    backgroundPanel.remove(imageLightningGoldChooseButton[index]);
                    backgroundPanel.remove(imageColaChooseButton[index]);
                    backgroundPanel.remove(imageColaGoldChooseButton[index]);
                    backgroundPanel.remove(imageCancelButton[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        for (int i = 0; i < imageArcherChooseButton.length; i++) {
            final int index = i;
            imageArcherChooseButton[i].setActionCommand("change" + i);
            imageArcherChooseButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (money >= archerTower.getCost()) {
                    if (actionCommand.equals("change" + index)) {
                        backgroundPanel.add(imageArcherButton[index]);
                        archerTowerFactory.addTower(archerTower, Originalx[index], Originaly[index]);
                        money = money - archerTower.getCost();
                        updateMoneyLabel();
                        backgroundPanel.remove(imageArcherChooseButton[index]);
                        backgroundPanel.remove(imageArcherGoldChooseButton[index]);
                        backgroundPanel.remove(imageLightningChooseButton[index]);
                        backgroundPanel.remove(imageLightningGoldChooseButton[index]);
                        backgroundPanel.remove(imageColaChooseButton[index]);
                        backgroundPanel.remove(imageColaGoldChooseButton[index]);
                        backgroundPanel.remove(imageCancelButton[index]);
                        backgroundPanel.revalidate();
                        backgroundPanel.repaint();
                    }
                }else{
                    System.out.println("金錢不足");
                }
            });
        }

        for (int i = 0; i < imageLightningChooseButton.length; i++) {
            final int index = i;
            imageLightningChooseButton[i].setActionCommand("change" + i);
            imageLightningChooseButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (money >= lightningTower.getCost()) {
                    if (actionCommand.equals("change" + index)) {
                        backgroundPanel.add(imageLightningButton[index]);
                        lightningTowerFactory.addTower(lightningTower, Originalx[index], Originaly[index]);
                        money = money - lightningTower.getCost();
                        updateMoneyLabel();
                        backgroundPanel.remove(imageArcherChooseButton[index]);
                        backgroundPanel.remove(imageArcherGoldChooseButton[index]);
                        backgroundPanel.remove(imageLightningChooseButton[index]);
                        backgroundPanel.remove(imageLightningGoldChooseButton[index]);
                        backgroundPanel.remove(imageColaChooseButton[index]);
                        backgroundPanel.remove(imageColaGoldChooseButton[index]);
                        backgroundPanel.remove(imageCancelButton[index]);
                        backgroundPanel.revalidate();
                        backgroundPanel.repaint();
                    }
                }else{
                    System.out.println("金錢不足");
                }
            });
        }

        for (int i = 0; i < imageColaChooseButton.length; i++) {
            final int index = i;
            imageColaChooseButton[i].setActionCommand("change" + i);
            imageColaChooseButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (money >= flameTower.getCost()) {
                    if (actionCommand.equals("change" + index)) {
                        backgroundPanel.add(imageColaButton[index]);
                        flameTowerFactory.addTower(flameTower, Originalx[index], Originaly[index]);
                        money = money - flameTower.getCost();
                        updateMoneyLabel();
                        backgroundPanel.remove(imageArcherChooseButton[index]);
                        backgroundPanel.remove(imageArcherGoldChooseButton[index]);
                        backgroundPanel.remove(imageLightningChooseButton[index]);
                        backgroundPanel.remove(imageLightningGoldChooseButton[index]);
                        backgroundPanel.remove(imageColaChooseButton[index]);
                        backgroundPanel.remove(imageColaGoldChooseButton[index]);
                        backgroundPanel.remove(imageCancelButton[index]);
                        backgroundPanel.revalidate();
                        backgroundPanel.repaint();
                    }
                }else{
                    System.out.println("金錢不足");
                }
            });
        }

        for (int i = 0; i < imageArcherButton.length; i++) {
            final int index = i;
            imageArcherButton[i].setActionCommand("change" + i);
            imageArcherButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    shouldDrawCircle = true;
                    circleX = Originalx[index];
                    circleY = Originaly[index];
                    backgroundPanel.setCircle(circleX, circleY, archerTower.getAlertRange(), shouldDrawCircle);
                    backgroundPanel.add(imageEscapeButton[index]);
                    backgroundPanel.add(imageSellButton[index]);
                    backgroundPanel.add(imageUpgradeButton[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        for (int i = 0; i < imageLightningButton.length; i++) {
            final int index = i;
            imageLightningButton[i].setActionCommand("change" + i);
            imageLightningButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    shouldDrawCircle = true;
                    circleX = Originalx[index];
                    circleY = Originaly[index];
                    backgroundPanel.setCircle(circleX, circleY, lightningTower.getAlertRange(), shouldDrawCircle);
                    backgroundPanel.add(imageEscapeButton[index]);
                    backgroundPanel.add(imageSellButton[index]);
                    backgroundPanel.add(imageUpgradeButton[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        for (int i = 0; i < imageColaButton.length; i++) {
            final int index = i;
            imageColaButton[i].setActionCommand("change" + i);
            imageColaButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    shouldDrawCircle = true;
                    circleX = Originalx[index];
                    circleY = Originaly[index];
                    backgroundPanel.setCircle(circleX, circleY, flameTower.getAlertRange(), shouldDrawCircle);
                    backgroundPanel.add(imageEscapeButton[index]);
                    backgroundPanel.add(imageSellButton[index]);
                    backgroundPanel.add(imageUpgradeButton[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        for (int i = 0; i < imageSellButton.length; i++) {
            final int index = i;
            imageSellButton[i].setActionCommand("change" + i);
            imageSellButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    shouldDrawCircle = false;
                    backgroundPanel.setCircle(circleX, circleY, 0, shouldDrawCircle);
                    controller.setCommand(sellCommand, money, towerArray.getTower(Originalx[index], Originaly[index]));
                    controller.performAction();
                    money = ((SellTowerCommand) sellCommand).getMoney();
                    updateMoneyLabel();
                    //money = money + towerArray.getCost(Originalx[index], Originaly[index]) * 0.8;
                    towerArray.removeTower(Originalx[index], Originaly[index]);
                    backgroundPanel.remove(imageEscapeButton[index]);
                    backgroundPanel.remove(imageSellButton[index]);
                    backgroundPanel.remove(imageUpgradeButton[index]);
                    backgroundPanel.remove(imageColaButton[index]);
                    backgroundPanel.remove(imageArcherButton[index]);
                    backgroundPanel.remove(imageLightningButton[index]);
                    backgroundPanel.add(imageAddButton[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }


        for (int i = 0; i < imageUpgradeButton.length; i++) {
            final int index = i;
            imageUpgradeButton[i].setActionCommand("change" + i);
            imageUpgradeButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    shouldDrawCircle = false;
                    backgroundPanel.setCircle(circleX, circleY, 0, shouldDrawCircle);
                    controller.setCommand(upgradeCommand, money, towerArray.getTower(Originalx[index], Originaly[index]));
                    controller.performAction();
                    backgroundPanel.remove(imageEscapeButton[index]);
                    backgroundPanel.remove(imageSellButton[index]);
                    backgroundPanel.remove(imageUpgradeButton[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }


        for (int i = 0; i < imageEscapeButton.length; i++) {
            final int index = i;
            imageEscapeButton[i].setActionCommand("change" + i);
            imageEscapeButton[i].addActionListener(e -> {
                String actionCommand = e.getActionCommand();
                if (actionCommand.equals("change" + index)) {
                    shouldDrawCircle = false;
                    backgroundPanel.setCircle(circleX, circleY, 0, shouldDrawCircle);
                    controller.setCommand(cancelCommand, money, towerArray.getTower(Originalx[index], Originaly[index]));
                    controller.performAction();
                    backgroundPanel.remove(imageEscapeButton[index]);
                    backgroundPanel.remove(imageSellButton[index]);
                    backgroundPanel.remove(imageUpgradeButton[index]);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                }
            });
        }

        frame.setVisible(true);
        start();
        enemy = backgroundPanel.enemyTileManager.getEnemies();
        Towerlist = LightningTowerFactory.getTowerlist();
    }
}
