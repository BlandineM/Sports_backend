package com.perso.sports.repository;

import com.perso.sports.entity.MovementEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface MovementRepository extends MongoRepository<MovementEntity, UUID> {
}