import java.util.Scanner;

public class hello {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your Name: ");
        String name = in.nextLine();
        System.out.println("Hello " + name + "!");
        in.close();
    }
}