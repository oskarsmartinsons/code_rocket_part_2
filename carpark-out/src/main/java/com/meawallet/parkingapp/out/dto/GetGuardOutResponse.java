package com.meawallet.parkingapp.out.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.util.Locale;

public record GetGuardOutResponse (
        @JsonProperty(value = "id")
        String externalId,
        @JsonProperty(value = "first_name")
        String firstName,
        @JsonProperty(value = "last_name")
        String lastName,
        String email
){
}
