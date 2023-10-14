package sv.edu.udb.demo_jsf.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public String getGreetingTemplate(final String name) {
        return "Hello " + name;
    }
}
