package com.company.socialmediaapp.service;

import com.company.socialmediaapp.dto.PostRequest;
import com.company.socialmediaapp.dto.PostResponse;
import com.company.socialmediaapp.exceptions.MwordNotFoundException;
import com.company.socialmediaapp.exceptions.PostNotFoundException;
import com.company.socialmediaapp.mapper.PostMapper;
import com.company.socialmediaapp.model.Mword;
import com.company.socialmediaapp.model.Post;
import com.company.socialmediaapp.model.User;
import com.company.socialmediaapp.repository.MwordRepository;
import com.company.socialmediaapp.repository.PostRepository;
import com.company.socialmediaapp.repository.UserRepository;
import java.util.List;
import static java.util.stream.Collectors.toList;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author mehul jain
 */

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PostService {
    private final PostRepository postRepository;
    private final MwordRepository mwordRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final PostMapper postMapper;

    public void save(PostRequest postRequest) {
        Mword mword = mwordRepository.findByName(postRequest.getMwordName())
                .orElseThrow(() -> new MwordNotFoundException(postRequest.getMwordName()));
        postRepository.save(postMapper.map(postRequest, mword, authService.getCurrentUser()));
    }

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByMword(Long mwordId) {
        Mword mword = mwordRepository.findById(mwordId)
                .orElseThrow(() -> new MwordNotFoundException(mwordId.toString()));
        List<Post> posts = postRepository.findAllByMword(mword);
        return posts.stream().map(postMapper::mapToDto).collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return postRepository.findByUser(user)
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }
}
