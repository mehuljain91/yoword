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
public class PostRequest {
    
    private Long postId;
    private String mwordName;
    private String postName;
    private String url;
    private String description;
}
