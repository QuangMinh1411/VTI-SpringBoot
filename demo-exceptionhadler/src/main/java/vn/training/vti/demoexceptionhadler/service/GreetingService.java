package vn.training.vti.demoexceptionhadler.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.training.vti.demoexceptionhadler.ObjectValidator;
import vn.training.vti.demoexceptionhadler.dto.Greeting;

@Service
@RequiredArgsConstructor
public class GreetingService {
    private final ObjectValidator<Greeting> greetingValidator;

    public String saveGreeting(Greeting greeting) {
        greetingValidator.validate(greeting);
        final String greetingMsg =
                "Greeting message <<" +
                        greeting.getMsg()
                        + ">> from: " +
                        greeting.getFrom().toUpperCase() +
                        " to: " +
                        greeting.getTo().toUpperCase();
        return greetingMsg;
    }

    public String throwException(){
        throw new IllegalStateException("Something wrong happened");
    }
}
