public class Customer {
    public Customer(String name, String email){
        this.name = name;
        this.email = email;

        if((!(name.equals(email)))){
            throw new IllegalArgumentException("Error: Invaild Email Address");
        }
    }

    @Override
    public String toString(){
        return name + "(" + email + ")";
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || this.getClass() != o.getClass()) 
            return false;        
        final Customer that = (Customer) o;
        return (this.name == that.name) && (this.email == that.email);
    }

    private String name;
    private String email;
}
