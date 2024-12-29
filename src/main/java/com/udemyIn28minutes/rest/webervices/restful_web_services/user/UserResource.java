package com.udemyIn28minutes.rest.webervices.restful_web_services.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
public class UserResource {

    private UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userDaoService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Integer id) {
        User user = userDaoService.getUser(id);

        if (user == null) {
            throw  new UserNotFoundexception("id:"+id);
        }

        return user;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userDaoService.deleteUserById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user, Locale locale) {

        userDaoService.addUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
