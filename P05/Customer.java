public class Customer {
    public Customer(String name, String email){
        this.name = name;
        this.email = email;

        if((!(email.contains("@")) && !(email.contains(".")))){
            throw new IllegalArgumentException("Error: Invaild Email Address");
        }
    }

    @Override
    public String toString(){
        return name + "(" + email + ")";
    }

    @Overide
    public boolean equals(){
        
    }

    private String name;
    private String email;
}
