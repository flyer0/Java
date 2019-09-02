package ch.hfict;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    public static void main(String [] args) {
        Map<Person,String> phonebook = new HashMap<Person, String>();
        
        phonebook.put(new Person ("Walter", "White"),("0797484747"));
        phonebook.put(new Person ("Paige", "Jenning"),("0754542323"));
        
        Person key = new Person("Paige","Jenning");
        System.out.println(key.getFirstname()+": "+ phonebook.get(key));
       
        
        
    }
    
    
}
