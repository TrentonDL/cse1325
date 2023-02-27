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
        if(o == null || getClass() != o.getClass()) 
            return false;
        final Customer that = (Customer) o;
        return (that.email.contains("@")) && (that.email.contains("."));
    }

    private String name;
    private String email;
}
