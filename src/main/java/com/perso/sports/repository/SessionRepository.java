package com.perso.sports.repository;

import com.perso.sports.entity.SessionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SessionRepository extends MongoRepository<SessionEntity, UUID> {
}