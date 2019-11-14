package com.trzewik.budgettrackerserver.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author Agnieszka Trzewik
 */
@Entity
@NoArgsConstructor
@Getter
public class Spending {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal price;

    @JsonCreator
    Spending(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }
}
