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
public class RegisterRequest {
    
    private String email;
    private String username;
    private String password;
}
