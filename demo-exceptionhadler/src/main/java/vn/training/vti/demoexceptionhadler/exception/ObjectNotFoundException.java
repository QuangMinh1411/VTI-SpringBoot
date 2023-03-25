package vn.training.vti.demoexceptionhadler.exception;

import lombok.Data;

import java.util.Set;

@Data
public class ObjectNotFoundException extends RuntimeException{
    private final Set<String> errorMessages;
}
