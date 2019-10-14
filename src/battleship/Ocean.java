package battleship;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

/**
 * A {@code Ocean}  represent ocean, it has array of ships
 * and methods that use it for containing different types of ship
 * and use them for playing game
 */
class Ocean{
    private Ship[][] ships = new Ship[10][10];
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    /**
     * Construct an object {@code Ocean},
     * has no parameters.
     */
    Ocean(){
       for(int i = 0; i < 10; i++){
           for (int j = 0; j < 10; j++){
               ships[i][j] = new EmptySea();
           }
       }
       shotsFired = 0;
       hitCount = 0;
       shipsSunk = 0;
    }

    /**
     * Method place all ships randomly considering
     * rules of the game battleship
     */
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

    /**
     * Put the ship in the ocean considering game rules
     * @param ship that you want to put
     */
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

    /**
     * Check if place is occupied by real ship or not
     * @param row number of row
     * @param column number of column
     * @return boolean value if cell is occupied
     * @throws IndexOutOfBoundsException
     */
    boolean isOccupied(int row, int column){
        if(row < 0 || row > 9 || column < 0 || column > 9)
            throw new IndexOutOfBoundsException();
        return ! (ships[row][column] instanceof EmptySea);
    }

    /**
     * Method shoot at cell we chose
     * @param row number of row
     * @param column number of column
     * @return if we was successful
     * @throws IndexOutOfBoundsException
     */
    boolean shootAt(int row, int column){
        if(row < 0 || row > 9 || column < 0 || column > 9)
            throw new IndexOutOfBoundsException();
        shotsFired++;
        if(isOccupied(row, column) || !ships[row][column].isSunk()){
            hitCount++;
            boolean flag = ships[row][column].shootAt(row, column);
            if(ships[row][column].isSunk()){
                System.out.println("You just sank a " + ships[row][column].getShipType() + ".");
                shipsSunk++;
            }
            return flag;
        }
        return false;
    }

    /**
     * Getter
     * @return number of shots fired
     */
    int getShotsFired() {
        return shotsFired;
    }

    /**
     * Getter
     * @return hit count
     */
    int getHitCount() {
        return hitCount;
    }

    /**
     * Getter
     * @return number of ships sunk
     */
    int getShipsSunk() {
        return shipsSunk;
    }

    /**
     * Check if game is over
     * @return boolean value if game is over
     */
    boolean isGameOver(){
        return shipsSunk == 10;
    }

    /**
     * Getter
     * @return arr of ships
     */
    Ship[][] getShips() {
        return ships;
    }

    /**
     * print our ocean and numbers of rows and columns
     */
    void print(){
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < 10; i++){
            System.out.print(i);
            for (int j = 0; j < 10; j++){
                    System.out.print(' ' + ships[i][j].toString());
            }
            System.out.println();
        }
    }
}
