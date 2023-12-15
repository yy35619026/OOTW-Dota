package Tower;

public class TowerArray {
    public double Towercost;
    public Tower Tower;

    public double getCost(int x, int y){
        for(int i = 0; i < TowerFactory.Towerlist.size(); i++){
            if(TowerFactory.Towerlist.get(i).getX() == x && TowerFactory.Towerlist.get(i).getY() == y){
                Towercost = TowerFactory.Towerlist.get(i).getTower().getCost();
            }
        }
        return Towercost;
    }
    public void removeTower(int x, int y) {
        for(int i = 0; i < TowerFactory.Towerlist.size(); i++){
            if(TowerFactory.Towerlist.get(i).getX() == x && TowerFactory.Towerlist.get(i).getY() == y){
                TowerFactory.Towerlist.remove(i);
            }
        }
    }
    public Tower getTower(int x, int y) {
        for(int i = 0; i < TowerFactory.Towerlist.size(); i++){
            if(TowerFactory.Towerlist.get(i).getX() == x && TowerFactory.Towerlist.get(i).getY() == y){
                Tower = TowerFactory.Towerlist.get(i).getTower();
            }
        }
        return Tower;
    }
}
