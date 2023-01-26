import java.lang.ProcessBuilder.Redirect.Type;

public class Pet {
    @Override
    public String toString(){
        return name + " is a " + type + " age " + age;
    }

    public Double humanAge() {
        this.age = humanLifeSpan;
    }

    private String name;
    private Type type;
    private Double age;
    private static final Double humanLifeSpan = 80.0;
}
