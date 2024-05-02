package kr.pe.jonghak.greeting.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class GreetingController {
    @GetMapping("/greet")
    public ResponseEntity<List<String>> greet() {
        RestTemplate restTemplate = new RestTemplate();
        List<String> users = restTemplate.getForObject("http://localhost:8080/users", List.class);
        List<String> greetings = users.stream().map(user -> "Hello, " + user).toList();
        return ResponseEntity.ok(greetings);
    }
}
