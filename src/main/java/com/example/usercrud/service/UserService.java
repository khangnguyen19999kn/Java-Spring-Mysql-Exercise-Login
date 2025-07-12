package com.example.usercrud.service;

import com.example.usercrud.entity.User;
import com.example.usercrud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() { return repository.findAll(); }
    public User save(User user) { return repository.save(user); }
    public void delete(Long id) { repository.deleteById(id); }
    public User findById(Long id) { return repository.findById(id).orElse(null); }
    public String login (String email,String password) {
        //Thêm code vô đây
    }
}
