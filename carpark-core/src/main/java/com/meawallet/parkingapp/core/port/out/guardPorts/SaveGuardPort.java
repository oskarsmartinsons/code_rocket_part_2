package com.meawallet.parkingapp.core.port.out.guardPorts;

import com.meawallet.parkingapp.domain.Guard;

public interface SaveGuardPort {
    Guard saveGuard(Guard guard);
}
