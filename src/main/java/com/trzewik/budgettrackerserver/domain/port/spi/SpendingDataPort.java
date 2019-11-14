package com.trzewik.budgettrackerserver.domain.port.spi;

import com.trzewik.budgettrackerserver.domain.Spending;

import javax.inject.Named;
import java.util.Optional;

/**
 * @author Agnieszka Trzewik
 */
@Named
public interface SpendingDataPort<T> {

    @SuppressWarnings("UnusedReturnValue")
    <S extends Spending> S save(S entity);

    Iterable<T> findAll();

    Optional<Spending> findById(Long aLong);

}
