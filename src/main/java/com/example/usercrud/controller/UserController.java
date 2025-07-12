package com.example.usercrud.controller;

import com.example.usercrud.entity.User;
import com.example.usercrud.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.usercrud.dto.LoginRequest;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public User create(@RequestBody User user) { return service.save(user); }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return service.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        // //Thêm code ở đây
        String result = service.login(loginRequest.getEmail(), loginRequest.getPassword());

        
        // return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login không thành công, tài khoản hoặc mật khẩu sai")
        // //Hoặc
         return ResponseEntity.ok(result);
    }
}
