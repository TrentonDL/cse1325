import java.util.ArrayList;

public class Order {
    public Order(Customer customer){
        this.customer = customer;
        this.orderNumber = nextOrderNumber++;
    }

    public void addComputer(Computer computer){
        computers.add(computer);
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("Order " + orderNumber++ + " for " + customer.toString() + "\n\n");
        for (Computer computer : computers) {
            s.append(computer.toString());
        } 
        return s.toString();
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass()) 
            return false;
        final Order that = (Order) o;
        boolean valid = false;
        for (Computer computer : computers) {
            if(computer == that.computer)
                valid = true;
            else
                valid = false;
        }
        return valid;
    }

    private static long nextOrderNumber = 0;
    private long orderNumber;
    private Customer customer;
    private ArrayList<Computer> computers;
}
