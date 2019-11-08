package com.trzewik.budgettrackerserver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Agnieszka Trzewik
 */
@Getter
@AllArgsConstructor
class Spending {

    private String description;
    private BigDecimal price;

}
