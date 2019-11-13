package com.trzewik.budgettrackerserver.domain.port.spi;

import com.trzewik.budgettrackerserver.domain.SpendingEntity;

import javax.inject.Named;
import java.util.Optional;

/**
 * @author Agnieszka Trzewik
 */
@Named
public interface SpendingDataPort<T> {

    @SuppressWarnings("UnusedReturnValue")
    <S extends SpendingEntity> S save(S entity);

    Iterable<T> findAll();

    Optional<SpendingEntity> findById(Long aLong);

}
