package com.example.springbootmongo.resource;

import com.example.springbootmongo.domain.Post;
import com.example.springbootmongo.domain.User;
import com.example.springbootmongo.dto.UserDto;
import com.example.springbootmongo.resource.util.URL;
import com.example.springbootmongo.service.PostService;
import com.example.springbootmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);

        List<Post> posts = postService.findByText(text);

        return ResponseEntity.ok().body(posts);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDateTxt,
            @RequestParam(value = "maxDate",  defaultValue = "") String maxDateTxt) {
        text = URL.decodeParam(text);
        LocalDate minDate = URL.convertDate(minDateTxt, LocalDate.now());
        LocalDate maxDate = URL.convertDate(maxDateTxt, LocalDate.now());

        List<Post> posts = postService.fullSearch(text, minDate, maxDate);

        return ResponseEntity.ok().body(posts);
    }


}
