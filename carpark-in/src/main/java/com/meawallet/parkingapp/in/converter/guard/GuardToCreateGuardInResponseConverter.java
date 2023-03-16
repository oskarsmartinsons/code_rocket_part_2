package com.meawallet.parkingapp.in.converter.guard;

import com.meawallet.parkingapp.domain.Guard;
import com.meawallet.parkingapp.in.dto.guard.CreateGuardInResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GuardToCreateGuardInResponseConverter {
    public CreateGuardInResponse convert (Guard guard) {
        return new CreateGuardInResponse(
                guard.id(),
                guard.firstName(),
                guard.lastName(),
                guard.email()
        );
    }
}
