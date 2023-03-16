package com.meawallet.parkingapp.out.converter;

import com.meawallet.parkingapp.domain.Guard;
import com.meawallet.parkingapp.out.dto.GetGuardOutResponse;
import org.springframework.stereotype.Component;

@Component
public class GetGuardOutResponseToGuardConverter {
    public Guard convert(GetGuardOutResponse response) {
        return Guard.builder()
                .firstName(response.firstName())
                .lastName(response.lastName())
                .email(response.email())
                .build();
    }
}
