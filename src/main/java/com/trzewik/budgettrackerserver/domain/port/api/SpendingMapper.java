package com.trzewik.budgettrackerserver.domain.port.api;

import com.trzewik.budgettrackerserver.adapter.Spending;
import com.trzewik.budgettrackerserver.domain.SpendingDTO;

/**
 * @author Agnieszka Trzewik
 */
public interface SpendingMapper {

    SpendingDTO map(Spending spending);

    Spending map(SpendingDTO spendingDTO);
}
