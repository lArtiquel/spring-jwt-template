package com.jwt.repository;

import java.util.Optional;

import com.jwt.model.ERole;
import com.jwt.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
