package battleship;

public class Submarine extends Ship {

    public Submarine() {
        lenght = 1;
        for(int i = 0; i < lenght; i++){
            hit[i] = false;
        }
    }

    @Override
    String getShipType() {
        return "submarine";
    }
}
