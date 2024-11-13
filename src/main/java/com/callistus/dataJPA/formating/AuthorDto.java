package com.callistus.dataJPA.formating;

import java.time.LocalDateTime;
import java.util.Optional;

public class AuthorDto {
    private Integer id;
    private  Optional  <String> firstName = Optional.empty();
    private Optional <String> lastName  = Optional.empty();
    private Optional <String> authorEmail = Optional.empty();
    private Optional <Integer> age = Optional.empty();
    private  LocalDateTime createdAt;
    public AuthorDto(Integer id, Optional<String> firstName, Optional<String> lastName, Optional<String> authorEmail,
            Optional<Integer> age, LocalDateTime createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorEmail = authorEmail;
        this.age = age;
        this.createdAt = createdAt;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Optional<String> getFirstName() {
        return firstName;
    }
    public void setFirstName(Optional<String> firstName) {
        this.firstName = firstName;
    }
    public Optional<String> getLastName() {
        return lastName;
    }
    public void setLastName(Optional<String> lastName) {
        this.lastName = lastName;
    }
    public Optional<String> getAuthorEmail() {
        return authorEmail;
    }
    public void setAuthorEmail(Optional<String> authorEmail) {
        this.authorEmail = authorEmail;
    }
    public Optional<Integer> getAge() {
        return age;
    }
    public void setAge(Optional<Integer> age) {
        this.age = age;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

  
}
