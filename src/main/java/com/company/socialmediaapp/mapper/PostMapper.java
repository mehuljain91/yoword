package com.company.socialmediaapp.mapper;

import com.github.marlonlom.utilities.timeago.TimeAgo;

import com.company.socialmediaapp.dto.PostRequest;
import com.company.socialmediaapp.dto.PostResponse;
import com.company.socialmediaapp.model.*;
import com.company.socialmediaapp.repository.CommentRepository;
import com.company.socialmediaapp.service.AuthService;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author mehul jain
 */

@Mapper(componentModel = "spring")
public abstract class PostMapper {
    
    @Autowired
    private CommentRepository commentRepository;

    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    @Mapping(target = "mword", source = "mword")
    @Mapping(target = "user", source = "user")
    public abstract Post map(PostRequest postRequest, Mword mword, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "mwordName", source = "mword.name")
    @Mapping(target = "userName", source = "user.username")
    @Mapping(target = "commentCount", expression = "java(commentCount(post))")
    @Mapping(target = "duration", expression = "java(getDuration(post))")
    public abstract PostResponse mapToDto(Post post);

    Integer commentCount(Post post) {
        return commentRepository.findByPost(post).size();
    }

    String getDuration(Post post) {
        return TimeAgo.using(post.getCreatedDate().toEpochMilli());
    }
}
