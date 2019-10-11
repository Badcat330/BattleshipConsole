package battleship;

public class Destroyer extends Ship {

    public Destroyer() {
        length = 2;
        for(int i = 0; i < length; i++){
            hit[i] = false;
        }
    }

    @Override
    String getShipType() {
        return "destroyer";
    }
}
