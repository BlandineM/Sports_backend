package com.perso.sports.controller;

import com.perso.sports.entity.Movements;
import com.perso.sports.repository.MovementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovementsController {
    @Autowired
    MovementsRepository movementsRepository;

    @GetMapping("/movements")
    public List<Movements> index(){
        return movementsRepository.findAll();
    }

    @DeleteMapping("movements/{id}")
    public boolean delete(@PathVariable Long id){

        return movementsRepository.deleteById(id);
    }
}
