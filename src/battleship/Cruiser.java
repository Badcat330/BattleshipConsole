package battleship;

public class Cruiser extends Ship {

    public Cruiser(){
        lenght = 3;
        for(int i = 0; i < lenght; i++){
            hit[i] = false;
        }
    }

    @Override
    String getShipType() {
        return "cruiser";
    }
}
