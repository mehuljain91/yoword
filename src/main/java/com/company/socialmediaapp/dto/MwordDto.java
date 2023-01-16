package com.company.socialmediaapp.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

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
    private String name;
    private String description;
    private Integer numberOfPosts;
}
