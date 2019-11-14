package com.trzewik.budgettrackerserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * @author Agnieszka Trzewik
 */
@AllArgsConstructor
@Getter
public class SpendingSummary {

    private BigDecimal summary;
    private OffsetDateTime timestamp;


}
