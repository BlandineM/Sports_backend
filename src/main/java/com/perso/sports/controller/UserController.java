package com.perso.sports.controller;

import com.perso.sports.entity.UserEntity;
import com.perso.sports.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    @ResponseBody
    public List<UserEntity> index(){
                return userRepository.findAll();
    }

    @PostMapping("/user")
    public UserEntity create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        UserEntity requestBook = new UserEntity(null, name);
        return userRepository.save(requestBook);
    }

    @PutMapping("/user/{id}")
    public UserEntity update(@PathVariable UUID id, @RequestBody Map<String, String> body){
        String name = body.get("name");
        UserEntity requestUser = new UserEntity(id,name);
        return userRepository.save(requestUser);
    }

    @DeleteMapping("user/{id}")
    public boolean delete(@PathVariable Integer id){
        userRepository.deleteById(id);
        return true;
    }
}
