package battleship;

import java.util.Arrays;

class Ocean{
    private Ship[][] ships = new Ship[10][10];
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    public Ocean(){
       for(int i = 0; i < 10; i++){
           for (int j = 0; j < 10; j++){
               ships[i][j] = new EmptySea();
           }
       }
       shotsFired = 0;
       hitCount = 0;
       shipsSunk = 0;
    }

    //TODO void placeAllShipsRandomly()

    boolean isOccupied(int row, int column){
        return ! (ships[row][column] instanceof EmptySea);
    }

    boolean shootAt(int row, int column){
        shotsFired++;
        if(! (ships[row][column] instanceof EmptySea || ships[row][column].isSunk())){
            hitCount++;
            return true;
        }
        return false;
    }

    int getShotsFired() {
        return shotsFired;
    }

    int getHitCount() {
        return hitCount;
    }

    int getShipsSunk() {
        return shipsSunk;
    }

    boolean isGameOver(){
        return shipsSunk == 10;
    }

    Ship[][] getShips() {
        return ships;
    }
    
    void print(){
        System.out.println("0,0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < 10; i++){
            System.out.print(" " + i + 1 + " ");
            for (int j = 0; j < 10; j++){
                    System.out.print(' ' + ships[i][j].toString());
            }
        }
    }
}
