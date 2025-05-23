package com.greeting.greetingapp.service;
import com.greeting.greetingapp.model.Greeting;
import java.util.List;
import java.util.Optional;

public interface IGreetingService {
    Greeting getGreetingMessage(String firstName, String lastName);

    Greeting saveGreeting(Greeting greeting);
    Optional<Greeting> findGreetingById(Long id);
    Optional<Greeting> updateGreeting(Long id, Greeting greeting);
    List<Greeting> getAllGreetings();
    boolean deleteGreeting(Long id);
}
