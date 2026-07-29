package com.f2f.service.accWiz;

import com.f2f.dto.accWiz.ChartTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ChartWizardService {

    private final ChartTemplateLoader loader;
    private final ChartTemplateCreator creator;

    public ChartWizardService(
            ChartTemplateLoader loader,
            ChartTemplateCreator creator
    ) {
        this.loader = loader;
        this.creator = creator;
    }

    public void createFromBusinessType(String businessType) {

        ChartTemplate template = loader.loadTemplate(businessType);

        creator.createChart(template);
    }
}
