package com.perso.sports.repository;

import com.perso.sports.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, Integer> {
}