package com.incubyte.user;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Serdeable
@Entity
@Table(name = "users")
public class User {
  @Id
  @GenericGenerator(name = "generator", strategy = "increment")
  @GeneratedValue(generator = "generator")
  Integer id;

  String name;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
