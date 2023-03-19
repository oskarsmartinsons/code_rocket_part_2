package com.meawallet.parkingapp.itest;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class FindSlotByIdIntegrationTest extends BaseIntegrationTest{
    @Test
    @DatabaseSetup(value = "classpath:dbunit/findSlotByIdSuccess.xml")
    @ExpectedDatabase(value = "classpath:dbunit/findSlotByIdSuccess.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    void shouldFindSlotById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/parking-slots/1"))
                .andExpect(status().isOk());
    }
}
