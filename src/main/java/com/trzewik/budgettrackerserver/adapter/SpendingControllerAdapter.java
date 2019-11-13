package com.trzewik.budgettrackerserver.adapter;


import com.trzewik.budgettrackerserver.domain.NoSpendingExistsException;
import com.trzewik.budgettrackerserver.domain.SpendingDTO;
import com.trzewik.budgettrackerserver.domain.ToLowPriceException;
import com.trzewik.budgettrackerserver.domain.port.api.SpendingPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Agnieszka Trzewik
 */
@RestController
@RequiredArgsConstructor
class SpendingControllerAdapter {

    private final SpendingPort spendingPort;

    @PostMapping("/spendings")
    void addNewSpendings(@RequestBody SpendingDTO spending) throws ToLowPriceException {
        spendingPort.addNewSpendings(spending);
    }

    @GetMapping("/spendings/{id}")
    SpendingDTO getSpending(@PathVariable Long id) throws NoSpendingExistsException {
        return spendingPort.getSpending(id);
    }

    @GetMapping("/spendings")
    List<SpendingDTO> getAllSpendings() {
        return spendingPort.getAllSpendings();
    }


}
