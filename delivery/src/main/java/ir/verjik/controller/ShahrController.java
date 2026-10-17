package ir.verjik.controller;

import ir.verjik.entity.Shahr;
import ir.verjik.service.ShahrService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shahr")
@RequiredArgsConstructor
public class ShahrController {

    private final ShahrService shahrService;

    @GetMapping("/list")
    public List<Shahr> findAll(@RequestParam("ostanId") Long ostanId) {
        return shahrService.getInfo(ostanId);
    }
}
