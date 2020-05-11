package com.gvozdilin.libraryJPA.service;

import com.gvozdilin.libraryJPA.dto.UserDto;
import com.gvozdilin.libraryJPA.entity.User;
import com.gvozdilin.libraryJPA.repository.UserCrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserService {

    @PersistenceContext
    EntityManager entityManager;
    private UserCrudRepository repository;


    public UserService(UserCrudRepository userCrudRepository) {
        this.repository = userCrudRepository;
    }

    @Transactional
    public User findUserById(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Transactional
    public List<User> findAllUsers() {
        List<User> allUsers = (List<User>) repository.findAll();
        return allUsers;
    }


    @Transactional
    public Boolean createUser(UserDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setPatronymic(dto.getPatronymic());
        user.setQuantity(0L);
        repository.save(user);
        return true;
    }
}
