package com.example.handleexceptions.handleexceptions.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

  @GetMapping("/app")
  public String index() {
    int value = Integer.parseInt("asd");
    System.out.println("Value: " + value);
    return "Hello World";
  }

}
