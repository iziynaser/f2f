package ir.verjik.service.accWiz;

import ir.verjik.dto.accWiz.ChartTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

@Service
public class ChartTemplateLoader {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ChartTemplate loadTemplate(String businessType) {
        try {
            // چاپ مسیر و فایل‌های موجود
            printAvailableTemplates();

            String path = "/templates/" + businessType + ".json";
            System.out.println("Trying to load template from: " + path);

            InputStream is = getClass().getResourceAsStream(path);

            if (is == null) {
                throw new RuntimeException("File not found in classpath: " + path);
            }

            return objectMapper.readValue(is, ChartTemplate.class);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Template not found for business type: " + businessType + " , error: " + e.getMessage());
        }
    }

    private void printAvailableTemplates() {
        try {
            URL url = getClass().getResource("/templates");
            System.out.println("Templates folder URL: " + url);

            if (url == null) {
                System.out.println("Templates folder not found in classpath.");
                return;
            }

            File folder = new File(url.toURI());
            File[] files = folder.listFiles();

            if (files == null || files.length == 0) {
                System.out.println("No files found in templates folder.");
                return;
            }

            System.out.println("Available template files:");
            for (File file : files) {
                System.out.println(" - " + file.getName());
            }

        } catch (Exception e) {
            System.out.println("Could not list template files: " + e.getMessage());
        }
    }
}
