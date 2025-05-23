package com.greeting.greetingapp.service;
import com.greeting.greetingapp.model.Greeting;

public interface IGreetingService {
    Greeting getGreetingMessage(String firstName, String lastName);
}
