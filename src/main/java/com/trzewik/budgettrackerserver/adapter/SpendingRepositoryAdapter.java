package com.trzewik.budgettrackerserver.adapter;

import com.trzewik.budgettrackerserver.domain.port.spi.SpendingDataPort;
import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;

/**
 * @author Agnieszka Trzewik
 */
@Named
interface SpendingRepositoryAdapter extends CrudRepository<Spending, Long>, SpendingDataPort {

}
