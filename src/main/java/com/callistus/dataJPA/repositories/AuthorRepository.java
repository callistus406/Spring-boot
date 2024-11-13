package com.callistus.dataJPA.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.callistus.dataJPA.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findByFirstName(String fn);
    List<Author> findAllByFirstName(String fn);
    List<Author> findAllByFirstNameIgnoreCase(String fn);

    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);
    // select * from authors where first_name like "name%"
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);

    // select * from authors where first_name like "%name"
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);

    // select * from authors where first_name in  ("mac","boss","luke")
    List<Author> findAllByFirstNameInIgnoreCase(List<Author> firstNames);

    Optional<Author> findByEmail(String email);

}
