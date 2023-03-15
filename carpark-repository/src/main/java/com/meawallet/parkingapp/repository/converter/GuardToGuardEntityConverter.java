package com.meawallet.parkingapp.repository.converter;

import com.meawallet.parkingapp.domain.Guard;
import com.meawallet.parkingapp.repository.entity.GuardEntity;
import org.springframework.stereotype.Component;

@Component
public class GuardToGuardEntityConverter {
    public GuardEntity convert(Guard guard) {
        return GuardEntity.builder()
                .id(guard.id())
                .firstName(guard.firstName())
                .lastName(guard.lastName())
                .email(guard.email())
                .build();
    }
}
