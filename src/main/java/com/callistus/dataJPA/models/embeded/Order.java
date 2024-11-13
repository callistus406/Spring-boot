package com.callistus.dataJPA.models.embeded;
import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
// @Entity
public class Order {
    @EmbeddedId
    private OrderId id;
    private String orderInfo;
    private String anotherString;


}
