package com.perso.sports.repository;

import com.perso.sports.entity.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Sessions, Integer> {
}