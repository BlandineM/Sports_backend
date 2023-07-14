package com.perso.sports.controller;

import com.perso.sports.entity.*;
import com.perso.sports.entity.presenter.ExercisePresenter;
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
    public SessionEntity create(@RequestBody RequestAddSessionPresenter requestAddSessionsPresenter){
        Integer idUsers = requestAddSessionsPresenter.getIdUsers();
        Instant date = requestAddSessionsPresenter.getDate();
        String name = requestAddSessionsPresenter.getName();
        List<ExercisePresenter> exercisePresenters = requestAddSessionsPresenter.getExercises();
        List <ExerciseEntity> exercises = ExerciseEntity.fromPresenter(exercisePresenters);
        SessionEntity requestSessions = new SessionEntity( null, exercises, idUsers, date,  name);
        return sessionRepository.save(requestSessions);
    }

    @PutMapping("/session/{id}")
    public SessionEntity update(@PathVariable UUID id, @RequestBody RequestUpdateSessionPresenter requestUpdateSessionsPresenter){
        Integer idUsers = requestUpdateSessionsPresenter.getIdUsers();
        Instant date = requestUpdateSessionsPresenter.getDate();
        String name = requestUpdateSessionsPresenter.getName();
        List<ExercisePresenter> exercisePresenters = requestUpdateSessionsPresenter.getExercises();
        List <ExerciseEntity> exercises = ExerciseEntity.fromPresenter(exercisePresenters);
        SessionEntity requestSessions = new SessionEntity(id, exercises, idUsers, date, name);
        return sessionRepository.save(requestSessions);

    }

    @DeleteMapping("session/{id}")
    public boolean delete(@PathVariable UUID id){
         sessionRepository.deleteById(id);
         return true;
    }
}
