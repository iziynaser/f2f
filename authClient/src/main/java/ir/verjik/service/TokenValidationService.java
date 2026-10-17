package ir.verjik.service;

import ir.verjik.dto.TokenValidationRequest;
import ir.verjik.dto.TokenValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class TokenValidationService {

    @Autowired
    private final RestTemplate restTemplate;

    @Value("${auth.service.url}")
    private String authServiceUrl;

    public TokenValidationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public TokenValidationResponse validateToken(String token) {
        try {
            TokenValidationRequest request = new TokenValidationRequest(token);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<TokenValidationRequest> entity = new HttpEntity<>(request, headers);

            ResponseEntity<TokenValidationResponse> response = restTemplate.exchange(
                    authServiceUrl,
                    HttpMethod.POST,
                    entity,
                    TokenValidationResponse.class
            );

            return response.getBody();
        } catch (Exception e) {
            TokenValidationResponse errorResponse = new TokenValidationResponse();
            errorResponse.setValid(false);
            errorResponse.setError("Auth service unreachable: " + e.getMessage());
            return errorResponse;
        }
    }
}
