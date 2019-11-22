package com.trzewik.budgettrackerserver.domain.port.api;


import com.trzewik.budgettrackerserver.domain.SpendingDTO;
import com.trzewik.budgettrackerserver.domain.SpendingSummary;

import javax.inject.Named;
import java.util.List;

/**
 * @author Agnieszka Trzewik
 */
@Named
public interface SpendingPort {

    void addNewSpending(SpendingDTO spending);

    List<SpendingDTO> getAllSpendings();

    SpendingSummary getSpendingSummary();
}
