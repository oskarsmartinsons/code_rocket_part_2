package com.meawallet.parkingapp.domain;

import lombok.Builder;

@Builder
public record Guard (
    Integer id,
    String firstName,
    String lastName,
    String email
){
}
