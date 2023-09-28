package Project_Shop;

import java.util.Scanner;

public class View {
    private final  Scanner input;
    public View(){
        this.input = new Scanner(System.in);
    }
    public int getIntegerInput(String message){
        System.out.println("-----"+message+"-----");
        return input.nextInt();
    }
    public double getDoubleInput(String message){
        System.out.println("-----"+message+"-----");
        return input.nextDouble();
    }
    public String getTextInput(String message){
        System.out.println("----"+message+"-----");
        return input.next();

    }
    public char getLetterInput(String message){
        System.out.println("-----"+message+"----");
        return input.next().charAt(0);
    }
    public void printMessage(String message){
        System.out.println(message);
    }
    public int printMenu (){
        System.out.println("Press 1 to add item to your cart");
        System.out.println("Press 2 to see all items in the shop");
        System.out.println("Press 3 to remove item from your cart");
        System.out.println("Press 4 to deposit money");
        System.out.println("Press 5 to make a purchase ");
        System.out.println("Press 6 to check your account");
        System.out.println("Press 7 to check your cart");
        System.out.println("Press 8 to Quit");
        return input.nextInt();
    }
}
