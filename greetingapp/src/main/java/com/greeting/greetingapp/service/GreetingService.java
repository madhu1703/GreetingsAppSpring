package com.greeting.greetingapp.service;
import com.greeting.greetingapp.model.Greeting;
import org.springframework.stereotype.Service;
@Service
public class GreetingService implements IGreetingService {

    @Override
    public Greeting getGreetingMessage(String firstName, String lastName) {
        String name = "";
        if (firstName != null && !firstName.isEmpty()) {
            name += firstName;
        }
        if (lastName != null && !lastName.isEmpty()) {
            if (!name.isEmpty()) {
                name += " ";
            }
            name += lastName;
        }

        String message = name.isEmpty() ? "Hello World" : "Hello " + name;
        return new Greeting(0, message);
    }
}
