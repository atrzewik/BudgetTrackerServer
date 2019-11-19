package com.trzewik.budgettrackerserver.domain;

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
public class Spending {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String description;
    @Getter
    private BigDecimal price;

    Spending(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }
}
