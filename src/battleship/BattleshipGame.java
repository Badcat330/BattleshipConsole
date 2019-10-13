package battleship;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BattleshipGame {

    private static String game(){
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        do{
            ocean.print();
            try{
                Scanner scanner = new Scanner(System.in);
                int row = scanner.nextInt();
                int column = scanner.nextInt();
                if(ocean.shootAt(row, column))
                    if(ocean.getShips()[row][column].isSunk())
                        System.out.println("Congratulations!");
                    else
                        System.out.println("hit");
                else System.out.println("miss");
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("YOu should enter coordinates in the range 0 - 9");
            }
            catch(InputMismatchException e){
                System.out.println("You should enter two numbers in range 0 - 9");
            }
        }while(!ocean.isGameOver());
        System.out.println("Game is over! I've done " + ocean.getShotsFired() + " shoots.");
        System.out.println("If you want to finish game print exit.");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static void main(String[] args){
        System.out.println("\nYou are welcome to play Battleship game! \n" +
                "Write coordinate you want to shoot and sulk all ships\n" +
                " \t Enjoy the game!\n");
        while(game().equalsIgnoreCase("exit"));

    }
}
