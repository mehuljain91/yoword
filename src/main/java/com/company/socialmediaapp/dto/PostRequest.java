package com.company.socialmediaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
/**
 *
 * @author mehul jain
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    
    private Long postId;
    private String mwordName;
    
    @NotBlank(message = "Post Name cannot be empty or Null")
    private String postName;
    private String url;
    private String description;
}
