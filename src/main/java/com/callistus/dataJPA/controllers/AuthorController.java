package com.callistus.dataJPA.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.callistus.dataJPA.formating.ApiResponse;
import com.callistus.dataJPA.formating.AuthorDto;
import com.callistus.dataJPA.models.Author;
import com.callistus.dataJPA.services.AuthorService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AuthorDto>>> findAuthors() {
        System.out.println("====================================");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");

        List<AuthorDto> authors = authorService.findAllAuthors();
        ApiResponse<List<AuthorDto>> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Authors Retrieved Successfully",
                authors, LocalDateTime.now().format(formatter));

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<Author>>> findAuthorByName(@RequestParam(required = true) String name) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");

        // Retrieve authors list
        List<Author> authors = authorService.findAuthorByName(name);

        var res = authors.stream().map(item -> item.getEmail()).collect(Collectors.toList());
        System.out.println(res);

        // Create ApiResponse object with metadata and data
        ApiResponse<List<Author>> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Authors Retrieved Successfully",
                authors,
                LocalDateTime.now().format(formatter));

        // Return the ApiResponse wrapped in a ResponseEntity
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> updateAuthor(@PathVariable Integer id, @RequestBody AuthorDto author) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");

        AuthorDto dto = new AuthorDto(
                id,
                author.getFirstName(),
                author.getLastName(),
                author.getAuthorEmail(),
                author.getAge(),
                author.getCreatedAt());
        String updateAuthor = authorService.updateAuthor(id, dto);

        ApiResponse<String> response = new ApiResponse<String>(HttpStatus.OK.value(), updateAuthor, null,
                LocalDateTime.now().format(formatter));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteRecord(@PathVariable Integer id) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");

        String response = authorService.deleteRecord(id);
        ApiResponse<String> apiRes = new ApiResponse<>(200, response, null, LocalDateTime.now().format(formatter));

        return new ResponseEntity<>(apiRes, HttpStatus.OK);
    }

}
