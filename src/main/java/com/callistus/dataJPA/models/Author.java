package com.callistus.dataJPA.models;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
// @Data // thid takes care of generating getters and setters along side with
// constructor
// args
@Getter
@Setter
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "Author_table")
public class Author extends BaseEntity {
    // @Id
    // @GeneratedValue
    // (strategy = GenerationType.SEQUENCE,
    // generator = "author_sequence")
    // @SequenceGenerator(name = "author_sequence",sequenceName =
    // "author_sequence",allocationSize = 1)
    // private Integer id;
    @Column(name = "f_name", length = 40)
    private String firstName;
    @Column(name = "l_name", length = 40)
    private String lastName;
    @Column(name = "customer_email", unique = true, nullable = false, length = 40)
    private String email;

    private Integer age;
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;
    @Column(insertable = false, updatable = false, nullable = true)
    private LocalDateTime updatedAt;
    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

}
