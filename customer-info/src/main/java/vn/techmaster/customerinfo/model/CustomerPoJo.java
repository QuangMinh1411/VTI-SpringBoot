package vn.techmaster.customerinfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPoJo {
    private String fullname;
    private String email;
    private long phone;
}
