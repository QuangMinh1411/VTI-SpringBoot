package vn.vti.jsondemo.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private Integer id;
    @NotBlank(message = "You have to enter the car model")
    @Size(min=3,max=20,message ="you have to enter between 3 to 20 character")
    private String model;
    @NotBlank(message = "You have to enter the car maker")
    @Size(min=3,max=20,message ="you have to enter between 3 to 20 character")
    private String maker;
    @Min(1990)
    @Max(2023)
    private Integer year;
    private String photo;
}
