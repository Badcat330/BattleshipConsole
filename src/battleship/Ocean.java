package battleship;

import java.util.Arrays;
import java.util.Random;

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

    void placeAllShipsRandomly(){
        Ship battleship = new Battleship();
        PutShip(battleship);
        for(int i = 0; i<2; i++){
            Ship cruiser = new Cruiser();
            PutShip(cruiser);
        }
        for(int i = 0; i<3; i++){
            Ship destroyer = new Destroyer();
            PutShip(destroyer);
        }
        for(int i = 0; i<4; i++){
            Ship submarine = new Submarine();
            PutShip(submarine);
        }
    }

    private void PutShip(Ship ship){
        Random random = new Random();
        int row;
        int column;
        boolean horizontal;
        do{
            row = random.nextInt(10);
            column = random.nextInt(10);
            horizontal = random.nextBoolean();
        }while(!ship.okToPlaceShipAt(row, column, horizontal, this));
        ship.placeShipAt(row, column, horizontal, this);
    }

    boolean isOccupied(int row, int column){
        if(row < 0 || row > 9 || column < 0 || column > 9)
            throw new IndexOutOfBoundsException();
        return ! (ships[row][column] instanceof EmptySea);
    }

    boolean shootAt(int row, int column){
        if(row < 0 || row > 9 || column < 0 || column > 9)
            throw new IndexOutOfBoundsException();
        shotsFired++;
        if(! (isOccupied(row, column) || ships[row][column].isSunk())){
            hitCount++;
            ships[row][column].shootAt(row, column);
            if(ships[row][column].isSunk())
                System.out.println("You just sank a " + ships[row][column].getShipType() + ".");
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
        for (int i = 0; i < 9; i++){
            System.out.print(" " + (i + 1) + " ");
            for (int j = 0; j < 9; j++){
                    System.out.print(' ' + ships[i][j].toString());
            }
            System.out.println();
        }
    }
}
