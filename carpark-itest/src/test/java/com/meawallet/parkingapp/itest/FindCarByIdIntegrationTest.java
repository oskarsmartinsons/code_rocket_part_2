package com.meawallet.parkingapp.itest;

import com.github.springtestdbunit.annotation.DatabaseSetups;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class FindCarByIdIntegrationTest extends BaseIntegrationTest{

    @Test
    @DatabaseSetups(value = "classpath:dbunit/findCarByIdSuccess.xml")
    @ExpectedDatabase(value = "classpath:dbunit/findCarByIdSuccess.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    void shouldFindCarById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/cars/1"))
                .andExpect(status().isOk());
    }
}
