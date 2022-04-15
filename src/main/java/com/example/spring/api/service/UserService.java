package com.example.spring.api.service;

import com.example.spring.api.entity.UserEntity;
import com.example.spring.api.exceptions.UserAlredyExists;
import com.example.spring.api.exceptions.UserNotFoundException;
import com.example.spring.api.model.User;
import com.example.spring.api.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlredyExists {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlredyExists("Пользователь уже существует");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("Пользователь не был найдет");
        }
        return User.toModel(user);
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
