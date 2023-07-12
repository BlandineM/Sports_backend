package com.perso.sports.repository;

import com.perso.sports.entity.MovementEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovementRepository extends MongoRepository<MovementEntity, Integer> {
}