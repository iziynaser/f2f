package ir.verjik.controller;

import ir.verjik.entity.Ostan;
import ir.verjik.service.OstanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ostan")
@RequiredArgsConstructor
public class OstanController {

    private final OstanService ostanService;

    @GetMapping("/list")
    public List<Ostan> getInfo() {
        return ostanService.getInfo();
    }
}

