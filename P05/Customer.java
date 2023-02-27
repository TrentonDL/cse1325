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
        email.toLowerCase();
        name.toLowerCase();
        String[] parts = name.split(" ");
        boolean valid = false;
        for (String string : parts) {
            if(that.email.contains(string))
                valid = true;
        }
        return valid;
    }

    private String name;
    private String email;
}
