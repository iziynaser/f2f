package ir.verjik.service.accWiz;

import ir.verjik.dto.accWiz.ChartTemplate;
import org.springframework.stereotype.Service;

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
