package com.incubyte.user;

import static org.assertj.core.api.Assertions.assertThat;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.RestAssured;
import jakarta.inject.Inject;
import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

@MicronautTest
class UserControllerTest {
  @Inject private UserRepository userRepository;

  @AfterEach
  void tearDown() {
    userRepository.deleteAll();
  }

  @Test
  void should_return_user_list() {
    RestAssured.given()
        .log()
        .all()
        .when()
        .get("/users")
        .then()
        .log()
        .all()
        .statusCode(HttpStatus.OK.getCode());
  }

  @Test
  void should_add_user() {

    UserDto body = new UserDto("name");

    User user =
        RestAssured.given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .body(body)
            .log()
            .all()
            .when()
            .post("/users")
            .then()
            .log()
            .all()
            .statusCode(HttpStatus.CREATED.getCode())
            .extract()
            .as(User.class);

    User expected = new User();
    expected.setId(1);
    expected.setName("name");
    assertThat(user).usingRecursiveComparison().isEqualTo(expected);
  }
}
