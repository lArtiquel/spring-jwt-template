package com.jwt.repository;

import com.jwt.model.RefreshToken;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends MongoRepository<RefreshToken, String> {
    Optional<RefreshToken> findById(String id);
    void deleteByUserIdAndExpiredInSecondsBefore(String userId, Long currentTimeInSeconds);
}
