package ir.verjik.dto;

import ir.verjik.enums.CatalogType;
import lombok.Data;

@Data
public class CatalogCreationRequest {
    private String name;
    private String locale;
    private String description;
    private CatalogType type; // STATIC, DYNAMIC
    private CatalogFilter filter;
}
