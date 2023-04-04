package com.vti.training.jparelation.onetoone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserDetail {
    @Id
    private Long id;
    private String job;
    private String address;

    public UserDetail(String job, String address) {
        this.job = job;
        this.address = address;
    }

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
}
