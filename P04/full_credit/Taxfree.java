public class Taxfree extends Product {
    public Taxfree(String name, double cost) {
        super(name, cost);
        cost = price();
    }

    @Override
    double price() {
        return cost;
    }
}
