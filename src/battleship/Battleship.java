package battleship;

class Battleship extends Ship{

    Battleship(){
        length = 4;
        for(int i = 0; i < length; i++){
            hit[i] = false;
        }
    }

    @Override
    String getShipType() {
        return "battleship";
    }
}
