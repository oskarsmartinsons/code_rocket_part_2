package com.meawallet.parkingapp.out.config;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class GuardApiConfig {
    @NotBlank
    private String guardUrl;
}
