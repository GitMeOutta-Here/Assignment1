public class InventoryManager {
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

