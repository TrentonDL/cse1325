package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Option {
    public Option(String name, long cost) {
        this.name = name;
        this.cost = cost;
        if (cost < 0) {
            throw new IllegalArgumentException("Error: Cost Cannot be Negative");
        }
    }

    public Option(BufferedReader br) throws IOException{
        name = br.readLine();
        cost = Long.parseLong(br.readLine());
    }

    public long cost() {
        return this.cost;
    }

    public void save(BufferedWriter bw) throws IOException{
        bw.write(name + '\n');
        bw.write("" + cost + '\n');
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
