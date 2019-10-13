package battleship;

import java.util.Scanner;

public class BattleshipGame {

    public static String game(){
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        Scanner scanner = new Scanner(System.in);
        do{
            ocean.print();
            try{
                ocean.shootAt(scanner.nextInt(), scanner.nextInt());
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Enter the coordinates in the range 0 - 9");
            }
        }while(ocean.isGameOver());
        System.out.println("Game is over! I've done " + ocean.getShotsFired() + " shoots.");
        System.out.println("If you want to finish game print exit.");
        return scanner.next();
    }

    public static void main(String[] args){
        System.out.println("\nYou are welcome to play Battleship game! \n" +
                "Write coordinate you want to shoot and sulk all ships\n" +
                " \t Enjoy the game!\n");

    }
}
