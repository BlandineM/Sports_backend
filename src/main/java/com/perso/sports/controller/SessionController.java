package com.perso.sports.controller;

import com.perso.sports.entity.*;
import com.perso.sports.entity.presenter.ExercisePresenter;
import com.perso.sports.entity.presenter.SessionPresenter;
import com.perso.sports.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
public class SessionController {

    @Autowired
    SessionRepository sessionRepository;

    @GetMapping("/session")
    public List<SessionEntity> index(){return sessionRepository.findAll();}

    @GetMapping("/session/{id}")
    public SessionEntity findById(@PathVariable UUID id){
        return sessionRepository.findById(id).orElse(null);
    }

    @PostMapping("/session")
    public SessionEntity create(@RequestBody RequestAddSessionPresenter requestAddSessionPresenter){
        UUID idUser = requestAddSessionPresenter.getIdUser();
        Instant date = requestAddSessionPresenter.getDate();
        String name = requestAddSessionPresenter.getName();
        List<ExercisePresenter> exercisePresenters = requestAddSessionPresenter.getExercises();
        List <ExerciseEntity> exercises = ExerciseEntity.fromPresenter(exercisePresenters);
        SessionEntity requestSession = new SessionEntity( null, exercises, idUser, date,  name);
        return sessionRepository.save(requestSession);
    }

    @PutMapping("/session/{id}")
    public SessionEntity update(@PathVariable UUID id, @RequestBody RequestUpdateSessionPresenter requestUpdateSessionPresenter){
        UUID idUser = requestUpdateSessionPresenter.getIdUser();
        Instant date = requestUpdateSessionPresenter.getDate();
        String name = requestUpdateSessionPresenter.getName();
        List<ExercisePresenter> exercisePresenters = requestUpdateSessionPresenter.getExercises();
        List <ExerciseEntity> exercises = ExerciseEntity.fromPresenter(exercisePresenters);
        SessionEntity requestSession = new SessionEntity(id, exercises, idUser, date, name);
        return sessionRepository.save(requestSession);

    }

    @DeleteMapping("session/{id}")
    public boolean delete(@PathVariable UUID id){
         sessionRepository.deleteById(id);
         return true;
    }
}
