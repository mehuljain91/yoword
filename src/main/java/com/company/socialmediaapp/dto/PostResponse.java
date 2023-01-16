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
public class PostResponse {
    private Long id;
    private String postName;
    private String url;
    private String description;
    private String userName;
    private String mwordName;
    private Integer commentCount;
    private String duration;
}
