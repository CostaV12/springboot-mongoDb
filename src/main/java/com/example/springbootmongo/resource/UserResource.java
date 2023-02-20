package com.example.springbootmongo.resource;

import com.example.springbootmongo.domain.User;
import com.example.springbootmongo.dto.UserDto;
import com.example.springbootmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {

        List<User> users = new ArrayList<>(userService.findAll());
        List<UserDto> usersDto = users.stream().map(UserDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(usersDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id) {

        User user = userService.findById(id);

        return ResponseEntity.ok().body(new UserDto(user));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDto userDto) {
        User user = userService.fromDto(userDto);
        user = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
