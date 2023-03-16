package com.meawallet.parkingapp.in.converter.guard;

import com.meawallet.parkingapp.domain.Guard;
import com.meawallet.parkingapp.in.dto.guard.GetGuardInResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GuardToGetGuardInResponseConverter {
    public GetGuardInResponse convert (Guard guard) {
        return new GetGuardInResponse(
                guard.id(),
                guard.firstName(),
                guard.lastName(),
                guard.email()
        );
    }
}
