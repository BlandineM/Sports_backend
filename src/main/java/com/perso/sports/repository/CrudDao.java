package com.perso.sports.repository;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudDao<T> {

    T save(T entity);

    T findById(Long id);

    List<T> findAll();

    T update(T entity);

    boolean deleteById(Long id);
}