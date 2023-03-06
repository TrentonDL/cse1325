package store;

import java.util.ArrayList;

public class Computer {
    public Computer(String name,String model){
        this.name = name;
        this.model = model;
        this.options = new ArrayList<>();
    }
    
    public void addOption(Option option){
        this.options.add(option);
    }

    public long cost(){
        long sum = 0;
        for (Option option : options) {
            sum += option.cost();
        }
        return sum;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder(name + "  (" + model + ")\n");
        for (Option option : options) {
            s.append("\t" + option.toString() +  "\n");
        }
        return s.toString();
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || this.getClass() != o.getClass()) 
            return false;
        final Computer that = (Computer) o;
        return (this.toString().equals(that.toString()));
    }

    private String name;
    private String model;
    private ArrayList<Option> options;

}
