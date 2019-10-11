package battleship;

import java.lang.reflect.Array;

public  abstract class Ship {
    private int bowRow;
    private int bowColumn;
    private int lenght;
    private boolean horizontal;
    private boolean[] hit = new boolean[4];

    public int getBowRow() {
        return bowRow;
    }

    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    public int getBowColumn() {
        return bowColumn;
    }

    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    abstract String getShipType();

    abstract boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean);

    abstract void placeShipAt(int row, int column, boolean horizontal, Ocean ocean);

    boolean shootAt(int row, int column){
        if(row < 0 || row > 9 || column < 0 || column > 9)
            throw new IndexOutOfBoundsException();
        if(horizontal)
            return row == bowRow && column >= bowColumn && column <= bowColumn + lenght - 1 && !hit[row - bowRow];
        else
            return column == bowColumn && row >= bowRow && row <= bowRow + lenght - 1 && !hit[column - bowColumn];
    }

    boolean isSunk(){
        boolean hitFlag = false;
        for (int i = 0; i < lenght; i++){
            hitFlag &= hit[i];
        }
        return hitFlag;
    }
}
