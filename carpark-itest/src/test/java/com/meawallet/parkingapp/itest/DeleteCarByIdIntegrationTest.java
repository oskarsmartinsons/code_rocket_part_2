package com.meawallet.parkingapp.itest;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.meawallet.parkingapp.core.port.in.carUseCases.DeleteCarUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DeleteCarByIdIntegrationTest extends BaseIntegrationTest{
    @MockBean
    private DeleteCarUseCase deleteCarUseCase;

    @Test
    @DatabaseSetup(value = "classpath:dbunit/deleteCarByIdInitialState.xml")
    @ExpectedDatabase(value = "classpath:dbunit/deleteCarByIdExpectedState.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    @DatabaseTearDown(value = "classpath:dbunit/deleteCarByIdInitialState.xml", type = DatabaseOperation.DELETE_ALL)
    public void shouldDeleteCarById() throws Exception {
        Integer id = 1;
        mvc.perform(delete("/cars/{id}", id))
                .andExpect(status().isNoContent());

        verify(deleteCarUseCase, times(1)).deleteCarById(id);
    }
}
