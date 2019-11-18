package com.trzewik.budgettrackerserver.domain.port.api;


import com.trzewik.budgettrackerserver.domain.Spending;
import com.trzewik.budgettrackerserver.domain.SpendingSummary;
import com.trzewik.budgettrackerserver.domain.ToLowPriceException;

import javax.inject.Named;
import java.util.List;

/**
 * @author Agnieszka Trzewik
 */
@Named
public interface SpendingPort {

    void addNewSpendings(Spending spending) throws ToLowPriceException;

    List<Spending> getAllSpendings();

    SpendingSummary getSpendingSummary();
}
