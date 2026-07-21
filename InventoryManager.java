import java.util.Scanner;

/**
 * InventoryManager manages and changes a store's inventory within 3 parallel arrays
 * 
 * <p> 
 * Prints a menu displaying 3 options (view inventory, restock item & exit program).
 * Handles erroneous user input so that the scanner object always takes correct datatype, 
 * and correct values if inputed value is outside of array range
 * 
 * 
 * 
 * @author Jack Grossenbacher
 * @author Daniel Gallegos
 */

public class InventoryManager {

    /**
    * Gets user input, handles erroneous inputs,
    * and calls restockItem & printInventory
    * 
    * @param args Stores command line arguments (not used)
    */
    
    public static void main(String[] args) {
        String[] itemNames = {"Corn", "Beef", "Tomatoes", "Bluberry", "Ham", "Cheese", "Turkey", "Radish", "Broccoli", "Grapes"};
        double[] itemPrices = {2.50, 3.75, 0.45, 0.12, 2.0, 1.43, 3.21, 0.76, 0.34, 0.09};
        int[] itemStocks = {15, 30, 21, 78, 321, 90, 532, 82, 29, 80};


        System.out.println("\nWelcome to the Inventory Manager!");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Please make a selection: ");
                System.out.print("1 to view inventory, 2 to restock an item, 3 to exit: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("\nInvalid selection, please enter 1, 2, or 3: ");
                    scanner.nextLine();
                }
                int selection = scanner.nextInt();
                switch (selection) {
                    case 1 -> printInventory(itemNames, itemPrices, itemStocks);
                    case 2 -> {
                        System.out.print("Which item are you restocking?: ");
                        scanner.nextLine();
                        while (scanner.hasNextInt() || scanner.hasNextDouble()) {
                            System.out.print("\nInvalid input. Enter the name of the item you are restocking: ");
                            scanner.nextLine();
                        }
                        String itemToRestock = scanner.nextLine();
                        System.out.print("How many of that item are you restocking?: ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("\nInvalid selection. Please enter a whole number: ");
                            scanner.nextLine();
                        }
                        int numToRestock = scanner.nextInt();
                        restockItem(itemNames, itemStocks, itemToRestock, numToRestock);
                    }
                    case 3 -> {
                        System.out.println("Program exiting. Goodbye.\n");
                        return;
                    }
                    default -> {
                        System.out.println("Invalid Selection. Please try again.\n");
                    }
                }
            }
        }

    }

    /**
    * Prints the name, price, and stocks of each item in the arrays
    * 
    * @param names  An array containing each items names
    * @param prices An array containing each items price
    * @param stocks An array containing each items current stocks
    */

    
    public static void printInventory(String[] names, double[] prices, int[] stocks) {
        for (int i = 0; i < 10; i++) {
            if (names[i] == null || prices[i] == 0) {
                System.out.print("");
            }
            else {
            System.out.println("#####################");
            System.out.println("Item Name: " + names[i]);
            System.out.println("Item Price: " + prices[i]);
            System.out.println("Item Stock: " + stocks[i]);
            }
            if (i == 9) {
                System.out.println("#####################");
            }
        }
    }

    /**
    * Finds item at target index, and increases item stock by amount
    * 
    * @param names  An array containing each items names
    * @param stocks An array containing each items current stocks
    * @param target A string representing the item to be restocked
    * @param amount An integer representing the num of items to restock
    */
 
    public static void restockItem(String[] names, int[] stocks, String target, int amount) {
        boolean isFound = false;
        for (int i = 0; i < 10; i++) {
            if (names[i] != null && names[i].equals(target)) {
                stocks[i] = stocks[i] + amount;
                isFound = true;
            }
        }

        if (isFound == false) {
                System.out.println("Item not found");
            }
    }
}