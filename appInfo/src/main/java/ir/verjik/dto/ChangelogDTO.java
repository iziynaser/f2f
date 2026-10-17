package ir.verjik.dto;

import lombok.Data;

import java.util.List;

@Data
public class ChangelogDTO {
    private String version;
    private String date;
    private List<String> features;
    private List<String> fixes;
}
