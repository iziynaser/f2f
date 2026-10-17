package ir.verjik.service;

import ir.verjik.dto.TokenValidationRequest;
import ir.verjik.dto.TokenValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthClient {

    @Value("${auth.service.url}")
    private String authServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    public TokenValidationResponse validateToken(String token) {
        TokenValidationRequest req = new TokenValidationRequest(token);

        ResponseEntity<TokenValidationResponse> res =
                restTemplate.postForEntity(
                        authServiceUrl + "/api/auth/validate",
                        req,
                        TokenValidationResponse.class
                );

        return res.getBody();
    }
}
