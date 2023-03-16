package com.meawallet.parkingapp.in.dto.guard;

public record GetGuardInResponse (
        Integer id,
        String firstName,
        String lastName,
        String email
) {
}
