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
                System.out.printf("======================== \n");
                System.out.println("  Welcome to the Store  ");
                System.out.printf("======================== \n\n");
                int i = 0;
                for (Product p : products) {
                    System.out.printf("%d) ", i++);
                    System.out.println(p);
                }
                double total = 0;
                System.out.printf("\nCurrent Order\n-------------\n\n");
                for(Product c: shoppingCart){
                    System.out.println(c);
                    total += c.price(c.cost);
                }
                System.out.printf("Total Cost: $ %.2f\n", total);
                System.out.println("Buy which product?");

                choice = input.nextInt();

                if(choice >= 0){
                    shoppingCart.add(products.get(choice));
                }
                else{
                    System.out.printf("\n\nYour Total is: $ %.2f\n", total);
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
