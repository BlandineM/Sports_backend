package com.perso.sports.controller;

import com.perso.sports.entity.RequestAddSessionsPresenter;
import com.perso.sports.entity.RequestUpdateSessionsPresenter;
import com.perso.sports.entity.Sessions;
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
    public Sessions findById(@PathVariable Long id){
        return sessionRepository.findById(id);
    }

    @PostMapping("/sessions")
    public Sessions create(@RequestBody RequestAddSessionsPresenter requestAddSessionsPresenter){
        Long idMovements = requestAddSessionsPresenter.getIdMovements();
        Long idUsers = requestAddSessionsPresenter.getIdUsers();
        Instant date = requestAddSessionsPresenter.getDate();
        int repetitions = requestAddSessionsPresenter.getRepetitions();
        int weight = requestAddSessionsPresenter.getWeight();
        String name = requestAddSessionsPresenter.getName();
        Sessions requestSessions = new Sessions(idMovements, null, idUsers, date, repetitions, weight, name);
        return sessionRepository.save(requestSessions);
    }

    @PutMapping("/sessions/{id}")
    public Sessions update(@PathVariable Long id, @RequestBody RequestUpdateSessionsPresenter requestUpdateSessionsPresenter){
        Long idMovements = requestUpdateSessionsPresenter.getIdMovements();
        Long idUsers = requestUpdateSessionsPresenter.getIdUsers();
        Instant date = requestUpdateSessionsPresenter.getDate();
        int repetitions = requestUpdateSessionsPresenter.getRepetitions();
        int weight = requestUpdateSessionsPresenter.getWeight();
        String name = requestUpdateSessionsPresenter.getName();
        Sessions requestSessions = new Sessions(idMovements, id, idUsers, date, repetitions, weight, name);
        return sessionRepository.update(requestSessions);

    }

    @DeleteMapping("sessions/{id}")
    public boolean delete(@PathVariable Long id){
        return sessionRepository.deleteById(id);
    }
}
