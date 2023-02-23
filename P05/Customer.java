public class Customer {
    public Customer(String name, String email){
        this.name = name;
        this.email = email;

        if(email.equals(null) || !(email.contentEquals(".com"))){

        }
    }

    private String name;
    private String email;
}
