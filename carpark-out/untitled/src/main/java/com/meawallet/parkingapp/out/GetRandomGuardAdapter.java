package com.meawallet.parkingapp.out;

import com.meawallet.parkingapp.core.port.out.guardPorts.GetRandomGuardPort;
import com.meawallet.parkingapp.domain.Guard;
import com.meawallet.parkingapp.out.converter.GetGuardOutResponseToGuardConverter;
import com.meawallet.parkingapp.out.dto.GetGuardOutResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@AllArgsConstructor
public class GetRandomGuardAdapter implements GetRandomGuardPort {
    private final RestTemplate restTemplate;
    private final GetGuardOutResponseToGuardConverter getGuardOutResponseToGuardConverter;

    @Override
    public Guard getRandomGuard() {
        var response = restTemplate.getForEntity("https://random-data-api.com/api/v2/users", GetGuardOutResponse.class)
                .getBody();

        log.debug("Received random guard: {}",response);
        var guard = getGuardOutResponseToGuardConverter.convert(response);
        return guard;
    }
}
