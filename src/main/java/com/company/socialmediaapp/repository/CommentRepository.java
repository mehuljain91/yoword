package com.company.socialmediaapp.repository;

import com.company.socialmediaapp.model.Comment;
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
public interface CommentRepository extends JpaRepository<Comment, Long> {
    
    List<Comment> findByPost(Post post);
    
    List<Comment> findAllByUser(User user);
}
