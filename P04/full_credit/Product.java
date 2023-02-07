abstract class Product {
    public Product(String name, double cost){
        this.name = name;
        this.cost = cost;
    }

    abstract double price(){

    } 
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return ;//super.toString();
    }

    protected double cost;
    protected String name;
}
