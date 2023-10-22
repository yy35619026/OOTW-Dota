package List;
import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;



public class TowerSelector {
    final int AddCancelButW = 50;
    final int AddCancelButH = 50;
    final int Originalx1 = 300;
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
        JButton imageAddButton = addCanceljButton("./pic_src/button/Add.png",x,y);
        //-號按鈕
        JButton imageCancelButton = addCanceljButton("./pic_src/button/Cancel.png",x,y);
        //箭塔選項
        JButton imageArcherChooseButton = getTowerChoosejButton("./pic_src/ArcherTower.png",x,y, 0);
        //雷電塔選項
        JButton imageLightningChooseButton = getTowerChoosejButton("./pic_src/LightningTower.png",x,y,1);
        //可樂塔選項
        JButton imageColaChooseButton = getTowerChoosejButton("./pic_src/ColaTower.png",x,y,2);
        //箭塔生成
        JButton imageArcherButton = getTowerjButton("./pic_src/ArcherTower.png",x,y);
        //雷電塔生成
        JButton imageLightningButton = getTowerjButton("./pic_src/LightningTower.png",x,y);
        //可樂塔生成
        JButton imageColaButton = getTowerjButton("./pic_src/ColaTower.png",x,y);
        //賣出按鈕
        JButton imageSellButton = getSellEscapejButton("./pic_src/button/Gold.png",x,y);
        //取消按鈕
        JButton imageEscapeButton = getSellEscapejButton("./pic_src/button/Escape.png",x,y);

        backgroundPanel.add(imageAddButton);


        imageAddButton.addActionListener(e -> {
            backgroundPanel.remove(imageAddButton);
            backgroundPanel.add(imageArcherChooseButton);
            backgroundPanel.add(imageLightningChooseButton);
            backgroundPanel.add(imageColaChooseButton);
            backgroundPanel.add(imageCancelButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imageCancelButton.addActionListener(e -> {
            backgroundPanel.remove(imageArcherChooseButton);
            backgroundPanel.remove(imageLightningChooseButton);
            backgroundPanel.remove(imageColaChooseButton);
            backgroundPanel.add(imageAddButton);
            backgroundPanel.remove(imageCancelButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imageArcherChooseButton.addActionListener(e -> {
            backgroundPanel.remove(imageArcherChooseButton);
            backgroundPanel.remove(imageLightningChooseButton);
            backgroundPanel.remove(imageColaChooseButton);
            backgroundPanel.add(imageArcherButton);
            backgroundPanel.remove(imageCancelButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imageLightningChooseButton.addActionListener(e -> {
            backgroundPanel.remove(imageArcherChooseButton);
            backgroundPanel.remove(imageLightningChooseButton);
            backgroundPanel.remove(imageColaChooseButton);
            backgroundPanel.add(imageLightningButton);
            backgroundPanel.remove(imageCancelButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imageColaChooseButton.addActionListener(e -> {
            backgroundPanel.remove(imageArcherChooseButton);
            backgroundPanel.remove(imageLightningChooseButton);
            backgroundPanel.remove(imageColaChooseButton);
            backgroundPanel.add(imageColaButton);
            backgroundPanel.remove(imageCancelButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imageArcherButton.addActionListener(e -> {
            backgroundPanel.add(imageEscapeButton);
            backgroundPanel.add(imageSellButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imageLightningButton.addActionListener(e -> {
            backgroundPanel.add(imageEscapeButton);
            backgroundPanel.add(imageSellButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imageColaButton.addActionListener(e -> {
            backgroundPanel.add(imageEscapeButton);
            backgroundPanel.add(imageSellButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imageEscapeButton.addActionListener(e -> {
            backgroundPanel.remove(imageEscapeButton);
            backgroundPanel.remove(imageSellButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });

        imageSellButton.addActionListener(e -> {
            backgroundPanel.remove(imageEscapeButton);
            backgroundPanel.remove(imageSellButton);
            backgroundPanel.remove(imageColaButton);
            backgroundPanel.remove(imageArcherButton);
            backgroundPanel.remove(imageLightningButton);
            backgroundPanel.add(imageAddButton);
            backgroundPanel.revalidate();
            backgroundPanel.repaint();
        });



        frame.setVisible(true);
    }
    //創建＋-符號
    private JButton addCanceljButton(String image, int x, int y) {
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
        imageoptionButton.setBounds(x + 25 - 90 + d * 67, y - 80, 45, 80);
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
            imageoptionButton.setBounds(x - 42, y - 160, 135, 240);
        } else if (image.equals("./pic_src/LightningTower.png")) {
            imageoptionButton.setBounds(x - 42, y - 160, 135, 240);
        } else if (image.equals("./pic_src/ColaTower.png")) {
            imageoptionButton.setBounds(x - 42, y - 160, 135, 240);
        }
        imageoptionButton.setFocusPainted(false);
        imageoptionButton.setOpaque(false);
        imageoptionButton.setContentAreaFilled(false);
        imageoptionButton.setBorderPainted(false);
        return imageoptionButton;
    }
    private JButton getSellEscapejButton(String image, int x, int y) {
        ImageIcon imageoptionbut = new ImageIcon(image);
        Image originaloptionbut = imageoptionbut.getImage();
        Image scaledchosenImage = originaloptionbut.getScaledInstance(AddCancelButW, AddCancelButH, Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledoptionIcon = new ImageIcon(scaledchosenImage);
        JButton imageoptionButton = new JButton(scaledoptionIcon);
        if(image.equals("./pic_src/button/Gold.png")){
            imageoptionButton.setBounds(x - 35, y + 80, 50, 50);
        } else if (image.equals("./pic_src/button/Escape.png")) {
            imageoptionButton.setBounds(x + 35, y + 80, 50, 50);
        }
        imageoptionButton.setFocusPainted(false);
        imageoptionButton.setOpaque(false);
        imageoptionButton.setContentAreaFilled(false);
        imageoptionButton.setBorderPainted(false);
        return imageoptionButton;
    }


}