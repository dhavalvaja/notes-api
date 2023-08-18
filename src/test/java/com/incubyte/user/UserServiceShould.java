package com.incubyte.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceShould {
  private final UserRepository userRepository = mock(UserRepository.class);

  @Captor ArgumentCaptor<User> userArgumentCaptor;

  @Test
  void call_repository_to_fetch_all_user() {
    UserService userService = new UserService(userRepository);

    userService.getAll();

    verify(userRepository).findAll();
  }

  @Test
  void call_repository_to_create_user() {
    UserService userService = new UserService(userRepository);
    UserDto userToCreateDto = new UserDto("name");

    userService.create(userToCreateDto);

    verify(userRepository).save(userArgumentCaptor.capture());
    assertThat(userArgumentCaptor.getValue().getName()).isEqualTo("name");
  }
}
