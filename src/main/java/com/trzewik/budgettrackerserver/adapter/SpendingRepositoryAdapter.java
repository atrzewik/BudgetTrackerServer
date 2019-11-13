package com.trzewik.budgettrackerserver.adapter;

import com.trzewik.budgettrackerserver.domain.SpendingEntity;
import com.trzewik.budgettrackerserver.domain.port.spi.SpendingDataPort;
import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import java.util.Optional;

/**
 * @author Agnieszka Trzewik
 */
@Named
interface SpendingRepositoryAdapter extends CrudRepository<SpendingEntity, Long>, SpendingDataPort<SpendingEntity> {

    @Override
    <S extends SpendingEntity> S save(S entity);

    @Override
    Iterable<SpendingEntity> findAll();

    @Override
    Optional<SpendingEntity> findById(Long aLong);
}
