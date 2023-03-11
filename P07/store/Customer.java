package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.regex.*;

public class Customer {
    public Customer(String name, String email){
        this.name = name;
        this.email = email;

        if(!Pattern.matches("^([-a-zA-Z0-9_.]+)@([-a-zA-Z0-9_.]+).([a-zA-Z]{2,5})$", email)){
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

    public void save(BufferedWriter bw) throws IOException{
        bw.write(name + '\n');
        bw.write(email + '\n');
    }

    public void Customer(BufferedReader br) throws IOException{
        name = br.readLine();
        email = br.readLine();
    }
    
    private String name;
    private String email;
}
