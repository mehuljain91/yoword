package com.company.socialmediaapp.model;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;
/**
 *
 * @author mehul jain
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "token")
public class VerificationToken {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String token;
    @OneToOne(fetch = LAZY)
    private User user;
    private Instant expiryDate;
}
