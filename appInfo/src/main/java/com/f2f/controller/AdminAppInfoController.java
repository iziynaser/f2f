package com.f2f.controller;

import com.f2f.dto.ChangelogDTO;
import com.f2f.service.AppInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/appinfo")  // قابل استفاده در پنل ادمین
@RequiredArgsConstructor
public class AdminAppInfoController {

    private final AppInfoService appInfoService;

    @GetMapping("/changelog")
    public ResponseEntity<ChangelogDTO> getAdminChangelog() {
        return ResponseEntity.ok(appInfoService.getChangelog());
    }
}
