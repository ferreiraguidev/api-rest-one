package com.example.apirestone.controller;

import com.example.apirestone.controller.dtos.request.UsersPostReqBody;
import com.example.apirestone.controller.dtos.request.UsersPutReqBody;
import com.example.apirestone.model.*;
import com.example.apirestone.service.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("v5")
public class UsersController {

    private final AutorService autorService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/users")
    public List<Users> list() {
        return autorService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("users/new")
    public ResponseEntity<Users> save(@RequestBody @Valid UsersPostReqBody usersPostReqBody) {
        return new ResponseEntity<>(autorService.save(usersPostReqBody), HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "users/{id}", method = RequestMethod.GET)
    public ResponseEntity<Users> findById(@PathVariable Long id) {
        return ResponseEntity.ok(autorService.findById(id));
    }

    @PutMapping("users")
    public ResponseEntity<Void> update(@Valid @RequestBody UsersPutReqBody usersPutReqBody) {
        autorService.update(usersPutReqBody);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        autorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
