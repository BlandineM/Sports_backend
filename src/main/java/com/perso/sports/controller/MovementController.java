package com.perso.sports.controller;

import com.perso.sports.entity.MovementEntity;
import com.perso.sports.entity.RequestAddMovementPresenter;
import com.perso.sports.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovementController {
    @Autowired
    MovementRepository movementsRepository;

    @GetMapping("/movement")
    public List<MovementEntity> index(){
        return movementsRepository.findAll();
    }

    @DeleteMapping("movement/{id}")
    public boolean delete(@PathVariable Integer id){
        movementsRepository.deleteById(id);
        return true;
    }

    @PostMapping("/movement")
    public MovementEntity create(@RequestBody RequestAddMovementPresenter requestAddMovementsPresenter){
        String name = requestAddMovementsPresenter.getName();
        String shortName = requestAddMovementsPresenter.getShortName();
        String description = requestAddMovementsPresenter.getDescription();
        MovementEntity requestMovements = new MovementEntity(null, name, shortName, description);
        return movementsRepository.save(requestMovements);
    }
}
