package com.meawallet.parkingapp.itest;

import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static com.github.springtestdbunit.annotation.DatabaseOperation.DELETE_ALL;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DatabaseTearDown(value = "classpath:dbunit/empty_dataset.xml", type = DELETE_ALL)
public class CreateLotIntegrationTest extends BaseIntegrationTest {

    @Test
    @ExpectedDatabase(value = "classpath:dbunit/createdLotSuccess.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    void shouldCreateLot() throws Exception {

        var guardResponse = readJson("guardResponseSuccess.json");
        var request = readJson("createParkingLotRequest.json");
        var response = readJson("createParkingLotResponseSuccess.json");

        stubGuardResponse(guardResponse, 200);

        mvc.perform(post("/parking-lots")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(content().json(response))
                .andExpect(status().isCreated());
    }

    private static void stubGuardResponse(String guardResponse, int status) {
        wireMockServer.stubFor(get(urlEqualTo("/random")).willReturn(
                aResponse()
                        .withStatus(status)
                        .withBody(guardResponse)
                        .withHeader(HttpHeaders.CONTENT_TYPE, "application/json")
        ));
    }
}
