package com.company.socialmediaapp.repository;

import com.company.socialmediaapp.model.VerificationToken;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mehul jain
 */
@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    
    Optional<VerificationToken> findByToken(String token);
}
