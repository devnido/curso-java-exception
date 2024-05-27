package com.example.handleexceptions.handleexceptions.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.handleexceptions.handleexceptions.exceptions.UserNotFoundException;
import com.example.handleexceptions.handleexceptions.models.domain.User;
import com.example.handleexceptions.handleexceptions.services.UserService;

@RestController
@RequestMapping("/app")
public class AppController {

  @Autowired
  private UserService service;

  @GetMapping
  public String index() {
    int value = Integer.parseInt("asd");
    System.out.println("Value: " + value);
    return "Hello World";
  }

  @GetMapping("/show/{id}")
  public User show(@PathVariable("id") Long id) {
    User user = service.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    return user;
  }

  // otra forma
  @GetMapping("/show2/{id}")
  public ResponseEntity<?> show2(@PathVariable("id") Long id) {
    Optional<User> optionalUser = service.findById(id);

    if (optionalUser.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(optionalUser.orElseThrow());
  }
}
