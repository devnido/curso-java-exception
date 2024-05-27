package com.example.handleexceptions.handleexceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.handleexceptions.handleexceptions.models.domain.User;

@Configuration
public class AppConfig {

  @Bean
  List<User> fakeUsers() {
    List<User> users = new ArrayList<User>();
    users.add(new User(1L, "John", "Doe", null));
    users.add(new User(2L, "Jane", "Doe", null));
    users.add(new User(3L, "Mike", "Smith", null));
    users.add(new User(4L, "Anne", "Brown", null));
    users.add(new User(5L, "Tom", "White", null));
    users.add(new User(6L, "Mary", "Black", null));
    return users;
  }

}
