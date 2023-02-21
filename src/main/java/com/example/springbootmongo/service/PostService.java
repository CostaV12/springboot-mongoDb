package com.example.springbootmongo.service;

import com.example.springbootmongo.domain.Post;
import com.example.springbootmongo.domain.User;
import com.example.springbootmongo.repository.PostRepository;
import com.example.springbootmongo.repository.UserRepository;
import com.example.springbootmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll () {
        return postRepository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }

}
