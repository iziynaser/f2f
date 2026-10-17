package ir.verjik.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.verjik.dto.ChangelogDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AppInfoService {

    private final ObjectMapper objectMapper;

    public ChangelogDTO getChangelog() {
        try {
            ClassPathResource resource = new ClassPathResource("changelog.json");
            return objectMapper.readValue(resource.getInputStream(), ChangelogDTO.class);
        } catch (IOException e) {
            throw new RuntimeException("خطا در بارگذاری changelog", e);
        }
    }
}
