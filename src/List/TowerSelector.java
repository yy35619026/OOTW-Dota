package List;
import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;



public class TowerSelector {
    final int AddCancelButW = 50;
    final int AddCancelButH = 50;
    final int Originalx1 = 300, Originalx1Center = Originalx1+AddCancelButW/2;
    final int Originalx2 = 500, Originalx2Center = Originalx2+AddCancelButW/2;

    final int Originaly1 = 280;
    final int Originaly2 = 280;
    public void Background(){



        JFrame frame = new JFrame("關卡一");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        BackgroundPanel backgroundPanel = new BackgroundPanel("./pic_src/TowerDefenceGame_Map.jpg");
        backgroundPanel.setLayout(null);
        frame.setContentPane(backgroundPanel);




        //+號按鈕
        JButton imageaddButton1 = addcanceljButton("./pic_src/button/Add.png");
        imageaddButton1.setFocusPainted(false);
        imageaddButton1.setOpaque(false);
        imageaddButton1.setContentAreaFilled(false);
        imageaddButton1.setBorderPainted(false);

        //-號按鈕
        JButton imagecancelButton = addcanceljButton("./pic_src/button/Cancel.png");
        imagecancelButton.setFocusPainted(false);
        imagecancelButton.setOpaque(false);
        imagecancelButton.setContentAreaFilled(false);
        imagecancelButton.setBorderPainted(false);
        //箭塔選項
        JButton imagearcherchooseButton = getTowerChoosejButton("./pic_src/ArcherTower.png", 0);
        imagecancelButton.setFocusPainted(false);
        imagearcherchooseButton.setOpaque(false);
        imagearcherchooseButton.setContentAreaFilled(false);
        imagearcherchooseButton.setBorderPainted(false);
        //雷電塔選項
        JButton imagelightningchooseButton = getTowerChoosejButton("./pic_src/LightningTower.png",1);
        imagecancelButton.setFocusPainted(false);
        imagelightningchooseButton.setOpaque(false);
        imagelightningchooseButton.setContentAreaFilled(false);
        imagelightningchooseButton.setBorderPainted(false);
        //可樂塔選項
        JButton imagecolachooseButton = getTowerChoosejButton("./pic_src/ColaTower.png",2);
        imagecancelButton.setFocusPainted(false);
        imagecolachooseButton.setOpaque(false);
        imagecolachooseButton.setContentAreaFilled(false);
        imagecolachooseButton.setBorderPainted(false);
        //箭塔生成
        JButton imagearcherButton = getTowerjButton("./pic_src/ArcherTower.png");
        imagecancelButton.setFocusPainted(false);
        imagearcherButton.setOpaque(false);
        imagearcherButton.setContentAreaFilled(false);
        imagearcherButton.setBorderPainted(false);
        //雷電塔生成
        JButton imagelightningButton = getTowerjButton("./pic_src/LightningTower.png");
        imagecancelButton.setFocusPainted(false);
        imagelightningButton.setOpaque(false);
        imagelightningButton.setContentAreaFilled(false);
        imagelightningButton.setBorderPainted(false);
        //可樂塔生成
        imagecancelButton.setFocusPainted(false);
        JButton imageColaButton = getTowerjButton("./pic_src/ColaTower.png");
        imageColaButton.setOpaque(false);
        imageColaButton.setContentAreaFilled(false);
        imageColaButton.setBorderPainted(false);

        //賣出按鈕
        JButton SellButton = sellsecapejButton("./pic_src/button/Gold.png");
        SellButton.setOpaque(false);
        SellButton.setContentAreaFilled(false);
        SellButton.setBorderPainted(false);
        //取消按鈕
        JButton EscapeButton = sellsecapejButton("./pic_src/button/Escape.png");
        EscapeButton.setOpaque(false);
        EscapeButton.setContentAreaFilled(false);
        EscapeButton.setBorderPainted(false);




        backgroundPanel.add(imageaddButton1);


        imageaddButton1.addActionListener(e -> {
            backgroundPanel.remove(imageaddButton1);
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
            backgroundPanel.add(imageaddButton1);
            backgroundPanel.remove(imagecancelButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imagearcherchooseButton.addActionListener(e -> {
            backgroundPanel.remove(imagearcherchooseButton);
            backgroundPanel.remove(imagelightningchooseButton);
            backgroundPanel.remove(imagecolachooseButton);
            backgroundPanel.add(imagearcherButton);
            imageaddButton1.setEnabled(false);

            backgroundPanel.remove(imagecancelButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imagelightningchooseButton.addActionListener(e -> {
            backgroundPanel.remove(imagearcherchooseButton);
            backgroundPanel.remove(imagelightningchooseButton);
            backgroundPanel.remove(imagecolachooseButton);
            backgroundPanel.add(imagelightningButton);
            imageaddButton1.setEnabled(false);

            backgroundPanel.remove(imagecancelButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imagecolachooseButton.addActionListener(e -> {
            backgroundPanel.remove(imagearcherchooseButton);
            backgroundPanel.remove(imagelightningchooseButton);
            backgroundPanel.remove(imagecolachooseButton);
            backgroundPanel.add(imageColaButton);
            imageaddButton1.setEnabled(false);
            backgroundPanel.remove(imagecancelButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imagearcherButton.addActionListener(e -> {
            backgroundPanel.add(EscapeButton);
            backgroundPanel.add(SellButton);
            imageaddButton1.setEnabled(false);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imagelightningButton.addActionListener(e -> {
            backgroundPanel.add(EscapeButton);
            backgroundPanel.add(SellButton);
            imageaddButton1.setEnabled(false);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imageColaButton.addActionListener(e -> {
            backgroundPanel.add(EscapeButton);
            backgroundPanel.add(SellButton);
            imageaddButton1.setEnabled(false);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        EscapeButton.addActionListener(e -> {
            backgroundPanel.remove(EscapeButton);
            backgroundPanel.remove(SellButton);
            imageaddButton1.setEnabled(false);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });


        frame.setVisible(true);
    }
    //創建＋-符號
    private JButton addcanceljButton(String image) {
        ImageIcon imageoptionbut = new ImageIcon(image);
        Image originaloptionbut = imageoptionbut.getImage();
        Image scaledchosenImage = originaloptionbut.getScaledInstance(AddCancelButW, AddCancelButH, Image.SCALE_SMOOTH);
        ImageIcon scaledoptionIcon = new ImageIcon(scaledchosenImage);
        JButton imageoptionButton = new JButton(scaledoptionIcon);
        imageoptionButton.setBounds(Originalx1, Originaly1, AddCancelButW, AddCancelButH);
        return imageoptionButton;
    }
    //創建防禦塔選項
    private JButton getTowerChoosejButton(String image, int d) {
        ImageIcon chooseTower = new ImageIcon(image);
        Image originalchooseImage = chooseTower.getImage();
        Image scaledcloseImage = originalchooseImage.getScaledInstance(45, 80, Image.SCALE_SMOOTH);
        ImageIcon scaledcloseIcon = new ImageIcon(scaledcloseImage);
        JButton imageoptionButton = new JButton(scaledcloseIcon);
        imageoptionButton.setBounds((Originalx1Center - 90 + (d * 67)), Originaly1-80, 45, 80);
        return imageoptionButton;
    }
    //創建已生成的防禦塔按鈕
    private JButton getTowerjButton(String image) {
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
        return imageoptionButton;
    }
    private JButton sellsecapejButton(String image) {
        ImageIcon imageoptionbut = new ImageIcon(image);
        Image originaloptionbut = imageoptionbut.getImage();
        Image scaledchosenImage = originaloptionbut.getScaledInstance(AddCancelButW, AddCancelButH, Image.SCALE_SMOOTH);
        ImageIcon scaledoptionIcon = new ImageIcon(scaledchosenImage);
        JButton imageoptionButton = new JButton(scaledoptionIcon);
        if(image.equals("./pic_src/button/Gold.png")){
            imageoptionButton.setBounds(Originalx1 - 35, Originaly1 + 80, 50, 50);
        } else if (image.equals("./pic_src/button/Escape.png")) {
            imageoptionButton.setBounds(Originalx1 + 35, Originaly1 + 80, 50, 50);        return imageoptionButton;
    }
        return imageoptionButton;
}


}
