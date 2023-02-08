abstract class Product {
    public Product(String name, double cost){
        this.name = name;
        this.cost = cost;

        if(cost < 0){
            throw new IllegalArgumentException("Cost cannot be negative");
        }
    }

    abstract double price(){
        return cost;
    } 
    
    @Override
    public String toString() {
        return name + " ($" + cost + ") /t/t/t/t$  " + price();
    }

    protected double cost;
    protected String name;
}
