package store;

import java.util.ArrayList;

public class Order {
    public Order(Customer customer) {
        this.customer = customer;
        this.orderNumber = nextOrderNumber++;
        this.computers = new ArrayList<>();
    }

    public void addComputer(Computer computer) {
        this.computers.add(computer);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Order " + orderNumber++ + " for " + customer.toString() + "\n\n");
        for (Computer computer : computers) {
            s.append(computer.toString());
        }
        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        final Order that = (Order) o;
        if (!this.customer.equals(that.customer)) {
            return false;
        }
        if (this.computers.size() != that.computers.size()) {
            return false;
        }
        for (int index = 0; index < this.computers.size(); index++) {
            Computer thisComp = this.computers.get(index);
            Computer thatComp = that.computers.get(index);
            if (!thisComp.equals(thatComp))
                return false;
        }
        return true;
    }

    private static long nextOrderNumber = 0;
    private long orderNumber;
    private Customer customer;
    private ArrayList<Computer> computers;
}
