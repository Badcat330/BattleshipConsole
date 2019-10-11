package battleship;

public class Destroyer extends Ship {

    public Destroyer() {
        lenght = 2;
        for(int i = 0; i < lenght; i++){
            hit[i] = false;
        }
    }

    @Override
    String getShipType() {
        return "destroyer";
    }
}
