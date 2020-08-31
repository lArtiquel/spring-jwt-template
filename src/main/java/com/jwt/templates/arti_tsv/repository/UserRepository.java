package com.jwt.templates.arti_tsv.repository;

import com.jwt.templates.arti_tsv.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

}
