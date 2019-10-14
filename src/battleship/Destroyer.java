package battleship;

/**
 * A {@code Destroyer} object represent a battle ship
 * and extends {@code Ship}.
 */
class Destroyer extends Ship {

    /**
     * Construct an object {@code Destroyer},
     * has no parameters.
     */
    Destroyer() {
        length = 2;
        for(int i = 0; i < length; i++){
            hit[i] = false;
        }
    }

    /**
     * Give ship type
     * @return name of type, "destroyer"
     */
    @Override
    String getShipType() {
        return "destroyer";
    }
}
