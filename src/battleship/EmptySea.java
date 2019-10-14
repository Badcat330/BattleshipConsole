package battleship;

/**
 * A {@code EmptySea} object represent a battle ship
 * and extends {@code Ship}. We need it because it help us
 * represent ocean and implement some methods.
 */
class EmptySea extends Ship{

    /**
     * Construct an object {@code EmptySea},
     * has no parameters.
     */
    EmptySea()
    {
        length = 1;
    }

    /**
     * Override method isSunk because we need to change
     * its logic for this class
     * @return always false because EmptySea can't be sunk
     */
    @Override
    boolean isSunk(){
        return false;
    }

    /**
     * Override method shootAt, point cell where we shooted
     * @param row number of row we want to shoot
     * @param column number of column we want to shoot
     * @return always false, it help us understand that we miss
     * @throws IndexOutOfBoundsException
     */
    @Override
    boolean shootAt(int row, int column){
        if(row < 0 || row > 9 || column < 0 || column > 9)
            throw new IndexOutOfBoundsException();
        hit[0] = true;
        return  false;
    }

    /**
     * Override toString fot EmptySea
     * @return "-" if cell has been shooted yet,
     * "." if cell has'n beem shooted yet
     */
    @Override
    public String toString(){
        if(hit[0])
            return "-";
        return ".";
    }

}
