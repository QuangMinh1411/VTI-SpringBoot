package vn.vti.jsondemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private String id;
    private String model;
    private String maker;
    private Integer year;
}
