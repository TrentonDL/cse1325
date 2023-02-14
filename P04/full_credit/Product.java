public abstract class Product {
    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;

        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative");
        }
    }

    abstract double price(double cost);

    @Override
    public String toString() {
        String display = name + " ($" + cost + ")";
        return String.format("%-50s $ %.2f", display, price(cost));
        // if(name.equals("Vanilla Ice Cream") || name.equals("Laundry Detergent"))
        // return String.format("%-50s $ %.2f", display, price(cost));
        // else
        // return name + " ($" + cost + ") \t\t\t\t\t $ " +
        // String.format("%.2f",price(cost));
    }

    protected double cost;
    protected String name;
}
