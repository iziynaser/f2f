package com.f2f.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "zarinpal")
@Getter
@Setter
public class ZarinpalProperties {
    private String merchantId;
    private String callbackUrl;
    private boolean sandbox;
}
