package battleship;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class BattleshipGame {

    private static boolean game(){
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        do{
            ocean.print();
            try{
                System.out.print("Row = ");
                Integer row = Reading();
                if(row == null)
                    return false;
                System.out.print("Column = ");
                Integer column = Reading();
                if(column == null)
                    return false;
                if(ocean.shootAt(row, column)){
                    if(ocean.getShips()[row][column].isSunk())
                        System.out.print("Congratulations! ");
                    System.out.println("Hit!");
                }
                else System.out.println("Miss!");
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("You should enter coordinates in the range 0 - 9");
            }
            catch(NumberFormatException e){
                System.out.println("You should enter coordinates in the range 0 - 9");
            }
        }while(!ocean.isGameOver());
        System.out.println("Game is over! I've done " + ocean.getShotsFired() + " shoots.");
        System.out.println("If you want to finish game print exit else print again.");
        Scanner scanner = new Scanner(System.in);
        return !scanner.next().equalsIgnoreCase("exit");
    }

    private static Integer Reading(){
        Integer n = null;
        Scanner scanner = new Scanner(System.in);
        String buf = scanner.next();
        if (buf.equalsIgnoreCase("exit"))
            return null;
        n = Integer.parseInt(buf);
        return n;
    }

    public static void main(String[] args){
        System.out.println("\nYou are welcome to play Battleship game! \n" +
                "Enter first coordinate than second to shoot! If you want\n" +
                "exit game you can write exit at any time! Sulk all ships\n" +
                " \t Enjoy the game!\n");
        try{
            while(game()) ;
        }
        catch(Exception e){
            System.out.println("Something go wrong!" + e.getMessage());
        }
        System.out.println("Thank you for game! By!");
    }
}
