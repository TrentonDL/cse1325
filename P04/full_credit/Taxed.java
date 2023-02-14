public class Taxed extends Product{
    public Taxed(String name, double cost) {
        super(name, cost);
        cost = price(cost);
    }

    private static double salesTaxRate = 0.0;

    public static  double setTaxRate(double salesTaxRate){
        salesTaxRate = 0.0825;
        return salesTaxRate;
    }

    @Override
    double price(double cost) {
        setTaxRate(salesTaxRate);
        return (cost * (1 + salesTaxRate));
    }
}
