package com.f2f.controller;

import com.f2f.dto.ChangelogDTO;
import com.f2f.service.AppInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client/appinfo")  // قابل استفاده در VueJS برای کاربران
@RequiredArgsConstructor
public class ClientAppInfoController {

    private final AppInfoService appInfoService;

    @GetMapping("/changelog")
    public ResponseEntity<ChangelogDTO> getClientChangelog() {
        return ResponseEntity.ok(appInfoService.getChangelog());
    }
}
