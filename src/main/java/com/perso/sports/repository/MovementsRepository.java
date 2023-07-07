package com.perso.sports.repository;

import com.perso.sports.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementsRepository extends JpaRepository<Movement, Integer> {
}