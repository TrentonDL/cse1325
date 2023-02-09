abstract class Product {
    abstract void product(String name, double cost);

    abstract double price();
    
    @Override
    public String toString() {
        return ") " + name + " ($" + cost + ") /t/t/t/t$  " + price();
    }

    protected double cost;
    protected String name;
}
