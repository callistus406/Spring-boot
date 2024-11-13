package com.callistus.dataJPA.models;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = true)
// @DiscriminatorValue( "T")

@Entity
public class Text extends Resource {
    private String content;

}
