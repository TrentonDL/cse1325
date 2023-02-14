public class Taxed extends Product{
    public Taxed(String name, double cost) {
        super(name, cost);
        cost = price(cost);
    }

    private static double salesTaxRate = 0.0825;

    public static void setTaxRate(double salesTaxRate){
        Taxed.salesTaxRate = salesTaxRate;
    }

    @Override
    double price(double cost) {
        return (cost * (1 + Taxed.salesTaxRate));
    }
}
