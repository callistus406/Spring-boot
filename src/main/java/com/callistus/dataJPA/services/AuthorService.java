package com.callistus.dataJPA.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.text.html.parser.Entity;

import org.springframework.stereotype.Service;

import com.callistus.dataJPA.exception.DuplicateException;
import com.callistus.dataJPA.exception.ResourceNotFoundException;
import com.callistus.dataJPA.formating.AuthorDto;
import com.callistus.dataJPA.models.Author;
import com.callistus.dataJPA.repositories.AuthorRepository;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAuthorByName(String name) {

        List<Author> author = this.authorRepository.findAllByFirstNameStartsWithIgnoreCase(name);

        return author;
    }

    public List<Author> findAuthorByFirstName(String name) {

        List<Author> author = this.authorRepository.findAllByFirstNameStartsWithIgnoreCase(name);

        return author;
    }

    public List<AuthorDto> findAllAuthors() {

        List<Author> authors = this.authorRepository.findAll();

        return authors.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public String deleteRecord(Integer id) {

        Optional<Author> author = this.authorRepository.findById(id);
        if (!author.isPresent()) {
            throw new ResourceNotFoundException("Record doesn't exist ");
        }
        
        this.authorRepository.deleteById(id);
        boolean isDeleted = this.authorRepository.existsById(id);
        System.out.println("================");
        System.out.println(isDeleted);
        if (!isDeleted) {
            return "Record deleted successfully";
        } else {
            return "Failed to delete record";

        }

    }

    public String updateAuthor(int id, AuthorDto author) {

        Author response = this.authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Author with ID " + id + " Not found"));
        if (author.getAuthorEmail().isPresent()) {
            String email = author.getAuthorEmail().get();
            Optional<Author> isFound = this.authorRepository.findByEmail(email);

            if (isFound.isPresent()) {
                throw new DuplicateException("Sorry you can't use this email.");
            }

        }

        author.getAuthorEmail().ifPresent(response::setEmail);
        author.getFirstName().ifPresent(response::setFirstName);
        author.getAge().ifPresent(response::setAge);
        author.getLastName().ifPresent(response::setLastName);

        Author res = this.authorRepository.save(response);
      
        if (res != null && author.getAuthorEmail().get() == res.getEmail()) {
            return "Update successful";
        } else {
            return "Update failed";

        }

    }

    private AuthorDto convertToDTO(Author author) {

        AuthorDto authorDto = new AuthorDto(author.getId(), Optional.ofNullable(author.getFirstName()),
                Optional.ofNullable(author.getLastName()),
                Optional.ofNullable(author.getEmail()), Optional.ofNullable(author.getAge()), author.getCreatedAt());
        return authorDto;
    }

}
