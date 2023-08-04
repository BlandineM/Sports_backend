package com.perso.sports.controller;

import com.perso.sports.entity.User;
import com.perso.sports.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    @ResponseBody
    public List<User> index(){
                return userRepository.findAll();
    }

    @PostMapping("/users")
    public User create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        User requestBook = new User(null, name);
        return userRepository.save(requestBook);
    }

    @PutMapping("/users/{id}")
    public User update(@PathVariable Integer id, @RequestBody Map<String, String> body){
        String name = body.get("name");
        User requestUser = new User(id,name);
        return userRepository.save(requestUser);
    }

    @DeleteMapping("users/{id}")
    public boolean delete(@PathVariable Integer id){
        userRepository.deleteById(id);
        return true;
    }
}
