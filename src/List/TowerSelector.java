package List;
import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;



public class TowerSelector {
    final int AddCancelButW = 50;
    final int AddCancelButH = 50;
    final int Originalx1 = 300, Originalx1Center = Originalx1+AddCancelButW/2;
    final int Originaly1 = 280;
    public void Background(){

        JFrame frame = new JFrame("關卡一");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        BackgroundPanel backgroundPanel = new BackgroundPanel("./pic_src/TowerDefenceGame_Map.jpg");
        backgroundPanel.setLayout(null);
        frame.setContentPane(backgroundPanel);

        int x = Originalx1, y = Originaly1;
        //+號按鈕
        JButton imageaddButton = addcanceljButton("./pic_src/button/Add.png",x,y);
        //-號按鈕
        JButton imagecancelButton = addcanceljButton("./pic_src/button/Cancel.png",x,y);
        //箭塔選項
        JButton imagearcherchooseButton = getTowerChoosejButton("./pic_src/ArcherTower.png",x,y, 0);
        //雷電塔選項
        JButton imagelightningchooseButton = getTowerChoosejButton("./pic_src/LightningTower.png",x,y,1);
        //可樂塔選項
        JButton imagecolachooseButton = getTowerChoosejButton("./pic_src/ColaTower.png",x,y,2);
        //箭塔生成
        JButton imagearcherButton = getTowerjButton("./pic_src/ArcherTower.png",x,y);
        //雷電塔生成
        JButton imagelightningButton = getTowerjButton("./pic_src/LightningTower.png",x,y);
        //可樂塔生成
        JButton imageColaButton = getTowerjButton("./pic_src/ColaTower.png",x,y);
        //賣出按鈕
        JButton SellButton = sellsecapejButton("./pic_src/button/Gold.png",x,y);
        //取消按鈕
        JButton EscapeButton = sellsecapejButton("./pic_src/button/Escape.png",x,y);

        backgroundPanel.add(imageaddButton);


        imageaddButton.addActionListener(e -> {
            backgroundPanel.remove(imageaddButton);
            backgroundPanel.add(imagearcherchooseButton);
            backgroundPanel.add(imagelightningchooseButton);
            backgroundPanel.add(imagecolachooseButton);
            backgroundPanel.add(imagecancelButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imagecancelButton.addActionListener(e -> {
            backgroundPanel.remove(imagearcherchooseButton);
            backgroundPanel.remove(imagelightningchooseButton);
            backgroundPanel.remove(imagecolachooseButton);
            backgroundPanel.add(imageaddButton);
            backgroundPanel.remove(imagecancelButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imagearcherchooseButton.addActionListener(e -> {
            backgroundPanel.remove(imagearcherchooseButton);
            backgroundPanel.remove(imagelightningchooseButton);
            backgroundPanel.remove(imagecolachooseButton);
            backgroundPanel.add(imagearcherButton);
            imageaddButton.setEnabled(false);

            backgroundPanel.remove(imagecancelButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imagelightningchooseButton.addActionListener(e -> {
            backgroundPanel.remove(imagearcherchooseButton);
            backgroundPanel.remove(imagelightningchooseButton);
            backgroundPanel.remove(imagecolachooseButton);
            backgroundPanel.add(imagelightningButton);
            imageaddButton.setEnabled(false);

            backgroundPanel.remove(imagecancelButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imagecolachooseButton.addActionListener(e -> {
            backgroundPanel.remove(imagearcherchooseButton);
            backgroundPanel.remove(imagelightningchooseButton);
            backgroundPanel.remove(imagecolachooseButton);
            backgroundPanel.add(imageColaButton);
            imageaddButton.setEnabled(false);
            backgroundPanel.remove(imagecancelButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imagearcherButton.addActionListener(e -> {
            backgroundPanel.add(EscapeButton);
            backgroundPanel.add(SellButton);
            imageaddButton.setEnabled(false);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imagelightningButton.addActionListener(e -> {
            backgroundPanel.add(EscapeButton);
            backgroundPanel.add(SellButton);
            imageaddButton.setEnabled(false);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imageColaButton.addActionListener(e -> {
            backgroundPanel.add(EscapeButton);
            backgroundPanel.add(SellButton);
            imageaddButton.setEnabled(false);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        EscapeButton.addActionListener(e -> {
            backgroundPanel.remove(EscapeButton);
            backgroundPanel.remove(SellButton);
            imageaddButton.setEnabled(false);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });


        frame.setVisible(true);
    }
    //創建＋-符號
    private JButton addcanceljButton(String image, int x, int y) {
        ImageIcon imageoptionbut = new ImageIcon(image);
        Image originaloptionbut = imageoptionbut.getImage();
        Image scaledchosenImage = originaloptionbut.getScaledInstance(AddCancelButW, AddCancelButH, Image.SCALE_SMOOTH);
        ImageIcon scaledoptionIcon = new ImageIcon(scaledchosenImage);
        JButton imageoptionButton = new JButton(scaledoptionIcon);
        imageoptionButton.setFocusPainted(false);
        imageoptionButton.setOpaque(false);
        imageoptionButton.setContentAreaFilled(false);
        imageoptionButton.setBorderPainted(false);
        imageoptionButton.setBounds(Originalx1, Originaly1, AddCancelButW, AddCancelButH);
        return imageoptionButton;
    }
    //創建防禦塔選項
    private JButton getTowerChoosejButton(String image, int x, int y, int d) {
        ImageIcon chooseTower = new ImageIcon(image);
        Image originalchooseImage = chooseTower.getImage();
        Image scaledcloseImage = originalchooseImage.getScaledInstance(45, 80, Image.SCALE_SMOOTH);
        ImageIcon scaledcloseIcon = new ImageIcon(scaledcloseImage);
        JButton imageoptionButton = new JButton(scaledcloseIcon);
        imageoptionButton.setBounds((Originalx1Center - 90 + (d * 67)), Originaly1-80, 45, 80);
        imageoptionButton.setFocusPainted(false);
        imageoptionButton.setOpaque(false);
        imageoptionButton.setContentAreaFilled(false);
        imageoptionButton.setBorderPainted(false);
        return imageoptionButton;
    }
    //創建已生成的防禦塔按鈕
    private JButton getTowerjButton(String image, int x, int y) {
        ImageIcon chosenTower = new ImageIcon(image);
        Image originalcloseImage = chosenTower.getImage();
        Image scaledcloseImage = originalcloseImage.getScaledInstance(135, 240, Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledcloseIcon = new ImageIcon(scaledcloseImage);
        JButton imageoptionButton = new JButton(scaledcloseIcon);
        if(image.equals("./pic_src/ArcherTower.png")){
            imageoptionButton.setBounds(Originalx1 - 42, Originaly1 - 160, 135, 240);
        } else if (image.equals("./pic_src/LightningTower.png")) {
            imageoptionButton.setBounds(Originalx1 - 42, Originaly1 - 160, 135, 240);
        } else if (image.equals("./pic_src/ColaTower.png")) {
            imageoptionButton.setBounds(Originalx1 - 42, Originaly1 - 160, 135, 240);
        }
        imageoptionButton.setFocusPainted(false);
        imageoptionButton.setOpaque(false);
        imageoptionButton.setContentAreaFilled(false);
        imageoptionButton.setBorderPainted(false);
        return imageoptionButton;
    }
    private JButton sellsecapejButton(String image, int x, int y) {
        ImageIcon imageoptionbut = new ImageIcon(image);
        Image originaloptionbut = imageoptionbut.getImage();
        Image scaledchosenImage = originaloptionbut.getScaledInstance(AddCancelButW, AddCancelButH, Image.SCALE_SMOOTH);
        ImageIcon scaledoptionIcon = new ImageIcon(scaledchosenImage);
        JButton imageoptionButton = new JButton(scaledoptionIcon);
        if(image.equals("./pic_src/button/Gold.png")){
            imageoptionButton.setBounds(Originalx1 - 35, Originaly1 + 80, 50, 50);
        } else if (image.equals("./pic_src/button/Escape.png")) {
            imageoptionButton.setBounds(Originalx1 + 35, Originaly1 + 80, 50, 50);
        }
        imageoptionButton.setFocusPainted(false);
        imageoptionButton.setOpaque(false);
        imageoptionButton.setContentAreaFilled(false);
        imageoptionButton.setBorderPainted(false);
        return imageoptionButton;
    }


}