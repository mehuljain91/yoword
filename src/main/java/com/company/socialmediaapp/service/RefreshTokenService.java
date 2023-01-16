package com.company.socialmediaapp.service;

import com.company.socialmediaapp.exceptions.AppException;
import com.company.socialmediaapp.model.RefreshToken;
import com.company.socialmediaapp.repository.RefreshTokenRepository;
import java.time.Instant;
import java.util.UUID;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author mehul jain
 */

@Service
@AllArgsConstructor
@Transactional
public class RefreshTokenService {
    
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken generateRefreshToken() {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setCreatedDate(Instant.now());

        return refreshTokenRepository.save(refreshToken);
    }

    void validateRefreshToken(String token) {
        refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> new AppException("Invalid refresh Token"));
    }

    public void deleteRefreshToken(String token) {
        refreshTokenRepository.deleteByToken(token);
    }
}
