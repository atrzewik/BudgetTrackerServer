package com.trzewik.budgettrackerserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Agnieszka Trzewik
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SpendingDTO {

    private String description;
    private BigDecimal price;

}