package com.company.socialmediaapp.repository;

import com.company.socialmediaapp.model.Mword;
import com.company.socialmediaapp.model.Post;
import com.company.socialmediaapp.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mehul jain
 */

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
    List<Post> findAllByMword(Mword mword);
    
    List<Post> findByUser(User user);
}
