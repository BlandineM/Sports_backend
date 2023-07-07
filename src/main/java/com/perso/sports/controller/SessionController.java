package com.perso.sports.controller;

import com.perso.sports.entity.*;
import com.perso.sports.entity.presenter.ExercisePresenter;
import com.perso.sports.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
public class SessionController {

    @Autowired
    SessionRepository sessionRepository;

    @GetMapping("/session")
    public List<Session> index(){return sessionRepository.findAll();}

    @GetMapping("/session/{id}")
    public Session findById(@PathVariable Integer id){
        return sessionRepository.findById(id).orElse(null);
    }

    @PostMapping("/session")
    public Session create(@RequestBody RequestAddSessionPresenter requestAddSessionsPresenter){
        Integer idUsers = requestAddSessionsPresenter.getIdUsers();
        Instant date = requestAddSessionsPresenter.getDate();
        String name = requestAddSessionsPresenter.getName();
        List<ExercisePresenter> exercisePresenters = requestAddSessionsPresenter.getExercises();
        List <Exercise> exercises = Exercise.fromPresenter(exercisePresenters);
        Session requestSessions = new Session( null, exercises, idUsers, date,  name);
        return sessionRepository.save(requestSessions);
    }

    @PutMapping("/session/{id}")
    public Session update(@PathVariable Integer id, @RequestBody RequestUpdateSessionPresenter requestUpdateSessionsPresenter){
        Integer idUsers = requestUpdateSessionsPresenter.getIdUsers();
        Instant date = requestUpdateSessionsPresenter.getDate();
        String name = requestUpdateSessionsPresenter.getName();
        List<ExercisePresenter> exercisePresenters = requestUpdateSessionsPresenter.getExercises();
        List <Exercise> exercises = Exercise.fromPresenter(exercisePresenters);
        Session requestSessions = new Session(id, exercises, idUsers, date, name);
        return sessionRepository.save(requestSessions);

    }

    @DeleteMapping("session/{id}")
    public boolean delete(@PathVariable Integer id){
         sessionRepository.deleteById(id);
         return true;
    }
}
