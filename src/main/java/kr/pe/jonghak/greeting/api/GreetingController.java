package kr.pe.jonghak.greeting.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
public class GreetingController {
    @GetMapping("/greet")
    public ResponseEntity<List<String>> greet() {
        RestTemplate restTemplate = new RestTemplate();
        List<String> users = restTemplate.getForObject("http://user-api-005.user/users", List.class);
        List<String> greetings = users.stream().map(user -> "Hello, " + user).toList();
        log.info("response greeting list: {}", greetings);
        return ResponseEntity.ok(greetings);
    }

    @GetMapping("/error")
    public ResponseEntity<String> error() {
        throw new RuntimeException("Designed error!");
    }
}
