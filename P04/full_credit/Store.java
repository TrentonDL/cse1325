import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    public static int main(String[] args) {
        products.add(Product("Milk", 4.43));
        products.add(Product("Dr.Pepper", 6.48));
        products.add(Product("Eggs", 4.25));
        products.add(Product("Water", 3.48));
        products.add(Product("Vanilla Ice Cream", 7.98));
        products.add(Product("Laundry Detergent", 27.24));

        Scanner input = new Scanner(System.in);
        int choice = -1;

        do{
            System.out.printf("%24= %n");
            System.out.println("  Welcome to the Store  ");
            System.out.printf("%24= %n%n");
            int i = 0;
            for (Product p : products) {
                System.out.printf("%d", i++);
                System.out.println(p);
            }
            double total = 0;
            System.out.printf("%nCurrent Order%n%13-%n%n");
            for(Product c: shoppingCart){
                System.out.println(c);
                total += c.cost;
            }
            System.out.println("Total Cost: " + total);
            System.out.println("Buy which product?");
            
            input.nextInt(choice);

            if(choice >= 0){
                shoppingCart.add(products.get(choice));
            }
        }while(choice >= 0);
    }

    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Product> shoppingCart = new ArrayList<>();
}
