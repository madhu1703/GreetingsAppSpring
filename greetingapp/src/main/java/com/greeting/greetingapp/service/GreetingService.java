package com.greeting.greetingapp.service;
import com.greeting.greetingapp.model.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingService implements IGreetingService {
    @Override
    public Greeting getGreetingMessage() {
        return new Greeting(1, "Hello World");
    }
}
