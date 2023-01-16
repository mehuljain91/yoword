package com.company.socialmediaapp.model;

import java.time.Instant;
import javax.persistence.*;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.validation.constraints.NotBlank;
import org.springframework.lang.Nullable;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

/**
 *
 * @author mehul jain
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long postId;
    @NotBlank(message = "Post Name cannot be empty or Null")
    private String postName;
    @Nullable
    private String url;
    @Nullable
    @Lob
    private String description;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
    private Instant createdDate;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Mword mword;
}
