package ir.verjik.controller.accWiz;

import ir.verjik.service.accWiz.ChartWizardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chart-wizard")
@RequiredArgsConstructor
public class ChartWizardController {

    private final ChartWizardService wizardService;

    @PostMapping("/generate/{businessType}")
    public ResponseEntity<?> generateChart(
            @PathVariable String businessType
    ) {

        wizardService.createFromBusinessType(businessType);

        return ResponseEntity.ok("Chart generated successfully");
    }
}
