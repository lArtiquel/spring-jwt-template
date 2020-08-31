package com.jwt.templates.arti_tsv.repository;

import com.jwt.templates.arti_tsv.model.ERole;
import com.jwt.templates.arti_tsv.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
