package com.meawallet.parkingapp.repository.adapter.guard;

import com.meawallet.parkingapp.core.port.out.guardPorts.SaveGuardPort;
import com.meawallet.parkingapp.domain.Guard;
import com.meawallet.parkingapp.repository.converter.GuardToGuardEntityConverter;
import com.meawallet.parkingapp.repository.repository.GuardRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@Transactional
@AllArgsConstructor
public class SaveGuardAdapter implements SaveGuardPort {
    private final GuardRepository guardRepository;
    private final GuardToGuardEntityConverter guardToGuardEntityConverter;
    @Override
    public Guard saveGuard(Guard guard) {
        var entity = guardToGuardEntityConverter.convert(guard);
        guardRepository.saveAndFlush(entity);

        log.debug("Saved GUARD entity: {}", entity);

        return Guard.builder()
                .id(entity.getId())
                .firstName(guard.firstName())
                .lastName(guard.lastName())
                .email(guard.email())
                .build();
    }
}
