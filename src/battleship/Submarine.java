package battleship;

public class Submarine extends Ship {

    public Submarine() {
        length = 1;
        for(int i = 0; i < length; i++){
            hit[i] = false;
        }
    }

    @Override
    String getShipType() {
        return "submarine";
    }
}
