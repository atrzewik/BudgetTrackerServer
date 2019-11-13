package com.trzewik.budgettrackerserver.domain;

import com.trzewik.budgettrackerserver.domain.port.api.SpendingPort;
import com.trzewik.budgettrackerserver.domain.port.spi.SpendingDataPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Agnieszka Trzewik
 */
@Named
@RequiredArgsConstructor
class SpendingService implements SpendingPort {

    private final SpendingDataPort<SpendingEntity> spendingDataPort;

    @Override
    public void addNewSpendings(SpendingDTO spending) throws ToLowPriceException {
        if (spending.getPrice().compareTo(BigDecimal.ZERO) < 0) throw new ToLowPriceException("To low price!");
        else spendingDataPort.save(new SpendingEntity(spending.getDescription(), spending.getPrice()));
    }

    @Override
    public List<SpendingDTO> getAllSpendings() {
        List<SpendingDTO> spendings = new ArrayList<>();
        spendingDataPort.findAll().forEach(spendingEntity -> spendings.add(new SpendingDTO(spendingEntity.getDescription(), spendingEntity.getPrice())));
        return spendings;
    }

    @Override
    public SpendingDTO getSpending(Long id) throws NoSpendingExistsException {
        SpendingEntity spendingEntity = spendingDataPort
                .findById(id)
                .orElseThrow(() -> new NoSpendingExistsException("Spending doesn't exist"));
        return new SpendingDTO(spendingEntity.getDescription(), spendingEntity.getPrice());
    }
}
