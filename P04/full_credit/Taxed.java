public class Taxed extends Product{
    public Taxed(String name, double cost) {
        super(name, cost);
        cost = price();
    }

    private static final double salesTaxRate = 0.0;

    public static  double setTaxRate(double salesTaxRate){
        return 0.0825;
    }

    @Override
    double price() {
        return cost * (1 + salesTaxRate);
    }
}
