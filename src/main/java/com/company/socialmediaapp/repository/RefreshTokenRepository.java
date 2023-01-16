package com.company.socialmediaapp.repository;

import com.company.socialmediaapp.model.RefreshToken;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mehul jain
 */

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    
    Optional<RefreshToken> findByToken(String token);
    
    void deleteByToken(String token);
}
