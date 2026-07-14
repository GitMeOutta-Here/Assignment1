import java.util.Scanner;

public class InventoryManager {

    /**
    * Gets user input, handles erroneous inputs,
    * and calls restockItem & printInventory
    * 
    * @param args Stores command line inputs at runtime
    * @return Returns nothing since method is void
    */
    
    public static void main(String[] args) {
        String[] itemNames = new String[10];
        double[] itemPrices = new double[10];
        int[] itemStocks = new int[10];


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
    * @param names  The name of each item.
    * @param prices The price of each item
    * @param stocks The amouunt of each item
    * @return Returns nothing since method is void
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
    * Increases the stock of a selected item
    * 
    * @param names  The name of each item.
    * @param stocks The amouunt of each item
    * @param target The target item to restock
    * @param amount The amount of items that will be restocked
    * @return Returns nothing since method is void
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

