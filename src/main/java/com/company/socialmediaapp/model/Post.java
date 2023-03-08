package com.company.socialmediaapp.model;

import java.time.Instant;

import jakarta.persistence.*;
import lombok.*;


/**
 *
 * @author mehul jain
 */
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    
    private String postName;
    
    private String url;
    
    @Lob
    private String description;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
    
    private Instant createdDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Mword mword;
}
