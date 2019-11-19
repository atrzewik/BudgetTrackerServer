package com.trzewik.budgettrackerserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Agnieszka Trzewik
 */
@NoArgsConstructor
@AllArgsConstructor
public class SpendingDTO {

    @Getter
    private String description;
    @Getter
    private BigDecimal price;

}
