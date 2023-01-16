package com.company.socialmediaapp.controller;

import com.company.socialmediaapp.dto.AuthenticationResponse;
import com.company.socialmediaapp.dto.LoginRequest;
import com.company.socialmediaapp.dto.RefreshTokenRequest;
import com.company.socialmediaapp.dto.RegisterRequest;
import com.company.socialmediaapp.service.AuthService;
import com.company.socialmediaapp.service.RefreshTokenService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import static org.springframework.http.HttpStatus.OK;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author mehul jain
 */
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    
    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity<>("User Registration Successful",
                OK);
    }

    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successfully", OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/refresh/token")
    public AuthenticationResponse refreshTokens(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(OK).body("Refresh Token Deleted Successfully!!");
    }
}
