package com.trzewik.budgettrackerserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

/**
 * @author Agnieszka Trzewik
 */

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
class BudgetTrackerServerApplicationTest {

    @Test
    void should_load_context_when_execute_this_method() {
    }
}