package com.vti.training.jparelation.repository.onetoone;

import com.vti.training.jparelation.onetoone.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
