package com.company.socialmediaapp.dto;

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
public class LoginRequest {
    
    private String username;
    private String password;
}
