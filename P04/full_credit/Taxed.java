public class Taxed extends Product{
    private static final double salesTaxRate = 0.0;

    public static  double setTaxRate(double salesTaxRate){
        return 0.0825;
    }

    @Override
    double price() {
        return cost * (1 + salesTaxRate);
    }

    public void Product(String name, double cost) {
        super("Vanilla Ice Cream", 7.98);
        super("Laundry Detergent", 27.24);
        super("Dr.Pepper", 6.48);
    }
}
