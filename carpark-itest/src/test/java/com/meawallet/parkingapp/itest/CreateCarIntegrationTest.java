package com.meawallet.parkingapp.itest;

import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CreateCarIntegrationTest extends BaseIntegrationTest {
    @Test
    @ExpectedDatabase(value = "classpath:dbunit/createdCarSuccess.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    void shouldCreateCar() throws Exception {
        mvc.perform(post("/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n"
                                + "  \"registrationNumber\" : \"33\",\n"
                                + "  \"carMake\" : \"Ford\" \n"
                                + "}"))
                .andExpect(status().isCreated());
    }
}
