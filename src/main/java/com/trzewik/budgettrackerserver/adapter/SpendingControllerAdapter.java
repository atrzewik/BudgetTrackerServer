package com.trzewik.budgettrackerserver.adapter;


import com.trzewik.budgettrackerserver.domain.Spending;
import com.trzewik.budgettrackerserver.domain.SpendingSummary;
import com.trzewik.budgettrackerserver.domain.ToLowPriceException;
import com.trzewik.budgettrackerserver.domain.port.api.SpendingPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Agnieszka Trzewik
 */
@RestController
@RequiredArgsConstructor
public class SpendingControllerAdapter {

    private final SpendingPort spendingPort;

    @PostMapping("/spendings")
    void addNewSpendings(@RequestBody Spending spending) throws ToLowPriceException {
        spendingPort.addNewSpendings(spending);
    }

    @GetMapping("/spendings")
    List<Spending> getAllSpendings() {
        return spendingPort.getAllSpendings();
    }

    @GetMapping("/summary")
    SpendingSummary getSpendingSummary() {
        return spendingPort.getSpendingSummary();
    }


}
