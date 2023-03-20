package com.meawallet.parkingapp.itest;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.github.springtestdbunit.annotation.DatabaseOperation.DELETE_ALL;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@DatabaseTearDown(value = "classpath:dbunit/empty_dataset.xml", type = DELETE_ALL)
public class FindLotByIdIntegrationTest extends BaseIntegrationTest {
    @Test
    @DatabaseSetup(value = "classpath:dbunit/findLotByIdSuccess.xml")
    @ExpectedDatabase(value = "classpath:dbunit/findLotByIdSuccess.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    void shouldFindLotById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/parking-lots/1"))
                .andExpect(status().isOk());
    }
}
