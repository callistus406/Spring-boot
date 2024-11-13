package com.callistus.dataJPA.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "section_table")

public class Section extends BaseEntity {
    // @Id
    // @GeneratedValue
    // private Integer id;
    private String name;
    private int section_order;
    @ManyToOne
    // many sections can belong to one course
    @JoinColumn(name = "course_id")
    private Course course;

    //one section to many lectures
    @OneToMany(mappedBy = "section") // sections is gotten from the inverse
    private List<Lecture> lectures;
    

}
