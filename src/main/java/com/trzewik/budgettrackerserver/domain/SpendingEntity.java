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
@Getter
public class SpendingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal price;

    SpendingEntity(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }
}
