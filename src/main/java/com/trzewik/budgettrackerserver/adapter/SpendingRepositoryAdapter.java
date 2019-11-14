package com.trzewik.budgettrackerserver.adapter;

import com.trzewik.budgettrackerserver.domain.Spending;
import com.trzewik.budgettrackerserver.domain.port.spi.SpendingDataPort;
import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import java.util.Optional;

/**
 * @author Agnieszka Trzewik
 */
@Named
interface SpendingRepositoryAdapter extends CrudRepository<Spending, Long>, SpendingDataPort<Spending> {

    @Override
    <S extends Spending> S save(S entity);

    @Override
    Iterable<Spending> findAll();

    @Override
    Optional<Spending> findById(Long aLong);
}
