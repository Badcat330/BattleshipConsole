package battleship;

/**
 * A {@code Submarine} object represent a battle ship
 * and extends {@code Ship}.
 */
class Submarine extends Ship {

    /**
     * Construct an object {@code Submarine},
     * has no parameters.
     */
    Submarine() {
        length = 1;
        for(int i = 0; i < length; i++){
            hit[i] = false;
        }
    }

    /**
     * Give ship type
     * @return name of type, "submarine"
     */
    @Override
    String getShipType() {
        return "submarine";
    }
}
