public class Taxfree extends Product {
    public Taxfree(String name, double cost) {
        super(name, cost);
        cost = price(cost);
    }

    @Override
    double price(double cost) {
        return cost;
    }
}
