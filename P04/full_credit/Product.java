public abstract class Product {
    public Product(String name, double cost){
        this.name = name;
        this.cost = cost;

        if(cost < 0){
            throw new IllegalArgumentException("Cost cannot be negative");
        }
    }

    abstract double price(double cost);
    
    @Override
    public String toString() {
        if(name.equals("Vanilla Ice Cream") || name.equals("Laundry Detergent"))
            return name + " ($" + cost + ") \t\t\t\t $ " + price(cost);
        else
            return name + " ($" + cost + ") \t\t\t\t\t $ " + price(cost);
    }

    protected double cost;
    protected String name;
}
