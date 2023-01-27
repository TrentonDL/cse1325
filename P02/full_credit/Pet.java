import java.lang.ProcessBuilder.Redirect.Type;

public class Pet {
    public Pet(String name, Double age, Type type){
        this.name = name;
        this.age = age;
        this.type = type;
    }

    @Override
    public String toString(){
        return name + " is a " + type + " age " + age;
    }

    private String name;
    private Type type;
    private Double age;
}
