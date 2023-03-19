package com.meawallet.parkingapp.itest;

import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.meawallet.parkingapp.out.dto.GetGuardOutResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockReset;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CreateLotIntegrationTest extends BaseIntegrationTest {
    @MockBean(reset = MockReset.NONE)
    private RestTemplate restTemplate;

    @Test
    @ExpectedDatabase(value = "classpath:dbunit/createdLotSuccess.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    void shouldCreateLot() throws Exception {
        when(restTemplate.getForEntity("https://random-data-api.com/api/v2/users", GetGuardOutResponse.class)).thenReturn(response());

        mvc.perform(post("/parking-lots")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n"
                                + "  \"name\" : \"MyLot\",\n"
                                + "  \"slotCount\" : 20, \n"
                                + "  \"emptySlots\" : 20 \n"
                                + "}"))
                .andExpect(status().isCreated());

    }

    private ResponseEntity<GetGuardOutResponse> response() {
        var body = new GetGuardOutResponse("13",
                "Guardian",
                "Lastone",
                   "gl@gmail.com");
        return ResponseEntity.ok(body);
    }
}
