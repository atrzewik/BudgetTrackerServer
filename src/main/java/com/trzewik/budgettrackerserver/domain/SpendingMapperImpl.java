package com.trzewik.budgettrackerserver.domain;

import com.trzewik.budgettrackerserver.adapter.Spending;
import com.trzewik.budgettrackerserver.domain.port.api.SpendingMapper;

import javax.inject.Named;

/**
 * @author Agnieszka Trzewik
 */
@Named
class SpendingMapperImpl implements SpendingMapper {
    @Override
    public SpendingDTO map(Spending spending) {
        return new SpendingDTO(spending.getDescription(), spending.getPrice());
    }

    @Override
    public Spending map(SpendingDTO spendingDTO) {
        return new Spending(spendingDTO.getDescription(), spendingDTO.getPrice());
    }
}
