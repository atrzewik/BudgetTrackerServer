package com.trzewik.budgettrackerserver.domain.port.api;


import com.trzewik.budgettrackerserver.domain.SpendingDTO;
import com.trzewik.budgettrackerserver.domain.SpendingSummary;
import com.trzewik.budgettrackerserver.domain.ToLowPriceException;

import javax.inject.Named;
import java.util.List;

/**
 * @author Agnieszka Trzewik
 */
@Named
public interface SpendingPort {

    void addNewSpendings(SpendingDTO spending) throws ToLowPriceException;

    List<SpendingDTO> getAllSpendings();

    SpendingSummary getSpendingSummary();
}
