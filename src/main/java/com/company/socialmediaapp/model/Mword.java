package com.company.socialmediaapp.model;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

/**
 *
 * @author mehul jain
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Mword {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    private String name;
    
    private String description;
    
    @OneToMany(fetch = LAZY)
    private List<Post> posts;
    private Instant createdDate;
    @ManyToOne(fetch = LAZY)
    private User user;
}
