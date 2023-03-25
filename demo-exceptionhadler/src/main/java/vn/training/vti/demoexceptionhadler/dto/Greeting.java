package vn.training.vti.demoexceptionhadler.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Greeting {
    @NotNull(message = "The message not be empty")
    @NotEmpty(message = "The message not be empty")
    private String msg;

    @NotNull(message = "The From not be empty")
    @NotEmpty(message = "The From not be empty")
    private String from;

    @NotNull(message = "The To not be empty")
    @NotEmpty(message = "The To not be empty")
    private String to;
}
