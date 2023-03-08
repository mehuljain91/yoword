package com.company.socialmediaapp.controller;

import com.company.socialmediaapp.dto.PostRequest;
import com.company.socialmediaapp.dto.PostResponse;
import com.company.socialmediaapp.service.PostService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.status;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author mehul jain
 */
@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
public class PostController {
    
    private final PostService postService;

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody PostRequest postRequest) {
        postService.save(postRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        return status(HttpStatus.OK).body(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable Long id) {
        return status(HttpStatus.OK).body(postService.getPost(id));
    }

    @GetMapping(params = "mwordId")
    public ResponseEntity<List<PostResponse>> getPostsByMword(@RequestParam Long mwordId) {
        return status(HttpStatus.OK).body(postService.getPostsByMword(mwordId));
    }

    @GetMapping(params = "username")
    public ResponseEntity<List<PostResponse>> getPostsByUsername(@RequestParam String username) {
        return status(HttpStatus.OK).body(postService.getPostsByUsername(username));
    }
}
