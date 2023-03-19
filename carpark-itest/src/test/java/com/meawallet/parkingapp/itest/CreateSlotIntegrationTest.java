package com.meawallet.parkingapp.itest;

import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CreateSlotIntegrationTest extends BaseIntegrationTest {
    @Test
    @ExpectedDatabase(value = "classpath:dbunit/createdSlotSuccess.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    void shouldCreateSlot() throws Exception {
        mvc.perform(post("/parking-slots")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n"
                                + "  \"slotNumber\" : \"666\",\n"
                                + "  \"isEmpty\" : \"true\" \n"
                                + "}"))
                .andExpect(status().isCreated());
    }
}
