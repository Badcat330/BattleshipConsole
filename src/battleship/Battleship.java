package battleship;

/**
 * A {@code Battleship} object represent a battle ship
 * and extends {@code Ship}.
 */
class Battleship extends Ship{

    /**
     * Construct an object {@code BattleShip},
     * has no parameters.
     */
    Battleship(){
        length = 4;
        for(int i = 0; i < length; i++){
            hit[i] = false;
        }
    }

    /**
     * Give ship type
     * @return name of type, "battleship"
     */
    @Override
    String getShipType() {
        return "battleship";
    }
}
