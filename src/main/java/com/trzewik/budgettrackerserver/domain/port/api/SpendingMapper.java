package com.trzewik.budgettrackerserver.domain.port.api;

import com.trzewik.budgettrackerserver.domain.Spending;
import com.trzewik.budgettrackerserver.domain.SpendingDTO;

import javax.inject.Named;

/**
 * @author Agnieszka Trzewik
 */
@Named
public interface SpendingMapper {

    SpendingDTO map(Spending spending);

    Spending map(SpendingDTO spendingDTO);
}
