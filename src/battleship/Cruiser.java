package battleship;

/**
 * A {@code Cruiser} object represent a battle ship
 * and extends {@code Ship}.
 */
class Cruiser extends Ship {

    /**
     * Construct an object {@code Cruiser},
     * has no parameters.
     */
    Cruiser(){
        length = 3;
        for(int i = 0; i < length; i++){
            hit[i] = false;
        }
    }

    /**
     * Give ship type
     * @return name of type, "cruiser"
     */
    @Override
    String getShipType() {
        return "cruiser";
    }
}
