package com.perso.sports.repository;

import com.perso.sports.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, Integer> {
}