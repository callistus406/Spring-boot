package com.callistus.dataJPA.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "lecture_table")
public class Lecture extends BaseEntity {
  
    private String name;

    //Many sections can belong to one lecture
    @ManyToOne
    @JoinColumn(name="section_id")
    private Section section;

    //one to one lecture - resource
    //uni directional
    @OneToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

}
