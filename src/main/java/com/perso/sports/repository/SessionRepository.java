package com.perso.sports.repository;

import com.perso.sports.entity.SessionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SessionRepository extends MongoRepository<SessionEntity, Integer> {
}