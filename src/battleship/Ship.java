package battleship;

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
        if(isSunk())
            return "x";
        if(hit[countToStringAscs]){
            countToStringAscs = ++countToStringAscs % 4;
            return "s";
        }
        return ".";
    }

    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean){
        int startIndexI = 0;
        int startIndexJ = 0;
        int endIndexI = 0;
        if(row < 0 || row > 9 || column < 0 || column > 9)
            throw new IndexOutOfBoundsException();
        if((column + length > 9 && horizontal) || (row + length > 9 && !horizontal))
            return false;
        if(column == 0){
            if(horizontal)
                startIndexJ++;
            else
                startIndexI++;
        }
        if(row == 0){
            if(horizontal)
                startIndexI++;
            else
                startIndexJ++;

        }
        if(row == 9 || column == 9)
            endIndexI--;

        if(horizontal){
            for(int i = startIndexI; i < endIndexI; i++){
                for(int j = startIndexJ; j < length + 1; j++){
                    if(!(ocean.getShips()[i + row - 1][j + column - 1] instanceof EmptySea))
                        return false;
                }
            }
        }
        else{
            for(int i = startIndexI; i < endIndexI; i++){
                for(int j = startIndexJ; j < length + 1; j++){
                    if(!(ocean.getShips()[j + row - 1][i + column - 1] instanceof EmptySea))
                        return false;
                }
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

    boolean shootAt(int row, int column){
        if(row < 0 || row > 9 || column < 0 || column > 9)
            throw new IndexOutOfBoundsException();
        if(horizontal)
            return row == bowRow && column >= bowColumn && column <= bowColumn + length - 1 && !hit[row - bowRow];
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
