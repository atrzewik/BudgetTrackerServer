package com.trzewik.budgettrackerserver.domain.port.spi;

import com.trzewik.budgettrackerserver.adapter.Spending;

import javax.inject.Named;

/**
 * @author Agnieszka Trzewik
 */
@Named
public interface SpendingDataPort {

    @SuppressWarnings("UnusedReturnValue")
    <S extends Spending> S save(S entity);

    Iterable<Spending> findAll();
}
