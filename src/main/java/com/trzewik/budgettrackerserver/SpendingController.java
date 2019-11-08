package com.trzewik.budgettrackerserver;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Agnieszka Trzewik
 */
@RestController
class SpendingController {

    private final SpendingService spendingService;

    SpendingController(SpendingService spendingService) {
        this.spendingService = spendingService;
    }

    @PostMapping("/spendings")
    String addNewSpendings(@RequestBody Spending spending) {
        if (spending.getPrice().compareTo(BigDecimal.ZERO) < 0) return "Too low value";
            //TODO: RestExceptionHandler
        else return "Ok";

    }

}
