package battleship;

class Destroyer extends Ship {

    Destroyer() {
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
