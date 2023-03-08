package com.company.socialmediaapp.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

import jakarta.validation.constraints.NotBlank;
/**
 *
 * @author mehul jain
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MwordDto {
    
    private Long id;
    
    @NotBlank(message = "Community name is required")
    private String name;
    
    @NotBlank(message = "Description is required")
    private String description;
    
    private Integer numberOfPosts;
}
