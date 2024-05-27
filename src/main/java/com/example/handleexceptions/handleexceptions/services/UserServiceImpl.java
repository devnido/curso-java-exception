package com.example.handleexceptions.handleexceptions.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.handleexceptions.handleexceptions.models.domain.User;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private List<User> users;

  @Override
  public List<User> findAll() {
    return users;
  }

  @Override
  public Optional<User> findById(Long id) {

    User user = users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);

    return Optional.ofNullable(user);
  }

}
