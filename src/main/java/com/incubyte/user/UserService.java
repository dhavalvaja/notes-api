package com.incubyte.user;

import jakarta.inject.Singleton;
import java.util.List;

@Singleton
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAll() {
    return this.userRepository.findAll();
  }

  public User create(UserDto userToCreate) {
    User user = new User();
    user.setName(userToCreate.getName());

    return userRepository.save(user);
  }
}
