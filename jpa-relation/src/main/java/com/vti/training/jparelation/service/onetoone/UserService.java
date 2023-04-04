package com.vti.training.jparelation.service.onetoone;

import com.vti.training.jparelation.onetoone.User;
import com.vti.training.jparelation.onetoone.UserDetail;
import com.vti.training.jparelation.repository.onetoone.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repo;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UserRepository userRepo;

    @Transactional
    public void generateUsers() {
        User u1 = new User("John", "john@gmail.com");
        UserDetail ud1 = new UserDetail("Developer", "1 Ngô Quyền, Hà nội");
        u1.setUserDetail(ud1);

        User u2 = new User("Anna", "anna@gmail.com");
        UserDetail ud2 = new UserDetail("Tester", "12 Nguyễn Du, Hà nội");
        u2.setUserDetail(ud2);

        em.persist(u1);
        em.persist(u2);
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public List<User> queryAll() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM user u", User.class);
        return query.getResultList();
    }

    public User findById(Long id){
        return userRepo.findById(id).orElse(null);
    }

}
