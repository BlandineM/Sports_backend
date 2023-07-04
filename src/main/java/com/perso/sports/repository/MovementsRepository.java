package com.perso.sports.repository;

import com.perso.sports.entity.Movements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementsRepository extends JpaRepository<Movements, Integer> {
}