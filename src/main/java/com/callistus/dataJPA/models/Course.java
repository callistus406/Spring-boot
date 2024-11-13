package com.callistus.dataJPA.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity
@Table(name = "course_table")
@SuperBuilder
@Setter

public class Course  extends BaseEntity{
    // @Id
    // @GeneratedValue
    // private Integer id;
    private String name;
    private String description;
    @JoinTable(name ="authors_courses" , 
            joinColumns = {
                @JoinColumn(name="course_id") //will hold the primary key of the owner of the relationship
            },
            inverseJoinColumns = {
                @JoinColumn(name="author_id")
            }                
            
            )
    @ManyToMany
    private List<Author> authors;
@OneToMany(mappedBy = "course")
    // one course has many sections
    private List<Section> sections;

     


}
