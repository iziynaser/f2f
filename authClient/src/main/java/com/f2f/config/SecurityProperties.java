package com.f2f.config;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "security.jwt")
public class SecurityProperties {
    private String rsaPublicKey;
    // getter / setter

    public String getRsaPublicKey() { return rsaPublicKey; }
    public void setRsaPublicKey(String rsaPublicKey) { this.rsaPublicKey = rsaPublicKey; }
}
