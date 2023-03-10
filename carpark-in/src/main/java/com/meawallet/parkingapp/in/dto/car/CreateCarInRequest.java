package com.meawallet.parkingapp.in.dto.car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record CreateCarInRequest (
        @NotBlank
        @Length(min = 1, max = 8)
        String registrationNumber,

        @NotBlank
        @Pattern(regexp = "[a-zA-Z]+")
        @Length(min = 1, max = 20)
        String carMake
){

}
