package com.company.socialmediaapp.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author mehul jain
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenRequest {
    
    @NotBlank
    private String refreshToken;
    private String username;
}
