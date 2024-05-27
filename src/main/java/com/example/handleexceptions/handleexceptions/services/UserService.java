package com.example.handleexceptions.handleexceptions.services;

import java.util.List;
import java.util.Optional;

import com.example.handleexceptions.handleexceptions.models.domain.User;

public interface UserService {

  List<User> findAll();

  Optional<User> findById(Long id);
}
