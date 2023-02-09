import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    public static int main(String[] args) {
        products.add(new Taxfree.Product());
        products.add(new Taxed.Product());
        //products.add(new Taxfree.Product("Eggs", 4.25));
        //products.add(new Taxfree.Product("Water", 3.48));
        //products.add(new Taxed.Product("Vanilla Ice Cream", 7.98));
        //products.add(new Taxed.Product("Laundry Detergent", 27.24));

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
            System.out.printf("Total Cost: $ %.2lf%n", total);
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
