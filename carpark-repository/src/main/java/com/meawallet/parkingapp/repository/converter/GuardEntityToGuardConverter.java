package com.meawallet.parkingapp.repository.converter;

import com.meawallet.parkingapp.domain.Guard;
import com.meawallet.parkingapp.repository.entity.GuardEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GuardEntityToGuardConverter {
    public Guard convert(GuardEntity entity) {
        return Guard.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .build();
    }
}
