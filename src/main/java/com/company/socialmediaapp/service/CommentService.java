package com.company.socialmediaapp.service;

import com.company.socialmediaapp.dto.CommentsDto;
import com.company.socialmediaapp.exceptions.AppException;
import com.company.socialmediaapp.exceptions.PostNotFoundException;
import com.company.socialmediaapp.mapper.CommentMapper;
import com.company.socialmediaapp.model.Comment;
import com.company.socialmediaapp.model.NotificationEmail;
import com.company.socialmediaapp.model.Post;
import com.company.socialmediaapp.model.User;
import com.company.socialmediaapp.repository.CommentRepository;
import com.company.socialmediaapp.repository.PostRepository;
import com.company.socialmediaapp.repository.UserRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author mehul jain
 */

@Service
@AllArgsConstructor
public class CommentService {
    
    private static final String POST_URL = "";
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;
    private final MailContentBuilder mailContentBuilder;
    private final MailService mailService;

    public void save(CommentsDto commentsDto) {
        Post post = postRepository.findById(commentsDto.getPostId())
                .orElseThrow(() -> new PostNotFoundException(commentsDto.getPostId().toString()));
        Comment comment = commentMapper.map(commentsDto, post, authService.getCurrentUser());
        commentRepository.save(comment);

        String message = mailContentBuilder.build(post.getUser().getUsername() + " posted a comment on your post." + POST_URL);
        sendCommentNotification(message, post.getUser());
    }

    private void sendCommentNotification(String message, User user) {
        mailService.sendMail(new NotificationEmail(user.getUsername() + " Commented on your post", user.getEmail(), message));
    }

    public List<CommentsDto> getAllCommentsForPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId.toString()));
        return commentRepository.findByPost(post)
                .stream()
                .map(commentMapper::mapToDto).toList();
    }

    public List<CommentsDto> getAllCommentsForUser(String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException(userName));
        return commentRepository.findAllByUser(user)
                .stream()
                .map(commentMapper::mapToDto)
                .toList();
    }

    public boolean containsSwearWords(String comment) {
        if (comment.contains("shit")) {
            throw new AppException("Comments contains unacceptable language");
        }
        return false;
    }
}
