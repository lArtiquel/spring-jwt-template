package com.jwt.templates.arti_tsv.repository;

import com.jwt.templates.arti_tsv.model.RefreshToken;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends MongoRepository<RefreshToken, String> {
    Optional<RefreshToken> findById(String id);
    void deleteByUserIdAndExpiredInSecondsBefore(String userId, Long currentTimeInSeconds);
}
