package testing;
import java.util.Scanner;


public class myMain {
    public static void main(String[] args) {
        System.out.println("=== WAREHOUSE OPERATIONS CONSOLE ===");
        System.out.println("1. Register new item");
        System.out.println("Log Stock Transaction (Restock/Dispense)");
        System.out.println("3. View inventory status");
        System.out.println("4. Critical Stock Alert (< 5 units)");
        System.out.println("5. Exit");

        Scanner in = new Scanner(System.in);

        
        in.close();
    }
}
