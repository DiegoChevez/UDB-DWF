package sv.edu.udb.demo_jsf.view;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class HelloBean {

    public String getName(){
        return "Mauricio";
    }

    public String getGreeting(){
        return "Hello";
    }

}
