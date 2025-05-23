package com.greeting.greetingapp.service;

import com.greeting.greetingapp.model.Greeting;
import com.greeting.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;             // <-- Add this import
import java.util.Optional;

@Service
public class GreetingService implements IGreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

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
        return new Greeting(null, message);
    }

    @Override
    public Greeting saveGreeting(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    @Override
    public Optional<Greeting> findGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
    @Override
    public Optional<Greeting> updateGreeting(Long id, Greeting updatedGreeting) {
        return greetingRepository.findById(id).map(existingGreeting -> {
            existingGreeting.setMessage(updatedGreeting.getMessage());
            return greetingRepository.save(existingGreeting);
        });
    }
}


