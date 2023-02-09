public class Taxfree extends Product {
    
    public void Product(String name, double cost) {
        super("Water", 3.48);
        super("Eggs", 4.25);
        super("Milk", 4.43);
    }

    @Override
    double price() {
        return cost;
    }
}
