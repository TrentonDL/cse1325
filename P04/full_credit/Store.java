import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    private static ArrayList<Product> products = new ArrayList<>();

    public static int main(String[] args) {
        products.add(new Product("Milk", 4.43));
        products.add(new Product("Dr.Pepper", 6.48));
        products.add(new Product("Eggs", 4.25));
        products.add(new Product("Water", 3.48));
        products.add(new Product("Vanilla Ice Cream", 7.98));
        products.add(new Product("Laundry Detergent", 27.24));

        do{
            System.out.printf("%24=\n");
            System.out.println("  Welcome to the Store  ");
            System.out.printf("%24=\n\n");
            int i = 0;
            for (Product p : products) {
                System.out.printf("%d", i++);
                System.out.println(p);
            }

            System.out.printf("\nCurrent Order\n%13-\n\n");
            for(Product c: shoppingCart){
                System.out.println(c);
            }
            Scanner input = new Scanner(System.in);

        }while();
    }

    private ArrayList<Product> shoppingCart = new ArrayList<>();
}
