package sv.edu.udb.demo_jsf.view;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.udb.demo_jsf.service.GreetingService;

import java.util.Date;

@Named
@RequestScoped
public class AjaxBean {

    @Inject
    private GreetingService greetingService;

    private String name;
    private String greeting;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return greeting;
    }

    public String getNow() {
        return new Date().toString();
    }

    public void doGreeting() {
        greeting = String.format(greetingService.getGreetingTemplate(this.name));
    }
}
