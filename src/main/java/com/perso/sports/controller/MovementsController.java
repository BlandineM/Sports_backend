package com.perso.sports.controller;

import com.perso.sports.entity.Movements;
import com.perso.sports.entity.RequestAddMovementsPresenter;
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
    public boolean delete(@PathVariable Integer id){
        movementsRepository.deleteById(id);
        return true;
    }

    @PostMapping("/movements")
    public Movements create(@RequestBody RequestAddMovementsPresenter requestAddMovementsPresenter){
        String name = requestAddMovementsPresenter.getName();
        String shortName = requestAddMovementsPresenter.getShortName();
        String description = requestAddMovementsPresenter.getDescription();
        Movements requestMovements = new Movements(null, name, shortName, description);
        return movementsRepository.save(requestMovements);
    }
}
