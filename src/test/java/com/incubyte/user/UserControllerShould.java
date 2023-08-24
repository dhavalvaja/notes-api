package com.incubyte.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class UserControllerShould {
  UserService userService = mock(UserService.class);

  @Test
  void return_call_user_service() {
    UserController userController = new UserController(userService);

    userController.getAll();

    verify(userService).getAll();
    assertThat(false).isTrue();
  }

  @Test
  void call_service_to_create_user() {
    UserController userController = new UserController(userService);
    UserDto userToCreate = new UserDto("name");

    userController.create(userToCreate);

    verify(userService).create(userToCreate);
  }
}
