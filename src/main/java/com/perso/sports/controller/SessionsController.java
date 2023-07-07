package com.perso.sports.controller;

import com.perso.sports.entity.*;
import com.perso.sports.entity.presenter.ExercisePresenter;
import com.perso.sports.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
public class SessionsController {

    @Autowired
    SessionRepository sessionRepository;

    @GetMapping("/sessions")
    public List<Sessions> index(){return sessionRepository.findAll();}

    @GetMapping("/sessions/{id}")
    public Sessions findById(@PathVariable Integer id){
        return sessionRepository.findById(id).orElse(null);
    }

    @PostMapping("/sessions")
    public Sessions create(@RequestBody RequestAddSessionsPresenter requestAddSessionsPresenter){
        Integer idUsers = requestAddSessionsPresenter.getIdUsers();
        Instant date = requestAddSessionsPresenter.getDate();
        String name = requestAddSessionsPresenter.getName();
        List<ExercisePresenter> exercisePresenters = requestAddSessionsPresenter.getExercises();
        List <Exercise> exercises = Exercise.fromPresenter(exercisePresenters);
        Sessions requestSessions = new Sessions( null, exercises, idUsers, date,  name);
        return sessionRepository.save(requestSessions);
    }

    @PutMapping("/sessions/{id}")
    public Sessions update(@PathVariable Integer id, @RequestBody RequestUpdateSessionsPresenter requestUpdateSessionsPresenter){
        Integer idUsers = requestUpdateSessionsPresenter.getIdUsers();
        Instant date = requestUpdateSessionsPresenter.getDate();
        String name = requestUpdateSessionsPresenter.getName();
        List<ExercisePresenter> exercisePresenters = requestUpdateSessionsPresenter.getExercises();
        List <Exercise> exercises = Exercise.fromPresenter(exercisePresenters);
        Sessions requestSessions = new Sessions(id, exercises, idUsers, date, name);
        return sessionRepository.save(requestSessions);

    }

    @DeleteMapping("sessions/{id}")
    public boolean delete(@PathVariable Integer id){
         sessionRepository.deleteById(id);
         return true;
    }
}
