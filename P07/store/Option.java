package store;

public class Option {
    public Option(String name, long cost) {
        this.name = name;
        this.cost = cost;
        if (cost < 0) {
            throw new IllegalArgumentException("Error: Cost Cannot be Negative");
        }
    }

    public long cost() {
        return this.cost;
    }

    @Override
    public String toString() {
        return name + "($" + this.cost / 100.0 + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        final Option that = (Option) o;
        return (that.toString().equals(this.toString()));
    }

    protected String name;
    protected long cost;
}
