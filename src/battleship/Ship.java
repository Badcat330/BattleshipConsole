package battleship;

import javax.swing.text.Utilities;

abstract class Ship {
    private int bowRow;
    private int bowColumn;
    protected int length;
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
//        if(isSunk())
//            return "x";
//        if(hit[countToStringAscs]){
//            countToStringAscs = ++countToStringAscs % 4;
//            return "s";
//        }
//        return ".";
        return "x";
    }

    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean){
        if(row < 0 || row > 9 || column < 0 || column > 9)
            throw new IndexOutOfBoundsException();
        Integer startI = 0;
        Integer startJ = 0;
        Integer endI = 3;
        Integer endJ = length + 2;

        if((column + length - 1 > 9 && horizontal) || (row + length - 1 > 9 && !horizontal))
            return false;

        if(horizontal){
            if(row == 9)
                endI = 2;

            if(row == 0)
                startI = 1;

            if(column == 0)
                startJ = 1;

            if(column + length - 1 == 9)
                endJ --;
        }
        else {
            endJ = 3;
            endI = length + 2;

            if(column == 9)
                endJ = 2;

            if(column == 0)
                startJ = 1;

            if(row == 0)
                startI = 1;

            if(row + length - 1 == 9)
                endI--;
        }

        for(int i = startI; i < endI; i++){
            for(int j = startJ; j < endJ; j++){
                if(ocean.isOccupied(i + row - 1, j + column - 1))
                    return false;
            }
        }

        return true;
    }

    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean){
        if(row < 0 || row > 9 || column < 0 || column > 9)
            throw new IndexOutOfBoundsException();
        bowRow = row;
        bowColumn = column;
        this.horizontal = horizontal;
        if(horizontal){
            for(int i = 0; i< length; i++){
                ocean.getShips()[row][column + i] = this;
            }
        }
        else {
            for(int i = 0; i< length; i++){
                ocean.getShips()[row + i][column] = this;
            }
        }
    }

    //TODO Check this func
    boolean shootAt(int row, int column){
        if(row < 0 || row > 9 || column < 0 || column > 9)
            throw new IndexOutOfBoundsException();
        if(horizontal && row == bowRow && column >= bowColumn
           && column <= bowColumn + length - 1 && !hit[row - bowRow]){
            hit[row - bowRow] = true;
            return true;
        }
        else
            return column == bowColumn && row >= bowRow && row <= bowRow + length - 1 && !hit[column - bowColumn];
    }

    boolean isSunk(){
        boolean hitFlag = false;
        for (int i = 0; i < length; i++){
            hitFlag &= hit[i];
        }
        return hitFlag;
    }
}
