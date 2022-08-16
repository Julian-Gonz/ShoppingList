
package controller;
import domain.ItemToPurchase;
import domain.ShoppingCart;
import java.util.Scanner;

public class ShoppingCartManager {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String customerName;
        String todaysDate;
        char menuChoice = ' ';

        System.out.println("Enter Customer's Name:");
        customerName = scnr.nextLine();

        System.out.println("Enter Today's Date:");
        todaysDate = scnr.nextLine();

        System.out.println("\nCustomer Name: " + customerName);
        System.out.println("Today's Date: " + todaysDate);
        System.out.println();

        ShoppingCart myCart = new ShoppingCart(customerName, todaysDate);   //Creates shopping cart

        printMenu();

        while(menuChoice != 'q') {  //Executes menu when menuChoice not equal to q
            System.out.println("Choose an option:");
            menuChoice = scnr.next().charAt(0);
            executeMenu(menuChoice, myCart, scnr);
            printMenu();
        }
        System.out.println("Thanks for shopping with us.  Please come again.");
    }

    public static void printMenu() {
        System.out.println("MENU");
        System.out.println("a - Add item to cart");
        System.out.println("d - Remove item from cart");
        System.out.println("c - Change item quantity");
        System.out.println("i - Output items' descriptions");
        System.out.println("o - Output shopping cart");
        System.out.println( "q - Quit");
        System.out.println();
    }

    public static void executeMenu(char option, ShoppingCart theCart, Scanner scnr) {
        String productName;
        String productDescription;
        double productPrice;
        int productQuantity;

        switch (option) {   //Executes the order depending on letter inputted
            case 'a':   //Adds item to cart
                scnr.nextLine();
                System.out.println("ADD ITEM TO CART");
                System.out.println("Enter the item name:");
                productName = scnr.nextLine();

                System.out.println("Enter the item description:");
                productDescription = scnr.nextLine();

                System.out.println("Enter the item price:");
                productPrice= scnr.nextDouble();

                System.out.println("Enter the item quantity:");
                productQuantity = scnr.nextInt();

                ItemToPurchase newItem = new ItemToPurchase(productName, productPrice,
                                        productQuantity, productDescription);    //Creates item to cart
                theCart.addItem(newItem);   //Adds item to cart

                System.out.println();
                break;

            case 'd':   //Deletes item from cart
                scnr.nextLine();

                System.out.println("REMOVE ITEM FROM CART");
                System.out.println("Enter name of item to remove:");
                productName = scnr.nextLine();

                theCart.removeItem(productName);    //Removes item from cart
                System.out.println();
                break;

            case 'c':   //Changes the item quantity
                scnr.nextLine();

                System.out.println("CHANGE ITEM QUANTITY");
                System.out.println("Enter the item name:");
                productName = scnr.nextLine();

                System.out.println("Enter the new quantity:");
                productQuantity = scnr.nextInt();

                ItemToPurchase modItem = new ItemToPurchase();  //Creates a modded item
                modItem.setItemName(productName);
                modItem.setItemQuantity(productQuantity);

                theCart.modifyItem(modItem);    //Mods item quantity
                System.out.println();
                break;

            case 'i':   //Outputs the descriptions of items
                System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
                theCart.printDescriptions();
                System.out.println();
                break;

            case 'o':   //Output of total for shopping cart
                System.out.println("OUTPUT SHOPPING CART");
                theCart.printTotal();
                System.out.println();
                break;
        }

    }



}