package battleship;

public class Battleship extends Ship{

    public Battleship(){
        lenght = 4;
        for(int i = 0; i < lenght; i++){
            hit[i] = false;
        }
    }

    @Override
    String getShipType() {
        return "battleship";
    }
}
