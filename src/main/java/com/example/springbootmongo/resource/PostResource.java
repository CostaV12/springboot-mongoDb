package com.example.springbootmongo.resource;

import com.example.springbootmongo.domain.Post;
import com.example.springbootmongo.domain.User;
import com.example.springbootmongo.dto.UserDto;
import com.example.springbootmongo.service.PostService;
import com.example.springbootmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findAll() {

        List<Post> posts = new ArrayList<>(postService.findAll());
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {

        Post post = postService.findById(id);

        return ResponseEntity.ok().body(post);
    }


}
