package battleship;

import java.lang.reflect.Array;

abstract class Ship {
    private int bowRow;
    private int bowColumn;
    protected int lenght;
    private boolean horizontal;
    protected boolean[] hit = new boolean[4];
    int countToStringAscs = 0;

    int getBowRow() {
        return bowRow;
    }

    void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    int getBowColumn() {
        return bowColumn;
    }

    void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    boolean isHorizontal() {
        return horizontal;
    }

    void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    String getShipType(){
        return "";
    }

    @Override
    public String toString(){
        if(isSunk())
            return "x";
        if(hit[countToStringAscs]){
            countToStringAscs = ++countToStringAscs % 4;
            return "s";
        }
        return ".";
    }

    //TODO abstract boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean);

    //TODO abstract void placeShipAt(int row, int column, boolean horizontal, Ocean ocean);

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
