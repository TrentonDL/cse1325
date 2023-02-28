public class Option {
    public Option(String name, long cost) {
        this.name = name;
        this.cost = cost;
    }

    public long cost(){
        if(cost < 0){
            throw new IllegalArgumentException("Error: Cost Cannot be Negative");
        }
        return cost/100;
    }

    @Override
    public String toString(){
        return name + "(" + cost() + ")";
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass()) 
            return false;
        final Option that = (Option) o;
        return (that.toString() == this.toString());
    }
    
    protected String name;
    protected long cost;
}
