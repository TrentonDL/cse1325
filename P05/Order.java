import java.util.ArrayList;

public class Order {
    public Order(Customer customer){
        this.customer = customer;
    }

    public void addComputer(Computer computer){
        computers.add(new Computer(computer));
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("Order " + orderNumber++ + " for " + customer.toString() + "\n\n");
        for (Computer computer : computers) {
            s.append(computer.toString());
        } 
        return s.toString();
    }

    private static long nextOrderNumber = 0;
    private long orderNumber;
    private Customer customer;
    private ArrayList<Computer> computers;
}
