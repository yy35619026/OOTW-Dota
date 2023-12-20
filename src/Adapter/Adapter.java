package Adapter;
import Tower.*;
public class Adapter extends Target{
    double money;
    private Tower ArcherTower = new ArcherTowerFactory().createTower();
    private Tower FlameTower = new FlameTowerFactory().createTower();
    private Tower LightningTower = new LightningTowerFactory().createTower();

    @Override
    public void lvlup(double money, Tower tower){
        if (tower instanceof ArcherTower && money >= 20) {
            System.out.println("ArcherTower lvlup!");
            money -= 20;
        }else if(tower instanceof LightningTower && money >= 40) {
            System.out.println("LightningTower lvlup!");
            money -= 40;
        } else if(tower instanceof FlameTower && money >= 60) {
            System.out.println("FlameTower lvlup!");
            money -= 60;
        }
        this.money = money;
    }
    public double getMoney(){
        return money;
    }
}
