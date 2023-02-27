import java.util.ArrayList;

public class Computer {
    public Computer(String name,String model){
        this.name = name;
        this.model = model;

    }
    
    public void addOption(Option option){
        options.add(new Option(option.name, option.cost));
    }

    public long cost(){
        long sum = 0;
        for (Option option : options) {
            sum += option.cost;
        }
        return sum;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder(name + "  (" + model + ")\n");
        for (Option option : options) {
            s.append("\t" + option.name + "  ($" + option.cost/100 +  ")\n");
        }
        return s.toString();
    }

    private String name;
    private String model;
    private ArrayList<Option> options;

}
