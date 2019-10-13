package battleship;

class Cruiser extends Ship {

    Cruiser(){
        length = 3;
        for(int i = 0; i < length; i++){
            hit[i] = false;
        }
    }

    @Override
    String getShipType() {
        return "cruiser";
    }
}
