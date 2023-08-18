package com.incubyte.user;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import java.util.List;

@Controller("/users")
public class UserController {
  UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @Get()
  public MutableHttpResponse<List<User>> getAll() {
    return HttpResponse.ok(this.userService.getAll());
  }

  @Post()
  public MutableHttpResponse<User> create(@Body UserDto userToCreate) {
    return HttpResponse.created(this.userService.create(userToCreate));
  }
}
