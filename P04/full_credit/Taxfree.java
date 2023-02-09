public class Taxfree extends Product {
    
    void Product(String name, double cost) {
        Product("Water", 3.48);
        Product("Eggs", 4.25);
        Product("Milk", 4.43);
    }

    @Override
    double price() {
        return cost;
    }
}
