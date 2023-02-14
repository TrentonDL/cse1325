import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    public static void main(String[] args) {
        products.add(new Taxfree("Milk", 4.43));
        products.add(new Taxed("Vanilla Ice Cream", 7.98));
        products.add(new Taxfree("Eggs", 4.25));
        products.add(new Taxfree("Water", 3.48));
        products.add(new Taxed("Dr.Pepper", 6.48));
        products.add(new Taxed("Laundry Detergent", 27.24));
        try{
            Scanner input = new Scanner(System.in);
            int choice = 0;

            do{
                System.out.println("=".repeat(24));
                System.out.println("  Welcome to the Store  ");
                System.out.println("=".repeat(24) + "\n");
                int i = 0;
                for (Product p : products) {
                    System.out.printf("%d) ", i++);
                    System.out.println(p);
                }
                double total = 0;
                System.out.println("\nCurrent Order");
                System.out.println("-".repeat(13) + "\n");
                for(Product c: shoppingCart){
                    System.out.println(c);
                    total += c.price(c.cost);
                }
                System.out.printf("Total Cost: $ %.2f%n", total);
                System.out.println("Buy which product?");

                choice = input.nextInt();

                if(choice >= 0){
                    shoppingCart.add(products.get(choice));
                }
            }while(choice >= 0);
            input.close();

        } catch(IllegalArgumentException i){
            System.err.println(i.getMessage() + "\n Order Canceled\n");
            System.exit(-1);
        }
    }

    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Product> shoppingCart = new ArrayList<>();
}
