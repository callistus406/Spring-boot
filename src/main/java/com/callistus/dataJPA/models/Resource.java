package com.callistus.dataJPA.models;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
@SuperBuilder
@Table(name = "resource_table")
@Inheritance(strategy = InheritanceType.JOINED)
// @DiscriminatorColumn(name = "resource_type") only with single table
@Entity
public class Resource extends BaseEntity{
    // @Id
    // @GeneratedValue
    // private Integer id;
    private String name;
    private int size;
    private String url;

    @OneToOne
    @JoinColumn(name="lecture_id")
    private Lecture lecture;


}
