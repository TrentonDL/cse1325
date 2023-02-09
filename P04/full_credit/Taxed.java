public class Taxed extends Product{
    private static final double salesTaxRate = 0.0;

    public static  double setTaxRate(double salesTaxRate){
        return 0.0825;
    }

    @Override
    double price() {
        return cost * (1 + salesTaxRate);
    }

    void Product(String name, double cost) {
        Product("Vanilla Ice Cream", 7.98);
        Product("Laundry Detergent", 27.24);
        Product("Dr.Pepper", 6.48);
    }
}
