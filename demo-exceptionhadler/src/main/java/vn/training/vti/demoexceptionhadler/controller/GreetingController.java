package vn.training.vti.demoexceptionhadler.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.training.vti.demoexceptionhadler.dto.Greeting;
import vn.training.vti.demoexceptionhadler.service.GreetingService;

@RestController
@RequestMapping("/api/v1/greeting")
@RequiredArgsConstructor
public class GreetingController {
    private final GreetingService service;

    @PostMapping
    public ResponseEntity<String> postGreeting(
            @RequestBody Greeting greeting
    ) {
        final String greetingMsg = service.saveGreeting(greeting);
        return ResponseEntity
                .accepted()
                .body(greetingMsg);
    }

    @GetMapping("/error")
    public ResponseEntity<?> throwException() {
        return ResponseEntity.ok(service.throwException());
    }
}
