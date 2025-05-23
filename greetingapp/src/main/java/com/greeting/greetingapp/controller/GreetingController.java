package com.greeting.greetingapp.controller;

import com.greeting.greetingapp.model.Greeting;
import com.greeting.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private IGreetingService greetingService;
    @GetMapping("/message")
    public Greeting getGreetingMessage(@RequestParam(required = false) String firstName,
                                       @RequestParam(required = false) String lastName) {
        return greetingService.getGreetingMessage(firstName, lastName);
    }

    @PostMapping("/save")
    public ResponseEntity<Greeting> saveGreeting(@RequestBody Greeting greeting) {
        Greeting savedGreeting = greetingService.saveGreeting(greeting);
        return ResponseEntity.ok(savedGreeting);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable Long id) {
        return greetingService.findGreetingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Greeting>> getAllGreetings() {
        List<Greeting> greetings = greetingService.getAllGreetings();
        return ResponseEntity.ok(greetings);
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("method", "GET");
        response.put("message", "Hello from GET!");
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> postGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("method", "POST");
        response.put("message", "Hello from POST!");
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> putGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("method", "PUT");
        response.put("message", "Hello from PUT!");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<Map<String, String>> deleteGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("method", "DELETE");
        response.put("message", "Hello from DELETE!");
        return ResponseEntity.ok(response);
    }
}